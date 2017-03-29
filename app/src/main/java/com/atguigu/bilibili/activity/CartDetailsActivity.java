package com.atguigu.bilibili.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.CartAdapter;
import com.atguigu.bilibili.bean.GoodsBean;
import com.atguigu.bilibili.utils.CartStorage;
import com.atguigu.bilibili.utils.VirtualkeyboardHeight;
import com.atguigu.bilibili.view.AddSubView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class CartDetailsActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.toolBar)
    LinearLayout toolBar;
    @Bind(R.id.iv_imgurl)
    ImageView ivImgurl;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_salveprice)
    TextView tvSalveprice;
    @Bind(R.id.ll_cart)
    LinearLayout llCart;
    @Bind(R.id.tv_good_info_callcenter)
    TextView tvGoodInfoCallcenter;
    @Bind(R.id.tv_good_info_collection)
    TextView tvGoodInfoCollection;
    @Bind(R.id.tv_good_info_cart)
    TextView tvGoodInfoCart;
    @Bind(R.id.btn_good_info_addcart)
    Button btnGoodInfoAddcart;
    @Bind(R.id.ll_goods_root)
    LinearLayout llGoodsRoot;
    @Bind(R.id.activity_cart_details)
    LinearLayout activityCartDetails;
    private ArrayList<Parcelable> data;

    private GoodsBean tempGoodsBean;
    private GoodsBean goodsBean;


    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initListener() {
        getData();
    }

    private void getData() {
        goodsBean = (GoodsBean) getIntent().getSerializableExtra(CartAdapter.GOODS_BEAN);

        //设置图片
        Glide.with(this).load(goodsBean.getImgUrl()).placeholder(R.drawable.img_tips_error_not_foud).into(ivImgurl);
        //设置名称和价格
        tvTitle.setText(goodsBean.getTitle());
        tvSalveprice.setText("¥" + goodsBean.getSalvePrice());

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(String json, String error) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_cart_details;
    }


    @OnClick({R.id.tv_good_info_cart, R.id.btn_good_info_addcart, R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_good_info_cart:
                Intent  intent = new Intent(this, CartActivity.class);
                intent.putExtra("checkedid",R.id.rb_cart);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_good_info_addcart:
                showPopwindow();
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private boolean isExist = false;

    private void showPopwindow() {

        tempGoodsBean = CartStorage.getInstance(this).findDete(goodsBean.getSkuId());
        if (tempGoodsBean == null) {
            isExist = false;
            tempGoodsBean = goodsBean;
        } else {
            isExist = true;
        }
        // 1 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow_add_product, null);
        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 4 控件处理
        ImageView iv_goodinfo_photo = (ImageView) view.findViewById(R.id.iv_goodinfo_photo);
        TextView tv_goodinfo_name = (TextView) view.findViewById(R.id.tv_goodinfo_name);
        TextView tv_goodinfo_price = (TextView) view.findViewById(R.id.tv_goodinfo_price);
        AddSubView nas_goodinfo_num = (AddSubView) view.findViewById(R.id.nas_goodinfo_num);
        Button bt_goodinfo_cancel = (Button) view.findViewById(R.id.bt_goodinfo_cancel);
        Button bt_goodinfo_confim = (Button) view.findViewById(R.id.bt_goodinfo_confim);

        // 加载图片
        Glide.with(CartDetailsActivity.this).load(goodsBean.getImgUrl()).into(iv_goodinfo_photo);

        // 名称
        tv_goodinfo_name.setText(tempGoodsBean.getTitle());
        // 显示价格
        tv_goodinfo_price.setText(tempGoodsBean.getSalvePrice() + "");

        // 设置最大值和当前值
        nas_goodinfo_num.setMaxValue(100);//库存100
        nas_goodinfo_num.setValue(1);

        nas_goodinfo_num.setValue(tempGoodsBean.getNumber());
        nas_goodinfo_num.setOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void OnNumberChanger(int value) {
                tempGoodsBean.setNumber(value);
            }
        });
        bt_goodinfo_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                if (isExist && tempGoodsBean.getNumber() == 1) {
                    tempGoodsBean.setNumber(tempGoodsBean.getNumber() + 1);
                }
            }
        });
        bt_goodinfo_confim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                //添加购物车
                CartStorage.getInstance(CartDetailsActivity.this).updataData(tempGoodsBean);
                Toast.makeText(CartDetailsActivity.this, "添加购物车成功", Toast.LENGTH_SHORT).show();
            }
        });

        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });

        // 5 在底部显示
        window.showAtLocation(CartDetailsActivity.this.findViewById(R.id.ll_goods_root),
                Gravity.BOTTOM, 0, VirtualkeyboardHeight.getBottomStatusHeight(CartDetailsActivity.this));

    }


}
