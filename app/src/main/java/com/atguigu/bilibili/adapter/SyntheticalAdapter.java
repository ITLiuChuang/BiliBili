package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.ComprehensiveBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class SyntheticalAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ComprehensiveBean.DataBean> datas;


    public SyntheticalAdapter(Context mContext, List<ComprehensiveBean.DataBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_synthetical, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ComprehensiveBean.DataBean dataBean = datas.get(position);
        viewHolder.tvTitle.setText(dataBean.getTitle());
        Glide.with(mContext).load(dataBean.getCover()).into(viewHolder.ivHot);

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_hot)
        ImageView ivHot;
        @Bind(R.id.iv_img)
        ImageView ivImg;
        @Bind(R.id.tv_play)
        TextView tvPlay;
        @Bind(R.id.iv_img1)
        ImageView ivImg1;
        @Bind(R.id.tv_player)
        TextView tvPlayer;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_follow)
        ImageView tvFollow;
        @Bind(R.id.item_live_layout)
        CardView itemLiveLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
