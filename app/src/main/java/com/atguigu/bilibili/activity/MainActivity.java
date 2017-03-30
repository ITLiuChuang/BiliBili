package com.atguigu.bilibili.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.HomeAdapter;
import com.atguigu.bilibili.fragment.CartoonFragment;
import com.atguigu.bilibili.fragment.DiscoverFragment;
import com.atguigu.bilibili.fragment.LiveFragment;
import com.atguigu.bilibili.fragment.PartitionFragment;
import com.atguigu.bilibili.fragment.RecommendFragment;
import com.atguigu.bilibili.view.CircleImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Bind(R.id.navigation_layout)
    LinearLayout navigationLayout;
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorlayout;
    @Bind(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @Bind(R.id.toolbar_user_avatar)
    CircleImageView toolbarUserAvatar;
    @Bind(R.id.notification_main_column)
    NavigationView notificationMainColumn;
    private ArrayList<Fragment> fragments;
    private HomeAdapter adapter;


    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initListener() {
        notificationMainColumn.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.vip:
                        showToast("我的大会员");
                        break;
                    case R.id.integral:

                        break;
                    case R.id.cache:

                        break;
                    case R.id.review:

                        break;
                    case R.id.collect:

                        break;
                    case R.id.history:

                        break;
                    case R.id.attention:

                        break;
                    case R.id.wallet:

                        break;
                    case R.id.select:

                        break;
                    case R.id.setting:

                        break;
                }
                return true;
            }
        });

        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();

                if (menuItemId == R.id.menu_download) {
                    startActivity(new Intent(MainActivity.this,DownloadListActivity.class));
                } else if (menuItemId == R.id.menu_search) {
                    showToast("搜索");
                } else if (menuItemId == R.id.menu_game) {
                    showToast("游戏");
                }
                return true;
            }
        });
    }

    @Override
    protected void initView() {
        toolBar.inflateMenu(R.menu.menu_toolbar);
    }

    @Override
    protected void initData(String jaon, String error) {
        fragments = new ArrayList<>();
        fragments.add(new LiveFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new CartoonFragment());
        fragments.add(new PartitionFragment());
        fragments.add(new DiscoverFragment());

        adapter = new HomeAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    private int startY;
    private int startX;
    private boolean isScrollY;
    private boolean isFirst;
    private boolean isOpen = true;

    //tollBar 回弹效果
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int eventY = (int) ev.getY();
        int eventX = (int) ev.getX();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = eventY;
                startX = eventX;
                isFirst = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isFirst) {
                    if (Math.abs(eventX - startX) > Math.abs(eventY - startY) && Math.abs(eventX - startX) > toolBar.getHeight() * 0.30) {
                        isScrollY = false;
                        isFirst = false;
                        appbar.setExpanded(isOpen);
                    } else if (Math.abs(eventY - startY) > Math.abs(eventX - startX) && Math.abs(eventY - startY) > toolBar.getHeight() * 0.30) {
                        isScrollY = true;
                        isFirst = false;
                    }
                }
                if (isOpen) {
                    if (startY < eventY) {
                        startY = eventY;
                    }
                } else {
                    if (startY > eventY) {
                        startY = eventY;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isScrollY) {
                    if (isOpen) {
                        if (startY - eventY > toolBar.getHeight() * 0.36) {
                            appbar.setExpanded(false);
                            isOpen = false;
                        } else {
                            appbar.setExpanded(true);
                            isOpen = true;
                        }
                    } else {
                        if (eventY - startY > toolBar.getHeight() * 0.36) {
                            appbar.setExpanded(true);
                            isOpen = true;
                        } else {
                            appbar.setExpanded(false);
                            isOpen = false;
                        }
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @OnClick(R.id.navigation_layout)
    public void onClick() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            drawerlayout.openDrawer(GravityCompat.START);
        }
    }

}
