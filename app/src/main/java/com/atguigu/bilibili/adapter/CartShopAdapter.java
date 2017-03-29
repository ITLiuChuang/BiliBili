package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.CartBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/29.
 */
public class CartShopAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<CartBean.ResultBean.RecordsBean> datas;
    private CartBean.ResultBean.RecordsBean recordsBean;

    public CartShopAdapter(Context mContext, List<CartBean.ResultBean.RecordsBean> datas) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
      ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_cartshop, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        recordsBean = datas.get(position);
        viewHolder.tvSalveprice.setText(recordsBean.getSalvePrice() + "");
        viewHolder.tvTitle.setText(recordsBean.getTitle());
        Glide.with(mContext).load(recordsBean.getImgUrl()).into(viewHolder.ivImgurl);

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_imgurl)
        ImageView ivImgurl;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_salveprice)
        TextView tvSalveprice;
        @Bind(R.id.ll_cart)
        LinearLayout llCart;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
