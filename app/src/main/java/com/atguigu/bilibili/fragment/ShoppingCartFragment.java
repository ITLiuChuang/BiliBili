package com.atguigu.bilibili.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.MyApplication;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.User;
import com.atguigu.bilibili.UserDao;
import com.atguigu.bilibili.activity.CartActivity;
import com.atguigu.bilibili.activity.OutActivity;
import com.atguigu.bilibili.adapter.ShoppingCartAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 刘闯 on 2017/3/28.
 */
public class ShoppingCartFragment extends BaseFragment {

    //编辑状态
    public static final int ACTION_EDIT = 1;
    //完成状态
    private static final int ACTION_COMPLETE = 2;
    @Bind(R.id.tv_shopcart_edit)
    TextView tvShopcartEdit;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.checkbox_all)
    CheckBox checkboxAll;
    @Bind(R.id.tv_shopcart_total)
    TextView tvShopcartTotal;
    @Bind(R.id.btn_check_out)
    Button btnCheckOut;
    @Bind(R.id.ll_check_all)
    LinearLayout llCheckAll;
    @Bind(R.id.checkbox_delete_all)
    CheckBox checkboxDeleteAll;
    @Bind(R.id.btn_delete)
    Button btnDelete;
    @Bind(R.id.ll_delete)
    LinearLayout llDelete;
    @Bind(R.id.iv_empty)
    ImageView ivEmpty;
    @Bind(R.id.tv_empty_cart_tobuy)
    TextView tvEmptyCartTobuy;
    @Bind(R.id.ll_empty_shopcart)
    LinearLayout llEmptyShopcart;
    private ShoppingCartAdapter adapter;
    private boolean isChecked;
    private UserDao userDao;
    private List<User> list;

    @Override
    protected void initListener() {
        userDao = MyApplication.getInstances().getDaoSession().getUserDao();
        showData();
    }

    private void hideDelete() {
        //1.设置编辑
        tvShopcartEdit.setTag(ACTION_EDIT);
        //2.隐藏显示控件
        llCheckAll.setVisibility(View.VISIBLE);
        llDelete.setVisibility(View.GONE);
        //4.设置文本为--编辑
        tvShopcartEdit.setText("编辑");
        //5.把所有的数据设置成勾选状态
        if (adapter != null) {
            adapter.checkAll_none(true);
            adapter.checkAll();
            adapter.showTotalPrice();
        }
    }

    private void showDelete() {
        //1.设置完成
        tvShopcartEdit.setTag(ACTION_COMPLETE);
        //2.显示删除控件
        llDelete.setVisibility(View.VISIBLE);
        //3.隐藏结算控件
        llCheckAll.setVisibility(View.GONE);
        //4.设置文本为--完成
        tvShopcartEdit.setText("完成");
        //5.把所有的数据设置非选择状态
        if (adapter != null) {
            adapter.checkAll_none(false);
            adapter.checkAll();

        }

    }

    private void showData() {


//        list = CartStorage.getInstance(mContext).getAllData();
       list = userDao.loadAll();
        if (this.list != null && this.list.size() > 0) {
            //有数据
            llEmptyShopcart.setVisibility(View.GONE);
            adapter = new ShoppingCartAdapter(mContext, this.list, tvShopcartTotal, checkboxAll, checkboxDeleteAll);
            //设置适配器
            recyclerview.setAdapter(adapter);
            //设置管理器
            recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            //点击事件监听
            adapter.setOnItemClickListener(new ShoppingCartAdapter.OnItemClickListener() {
                @Override
                public void onItemClickListener(View view, int position) {
                    //设置Bean对象取反
                    User user = list.get(position);
                    user.setIsChecked(!user.getIsChecked());
                    adapter.notifyItemChanged(position);
                    //刷新价格
                    adapter.showTotalPrice();
                    //校验是否全选
                    adapter.checkAll();

                }
            });
            //校验是否全选
            adapter.checkAll();

        } else {
            //没数据
            llEmptyShopcart.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_cart;
    }

    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initData(String json) {

    }

    private void showEempty() {
        if (adapter.getItemCount() == 0) {
            llEmptyShopcart.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.tv_shopcart_edit, R.id.checkbox_all, R.id.btn_check_out, R.id.checkbox_delete_all, R.id.btn_delete, R.id.tv_empty_cart_tobuy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_shopcart_edit:
                //设置编辑状态
                tvShopcartEdit.setTag(ACTION_EDIT);
                tvShopcartEdit.setText("编辑");
                //显示要去结算的布局
                llCheckAll.setVisibility(View.VISIBLE);
                tvShopcartEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //1.得到状态
                        int action = (int) v.getTag();
                        //2.根据不同的状态做不同的处理
                        if (action == ACTION_EDIT) {
                            //切换完成状态
                            showDelete();
                        } else {
                            //切换成编辑状态
                            hideDelete();
                        }
                    }
                });
                break;
            case R.id.checkbox_all:
                Toast.makeText(mContext, "全选", Toast.LENGTH_SHORT).show();
                isChecked = checkboxAll.isChecked();
                //全选和反全选
                adapter.checkAll_none(isChecked);
                //显示总价格
                adapter.showTotalPrice();
                break;
            case R.id.btn_check_out:
                Intent intent = new Intent(mContext, OutActivity.class);
                startActivity(intent);
                break;
            case R.id.checkbox_delete_all:
                isChecked = checkboxDeleteAll.isChecked();
                //全选和反全选
                adapter.checkAll_none(isChecked);
                //显示总价格
                adapter.showTotalPrice();
                break;
            case R.id.btn_delete:
                list = userDao.loadAll();
                for (int i = 0; i <list.size() ; i++) {
                    if(list.get(i).getIsChecked()) {
                        userDao.delete(list.get(i));
                    }
                }
                showData();
                adapter.deleteData();
                adapter.checkAll();
                showEempty();
                break;

            case R.id.tv_empty_cart_tobuy:
                intent = new Intent(mContext, CartActivity.class);
                intent.putExtra("checkedid", R.id.rb_home);
                startActivity(intent);
                break;
        }
    }
}
