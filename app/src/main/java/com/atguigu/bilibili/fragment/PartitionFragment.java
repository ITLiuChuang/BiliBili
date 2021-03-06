package com.atguigu.bilibili.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.ZoneAdapter;
import com.atguigu.bilibili.bean.PartitionBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/21.
 */
public class PartitionFragment extends BaseFragment {
    @Bind(R.id.rv_home)
    RecyclerView rvHome;

    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_partition;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.PARTITION_TAG;
    }

    @Override
    protected void initData(String json) {
        if (TextUtils.isEmpty(json)) {

        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            int code = jsonObject.getInteger("code");
            if (code == 0) {
                PartitionBean partitionBean = JSON.parseObject(json, PartitionBean.class);
                rvHome.setAdapter(new ZoneAdapter(mContext, partitionBean.getData()));
                rvHome.setLayoutManager(new LinearLayoutManager(mContext));
            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
