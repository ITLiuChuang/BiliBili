package com.atguigu.bilibili.bean;

import java.util.List;

/**
 * Created by 刘闯 on 2017/3/22.
 */

public class CartoonBean {

    /**
     * code : 0
     * message : success
     * result : {"ad":{"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/c711e42ae09f5edafb72591a744b9879c1e0c458.jpg","link":"http://www.bilibili.com/blackboard/activity-S1aPZanjx.html","pub_time":"2017-03-27 12:14:00","title":"4月新番"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/d9ac161c9be635340e18838836e0c6479f03b718.jpg","link":"http://bangumi.bilibili.com/anime/5788","pub_time":"2017-03-27 01:25:00","title":"小魔女学园"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/d3f1a286da362b803f6f32a1992ee1f0492d69fc.jpg","link":"http://bangumi.bilibili.com/anime/5789","pub_time":"2017-03-26 22:30:00","title":"热诚传说X"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/5b646d52b5e4556afeeca7b24be0bc3c6e443d14.jpg","link":"http://bangumi.bilibili.com/anime/5790","pub_time":"2017-03-26 22:30:00","title":"宇宙警探elDLIVE"}]},"previous":{"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg","favourites":"1680758","is_finish":1,"last_time":1482262210,"newest_ep_index":"11","pub_time":1475607600,"season_id":5550,"season_status":2,"title":"夏目友人帐 伍","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b75c55d209d156c8631f5ceb21e5c52c834dbb60.jpg","favourites":"1336188","is_finish":1,"last_time":1483196409,"newest_ep_index":"1","pub_time":1483196400,"season_id":5747,"season_status":2,"title":"Fate/Grand Order \u2010First Order\u2010","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b3633d2e5cafa0d048f4beef63618c92cfac4c4c.jpg","favourites":"788271","is_finish":1,"last_time":1482465609,"newest_ep_index":"12","pub_time":1475812800,"season_id":5534,"season_status":2,"title":"我太受欢迎了该怎么办","watching_count":0}],"season":4,"year":2016},"serializing":[{"cover":"http://i0.hdslb.com/bfs/bangumi/e7f7e5b07441da16e382ea4563f82f63f8632626.jpg","favourites":"63505","is_finish":0,"is_started":1,"last_time":1490610302,"newest_ep_index":"38","pub_time":1467627900,"season_id":5025,"season_status":2,"title":"智龙迷城X","watching_count":88},{"cover":"http://i0.hdslb.com/bfs/bangumi/7ce71b6800274f033f9cbb6303d19a6228997dc7.jpg","favourites":"30415","is_finish":0,"is_started":1,"last_time":1490583936,"newest_ep_index":"6","pub_time":1487260800,"season_id":5934,"season_status":2,"title":"寻找克洛托","watching_count":15},{"cover":"http://i0.hdslb.com/bfs/bangumi/553d0ba77ba810fb912837820f6f8fa27e494410.jpg","favourites":"177656","is_finish":1,"is_started":1,"last_time":1490558702,"newest_ep_index":"13","pub_time":1484503500,"season_id":5832,"season_status":2,"title":"暗芝居 第四季","watching_count":457},{"cover":"http://i0.hdslb.com/bfs/bangumi/1aa1cee348544dbd677e05cbeaa85c52c11e1a06.jpg","favourites":"183469","is_finish":0,"is_started":1,"last_time":1490549100,"newest_ep_index":"12","pub_time":1483891200,"season_id":5788,"season_status":2,"title":"小魔女学园 TV版","watching_count":2922},{"cover":"http://i0.hdslb.com/bfs/bangumi/94b8e40429614d34374da619f0fc433e7c91a278.jpg","favourites":"292667","is_finish":1,"is_started":1,"last_time":1490542202,"newest_ep_index":"12","pub_time":1483889400,"season_id":5786,"season_status":2,"title":"猫咪日常","watching_count":282},{"cover":"http://i0.hdslb.com/bfs/bangumi/35ed3ea03b7e06ac7c1a199029aaea925313ffdc.jpg","favourites":"129242","is_finish":1,"is_started":1,"last_time":1490540402,"newest_ep_index":"12","pub_time":1483887600,"season_id":5787,"season_status":2,"title":"偶像选举","watching_count":212}]}
     */

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * ad : {"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/c711e42ae09f5edafb72591a744b9879c1e0c458.jpg","link":"http://www.bilibili.com/blackboard/activity-S1aPZanjx.html","pub_time":"2017-03-27 12:14:00","title":"4月新番"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/d9ac161c9be635340e18838836e0c6479f03b718.jpg","link":"http://bangumi.bilibili.com/anime/5788","pub_time":"2017-03-27 01:25:00","title":"小魔女学园"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/d3f1a286da362b803f6f32a1992ee1f0492d69fc.jpg","link":"http://bangumi.bilibili.com/anime/5789","pub_time":"2017-03-26 22:30:00","title":"热诚传说X"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/5b646d52b5e4556afeeca7b24be0bc3c6e443d14.jpg","link":"http://bangumi.bilibili.com/anime/5790","pub_time":"2017-03-26 22:30:00","title":"宇宙警探elDLIVE"}]}
         * previous : {"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg","favourites":"1680758","is_finish":1,"last_time":1482262210,"newest_ep_index":"11","pub_time":1475607600,"season_id":5550,"season_status":2,"title":"夏目友人帐 伍","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b75c55d209d156c8631f5ceb21e5c52c834dbb60.jpg","favourites":"1336188","is_finish":1,"last_time":1483196409,"newest_ep_index":"1","pub_time":1483196400,"season_id":5747,"season_status":2,"title":"Fate/Grand Order \u2010First Order\u2010","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b3633d2e5cafa0d048f4beef63618c92cfac4c4c.jpg","favourites":"788271","is_finish":1,"last_time":1482465609,"newest_ep_index":"12","pub_time":1475812800,"season_id":5534,"season_status":2,"title":"我太受欢迎了该怎么办","watching_count":0}],"season":4,"year":2016}
         * serializing : [{"cover":"http://i0.hdslb.com/bfs/bangumi/e7f7e5b07441da16e382ea4563f82f63f8632626.jpg","favourites":"63505","is_finish":0,"is_started":1,"last_time":1490610302,"newest_ep_index":"38","pub_time":1467627900,"season_id":5025,"season_status":2,"title":"智龙迷城X","watching_count":88},{"cover":"http://i0.hdslb.com/bfs/bangumi/7ce71b6800274f033f9cbb6303d19a6228997dc7.jpg","favourites":"30415","is_finish":0,"is_started":1,"last_time":1490583936,"newest_ep_index":"6","pub_time":1487260800,"season_id":5934,"season_status":2,"title":"寻找克洛托","watching_count":15},{"cover":"http://i0.hdslb.com/bfs/bangumi/553d0ba77ba810fb912837820f6f8fa27e494410.jpg","favourites":"177656","is_finish":1,"is_started":1,"last_time":1490558702,"newest_ep_index":"13","pub_time":1484503500,"season_id":5832,"season_status":2,"title":"暗芝居 第四季","watching_count":457},{"cover":"http://i0.hdslb.com/bfs/bangumi/1aa1cee348544dbd677e05cbeaa85c52c11e1a06.jpg","favourites":"183469","is_finish":0,"is_started":1,"last_time":1490549100,"newest_ep_index":"12","pub_time":1483891200,"season_id":5788,"season_status":2,"title":"小魔女学园 TV版","watching_count":2922},{"cover":"http://i0.hdslb.com/bfs/bangumi/94b8e40429614d34374da619f0fc433e7c91a278.jpg","favourites":"292667","is_finish":1,"is_started":1,"last_time":1490542202,"newest_ep_index":"12","pub_time":1483889400,"season_id":5786,"season_status":2,"title":"猫咪日常","watching_count":282},{"cover":"http://i0.hdslb.com/bfs/bangumi/35ed3ea03b7e06ac7c1a199029aaea925313ffdc.jpg","favourites":"129242","is_finish":1,"is_started":1,"last_time":1490540402,"newest_ep_index":"12","pub_time":1483887600,"season_id":5787,"season_status":2,"title":"偶像选举","watching_count":212}]
         */

        private AdBean ad;
        private PreviousBean previous;
        private List<SerializingBean> serializing;

        public AdBean getAd() {
            return ad;
        }

        public void setAd(AdBean ad) {
            this.ad = ad;
        }

        public PreviousBean getPrevious() {
            return previous;
        }

        public void setPrevious(PreviousBean previous) {
            this.previous = previous;
        }

        public List<SerializingBean> getSerializing() {
            return serializing;
        }

        public void setSerializing(List<SerializingBean> serializing) {
            this.serializing = serializing;
        }

        public static class AdBean {
            private List<?> body;
            private List<HeadBean> head;

            public List<?> getBody() {
                return body;
            }

            public void setBody(List<?> body) {
                this.body = body;
            }

            public List<HeadBean> getHead() {
                return head;
            }

            public void setHead(List<HeadBean> head) {
                this.head = head;
            }

            public static class HeadBean {
                /**
                 * id : 0
                 * img : http://i0.hdslb.com/bfs/bangumi/c711e42ae09f5edafb72591a744b9879c1e0c458.jpg
                 * link : http://www.bilibili.com/blackboard/activity-S1aPZanjx.html
                 * pub_time : 2017-03-27 12:14:00
                 * title : 4月新番
                 */

                private int id;
                private String img;
                private String link;
                private String pub_time;
                private String title;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getPub_time() {
                    return pub_time;
                }

                public void setPub_time(String pub_time) {
                    this.pub_time = pub_time;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class PreviousBean {
            /**
             * list : [{"cover":"http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg","favourites":"1680758","is_finish":1,"last_time":1482262210,"newest_ep_index":"11","pub_time":1475607600,"season_id":5550,"season_status":2,"title":"夏目友人帐 伍","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b75c55d209d156c8631f5ceb21e5c52c834dbb60.jpg","favourites":"1336188","is_finish":1,"last_time":1483196409,"newest_ep_index":"1","pub_time":1483196400,"season_id":5747,"season_status":2,"title":"Fate/Grand Order \u2010First Order\u2010","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/b3633d2e5cafa0d048f4beef63618c92cfac4c4c.jpg","favourites":"788271","is_finish":1,"last_time":1482465609,"newest_ep_index":"12","pub_time":1475812800,"season_id":5534,"season_status":2,"title":"我太受欢迎了该怎么办","watching_count":0}]
             * season : 4
             * year : 2016
             */

            private int season;
            private int year;
            private List<ListBean> list;

            public int getSeason() {
                return season;
            }

            public void setSeason(int season) {
                this.season = season;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * cover : http://i0.hdslb.com/bfs/bangumi/2673ac643b48eb5bda64c960a2ca850fbebb839d.jpg
                 * favourites : 1680758
                 * is_finish : 1
                 * last_time : 1482262210
                 * newest_ep_index : 11
                 * pub_time : 1475607600
                 * season_id : 5550
                 * season_status : 2
                 * title : 夏目友人帐 伍
                 * watching_count : 0
                 */

                private String cover;
                private String favourites;
                private int is_finish;
                private int last_time;
                private String newest_ep_index;
                private int pub_time;
                private int season_id;
                private int season_status;
                private String title;
                private int watching_count;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getFavourites() {
                    return favourites;
                }

                public void setFavourites(String favourites) {
                    this.favourites = favourites;
                }

                public int getIs_finish() {
                    return is_finish;
                }

                public void setIs_finish(int is_finish) {
                    this.is_finish = is_finish;
                }

                public int getLast_time() {
                    return last_time;
                }

                public void setLast_time(int last_time) {
                    this.last_time = last_time;
                }

                public String getNewest_ep_index() {
                    return newest_ep_index;
                }

                public void setNewest_ep_index(String newest_ep_index) {
                    this.newest_ep_index = newest_ep_index;
                }

                public int getPub_time() {
                    return pub_time;
                }

                public void setPub_time(int pub_time) {
                    this.pub_time = pub_time;
                }

                public int getSeason_id() {
                    return season_id;
                }

                public void setSeason_id(int season_id) {
                    this.season_id = season_id;
                }

                public int getSeason_status() {
                    return season_status;
                }

                public void setSeason_status(int season_status) {
                    this.season_status = season_status;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getWatching_count() {
                    return watching_count;
                }

                public void setWatching_count(int watching_count) {
                    this.watching_count = watching_count;
                }
            }
        }

        public static class SerializingBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/e7f7e5b07441da16e382ea4563f82f63f8632626.jpg
             * favourites : 63505
             * is_finish : 0
             * is_started : 1
             * last_time : 1490610302
             * newest_ep_index : 38
             * pub_time : 1467627900
             * season_id : 5025
             * season_status : 2
             * title : 智龙迷城X
             * watching_count : 88
             */

            private String cover;
            private String favourites;
            private int is_finish;
            private int is_started;
            private int last_time;
            private String newest_ep_index;
            private int pub_time;
            private int season_id;
            private int season_status;
            private String title;
            private int watching_count;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getFavourites() {
                return favourites;
            }

            public void setFavourites(String favourites) {
                this.favourites = favourites;
            }

            public int getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(int is_finish) {
                this.is_finish = is_finish;
            }

            public int getIs_started() {
                return is_started;
            }

            public void setIs_started(int is_started) {
                this.is_started = is_started;
            }

            public int getLast_time() {
                return last_time;
            }

            public void setLast_time(int last_time) {
                this.last_time = last_time;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }

            public int getSeason_id() {
                return season_id;
            }

            public void setSeason_id(int season_id) {
                this.season_id = season_id;
            }

            public int getSeason_status() {
                return season_status;
            }

            public void setSeason_status(int season_status) {
                this.season_status = season_status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }
        }
    }
}
