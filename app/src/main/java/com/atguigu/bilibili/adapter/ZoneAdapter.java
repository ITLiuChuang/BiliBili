package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.PartitionBean;
import com.atguigu.bilibili.view.MyGridView;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/23.
 */
public class ZoneAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {
    public static final int CHANNEL = 0;
    public static final int DRAG = 1;
    private final Context mContext;
    private final List<PartitionBean.DataBean> datas;
    private final LayoutInflater inflater;


    private String[] name = new String[]{"直播", "番剧", "动画", "国创"
            , "音乐", "舞蹈", "游戏", "科技", "生活", "鬼畜"
            , "时尚", "广告", "娱乐", "电影", "电视剧", "游戏中心"};
    private int[] id = new int[]{R.drawable.ic_head_live
            , R.drawable.ic_category_t13, R.drawable.ic_category_t1, R.drawable.bangumi_follow_ic_domestic_recommend
            , R.drawable.ic_category_t3, R.drawable.ic_category_t129, R.drawable.ic_category_t4
            , R.drawable.ic_category_t36, R.drawable.ic_category_t160, R.drawable.ic_category_t119
            , R.drawable.ic_category_t155, R.drawable.ic_category_t165, R.drawable.ic_category_t5
            , R.drawable.ic_category_t23, R.drawable.ic_category_t11, R.drawable.ic_category_game_center
    };

    public ZoneAdapter(Context mContext, List<PartitionBean.DataBean> data) {
        this.mContext = mContext;
        this.datas = data;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == CHANNEL) {
            return CHANNEL;

        } else if (position == DRAG) {
            return DRAG;
        }
        return CHANNEL;
    }

    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CHANNEL) {
            return new ChannelViewHolder(View.inflate(mContext, R.layout.item_zone_channe, null));
     } else if (viewType == DRAG) {
           return new DragViewHolder(View.inflate(mContext, R.layout.item_zone_drag, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(LiveBaseViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ChannelViewHolder extends LiveBaseViewHolder {
        @Bind(R.id.gv_channel)
        MyGridView gvChannel;

        public ChannelViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {
            gvChannel.setAdapter(new ChanneAdapter(mContext,name,id));
        }
    }

    class DragViewHolder extends LiveBaseViewHolder {
        @Bind(R.id.gv_hot)
        MyGridView gvHot;

        public DragViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this,inflate);
        }

        @Override
        public void setData() {
            gvHot.setAdapter(new DragAdater(mContext, datas,name,id));

        }
    }
}
