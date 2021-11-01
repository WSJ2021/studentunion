package com.student.union.service;

import com.student.union.entity.Goods;

import java.util.List;

public interface IGoodsService {
    /**
     * 添加物品
     */
    void addGoods(Goods goods);
    /**
     * 按部门搜索物品
     */
    List<Goods> getGoodsByDepart(String goodsDepart);
    /**
     * 按名称搜索物品
     */
    List<Goods> getGoodsByName(String goodsName);
    /**
     * 改变物品状态
     */
    void isnGoods(String goodsState,String goodsId);
    /**
     * 删除物品
     */
    void delGoods(String goodsId);
    /**
     * 改变借出物品数量
     */
    void cGoodsNumber(String lentNumber,String goodsId);
    /**
     * 按id搜索物品
     */
    List<Goods> getGoodsById(String goodsIdId);
}
