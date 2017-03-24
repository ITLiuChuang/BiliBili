package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.PartitionBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class DragAdapters extends BaseAdapter {
    private final Context mContext;
    private final List<PartitionBean.DataBean.BodyBean> datas;

    public DragAdapters(Context mContext, List<PartitionBean.DataBean.BodyBean> body) {
        this.mContext = mContext;
        this.datas = body;
    }

    @Override
    public int getCount() {
        if (datas.size() < 4) {
            return datas.size();
        }
        return 4;
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
            convertView = View.inflate(mContext, R.layout.item_drags, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PartitionBean.DataBean.BodyBean bodyBean = datas.get(position);
        viewHolder.tvTitle.setText(bodyBean.getTitle());
        viewHolder.tvName.setText(bodyBean.getPlay() + "");
        viewHolder.tvFollow.setText(bodyBean.getDanmaku() + "");
        Glide.with(mContext).load(bodyBean.getCover()).into(viewHolder.ivHot);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_hot)
        ImageView ivHot;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.iv_palyer)
        ImageView ivPalyer;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_follow)
        TextView tvFollow;
        @Bind(R.id.item_live_layout)
        CardView itemLiveLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
