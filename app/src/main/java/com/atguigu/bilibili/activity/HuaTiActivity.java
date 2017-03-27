package com.atguigu.bilibili.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.HuaTiAdapter;
import com.atguigu.bilibili.bean.HuoDongBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;

public class HuaTiActivity extends BaseActivity {


    @Bind(R.id.lv_home)
    ListView lvHome;

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    Button ivBack;
    private String name;


    @Override
    protected String setUrl() {
        return AppNetConfig.HUODONG_TAG;
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
        Intent intent = getIntent();
        name = intent.getStringExtra("name");


    }

    @Override
    protected void initData(String json, String error) {
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "json为空");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {

                HuoDongBean huoDongBean = JSON.parseObject(json, HuoDongBean.class);
                lvHome.setAdapter(new HuaTiAdapter(HuaTiActivity.this, huoDongBean.getList()));


                tvTitle.setText(name);
            }
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_hua_ti;
    }


}
