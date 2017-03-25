package com.atguigu.bilibili.bean;

import java.util.List;

/**
 * Created by 刘闯 on 2017/3/24.
 */

public class BannerBean {


    /**
     * code : 0
     * message : success
     * result : [{"cover":"http://i0.hdslb.com/bfs/bangumi/a093348aea6f7def3ef45a68f6272270e5f0afb1.jpg","cursor":0,"desc":"涓嶆槸鍏ㄩ儴锛佷笉鏄叏閮紒涓嶆槸鍏ㄩ儴锛乗n涓嬩竴娉㈠懆鏃ヨ~","id":3967,"is_new":1,"link":"http://www.bilibili.com/blackboard/activity-S1aPZanjx.html","onDt":"2017-03-24 19:20:00","title":"2017骞�4鏈堟柊鐣1娉㈠叕甯冿紒"},{"cover":"http://i0.hdslb.com/bfs/bangumi/669ede525abf7e52c2ec0fefdee5eb9fe1a6cffc.jpg","cursor":0,"desc":"杩欐璺崇エ鎴樼嚎搴旇涓嶄細鍐嶁\u20ac︹\u20ac︼紙鎬昏寰楁槸涓猣lag","id":3945,"is_new":1,"link":"http://www.bilibili.com/blackboard/activity-rk0PH-M2e.html","onDt":"2017-03-24 18:00:00","title":"銆愯祫璁。銆�2017骞寸12鍛�"},{"cover":"http://i0.hdslb.com/bfs/bangumi/973e8102edf9a5ec5fb753d33490bb5481daf17f.jpg","cursor":0,"desc":"鍥犱负鍋氫笉鍒帮紝灏辫鏀惧純姊︽兂鍚楋紵","id":3898,"is_new":1,"link":"http://bangumi.bilibili.com/anime/5798","onDt":"2017-03-23 18:00:00","title":"One Room 11"},{"cover":"http://i0.hdslb.com/bfs/bangumi/790c62dc1d7752620e486480230bc01f4886cd46.jpg","cursor":0,"desc":"绗簩娆\u2033叕寮\u20ac鐩存挱\no(*鈮р柦鈮�)銉勨攺鈹佲敁kimi涓嶈鎬绘槸鎼炰簨\n灏变綘鏈\u20ac璺�","id":3897,"is_new":1,"link":"http://bangumi.bilibili.com/anime/5061","onDt":"2017-03-22 18:15:00","title":"姊︿箣绁紒鐮旂┒瀹� 21"},{"cover":"http://i0.hdslb.com/bfs/bangumi/31f8adbe9de4ba004b8d97aa173b8d9978c71764.jpg","cursor":0,"desc":"鍚閭ｄ竴瀹跺瓙绗ㄨ泲鍙堝嚭鏉ヤ簡锛�","id":3862,"link":"http://bangumi.bilibili.com/anime/92","onDt":"2017-03-21 08:00:00","title":"姣忓害锛佹郸瀹夐搧绛嬪鏃�"},{"cover":"http://i0.hdslb.com/bfs/bangumi/7a3a43959444ed1cf06dcc3b29a0675e22e05009.jpg","cursor":0,"desc":"杩疯尗鐨勬椂鍊欎篃瑕佹垬鏂梊n鍐嶅幓鐪嬬湅閭ｄ簺鑷繁鏇剧粡浠樺嚭杩囧姫鍔涚殑鍦版柟鍚�","id":3861,"link":"http://bangumi.bilibili.com/anime/5787","onDt":"2017-03-20 18:00:00","title":"鍋跺儚閫変妇 11"},{"cover":"http://i0.hdslb.com/bfs/bangumi/eae1bfdcf27750933341212d25b82af764fdf67f.jpg","cursor":0,"desc":"璇烽棶鎮ㄤ粖澶╄鏉ョ偣灏惧反鑲夊悧锛�","id":3859,"link":"http://www.bilibili.com/blackboard/activity-HJBAZ_8sg.html","onDt":"2017-03-19 18:00:00","title":"銆怉niKey vol.8銆戣繖閲岀殑榫欎笉寰椾簡"},{"cover":"http://i0.hdslb.com/bfs/bangumi/f5932fed37d21a098ea20a387982d694fcbbc241.jpg","cursor":0,"desc":"鏇剧粡涓嶆効闈㈠鐨勪簨鐗\u2010n鍗撮噸鏂板彉寰楀姝ょ殑缇庝附","id":3823,"link":"http://www.bilibili.com/video/av5753879/","onDt":"2017-03-18 18:00:00","reply":"110","title":"銆愬懆鏈墽鍦恒\u20ac戣媿涔嬭導"},{"cover":"http://i0.hdslb.com/bfs/bangumi/50927447dd7e485e092f3da9ee64d18986a47544.jpg","cursor":0,"desc":"鍡ㄥ棬鍡ㄩ啋涓\u20ac閱掞紝鍥涙湀鐣兘瑕佹潵浜唦","id":3852,"link":"http://www.bilibili.com/video/av9218963/","onDt":"2017-03-17 19:14:00","reply":"5334","title":"2017骞�4鏈堟柊鐣粙缁�"},{"cover":"http://i0.hdslb.com/bfs/bangumi/da7c2f394a52dc7e2f50ffdeb1d912a5b17b5f9a.jpg","cursor":1489744800606,"desc":"浜樋灏间俊浠板厖鍊硷紒","id":3843,"link":"http://www.bilibili.com/blackboard/activity-Hkwjcpdje.html","onDt":"2017-03-17 18:00:00","title":"銆愯祫璁。銆�2017骞寸11鍛�"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/a093348aea6f7def3ef45a68f6272270e5f0afb1.jpg
         * cursor : 0
         * desc : 涓嶆槸鍏ㄩ儴锛佷笉鏄叏閮紒涓嶆槸鍏ㄩ儴锛乗n涓嬩竴娉㈠懆鏃ヨ~
         * id : 3967
         * is_new : 1
         * link : http://www.bilibili.com/blackboard/activity-S1aPZanjx.html
         * onDt : 2017-03-24 19:20:00
         * title : 2017骞�4鏈堟柊鐣1娉㈠叕甯冿紒
         * reply : 110
         */

        private String cover;
        private int cursor;
        private String desc;
        private int id;
        private int is_new;
        private String link;
        private String onDt;
        private String title;
        private String reply;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getCursor() {
            return cursor;
        }

        public void setCursor(int cursor) {
            this.cursor = cursor;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getOnDt() {
            return onDt;
        }

        public void setOnDt(String onDt) {
            this.onDt = onDt;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }
    }
}
