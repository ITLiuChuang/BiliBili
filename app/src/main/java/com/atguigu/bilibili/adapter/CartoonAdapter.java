package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.CartoonBean;
import com.atguigu.bilibili.view.MyGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/23.
 */
public class CartoonAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final CartoonBean.ResultBean datas;
    private final LayoutInflater inflater;
    private static final int LANDING = 0;
    private static final int SERIALIZ = 1;
    private static final int BANNER = 2;


    public CartoonAdapter(Context mContext, CartoonBean.ResultBean result) {
        this.mContext = mContext;
        this.datas = result;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {

        if (position == LANDING) {
            return LANDING;
        }
        if (position == SERIALIZ) {
            return SERIALIZ;
        }
        if (position == BANNER) {
            return BANNER;
        }
        return SERIALIZ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case LANDING:
                return new LandingViewHodler(View.inflate(mContext, R.layout.item_cartoon_landing, null));
            case SERIALIZ:
                return new SerializViewHodler(View.inflate(mContext, R.layout.item_cartoon_serializ, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case SERIALIZ:
                SerializViewHodler viewHodler = (SerializViewHodler) holder;
                viewHodler.setData();
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class SerializViewHodler extends RecyclerView.ViewHolder {
        @Bind(R.id.gv_hot)
        MyGridView gvHot;

        public SerializViewHodler(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        public void setData() {
            gvHot.setAdapter(new SerializAdapter(mContext, datas.getSerializing()));
        }
    }

    private class LandingViewHodler extends RecyclerView.ViewHolder {
        public LandingViewHodler(View inflate) {
            super(inflate);
        }
    }
}
