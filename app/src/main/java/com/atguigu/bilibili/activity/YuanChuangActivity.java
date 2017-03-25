package com.atguigu.bilibili.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.TabLayoutAdapter;
import com.atguigu.bilibili.fragment.FanJuFragment;
import com.atguigu.bilibili.fragment.QuanZhanFragment;
import com.atguigu.bilibili.fragment.YuanChuangFragment;

import java.util.ArrayList;

import butterknife.Bind;

public class YuanChuangActivity extends BaseActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.iv_drown)
    ImageView ivDrown;
    @Bind(R.id.ll_bar)
    RelativeLayout llBar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.activity_yuan_chuang)
    LinearLayout activityYuanChuang;
    private ArrayList<Fragment> fragments;
    private TabLayoutAdapter adapter;

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
        fragments = new ArrayList<>();
        fragments.add(new YuanChuangFragment());
        fragments.add(new QuanZhanFragment());
        fragments.add(new FanJuFragment());



        adapter = new TabLayoutAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_yuan_chuang;
    }



}
