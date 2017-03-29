package com.atguigu.bilibili.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.fragment.BaseFragment;
import com.atguigu.bilibili.fragment.HomeFragment;
import com.atguigu.bilibili.fragment.ShoppingCartFragment;

import java.util.ArrayList;

import butterknife.Bind;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class CartActivity extends BaseActivity {
    @Bind(R.id.fl_mian)
    FrameLayout flMian;
    @Bind(R.id.rb_home)
    RadioButton rbHome;
    @Bind(R.id.rb_cart)
    RadioButton rbCart;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    @Bind(R.id.activity_cart)
    LinearLayout activityCart;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    /**
     * 集合,装Fragment
     */
    private ArrayList<BaseFragment> fragments;
    /**
     * Fragment的下标
     */
    private int position;
    /**
     * 当前的Fragment
     */
    private Fragment tempFragment;

    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.share) {
                    OnekeyShare oks = new OnekeyShare();
                    //关闭sso授权
                    oks.disableSSOWhenAuthorize();
                    // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
                    oks.setTitle("标题");
                    // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
                    oks.setTitleUrl("http://sharesdk.cn");
                    // text是分享文本，所有平台都需要这个字段
                    oks.setText("我是分享文本");
                    //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
                    oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                    // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                    //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                    // url仅在微信（包括好友和朋友圈）中使用
                    oks.setUrl("http://sharesdk.cn");
                    // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                    oks.setComment("我是测试评论文本");
                    // site是分享此内容的网站名称，仅在QQ空间使用
                    oks.setSite("ShareSDK");
                    // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                    oks.setSiteUrl("http://sharesdk.cn");

                    // 启动分享GUI
                    oks.show(CartActivity.this);
                } else if (itemId == R.id.liulanqi) {

                }
                return true;
            }
        });
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;

                    case R.id.rb_cart:
                        position = 1;
                        break;
                }
                /**
                 * 根据位置获取不同的Fragment
                 */
                Fragment currentFragment = fragments.get(position);
                switchFragment(currentFragment);
            }
        });


        //默然为首页
        rgMain.check(R.id.rb_home);

    }

    @Override
    protected void initView() {
        toolBar.inflateMenu(R.menu.menu_share);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ShoppingCartFragment());


    }

    @Override
    protected void initData(String json, String error) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_cart;
    }

    private void switchFragment(Fragment currentFragment) {
        //判断切换的页面是不是当前页面
        if (tempFragment != currentFragment) {
            //开启事物,得到Fragmentmagre
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断是否添加过
            if (!currentFragment.isAdded()) {
                //隐藏缓存
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }

                //添加
                ft.add(R.id.fl_mian, currentFragment);
            } else {
                //隐藏缓存
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                //显示
                ft.show(currentFragment);
            }
            //提交事物
            ft.commit();
            //把当前的赋值为缓存的
            tempFragment = currentFragment;
        }
    }

}
