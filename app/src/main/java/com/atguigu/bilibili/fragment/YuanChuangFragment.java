package com.atguigu.bilibili.fragment;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.YuanChuangAdapter;
import com.atguigu.bilibili.bean.YuanChuangBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;

/**
 * Created by 刘闯 on 2017/3/25.
 */
public class YuanChuangFragment extends BaseFragment {
    @Bind(R.id.lv_home)
    ListView lvHome;


    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_yuanchuang;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.YUANCHUANG_TAG;
    }

    @Override
    protected void initData(String json) {
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "LiveFragment initData()");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {
                YuanChuangBean yuanChuangBean = JSON.parseObject(json, YuanChuangBean.class);
                lvHome.setAdapter(new YuanChuangAdapter(mContext, yuanChuangBean.getData()));
            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
    }


}
