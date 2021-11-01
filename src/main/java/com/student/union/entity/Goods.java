package com.student.union.entity;

public class Goods {
    private String goodsId;
    private String goodsName;
    private String goodsDepart;
    private String goodsPrice;
    private String goodsBuyTime;
    private String goodsState;
    private String goodsNumber;
    private String lentNumber;


    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getLentNumber() {
        return lentNumber;
    }

    public void setLentNumber(String lentNumber) {
        this.lentNumber = lentNumber;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDepart() {
        return goodsDepart;
    }

    public void setGoodsDepart(String goodsDepart) {
        this.goodsDepart = goodsDepart;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsBuyTime() {
        return goodsBuyTime;
    }

    public void setGoodsBuyTime(String goodsBuyTime) {
        this.goodsBuyTime = goodsBuyTime;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }
}
