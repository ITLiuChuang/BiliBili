package com.atguigu.bilibili.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 刘闯 on 2017/3/24.
 */

public class ComprehensiveBean {

    @JSONField(name = "code")
    private int _$Code97; // FIXME check this code
    private String message;
    private List<DataBean> data;

    public int get_$Code97() {
        return _$Code97;
    }

    public void set_$Code97(int _$Code97) {
        this._$Code97 = _$Code97;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 【饭糕绘画学院】今天依旧是小姐姐（上色过程）
         * cover : http://i2.hdslb.com/bfs/archive/dbf3260741b65b3af3347ab0ee4c609ba7a9fd5a.jpg
         * uri : bilibili://video/9342143
         * param : 9342143
         * goto : av
         * desc : 美少女就是力量！（出自饭糕学院插画课堂）
         授课教师：胡桃    解说：咸鱼酱
         每周三、周四、周五、周六饭糕绘画公开课 准时开课
         最近开课：插画72期-3月21号开课-每周二 周五 周日上课
         漫画19期-3月28号开课-每周二 周四 周日上课
         咨询详情戳饭糕QQ：800046881 官网戳：www.fangao.cc
         * play : 894
         * idx : 1490344454
         * tid : 162
         * tname : 绘画
         * tag : {"tag_id":2800,"tag_name":"绘画"}
         * dislike_reasons : [{"reason_id":4,"reason_name":"UP主:饭糕绘画学院"},{"reason_id":2,"reason_name":"分区:绘画"},{"reason_id":3,"reason_name":"标签:绘画"},{"reason_id":1,"reason_name":"不感兴趣"}]
         * ctime : 1490264577
         * danmaku : 9
         * duration : 1254
         * mid : 2126062
         * name : 饭糕绘画学院
         * face : http://i2.hdslb.com/bfs/face/1819b7b27000e7e40cfd5c9b5f6a1f7f04b9267d.jpg
         * request_id : 1490354664994q172a18a61a127q138
         * src_id : 1963
         * is_ad_loc : true
         * client_ip : 113.45.83.91
         */

        private String title;
        private String cover;
        private String uri;
        private String param;
        @JSONField(name = "goto")
        private String gotoX;
        private String desc;
        private int play;
        private int idx;
        private int tid;
        private String tname;
        private TagBean tag;
        private int ctime;
        private int danmaku;
        private int duration;
        private int mid;
        private String name;
        private String face;
        private String request_id;
        private int src_id;
        private boolean is_ad_loc;
        private String client_ip;
        private List<DislikeReasonsBean> dislike_reasons;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public TagBean getTag() {
            return tag;
        }

        public void setTag(TagBean tag) {
            this.tag = tag;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getRequest_id() {
            return request_id;
        }

        public void setRequest_id(String request_id) {
            this.request_id = request_id;
        }

        public int getSrc_id() {
            return src_id;
        }

        public void setSrc_id(int src_id) {
            this.src_id = src_id;
        }

        public boolean isIs_ad_loc() {
            return is_ad_loc;
        }

        public void setIs_ad_loc(boolean is_ad_loc) {
            this.is_ad_loc = is_ad_loc;
        }

        public String getClient_ip() {
            return client_ip;
        }

        public void setClient_ip(String client_ip) {
            this.client_ip = client_ip;
        }

        public List<DislikeReasonsBean> getDislike_reasons() {
            return dislike_reasons;
        }

        public void setDislike_reasons(List<DislikeReasonsBean> dislike_reasons) {
            this.dislike_reasons = dislike_reasons;
        }

        public static class TagBean {
            /**
             * tag_id : 2800
             * tag_name : 绘画
             */

            private int tag_id;
            private String tag_name;

            public int getTag_id() {
                return tag_id;
            }

            public void setTag_id(int tag_id) {
                this.tag_id = tag_id;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }
        }

        public static class DislikeReasonsBean {
            /**
             * reason_id : 4
             * reason_name : UP主:饭糕绘画学院
             */

            private int reason_id;
            private String reason_name;

            public int getReason_id() {
                return reason_id;
            }

            public void setReason_id(int reason_id) {
                this.reason_id = reason_id;
            }

            public String getReason_name() {
                return reason_name;
            }

            public void setReason_name(String reason_name) {
                this.reason_name = reason_name;
            }
        }
    }
}
