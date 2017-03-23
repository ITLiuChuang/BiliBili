package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.RecommendActivity;
import com.atguigu.bilibili.bean.LiveBean;
import com.atguigu.bilibili.view.MyGridView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/22.
 */

public class EntranceiconsAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<LiveBean.DataBean.PartitionsBean> datas;
    private LiveBean.DataBean.PartitionsBean iconsBean;

    public EntranceiconsAdapter(Context mContext, List<LiveBean.DataBean.PartitionsBean> entranceIcons) {
        this.mContext = mContext;
        this.datas = entranceIcons;

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
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_entranceicons, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        iconsBean = datas.get(position);
        viewHolder.tvTypename.setText(iconsBean.getPartition().getName());
        viewHolder.count.setText("当前" + iconsBean.getPartition().getCount() + "个主播");
        viewHolder.gvHot.setAdapter(new PartitionAdapter(mContext, datas.get(position).getLives()));
        Glide.with(mContext).load(iconsBean.getPartition().getSub_icon().getSrc()).into(viewHolder.image);

        viewHolder.rlTuijianzhubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RecommendActivity.class);
                intent.putExtra("name", viewHolder.tvTypename.getText());
                mContext.startActivity(intent);
            }
        });

        viewHolder.butMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RecommendActivity.class);
                intent.putExtra("name", viewHolder.tvTypename.getText());
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @Bind(R.id.image)
        ImageView image;
        @Bind(R.id.tv_typename)
        TextView tvTypename;
        @Bind(R.id.count)
        TextView count;
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
