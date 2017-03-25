package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.BannerActivity;
import com.atguigu.bilibili.bean.LiveBean;
import com.atguigu.bilibili.view.MyGridView;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘闯 on 2017/3/21.
 */

public class LiveAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {
    private static final int BANNER = 0;
    private static final int ENTRANCEICONS = 1;
    private final Context mContext;
    private final LiveBean.DataBean datas;
    private static LayoutInflater inflater;


    public LiveAdapter(Context mContext, LiveBean.DataBean data) {
        this.mContext = mContext;
        this.datas = data;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            return BANNER;
        } else if (position == ENTRANCEICONS) {
            return ENTRANCEICONS;
        }
        return BANNER;
    }

    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BANNER:

                return new BannerViewHodler(View.inflate(mContext, R.layout.item_live_banner, null));
            case ENTRANCEICONS:
                return new EntranceiconsViewHodler(View.inflate(mContext, R.layout.item_live_entranceicons, null));
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


    class BannerViewHodler extends LiveBaseViewHolder {
        @Bind(R.id.banner)
        Banner banner;


        public BannerViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData() {
            List<String> images = new ArrayList<>();
            for (int i = 0; i < datas.getBanner().size(); i++) {
                images.add(datas.getBanner().get(i).getImg());

            }
            banner.setImages(images).
                    setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(mContext).load(path).into(imageView);
                        }
                    });

            banner.start();

            banner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent = new Intent(mContext, BannerActivity.class);
                    String link = datas.getBanner().get(position-1).getLink();
                    intent.putExtra("img",link );
                    mContext.startActivity(intent);
                }
            });

        }

        @OnClick({R.id.live_home_follow_anchor, R.id.live_home_live_center, R.id.live_home_clip_video, R.id.live_home_search_room, R.id.live_home_all_category})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.live_home_follow_anchor:
                    Toast.makeText(mContext, "关注", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.live_home_live_center:
                    Toast.makeText(mContext, "中心", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.live_home_clip_video:
                    Toast.makeText(mContext, "小视频", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.live_home_search_room:
                    Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.live_home_all_category:
                    Toast.makeText(mContext, "分类", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    class EntranceiconsViewHodler extends LiveBaseViewHolder {

        @Bind(R.id.gv_hot)
        MyGridView gvHot;
        private EntranceiconsAdapter adapter;

        public EntranceiconsViewHodler(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {

            //设置适配器
            adapter = new EntranceiconsAdapter(mContext, datas.getPartitions());
            gvHot.setAdapter(adapter);

        }
    }


}