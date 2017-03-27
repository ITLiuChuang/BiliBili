package com.atguigu.bilibili.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.SearchAdapter;
import com.atguigu.bilibili.fragment.FanFragment;
import com.atguigu.bilibili.fragment.UPFragment;
import com.atguigu.bilibili.fragment.YingShiFragment;
import com.atguigu.bilibili.fragment.ZongHeFragment;

import java.util.ArrayList;

import butterknife.Bind;

public class SearchActivity extends BaseActivity {


    @Bind(R.id.scan)
    ImageView scan;
    @Bind(R.id.ll_search)
    LinearLayout llSearch;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.activity_search)
    LinearLayout activitySearch;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_name)
    TextView tvName;
    private ArrayList<Fragment> fragments;

    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData(String json, String error) {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvName.setText(name);

        fragments = new ArrayList<>();
        fragments.add(new ZongHeFragment(this, name));
        fragments.add(new FanFragment());
        fragments.add(new UPFragment());
        fragments.add(new YingShiFragment());

        viewpager.setAdapter(new SearchAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_search;
    }


}
