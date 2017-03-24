package com.atguigu.bilibili.fragment;

import com.atguigu.bilibili.R;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class DynamicFragment extends BaseFragment {
    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initData(String json) {

    }
}
