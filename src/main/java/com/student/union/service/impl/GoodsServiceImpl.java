package com.student.union.service.impl;

import com.student.union.dao.IGoodsDao;
import com.student.union.entity.Goods;
import com.student.union.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    IGoodsDao iGoodsDao;
    /**
     * 添加物品
     */
    @Override
    public void addGoods(Goods goods) {
        iGoodsDao.addGoods(goods);
    }

    /**
     * 按部门搜索物品
     */
    @Override
    public List<Goods> getGoodsByDepart(String goodsDepart) {
        return iGoodsDao.getGoodsByDepart(goodsDepart);
    }
    /**
     * 按名称搜索物品
     */
    @Override
    public List<Goods> getGoodsByName(String goodsName) {
        return iGoodsDao.getGoodsByName(goodsName);
    }

    /**
     * 改变物品状态
     */

    @Override
    public void isnGoods(String goodsState,String goodsId) {
        iGoodsDao.isnGoods(goodsState,goodsId);
    }
    /**
     * 删除物品
     */
    @Override
    public void delGoods(String goodsId) {
        iGoodsDao.delGoods(goodsId);
    }
    /**
     * 改变借出物品数量
     */
    @Override
    public void cGoodsNumber(String lentNumber, String goodsId) {
        iGoodsDao.cGoodsNumber(lentNumber,goodsId);
    }
    /**
     * 按id搜索物品
     */
    @Override
    public List<Goods> getGoodsById(String goodsIdId) {
        return iGoodsDao.getGoodsById(goodsIdId);
    }
}
