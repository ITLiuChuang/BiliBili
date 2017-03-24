package com.atguigu.bilibili.fragment;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.Discoverbean;
import com.atguigu.bilibili.utils.AppNetConfig;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘闯 on 2017/3/21.
 * 发现
 */
public class DiscoverFragment extends BaseFragment {


    @Bind(R.id.ivest_hot_fl)
    TagFlowLayout ivestHotFl;
    @Bind(R.id.tv_xingququan)
    TextView tvXingququan;
    @Bind(R.id.tv_huatizhongxin)
    TextView tvHuatizhongxin;
    @Bind(R.id.tv_huodongzhongxin)
    TextView tvHuodongzhongxin;
    @Bind(R.id.tv_yuanchuang)
    TextView tvYuanchuang;
    @Bind(R.id.tv_quanqu)
    TextView tvQuanqu;
    private Discoverbean discoverbean;
    private String[] datas;

    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected String setUrl() {
        return AppNetConfig.DISCOVER_TAG;
    }

    @Override
    protected void initData(String json) {
        if (TextUtils.isEmpty(json)) {
            Log.e("TAG", "LiveFragment initData()");
        } else {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer code = jsonObject.getInteger("code");
            if (code == 0) {
                discoverbean = JSON.parseObject(json, Discoverbean.class);
                datas = new String[discoverbean.getData().getList().size()];
                for (int i = 0; i < discoverbean.getData().getList().size(); i++) {
                    datas[i] = discoverbean.getData().getList().get(i).getKeyword();
                }

            } else {
                Log.e("TAG", "LiveFragment initData()联网失败");
            }
        }
        ivestHotFl.setAdapter(new TagAdapter<String>(datas) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                final TextView textView = new TextView(getActivity());
                textView.setText(s);
                //设置shape
                textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.hot_shape));
                //获取shapeDrawable
                GradientDrawable background = (GradientDrawable) textView.getBackground();
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                return textView;
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.tv_xingququan, R.id.tv_huatizhongxin, R.id.tv_huodongzhongxin, R.id.tv_yuanchuang, R.id.tv_quanqu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_xingququan:
                break;
            case R.id.tv_huatizhongxin:
                break;
            case R.id.tv_huodongzhongxin:
                break;
            case R.id.tv_yuanchuang:
                break;
            case R.id.tv_quanqu:
                break;
        }
    }
}
