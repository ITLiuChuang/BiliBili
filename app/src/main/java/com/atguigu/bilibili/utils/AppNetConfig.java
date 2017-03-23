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

    public static final String RECOMMEND_TAG = "http://live.bilibili.com/mobile/rooms?_device=android&appkey=\n" +
            "1d8b6e7d45233436&area_id=9&build=501000&mobi_app=android&page=\n" +
            "1&platform=android&sort=recommend&ts=1490014712000&sign=5b0bd85dc9f84381ff493283e59e8a6e";
    /**
     * 追番
     */
    public static final String CARTOON_TAG = "http://bangumi.bilibili.com/api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios";
}
