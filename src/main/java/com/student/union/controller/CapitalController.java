package com.student.union.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.union.common.JsonResult;
import com.student.union.entity.Capital;
import com.student.union.entity.Debit;
import com.student.union.entity.Meeting;
import com.student.union.service.ICapitalService;
import com.student.union.service.IDebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CapitalController {
    @Autowired
    ICapitalService iCapitalService;
    /**
     * 添加资金申请表
     */
    @RequestMapping(value = "/addcapital",method = RequestMethod.POST)
    public JsonResult addCapital(@RequestBody Capital capital){
        JsonResult result=null;
        try {
            iCapitalService.addCapital(capital);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 根据id修改资金申请表
     */
    @RequestMapping(value = "/upcapital",method = RequestMethod.PUT)
    public JsonResult upCapital(@RequestBody Capital capital){
        JsonResult result=null;
        try {
            iCapitalService.upCapital(capital);
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }

    /**
     * 搜索审核未通过资金申请表
     */
    @RequestMapping(value = "/getncapital",method= RequestMethod.GET)
    public JsonResult getNCapital(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.getNCapital();
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 搜索审核通过资金申请表
     */
    @RequestMapping(value = "/geticapital",method= RequestMethod.GET)
    public JsonResult getICapital(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.getICapital();
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 按部门搜索通过资金申请表
     */
    @RequestMapping(value = "/igetcapitalbydep",method= RequestMethod.GET)
    public JsonResult igetNCapitalByDep(String capitalDepart,
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.igetCapitalByDep(capitalDepart);
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 按部门搜索未通过资金申请表
     */
    @RequestMapping(value = "/ngetcapitalbydep",method= RequestMethod.GET)
    public JsonResult ngetCapitalByDep(String capitalDepart,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.ngetCapitalByDep(capitalDepart);
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 按名称搜索通过资金申请表
     */
    @RequestMapping(value = "/igetcapitalbyname",method= RequestMethod.GET)
    public JsonResult igetICapitalByName(String capitalActName,String capitalDepart,
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.igetCapitalByName(capitalActName,capitalDepart);
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 按名称搜索未通过资金申请表
     */
    @RequestMapping(value = "/ngetcapitalbyname",method= RequestMethod.GET)
    public JsonResult ngetICapitalByName(String capitalActName,String capitalDepart,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.ngetCapitalByName(capitalActName,capitalDepart);
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 按申请人搜索未通过资金申请表
     */
    @RequestMapping(value = "/ngetcapitalbyper",method= RequestMethod.GET)
    public JsonResult ngetICapitalByPer(String capitalActName,String capitalPerson,
                                         @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.ngetCapitalByPer(capitalActName,capitalPerson);
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 按申请人搜索通过资金申请表
     */
    @RequestMapping(value = "/igetcapitalbyper",method= RequestMethod.GET)
    public JsonResult igetICapitalByPer(String capitalActName,String capitalPerson,
                                        @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Capital> capitals=iCapitalService.igetCapitalByPer(capitalActName,capitalPerson);
            PageInfo pageInfo=new PageInfo(capitals);
            if(capitals!=null){
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
     * 根据id删除资金申请表
     */
    @RequestMapping(value = "/delcapital",method = RequestMethod.POST)
    public JsonResult delCapital(@RequestBody Capital capital){
        JsonResult result=null;
        try {
            iCapitalService.delCapital(capital.getCapitalId());
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 改变资金申请表状态
     */
    @RequestMapping(value = "/isncapital",method = RequestMethod.PUT)
    public JsonResult isnCapital(@RequestBody Capital capital){
        JsonResult result=null;
        try {
            iCapitalService.isnCapital(capital.getCapitalState(),capital.getCapitalId());
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }

}
