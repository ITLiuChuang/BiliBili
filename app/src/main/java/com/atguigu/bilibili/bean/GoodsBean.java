package com.atguigu.bilibili.bean;

import java.io.Serializable;

/**
 * Created by 刘闯 on 2017/3/28.
 */

public class GoodsBean implements Serializable{
    /**
     * title : bilibili周边 魔性小电视长条抱枕 毛绒公仔90CM
     * skuId : 83
     * oldPrice : 299
     * vipPlusPrice : 179
     * salvePrice : 199
     * imgUrl : http://i0.hdslb.com/bfs/travel/8bf24a1f803a439421d8101691b167e9f40b56ef.jpg
     */

    private String title;
    private int skuId;
    private int oldPrice;
    private int vipPlusPrice;
    private int salvePrice;
    private String imgUrl;
    private int number = 1;
    /**
     * 是否选中
     */
    private boolean isChecked = true;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getVipPlusPrice() {
        return vipPlusPrice;
    }

    public void setVipPlusPrice(int vipPlusPrice) {
        this.vipPlusPrice = vipPlusPrice;
    }

    public int getSalvePrice() {
        return salvePrice;
    }

    public void setSalvePrice(int salvePrice) {
        this.salvePrice = salvePrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
