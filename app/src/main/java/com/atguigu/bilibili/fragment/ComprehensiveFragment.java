package com.atguigu.bilibili.fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.MultipleAdapter;
import com.atguigu.bilibili.bean.ComprehensiveBean;
import com.atguigu.bilibili.utils.AppNetConfig;
import com.atguigu.bilibili.utils.NetUtils;

import butterknife.Bind;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class ComprehensiveFragment extends BaseFragment {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void initListener() {
        //设置下拉多少距离起作用
        swipeRefreshLayout.setDistanceToTriggerSync(100);//设置下拉距离
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.BLACK, Color.RED, Color.GREEN);
        //设置背景的颜色
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.holo_blue_bright);

        //设置下拉刷新的监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(mContext, "wedsjkmd,fb", Toast.LENGTH_SHORT).show();
                if (!TextUtils.isEmpty(setUrl())) {
                    NetUtils.getInstance().okhttpUtilsget(setUrl(), new NetUtils.resultJson() {
                        @Override
                        public void onResponse(String json) {
                            initData(json);
                        }

                        @Override
                        public void onError(String error) {
                            initData(null);
                        }
                    });
                } else {
                    initData(null);
                }


            }
        });
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_comprehensive;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.RECOMMEND_TAG;
    }

    @Override
    protected void initData(String json) {
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "LiveFragment initData()");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {

                ComprehensiveBean comprehensiveBean = JSON.parseObject(json, ComprehensiveBean.class);
                recyclerview.setAdapter(new MultipleAdapter(mContext, comprehensiveBean.getData()));
                recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
                swipeRefreshLayout.setRefreshing(false);
            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
    }


}
