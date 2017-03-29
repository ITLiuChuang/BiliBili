package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.ComprehensiveBean;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/29.
 */
public class MultipleAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {
    private final Context mContext;
    private final List<ComprehensiveBean.DataBean> datas;

    private ComprehensiveBean.DataBean dataBean;

    public MultipleAdapter(Context mContext, List<ComprehensiveBean.DataBean> data) {
        this.mContext = mContext;
        this.datas = data;
    }

    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MultipleViewHodler(View.inflate(mContext, R.layout.item_recommend_multipl, null));
    }

    @Override
    public void onBindViewHolder(LiveBaseViewHolder holder, int position) {
        MultipleViewHodler multipleViewHodler = (MultipleViewHodler) holder;

        dataBean = datas.get(position);
        Glide.with(mContext).load(dataBean.getCover()).into(multipleViewHodler.ivHot);
        multipleViewHodler.tvPlay.setText(dataBean.getPlay() +"");
        multipleViewHodler.tvTitle.setText(dataBean.getTitle());
        multipleViewHodler.tvTime.setText(dataBean.getCtime() + "");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void AddFooterItem(List<ComprehensiveBean.DataBean> footerDatas) {
        datas.addAll(footerDatas);
        notifyDataSetChanged();

    }

    class MultipleViewHodler extends LiveBaseViewHolder {
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

        public MultipleViewHodler(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {

        }
    }
}
