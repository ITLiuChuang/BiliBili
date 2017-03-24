package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.ComprehensiveBean;
import com.atguigu.bilibili.view.MyGridView;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class MultipleAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {
    private final Context mContext;
    private final List<ComprehensiveBean.DataBean> datas;
    @Bind(R.id.gv_hot)
    MyGridView gvHot;
    private final LayoutInflater inflater;


    public MultipleAdapter(Context mContext, List<ComprehensiveBean.DataBean> data) {
        this.mContext = mContext;
        this.datas = data;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MultipleViewHodler(View.inflate(mContext, R.layout.item_recommend_multiple, null));
    }

    @Override
    public void onBindViewHolder(LiveBaseViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

     class MultipleViewHodler extends LiveBaseViewHolder {
        @Bind(R.id.gv_hot)
        MyGridView gvHot;
        public MultipleViewHodler(View inflate) {
            super(inflate);
            ButterKnife.bind(this,inflate);
        }

        @Override
        public void setData() {
            gvHot.setAdapter(new SyntheticalAdapter(mContext,datas));
        }
    }
}
