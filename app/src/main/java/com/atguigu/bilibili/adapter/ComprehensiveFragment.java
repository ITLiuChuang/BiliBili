package com.atguigu.bilibili.adapter;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.ComprehensiveBean;
import com.atguigu.bilibili.fragment.BaseFragment;
import com.atguigu.bilibili.utils.AppNetConfig;
import com.atguigu.bilibili.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class ComprehensiveFragment extends BaseFragment {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private List<ComprehensiveBean.DataBean> data;

    private MultipleAdapter multipleAdapter;

    @Override
    protected void initListener() {


        //下拉刷新
        initPullRefresh();
        //上拉加载
        initLoadMoreListener();

    }
    private void initLoadMoreListener() {

        recyclerview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem ;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //判断RecyclerView的状态 是空闲时，同时，是最后一个可见的ITEM时才加载
                if(newState==RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==multipleAdapter.getItemCount()){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            List<ComprehensiveBean.DataBean> footerDatas = new ArrayList<ComprehensiveBean.DataBean>();
                            for (int i = 0; i< data.size(); i++) {

                                footerDatas.add(data.get(i));
                            }
                            multipleAdapter.AddFooterItem(footerDatas);
                            Toast.makeText(mContext, "更新了 "+footerDatas.size()+" 条动态", Toast.LENGTH_SHORT).show();
                        }
                    }, 1000);


                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //最后一个可见的ITEM
                lastVisibleItem=layoutManager.findLastVisibleItemPosition();
            }
        });

    }



    private void initPullRefresh() {
        //设置下拉多少距离起作用
        swipeRefreshLayout.setDistanceToTriggerSync(100);//设置下拉距离
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.BLACK, Color.RED, Color.GREEN);
        //设置背景的颜色
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.holo_blue_bright);

        //设置下拉刷新的监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
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

                data = comprehensiveBean.getData();
                multipleAdapter = new MultipleAdapter(mContext, data);
                recyclerview.setAdapter(multipleAdapter);
                recyclerview.setLayoutManager(new GridLayoutManager(mContext, 2));
                swipeRefreshLayout.setRefreshing(false);
            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
    }
}
