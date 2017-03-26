package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.SuoSouBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/26.
 */
public class SeasonAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<SuoSouBean.DataBean.ItemsBean.SeasonBean> datas;

    public SeasonAdapter(Context mContext, List<SuoSouBean.DataBean.ItemsBean.SeasonBean> season) {
        this.mContext = mContext;
        this.datas = season;
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
            convertView = View.inflate(mContext, R.layout.item_season1, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(datas.size()!=0) {
            SuoSouBean.DataBean.ItemsBean.SeasonBean seasonBean = datas.get(position);
            viewHolder.tvTitle1.setText(seasonBean.getTitle());
            viewHolder.tvIndex.setText(seasonBean.getNewest_season() + "，更新至" + seasonBean.getIndex() + "hua");
            viewHolder.tvCatDesc.setText(seasonBean.getCat_desc());
            Glide.with(mContext).load(seasonBean.getCover()).into(viewHolder.ivCover1);
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_cover1)
        ImageView ivCover1;
        @Bind(R.id.tv_title1)
        TextView tvTitle1;
        @Bind(R.id.tv_index)
        TextView tvIndex;
        @Bind(R.id.tv_cat_desc)
        TextView tvCatDesc;
        @Bind(R.id.ll_search)
        LinearLayout llSearch;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
