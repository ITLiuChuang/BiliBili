package com.atguigu.bilibili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.SearchAdapter;
import com.atguigu.bilibili.fragment.FanFragment;
import com.atguigu.bilibili.fragment.UPFragment;
import com.atguigu.bilibili.fragment.YingShiFragment;
import com.atguigu.bilibili.fragment.ZongHeFragment;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

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
    private int REQUEST_CODE;
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
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(SearchActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (requestCode == REQUEST_CODE) {
                //处理扫描结果（在界面上显示）
                if (null != data) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
//                        Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(SearchActivity.this, BannerActivity.class);
                        intent.putExtra("img",result );
                        startActivity(intent);
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
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
