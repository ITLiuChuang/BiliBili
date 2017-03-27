package com.atguigu.bilibili.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.SearchActivity;
import com.atguigu.bilibili.adapter.ZongAdapter;
import com.atguigu.bilibili.bean.SuoSouBean;
import com.atguigu.bilibili.utils.AppNetConfig;

import butterknife.Bind;

/**
 * Created by 刘闯 on 2017/3/26.
 */
public class ZongHeFragment extends BaseFragment {


    private final String name;
    @Bind(R.id.rv_home)
    RecyclerView rvHome;

    public ZongHeFragment(SearchActivity searchActivity, String name) {
        this.mContext = searchActivity;
        this.name = name;
    }



    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_zonghe;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.SOU_TAG + name + AppNetConfig.SUO_TAG;

    }

    @Override
    protected void initData(String json) {

        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "LiveFragment initData()");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {
                SuoSouBean suoSouBean = JSON.parseObject(json, SuoSouBean.class);
                rvHome.setAdapter(new ZongAdapter(mContext, suoSouBean.getData()));
                rvHome.setLayoutManager(new LinearLayoutManager(mContext));
            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
    }


}
