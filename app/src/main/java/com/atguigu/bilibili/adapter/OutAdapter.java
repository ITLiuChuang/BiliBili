package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.User;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/28.
 */
public class OutAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<User> listData;
    private User user;


    public OutAdapter(Context mContext, List<User> listData) {
        this.mContext = mContext;
        this.listData = listData;
    }


    @Override
    public int getCount() {
        return listData.size();
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
            convertView = View.inflate(mContext, R.layout.item_checkout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        user = listData.get(position);
        Glide.with(mContext).load(user.getImageUrl()).into(viewHolder.ivGov);
        viewHolder.tvDescGov.setText(user.getDetails());
        viewHolder.tvPriceGov.setText("￥" + user.getNumber());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_gov)
        ImageView ivGov;
        @Bind(R.id.tv_desc_gov)
        TextView tvDescGov;
        @Bind(R.id.tv_price_gov)
        TextView tvPriceGov;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
