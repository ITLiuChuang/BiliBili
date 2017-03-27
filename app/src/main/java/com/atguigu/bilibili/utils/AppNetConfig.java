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
     * 分区
     */
    public static final String PARTITION_TAG = "http://app.bilibili.com/x/v2/show/region?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&ts=1490248769000&sign=7caf6c7efe17f2866cc1f52d1adf6347";
    /**
     * 发现
     */
    public static final String DISCOVER_TAG = "http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&limit=50&mobi_app=android&platform=android&ts=1490014710000&sign=e5ddf94fa9a0d6876cb85756c37c4adc";
    /**
     * 所搜
     */
    public static final String SOU_TAG = "http://app.bilibili.com/x/v2/search?appkey=1d8b6e7d45233436&build=501000&duration=0&keyword=";
    public static final String SUO_TAG = "&mobi_app=android&platform=android&pn=1&ps=20";
    /**
     * 话题中心
     */
    public static final String HUATI_TAG = "http://api.bilibili.com/topic/getlist?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&page=1&pageSize=20&platform=android&ts=1490015740000&sign=be68382cdc99c168ef87f2fa423dd280";
    /**
     * 活动中心
     */
    public static final String HUODONG_TAG = "http://api.bilibili.com/event/getlist?access_key=a02590621e65e8a89a5c2d773a6153f8&appkey=1d8b6e7d45233436&build=501000&mobi_app=android&page=1&pageSize=20&platform=android&ts=1490612726000&sign=3dbcbc2b25e93a9d1b5c9d24497e43d1";
    /**
     * 原创排行榜
     */
    public static final String YUANCHUANG_TAG = "http://app.bilibili.com/x/v2/rank?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&order=all&platform=android&pn=1&ps=20&ts=1490015891000&sign=8e7dfaa1c2fb779943430b46e734b422";
}
