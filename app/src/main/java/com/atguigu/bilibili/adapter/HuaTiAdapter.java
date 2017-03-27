package com.atguigu.bilibili.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.BannerActivity;
import com.atguigu.bilibili.activity.HuaTiActivity;
import com.atguigu.bilibili.bean.HuoDongBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/25.
 */
public class HuaTiAdapter extends BaseAdapter {
    private final HuaTiActivity mContext;

    private final List<HuoDongBean.ListBean> datas;





    public HuaTiAdapter(HuaTiActivity huaTiActivity, List<HuoDongBean.ListBean> list) {
        this.mContext = huaTiActivity;
        this.datas = list;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_huati, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTitle.setText(datas.get(position).getTitle());
        Glide.with(mContext).load(datas.get(position).getCover()).into(viewHolder.ivImg);

        viewHolder.llHuati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BannerActivity.class);
                intent.putExtra("img",datas.get(position).getLink());
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_img)
        ImageView ivImg;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.item_live_layout)
        CardView itemLiveLayout;
        @Bind(R.id.ll_huati)
        LinearLayout llHuati;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
