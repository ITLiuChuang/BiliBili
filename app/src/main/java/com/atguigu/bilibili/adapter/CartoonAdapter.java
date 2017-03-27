package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.CartoonBean;
import com.atguigu.bilibili.view.MyGridView;
import com.atguigu.bilibili.viewhodler.LiveBaseViewHolder;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/23.
 */
public class CartoonAdapter extends RecyclerView.Adapter<LiveBaseViewHolder> {
    private final Context mContext;

    private final LayoutInflater inflater;
    private static final int LANDING = 0;
    private static final int SERIALIZ = 1;
    private final CartoonBean.ResultBean datas;


    public CartoonAdapter(Context mContext, CartoonBean.ResultBean result) {
        this.mContext = mContext;
        this.datas = result;

        inflater = LayoutInflater.from(mContext);
    }




    @Override
    public int getItemViewType(int position) {
        if (position == LANDING) {
            return LANDING;
        }
        if (position == SERIALIZ) {
            return SERIALIZ;
        }
        return LANDING;
    }

    @Override
    public LiveBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LANDING) {
            return new LandingViewHodler(View.inflate(mContext, R.layout.item_cartoon_landing, null));
        }
        if (viewType == SERIALIZ) {
            return new SerializViewHodler(View.inflate(mContext, R.layout.item_cartoon_serializ, null));
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

    private class LandingViewHodler extends LiveBaseViewHolder {
        public LandingViewHodler(View inflate) {
            super(inflate);
        }

        @Override
        public void setData() {

        }
    }

    class SerializViewHodler extends LiveBaseViewHolder {
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
        @Bind(R.id.banner)
        Banner banner;

        public SerializViewHodler(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }

        @Override
        public void setData() {
            gvHot.setAdapter(new SerializAdapter(mContext, datas.getSerializing()));
            List<String> images = new ArrayList<>();
            for (int i = 0; i < datas.getAd().getHead().size(); i++) {
                images.add(datas.getAd().getHead().get(i).getImg());
            }

            banner.setImages(images).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(mContext).load(path).into(imageView);
                }
            });
            banner.start();
        }
    }
}




