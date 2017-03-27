package com.atguigu.bilibili.activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;

import butterknife.Bind;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class BannerActivity extends BaseActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_recommend_area)
    TextView tvRecommendArea;
    @Bind(R.id.tv_promo)
    ImageView tvPromo;
    @Bind(R.id.iv_img)
    WebView webview;


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
        tvPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CharSequence[] items = {"分享", "浏览器打开", "复制链接"};
                AlertDialog.Builder builder = new AlertDialog.Builder(BannerActivity.this);

                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                        if (item == 0) {
                        //
                        /*    Intent intent=new Intent(Intent.ACTION_SEND);
                            intent.setType("image*//*");
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
                            intent.putExtra(Intent.EXTRA_TEXT, "I have successfully share my message through my app");
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(Intent.createChooser(intent, getTitle()));*/

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
                            oks.show(BannerActivity.this);
                        }

                    }
                });

                builder.show();
            }
        });
    }

    @Override
    protected void initView() {
        Intent intent = this.getIntent();
        String img = intent.getStringExtra("img");
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl(img);

    }

    @Override
    protected void initData(String json, String error) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_banner;
    }


}
