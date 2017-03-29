package com.atguigu.bilibili.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.CartAdapter;
import com.atguigu.bilibili.bean.CartBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/28.
 */
public class HomeFragment extends BaseFragment {



    @Bind(R.id.lv_cart)
    RecyclerView lvCart;

    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.CART_TAG;
    }

    @Override
    protected void initData(final String json) {
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "LiveFragment initData()");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {
                CartBean cartBean = JSON.parseObject(json, CartBean.class);
                lvCart.setAdapter(new CartAdapter(mContext, cartBean.getResult().getRecords()));
                lvCart.setLayoutManager(new LinearLayoutManager(mContext));
            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
