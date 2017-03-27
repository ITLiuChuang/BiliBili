package com.atguigu.bilibili.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.LiveAdapter;
import com.atguigu.bilibili.bean.LiveBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;

/**
 * Created by 刘闯 on 2017/3/21.
 * <p>
 * 直播页面
 */
public class  LiveFragment extends BaseFragment {


    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.LIVE_TAG;
    }

    @Override
    protected void initData(String json) {
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "LiveFragment initData()");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {
                LiveBean liveBean = JSON.parseObject(json, LiveBean.class);
                recyclerview.setAdapter(new LiveAdapter(mContext, liveBean.getData()));
                recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
    }



}
