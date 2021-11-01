package com.student.union.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.union.common.JsonResult;
import com.student.union.entity.Debit;
import com.student.union.entity.Goods;
import com.student.union.service.IDebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DebitController {
    @Autowired
    IDebitService iDebitService;
    /**
     * 添加借记表
     */
    @RequestMapping(value = "/adddebit",method = RequestMethod.POST)
    public JsonResult addDebit(@RequestBody Debit debit){
        JsonResult result=null;
        try {
            iDebitService.addDebit(debit);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 搜索所有未归还借记表
     */
    @RequestMapping(value = "/getndebit",method= RequestMethod.GET)
    public JsonResult getNDebit(String debitDepart,
                                      @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Debit> debits=iDebitService.getNDebit(debitDepart);
            PageInfo pageInfo=new PageInfo(debits);
            if(debits!=null){
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
     * 搜索所有归还借记表
     */
    @RequestMapping(value = "/getidebit",method= RequestMethod.GET)
    public JsonResult getIDebit(String debitDepart,
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Debit> debits=iDebitService.getIDebit(debitDepart);
            PageInfo pageInfo=new PageInfo(debits);
            if(debits!=null){
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
     * 按物品名搜索已归还借记表
     */
    @RequestMapping(value = "/igetdebitbygoods",method= RequestMethod.GET)
    public JsonResult igetDebitByGoods(String debitGoodsName,String debitDepart,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Debit> debits=iDebitService.igetDebitByGoods(debitGoodsName,debitDepart);
            PageInfo pageInfo=new PageInfo(debits);
            if(debits!=null){
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
     * 按物品名搜索未归还借记表
     */
    @RequestMapping(value = "/ngetdebitbygoods",method= RequestMethod.GET)
    public JsonResult ngetDebitByGoods(String debitGoodsName,String debitDepart,
                                      @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Debit> debits=iDebitService.ngetDebitByGoods(debitGoodsName,debitDepart);
            PageInfo pageInfo=new PageInfo(debits);
            if(debits!=null){
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
     * 根据借记表id删除借记表
     */
    @RequestMapping(value = "/deldebit",method = RequestMethod.POST)
    public JsonResult delDebit(@RequestBody Debit debit){
        JsonResult result=null;
        try {
            iDebitService.delDebit(debit.getDebitId());
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 改变借记表状态
     */
    @RequestMapping(value = "/isndebit",method = RequestMethod.PUT)
    public JsonResult isnDebit(@RequestBody Debit debit){
        JsonResult result=null;
        try {
            iDebitService.isnDebit(debit.getDebitState(),debit.getDebitId());
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }


}
