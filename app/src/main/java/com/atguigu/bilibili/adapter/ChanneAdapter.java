package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/23.
 */
public class ChanneAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] name;
    private final int[] id;

    public ChanneAdapter(Context mContext, String[] name, int[] id) {
        this.mContext = mContext;
        this.name = name;
        this.id = id;
    }

    @Override
    public int getCount() {
        return 16;
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
            convertView = View.inflate(mContext, R.layout.item_channe, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.tvChannel.setText(name[position]);
        viewHolder.ivChannel.setImageResource(id[position]);

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_channel)
        ImageView ivChannel;
        @Bind(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
