package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.CartoonBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/22.
 */
public class SerializAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<CartoonBean.ResultBean.SerializingBean> datas;

    public SerializAdapter(Context mContext, List<CartoonBean.ResultBean.SerializingBean> serializing) {
        this.mContext = mContext;
        this.datas = serializing;
    }

    @Override
    public int getCount() {
        return 3;
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
            convertView = View.inflate(mContext, R.layout.item_serializ, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CartoonBean.ResultBean.SerializingBean serializingBean = datas.get(position);
        viewHolder.favourites.setText(serializingBean.getFavourites());
        viewHolder.title.setText(serializingBean.getTitle());
        viewHolder.newestEpIndex.setText("更新至" + serializingBean.getNewest_ep_index());
        Glide.with(mContext).load(serializingBean.getCover()).into(viewHolder.ivImg);
        return convertView;
    }

     class ViewHolder {
        @Bind(R.id.iv_img)
        ImageView ivImg;
        @Bind(R.id.favourites)
        TextView favourites;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.newest_ep_index)
        TextView newestEpIndex;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
