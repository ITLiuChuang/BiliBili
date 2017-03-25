package com.atguigu.bilibili.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.RecommendAdapter;
import com.atguigu.bilibili.bean.RecommendBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;

public class RecommendActivity extends BaseActivity {


    @Bind(R.id.tv_recommend_area)
    TextView tvRecommendArea;

    @Bind(R.id.iv_img)
    ImageView ivImg;

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected String setUrl() {
        return AppNetConfig.LIVE_RECOMMEND_TAG;
    }

    @Override
    protected void initListener() {
        ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        tvRecommendArea.setText(name);


    }

    @Override
    protected void initData(String json, String error) {
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "LiveFragment initData()");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {
                RecommendBean recommendBean = JSON.parseObject(json, RecommendBean.class);
                RecommendAdapter recommendAdapter = new RecommendAdapter(this, recommendBean.getData());
                recyclerview.setAdapter(recommendAdapter);
                recyclerview.setLayoutManager(new LinearLayoutManager(this));

            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_recommend_activity;
    }



}
