package com.atguigu.bilibili.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.CartoonAdapter;
import com.atguigu.bilibili.bean.CartoonBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;

/**
 * Created by 刘闯 on 2017/3/21.
 * 追番
 */
public class CartoonFragment extends BaseFragment {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_cartoon;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.CARTOON_TAG;
    }

    @Override
    protected void initData(String json) {
        CartoonBean cartoonBean = JSON.parseObject(json, CartoonBean.class);
        recyclerview.setAdapter(new CartoonAdapter(mContext,cartoonBean.getResult()));
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
    }



}
