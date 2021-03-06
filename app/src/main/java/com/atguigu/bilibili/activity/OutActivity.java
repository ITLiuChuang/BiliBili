package com.atguigu.bilibili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.atguigu.bilibili.MyApplication;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.User;
import com.atguigu.bilibili.UserDao;
import com.atguigu.bilibili.adapter.OutAdapter;
import com.atguigu.bilibili.bean.AddressBean;
import com.atguigu.bilibili.utils.PayResult;
import com.atguigu.bilibili.utils.SignUtils;
import com.atguigu.bilibili.utils.pay.PayKeys;
import com.atguigu.bilibili.view.NoScrollListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OutActivity extends AppCompatActivity {

    @Bind(R.id.tv_left_back)
    TextView tvLeftBack;
    @Bind(R.id.title_right)
    ImageView titleRight;
    @Bind(R.id.tvAddresseeName)
    TextView tvAddresseeName;
    @Bind(R.id.tvSmeAredAddress)
    TextView tvSmeAredAddress;
    @Bind(R.id.tvAddressNext)
    TextView tvAddressNext;
    @Bind(R.id.detailAddress)
    TextView detailAddress;
    @Bind(R.id.addressRelative)
    RelativeLayout addressRelative;
    @Bind(R.id.tv_paymode)
    TextView tvPaymode;
    @Bind(R.id.alipay)
    RadioButton alipay;
    @Bind(R.id.weixing)
    RadioButton weixing;
    @Bind(R.id.rg_paymode)
    RadioGroup rgPaymode;
    ;
    @Bind(R.id.tvCheckOutAllPrice)
    TextView tvCheckOutAllPrice;
    @Bind(R.id.btnSureCheckOut)
    Button btnSureCheckOut;
    @Bind(R.id.checkOutListView)
    NoScrollListView checkOutListView;
    private ArrayList<AddressBean> addressList;

    private OutAdapter adapter;

    private List<User> listData;
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);
        ButterKnife.bind(this);
        getAddressData();
        showAddressInfo(0);
        setData();
        showTotalPrice();
    }

    private void showTotalPrice() {
        tvCheckOutAllPrice.setText("合计:" + getTotalPrice());
    }

    /**
     * 得到总价格
     *
     * @return
     */
    public double getTotalPrice() {
        double totalPrice = 0.0;

        if (listData != null && listData.size() > 0) {
            for (int i = 0; i < listData.size(); i++) {

                User user = listData.get(i);
                if (user.getIsChecked()) {
                    //被选中的
                    totalPrice = totalPrice + user.getNumber() * Double.parseDouble(user.getMoney() + "");
                }
            }
        }

        return totalPrice;
    }

    private void setData() {
        rgPaymode.check(R.id.alipay);
//        listData = CartStorage.getInstance(this).getAllData();
        UserDao userDao = MyApplication.getInstances().getDaoSession().getUserDao();
        listData = this.userDao.loadAll();
        if (listData != null && listData.size() > 0) {
            adapter = new OutAdapter(this, listData);
            checkOutListView.setAdapter(adapter);
        }
    }

    //显示收货人姓名地址等信息
    private void showAddressInfo(int i) {

        AddressBean bean = addressList.get(i);
        tvAddresseeName.setText(bean.getName());
        tvSmeAredAddress.setText(bean.getSmearedAddress());
        detailAddress.setText(bean.getDetailAddress());
    }

    private void getAddressData() {
        addressList = new ArrayList<>();

        AddressBean bean = new AddressBean();
        bean.setName("刘先生");
        bean.setSmearedAddress("贵州省黎平县");
        bean.setDetailAddress("黎平一中  15527196048");
        addressList.add(bean);

        AddressBean bean2 = new AddressBean();
        bean2.setName("杨先生");
        bean2.setSmearedAddress("北京昌平");
        bean2.setDetailAddress("北京昌平xxx家园  18140549110");
        addressList.add(bean2);
    }

    @OnClick({R.id.tv_left_back, R.id.tvAddressNext, R.id.btnSureCheckOut})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_left_back:
                finish();
                break;

            case R.id.tvAddressNext:
                // 修改收货地址
                Toast.makeText(OutActivity.this, "修改地址", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnSureCheckOut:
                int checkId = rgPaymode.getCheckedRadioButtonId();
                if (checkId == R.id.alipay) {
                    //支付
                    pay();
                } else if (checkId == R.id.weixing) {
                    //微信支付
                    Toast.makeText(this, "微信暂未完成", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private static int REQUESTCODE = 1;          //跳转请求码

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            int addressIndex = bundle.getInt("addressIndex");
            showAddressInfo(addressIndex);
        }
    }
    //---------------------支付

    //商户PID
    public static final String PARTNER = PayKeys.DEFAULT_PARTNER;
    //商户收款账号
    public static final String SELLER = PayKeys.DEFAULT_SELLER;
    //商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = PayKeys.PRIVATE;
    //支付宝公钥
    public static final String RSA_PUBLIC = PayKeys.PUBLIC;


    private static final int SDK_PAY_FLAG = 1;

    private static final int SDK_CHECK_FLAG = 2;


    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);

                    // 支付宝返回此次支付结果及加签，建议对支付宝签名信息拿签约时支付宝提供的公钥做验签
                    String resultInfo = payResult.getResult();

                    String resultStatus = payResult.getResultStatus();

                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(OutActivity.this, "支付成功",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(OutActivity.this, "支付结果确认中",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(OutActivity.this, "支付失败",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                case SDK_CHECK_FLAG: {
                    Toast.makeText(OutActivity.this, "检查结果为：" + msg.obj,
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                    break;
            }
        }
    };

    /**
     * call alipay sdk pay. 调用SDK支付
     */
    public void pay() {
        // 订单
        String orderInfo = getOrderInfo("测试的商品", "该测试商品的详细描述", "0.01");
        // 对订单做RSA 签名
        String sign = sign(orderInfo);
        try {
            // 仅需对sign 做URL编码
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 完整的符合支付宝参数规范的订单信息
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&"
                + getSignType();

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(OutActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * create the order info. 创建订单信息
     */
    public String getOrderInfo(String subject, String body, String price) {
        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm"
                + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }

    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    public String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss",
                Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content 待签名订单信息
     */
    public String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }


    /**
     * get the sign type we use. 获取签名方式
     */
    public String getSignType() {
        return "sign_type=\"RSA\"";
    }
}
