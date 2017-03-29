package com.atguigu.bilibili.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.OutAdapter;
import com.atguigu.bilibili.bean.AddressBean;
import com.atguigu.bilibili.bean.GoodsBean;
import com.atguigu.bilibili.utils.CartStorage;
import com.atguigu.bilibili.view.NoScrollListView;

import java.util.ArrayList;
import java.util.List;

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
    private List<GoodsBean> listData;
    private OutAdapter adapter;

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

                GoodsBean goodsBean = listData.get(i);
                if (goodsBean.isChecked()) {
                    //被选中的
                    totalPrice = totalPrice + goodsBean.getNumber() * Double.parseDouble(goodsBean.getSalvePrice() + "");
                }
            }
        }

        return totalPrice;
    }

    private void setData() {
        rgPaymode.check(R.id.alipay);
        listData = CartStorage.getInstance(this).getAllData();

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
//                    pay(null);
                } else if (checkId == R.id.weixing) {
                    //微信支付
                    Toast.makeText(this, "微信暂未完成", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private static int REQUESTCODE = 1;          //跳转请求码
}
