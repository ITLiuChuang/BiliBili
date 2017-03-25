package com.atguigu.bilibili.utils;

/**
 * Created by 刘闯 on 2017/3/21.
 */

public class AppNetConfig {
    /**
     * 直播
     */
    public static final String LIVE_TAG = "http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=\n" +
            "1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=\n" +
            "hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b";
    /**
     * 直播推荐
     */
    public static final String LIVE_RECOMMEND_TAG = "http://live.bilibili.com/mobile/rooms?_device=android&appkey=\n" +
            "1d8b6e7d45233436&area_id=9&build=501000&mobi_app=android&page=\n" +
            "1&platform=android&sort=recommend&ts=1490014712000&sign=5b0bd85dc9f84381ff493283e59e8a6e";
    /**
     * 推荐页面
     */
    public static final String RECOMMEND_TAG = "http://app.bilibili.com/x/feed/index?appkey=1d8b6e7d45233436&build=501000&idx=1490344444&mobi_app=android&network=wifi&platform=android&pull=true&style=2&ts=1490344659000&sign=2882d844ffcd48d6383e231680f661fd";

    /**
     * 追番
     */
    public static final String CARTOON_TAG = "http://bangumi.bilibili.com/api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios";

    /**
     * 追番banner
     */
    public static final String BANNER_TAG = "http://bangumi.bilibili.com/api/bangumi_recommend?access_key=f5bd4e793b82fba5aaf5b91fb549910a&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3470&cursor=0&device=phone&mobi_app=iphone&pagesize=10&platform=ios&sign=56329a5709c401d4d7c0237f64f7943f&ts=1469613558";
    /**
     * 分区
     */
    public static final String PARTITION_TAG = "http://app.bilibili.com/x/v2/show/region?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&ts=1490248769000&sign=7caf6c7efe17f2866cc1f52d1adf6347";
    /**
     * 发现
     */
    public static final String DISCOVER_TAG = "http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&limit=50&mobi_app=android&platform=android&ts=1490014710000&sign=e5ddf94fa9a0d6876cb85756c37c4adc";
}
