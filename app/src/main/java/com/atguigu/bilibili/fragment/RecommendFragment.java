package com.atguigu.bilibili.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.ComprehensiveAdapter;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by 刘闯 on 2017/3/21.
 * 推荐
 */
public class RecommendFragment extends BaseFragment {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initData(String json) {
        fragments = new ArrayList<>();
        fragments.add(new ComprehensiveFragment());
        fragments.add(new DynamicFragment());

        viewpager.setAdapter(new ComprehensiveAdapter(getChildFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }


}
