package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.PartitionBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class DragAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<PartitionBean.DataBean.BodyBean> datas;


    public DragAdapter(Context mContext, List<PartitionBean.DataBean.BodyBean> body) {
        this.mContext = mContext;
        this.datas = body;
    }

    @Override
    public int getCount() {
        return 1;
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
            convertView = View.inflate(mContext, R.layout.item_dragadapter, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PartitionBean.DataBean.BodyBean bodyBean = datas.get(position);
        Log.e("TAG", "aaaaaaaaaaaaaa" + bodyBean.getCover());
        Glide.with(mContext).load(bodyBean.getCover()).into(viewHolder.ivImg);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_img)
        ImageView ivImg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
