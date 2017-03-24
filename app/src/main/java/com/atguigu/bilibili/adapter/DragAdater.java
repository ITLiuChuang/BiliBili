package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.PartitionBean;
import com.atguigu.bilibili.view.MyGridView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/24.
 */
public class DragAdater extends BaseAdapter {

    private final Context mContext;
    private final List<PartitionBean.DataBean> datas;
    private final String[] name;
    private final int[] id;

    public DragAdater(Context mContext, List<PartitionBean.DataBean> datas, String[] name, int[] id) {
        this.mContext = mContext;
        this.datas = datas;
        this.name = name;
        this.id = id;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_drag, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PartitionBean.DataBean dataBean = datas.get(position);
        if (!TextUtils.isEmpty(dataBean.getTitle()) ) {
            viewHolder.tvTypename.setText(datas.get(position).getTitle());
            viewHolder.image.setImageResource(id[position%16]);
            if(datas.get(position).getBody().size()<4) {
                viewHolder.gvHot.setNumColumns(3);
            }
            viewHolder.gvHot.setAdapter(new DragAdapters(mContext, datas.get(position).getBody()));

        } else {
            viewHolder.tvTypename.setText("主题");
            viewHolder.image.setImageResource(id[position%16]);
            viewHolder.gvHot.setNumColumns(1);
            viewHolder.gvHot.setAdapter(new DragAdapter(mContext, datas.get(position).getBody()));
        }


        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.image)
        ImageView image;
        @Bind(R.id.tv_typename)
        TextView tvTypename;
        @Bind(R.id.rl_tuijianzhubo)
        RelativeLayout rlTuijianzhubo;
        @Bind(R.id.gv_hot)
        MyGridView gvHot;
        @Bind(R.id.but_more)
        Button butMore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
