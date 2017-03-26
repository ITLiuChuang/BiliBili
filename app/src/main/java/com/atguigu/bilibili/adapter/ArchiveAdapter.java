package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
public class ArchiveAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<SuoSouBean.DataBean.ItemsBean.ArchiveBean> datas;

    public ArchiveAdapter(Context mContext, List<SuoSouBean.DataBean.ItemsBean.ArchiveBean> archive) {
        this.mContext = mContext;
        this.datas = archive;
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
            convertView = View.inflate(mContext, R.layout.item_archive1, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SuoSouBean.DataBean.ItemsBean.ArchiveBean archiveBean = datas.get(position);
        viewHolder.tvDuration.setText(archiveBean.getDuration());
        viewHolder.tvTitle.setText(archiveBean.getTitle());
        viewHolder.tvAuthor.setText(archiveBean.getAuthor());
        viewHolder.tvPlay.setText(archiveBean.getPlay() + "");
        viewHolder.tvDanmaku.setText(archiveBean.getDanmaku() + "");
        Glide.with(mContext).load(archiveBean.getCover()).into(viewHolder.ivCover);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_cover)
        ImageView ivCover;
        @Bind(R.id.tv_duration)
        TextView tvDuration;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_author)
        TextView tvAuthor;
        @Bind(R.id.iv_img)
        ImageView ivImg;
        @Bind(R.id.tv_play)
        TextView tvPlay;
        @Bind(R.id.iv_img1)
        ImageView ivImg1;
        @Bind(R.id.tv_danmaku)
        TextView tvDanmaku;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
