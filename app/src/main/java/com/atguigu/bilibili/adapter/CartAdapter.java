package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.CartDetailsActivity;
import com.atguigu.bilibili.bean.CartBean;
import com.atguigu.bilibili.bean.GoodsBean;
import com.atguigu.bilibili.view.MyGridView;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/28.
 */
public class CartAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {
    private final Context mContext;
    private final List<CartBean.ResultBean.RecordsBean> datas;

    private CartBean.ResultBean.RecordsBean recordsBean;
    public static final String GOODS_BEAN = "goodsBean";

    public CartAdapter(Context mContext, List<CartBean.ResultBean.RecordsBean> records) {
        this.mContext = mContext;
        this.datas = records;
    }


    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CartViewHolder(View.inflate(mContext, R.layout.item_cart, null));
    }

    @Override
    public void onBindViewHolder(LiveBaseViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 1;
    }


     class CartViewHolder extends LiveBaseViewHolder {
        @Bind(R.id.gv_home)
        MyGridView gvHome;

        public CartViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {
            gvHome.setAdapter(new CartShopAdapter(mContext, datas));
            gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    CartBean.ResultBean.RecordsBean recordsBean = datas.get(position);
                    GoodsBean goodsBean = new GoodsBean();
                    goodsBean.setImgUrl(recordsBean.getImgUrl());
                    goodsBean.setTitle(recordsBean.getTitle());
                    goodsBean.setSalvePrice(recordsBean.getSalvePrice());

                    Intent intent = new Intent(mContext, CartDetailsActivity.class);
                    intent.putExtra(GOODS_BEAN, goodsBean);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
