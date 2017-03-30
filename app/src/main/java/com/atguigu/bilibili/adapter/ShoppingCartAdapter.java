package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.User;
import com.atguigu.bilibili.view.AddSubView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘闯 on 2017/3/28.
 */
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHoler> {
    private final Context mContent;
    private final TextView tvShopcartTotal;
    private final CheckBox checkboxAll;
    private final CheckBox checkboxDeleteAll;
    private final List<User> datas;
    private User user;

    public ShoppingCartAdapter(Context mContext, List<User> list, TextView tvShopcartTotal, CheckBox checkboxAll, CheckBox checkboxDeleteAll) {
        this.mContent = mContext;
        this.datas = list;
        this.tvShopcartTotal = tvShopcartTotal;
        this.checkboxAll = checkboxAll;
        this.checkboxDeleteAll = checkboxDeleteAll;
        showTotalPrice();
    }

    public void showTotalPrice() {
        tvShopcartTotal.setText("合计：" + getTotalPrice());
    }

    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHoler(View.inflate(mContent, R.layout.item_shop_cart, null));
    }

    @Override
    public void onBindViewHolder(MyViewHoler holder, int position) {
//得到数据
        user = datas.get(position);
        Log.e("TAG", "datas" + datas.get(position));
        //绑定数据
        holder.cbGov.setChecked(user.getIsChecked());
        //图片
        Glide.with(mContent).load(user.getImageUrl()).into(holder.ivGov);
        //设置名称
        holder.tvDescGov.setText(user.getDetails());
        //设置价格
        holder.tvPriceGov.setText("¥" + user.getMoney());
        //设置数量
        holder.addSubView.setValue(user.getNumber());

        //设置最小值与库存
        holder.addSubView.getMinValue(1);
        holder.addSubView.getMaxValue(100);

        holder.addSubView.setOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void OnNumberChanger(int value) {
                //回调数量
                user.setNumber(value);
//                CartStorage.getInstance(mContent).updataData(goodsBean);
                showTotalPrice();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    /**
     * 校验是否全选
     */
    public void checkAll() {
        if (datas != null && datas.size() > 0) {
            int number = 0;
            for (int i = 0; i < datas.size(); i++) {
                User user = datas.get(i);
                if (!user.getIsChecked()) {
                    checkboxAll.setChecked(false);
                    checkboxDeleteAll.setChecked(false);
                } else {
                    number++;
                }
            }
            if (datas.size() == number) {
                checkboxDeleteAll.setChecked(true);
                checkboxAll.setChecked(true);

            }
        } else {
            checkboxAll.setChecked(false);
            checkboxDeleteAll.setChecked(false);
        }
    }
    /**
     * 删除
     */
    public void deleteData() {
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                User user = datas.get(i);
                if (user.getIsChecked()) {
                    //内存删除
                    datas.remove(user);
                    //本地保存
                    //刷新数据

                    notifyItemRemoved(i);
                    i--;
                }

            }

        }
    }
    public void checkAll_none(boolean isChecked) {
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                User user = datas.get(i);
                //设置勾选状态
                user.setIsChecked(isChecked);
                checkboxAll.setChecked(isChecked);
                checkboxDeleteAll.setChecked(isChecked);
                //更新视图
                notifyItemChanged(i);
            }
        }

    }
    public double getTotalPrice() {
        double totalPrice = 0;
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                User user = datas.get(i);
                if (user.getIsChecked()) {
                    totalPrice += Double.parseDouble(user.getMoney() + "") * user.getNumber();
                }
            }
        }
        return totalPrice;
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {
        @Bind(R.id.cb_gov)
        CheckBox cbGov;
        @Bind(R.id.iv_gov)
        ImageView ivGov;
        @Bind(R.id.tv_desc_gov)
        TextView tvDescGov;
        @Bind(R.id.tv_price_gov)
        TextView tvPriceGov;
        @Bind(R.id.addSubView)
        AddSubView addSubView;
        private String totalPrice;

        public MyViewHoler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemOnItemClick != null) {
                        itemOnItemClick.onItemClickListener(v, getLayoutPosition());
                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        public void onItemClickListener(View view, int position);
    }

    private OnItemClickListener itemOnItemClick;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.itemOnItemClick = l;

    }
}
