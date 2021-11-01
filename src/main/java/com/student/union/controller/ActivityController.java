package com.student.union.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.union.common.JsonResult;
import com.student.union.entity.Activity;
import com.student.union.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    IActivityService activityService;
    /**
     * 添加活动
     */
    @RequestMapping(value = "/addact",method = RequestMethod.POST)
    public JsonResult addAct(@RequestBody Activity activity){
        JsonResult result=null;
        try {
            activityService.addAct(activity);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 根据id删除活动
     */
    @RequestMapping(value = "/delact",method = RequestMethod.DELETE)
    public JsonResult delAct(String actId){
        JsonResult result=null;
        try {
            activityService.delAct(actId);
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 根据id修改活动
     */
    @RequestMapping(value = "/upact",method = RequestMethod.PUT)
    public JsonResult upAct(@RequestBody Activity activity){
        JsonResult result=null;
        try {
            activityService.upAct(activity);
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 根据活动开始时间检索活动
     */
    @RequestMapping(value = "/getactbytime",method= RequestMethod.GET)
    public JsonResult getActByTime(String actStartTime,
                                   @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Activity> activities=activityService.getActByTime(actStartTime);
            PageInfo pageInfo=new PageInfo(activities);
            if(activities!=null){
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
     * 根据活动标题检索活动
     */
    @RequestMapping(value = "/getactbyname",method= RequestMethod.GET)
    public JsonResult getActByName(String actName,
                                   @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Activity> activities=activityService.getActByName(actName);
            PageInfo pageInfo=new PageInfo(activities);
            if(activities!=null){
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
     * 查询最近开始的活动
     */
    @RequestMapping(value = "/getactbystarttime",method= RequestMethod.GET)
    public JsonResult getActByStartTime(
                                   @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Activity> activities=activityService.getActByStartTime();
            PageInfo pageInfo=new PageInfo(activities);
            if(activities!=null){
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
     * 查询某部门所有审核通过的活动
     */
    @RequestMapping(value = "/getiactbydepart",method= RequestMethod.GET)
    public JsonResult getIActByDepart(String actApplyDepart,
                                   @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Activity> activities=activityService.getIActByDepart(actApplyDepart);
            PageInfo pageInfo=new PageInfo(activities);
            if(activities!=null){
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
     * 查询某部门所有审核未通过的活动
     */
    @RequestMapping(value = "/getnactbydepart",method= RequestMethod.GET)
    public JsonResult getNActByDepart(String actApplyDepart,
                                      @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Activity> activities=activityService.getNActByDepart(actApplyDepart);
            PageInfo pageInfo=new PageInfo(activities);
            if(activities!=null){
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
     * 审核活动
     */
    @RequestMapping(value = "/isnact",method = RequestMethod.PUT)
    public JsonResult isnAct(@RequestBody Activity activity){
        JsonResult result=null;
        try {
            activityService.isnAct(activity.getActState(),activity.getActId());
            result=new JsonResult(200,"审核成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 查询所有部门审核通过的活动
     */
    @RequestMapping(value = "/getiact",method= RequestMethod.GET)
    public JsonResult getIAct(        @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Activity> activities=activityService.getIAct();
            PageInfo pageInfo=new PageInfo(activities);
            if(activities!=null){
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
     * 查询所有部门审核未通过的活动
     */
    @RequestMapping(value = "/getnact",method= RequestMethod.GET)
    public JsonResult getNAct(        @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Activity> activities=activityService.getNAct();
            PageInfo pageInfo=new PageInfo(activities);
            if(activities!=null){
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
}
