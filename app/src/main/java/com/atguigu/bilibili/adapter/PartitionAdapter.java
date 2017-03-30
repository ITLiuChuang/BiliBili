package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.DanmkuVideoActivity;
import com.atguigu.bilibili.bean.LiveBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/22.
 */
public class PartitionAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<LiveBean.DataBean.PartitionsBean.LivesBean> datas;

    public PartitionAdapter(Context mContext, List<LiveBean.DataBean.PartitionsBean.LivesBean> lives) {
        this.mContext = mContext;
        this.datas = lives;
    }

    @Override
    public int getCount() {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_partition, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LiveBean.DataBean.PartitionsBean.LivesBean livesBean = datas.get(position);
        viewHolder.tvTitle.setText(livesBean.getTitle());
        viewHolder.tvName.setText(livesBean.getOwner().getName());
        viewHolder.tvFollow.setText(livesBean.getOnline() + "");
        Glide.with(mContext).load(livesBean.getCover().getSrc()).into(viewHolder.ivHot);

        viewHolder.itemLiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DanmkuVideoActivity.class);
                intent.putExtra("video",datas.get(position).getPlayurl());
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_hot)
        ImageView ivHot;
        @Bind(R.id.tv_title)
        TextView tvTitle;
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
