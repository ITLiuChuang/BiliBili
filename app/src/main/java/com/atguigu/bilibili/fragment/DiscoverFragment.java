package com.atguigu.bilibili.fragment;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.HuaTiActivity;
import com.atguigu.bilibili.activity.YuanChuangActivity;
import com.atguigu.bilibili.bean.Discoverbean;
import com.atguigu.bilibili.utils.AppNetConfig;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.atguigu.bilibili.R.id.tv_xingququan;

/**
 * Created by 刘闯 on 2017/3/21.
 * 发现
 */
public class DiscoverFragment extends BaseFragment {


    @Bind(R.id.ivest_hot_fl)
    TagFlowLayout ivestHotFl;
    @Bind(tv_xingququan)
    TextView tvXingququan;
    @Bind(R.id.tv_huatizhongxin)
    TextView tvHuatizhongxin;
    @Bind(R.id.tv_huodongzhongxin)
    TextView tvHuodongzhongxin;
    @Bind(R.id.tv_yuanchuang)
    TextView tvYuanchuang;
    @Bind(R.id.tv_quanqu)
    TextView tvQuanqu;
    @Bind(R.id.ivest_hot_f2)
    TagFlowLayout ivestHotF2;
    @Bind(R.id.jiazai)
    TextView jiazai;

    @Bind(R.id.shouqi)
    TextView shouqi;
    @Bind(R.id.ll_shouqi)
    LinearLayout llShouqi;
    @Bind(R.id.ll_jiazai)
    LinearLayout llJiazai;
    private Discoverbean discoverbean;
    private String[] datas;

    @Override
    protected void initListener() {
        llJiazai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llShouqi.setVisibility(View.VISIBLE);
                llJiazai.setVisibility(View.GONE);
            }
        });
        llShouqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llShouqi.setVisibility(View.GONE);
                llJiazai.setVisibility(View.VISIBLE);
            }
        });
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
        ivestHotF2.setAdapter(new TagAdapter<String>(datas) {

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


    @OnClick({tv_xingququan, R.id.tv_huatizhongxin, R.id.tv_huodongzhongxin, R.id.tv_yuanchuang, R.id.tv_quanqu})
    public void onClick(View view) {
        switch (view.getId()) {
            case tv_xingququan:
                break;
            case R.id.tv_huatizhongxin:
                Intent intent = new Intent(mContext, HuaTiActivity.class);
                intent.putExtra("name", tvHuatizhongxin.getText().toString());
                startActivity(intent);
                break;
            case R.id.tv_huodongzhongxin:
                intent = new Intent(mContext, HuaTiActivity.class);
                intent.putExtra("name", tvHuodongzhongxin.getText().toString());
                startActivity(intent);
                break;
            case R.id.tv_yuanchuang:
                intent = new Intent(mContext,YuanChuangActivity.class);
                intent.putExtra("name", tvYuanchuang.getText().toString());
                startActivity(intent);
                break;
            case R.id.tv_quanqu:
                break;
        }
    }


}
