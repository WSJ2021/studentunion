package com.student.union.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.union.common.JsonResult;
import com.student.union.entity.Goods;
import com.student.union.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    IGoodsService iGoodsService;
    /**
     * 添加物品
     */
    @RequestMapping(value = "/addgoods",method = RequestMethod.POST)
    public JsonResult addGoods(@RequestBody Goods goods){
        JsonResult result=null;
        try {
            iGoodsService.addGoods(goods);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 按部门搜索物品
     */
    @RequestMapping(value = "/getgoodsbydepart",method= RequestMethod.GET)
    public JsonResult getGoodsByDepart(String goodsDepart,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Goods> goods=iGoodsService.getGoodsByDepart(goodsDepart);
            PageInfo pageInfo=new PageInfo(goods);
            if(goods!=null){
                result=new JsonResult(200,"查询成功",pageInfo);
            }else{
                result=new JsonResult(404,"查询失败");
            }
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }

        return result;
    }
    /**
     * 按名称搜索物品
     */
    @RequestMapping(value = "/getgoodsbyname",method= RequestMethod.GET)
    public JsonResult getGoodsByName(String goodsName,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Goods> goods=iGoodsService.getGoodsByName(goodsName);
            PageInfo pageInfo=new PageInfo(goods);
            if(goods!=null){
                result=new JsonResult(200,"查询成功",pageInfo);
            }else{
                result=new JsonResult(404,"查询失败");
            }
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }

        return result;
    }
    /**
     * 按id搜索物品
     */
    @RequestMapping(value = "/getgoodsbyid",method= RequestMethod.GET)
    public JsonResult getGoodsById(String goodsId,
                                     @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Goods> goods=iGoodsService.getGoodsById(goodsId);
            PageInfo pageInfo=new PageInfo(goods);
            if(goods!=null){
                result=new JsonResult(200,"查询成功",pageInfo);
            }else{
                result=new JsonResult(404,"查询失败");
            }
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }

        return result;
    }
    /**
     * 改变物品状态
     */
    @RequestMapping(value = "/isngoods",method = RequestMethod.PUT)
    public JsonResult isnGoods(@RequestBody Goods goods){
        JsonResult result=null;
        try {
            iGoodsService.isnGoods(goods.getGoodsState(),goods.getGoodsId());
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 改变借出物品数量
     */
    @RequestMapping(value = "/cgoodsnumber",method = RequestMethod.PUT)
    public JsonResult cGoodsNumber(@RequestBody Goods goods){
        JsonResult result=null;
        try {
            iGoodsService.cGoodsNumber(goods.getLentNumber(),goods.getGoodsId());
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 删除物品
     */
    @RequestMapping(value = "/delgoods",method = RequestMethod.POST)
    public JsonResult delGoods(@RequestBody Goods goods){
        JsonResult result=null;
        try {
            iGoodsService.delGoods(goods.getGoodsId());
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
}
