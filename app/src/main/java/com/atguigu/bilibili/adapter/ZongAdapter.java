package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.SuoSouBean;
import com.atguigu.bilibili.view.MyGridView;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/26.
 */
public class ZongAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {
    private static final int SEASON = 0;
    private static final int ARCHIVE = 1;
    private final Context mContext;
    private final SuoSouBean.DataBean datas;

    public ZongAdapter(Context mContext, SuoSouBean.DataBean data) {
        this.mContext = mContext;
        this.datas = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == SEASON) {
            return SEASON;
        } else if (position == ARCHIVE) {
            return ARCHIVE;
        }
        return SEASON;
    }

    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SEASON) {

            return new SeasonViewHolder(View.inflate(mContext, R.layout.item_season, null));

        } else if (viewType == ARCHIVE) {
            return new ArchiveViewHolder(View.inflate(mContext, R.layout.item_archive, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(LiveBaseViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    class SeasonViewHolder extends LiveBaseViewHolder {

        @Bind(R.id.gv_hot)
        MyGridView gvHot;

        public SeasonViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {
            if (datas.getItems().getSeason()!= null) {

                gvHot.setAdapter(new SeasonAdapter(mContext, datas.getItems().getSeason()));
            }
        }
    }

    class ArchiveViewHolder extends LiveBaseViewHolder {
        @Bind(R.id.gv_home)
        MyGridView gvHome;

        public ArchiveViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {
            gvHome.setAdapter(new ArchiveAdapter(mContext, datas.getItems().getArchive()));
        }
    }
}
