package com.atguigu.bilibili.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.HuaTiAdapter;
import com.atguigu.bilibili.bean.HuaTiBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;

public class HuaTiActivity extends BaseActivity {


    @Bind(R.id.lv_home)
    ListView lvHome;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    @Override
    protected String setUrl() {
        return AppNetConfig.HUATI_TAG;
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
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "json为空");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {
                HuaTiBean huaTiBean = JSON.parseObject(json, HuaTiBean.class);
                lvHome.setAdapter(new HuaTiAdapter(HuaTiActivity.this, huaTiBean.getList()));
            }
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_hua_ti;
    }



}
