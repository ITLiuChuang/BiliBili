package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.RecommendBean;
import com.atguigu.bilibili.view.MyGridView;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/23.
 */
public class RecommendAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {

    private static final int RECOMMEND = 0;
    private final Context mContext;
    private final List<RecommendBean.DataBean> datas;
    private final LayoutInflater inflater;


    public RecommendAdapter(Context mContext, List<RecommendBean.DataBean> data) {
        this.mContext = mContext;
        this.datas = data;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return RECOMMEND;
    }

    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RECOMMEND) {
            return new RecommendViewHodler(View.inflate(mContext, R.layout.item_live_recommend, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(LiveBaseViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class RecommendViewHodler extends LiveBaseViewHolder {
        @Bind(R.id.gv_hot)
        MyGridView gvHot;
        private RecommAdapter recommAdapter;

        public RecommendViewHodler(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {
            recommAdapter = new RecommAdapter(mContext, datas);
            gvHot.setAdapter(recommAdapter);
        }
    }
}
