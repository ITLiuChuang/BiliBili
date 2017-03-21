package com.atguigu.bilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 刘闯 on 2017/3/21.
 */

public class HomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    String[] titles = {"直播","推荐","追番","分区","发现"};

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public HomeAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
