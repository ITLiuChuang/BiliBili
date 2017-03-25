package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.YuanChuangBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/25.
 */
public class YuanChuangAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<YuanChuangBean.DataBean> data;

    public YuanChuangAdapter(Context mContext, List<YuanChuangBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
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
            convertView = View.inflate(mContext, R.layout.item_yuanchuang, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        YuanChuangBean.DataBean dataBean = data.get(position);
        viewHolder.tvName.setText(dataBean.getName());
        viewHolder.tvTitle.setText(dataBean.getTitle());
        viewHolder.tvPts.setText("综合评价:" + dataBean.getPts());
        Glide.with(mContext).load(dataBean.getCover()).into(viewHolder.ivCover);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_cover)
        ImageView ivCover;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_pts)
        TextView tvPts;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
