package com.student.union.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.union.common.JsonResult;
import com.student.union.entity.Meeting;
import com.student.union.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeetingController {
    @Autowired
    IMeetingService meetingService;
    /**
     * 添加会议记录
     */
    @RequestMapping(value = "/addmeeting",method = RequestMethod.POST)
    public JsonResult addMeeting(@RequestBody Meeting meeting){
        JsonResult result=null;
        try {
            meetingService.addMeeting(meeting);
                result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 根据会议id删除会议记录
     */
    @RequestMapping(value = "/delmeeting",method = RequestMethod.DELETE)
    public JsonResult delMeeting(String meetingId){
        JsonResult result=null;
        try {
            meetingService.delMeeting(meetingId);
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }

    /**
     * 根据会议id修改会议记录
     */
    @RequestMapping(value = "/upmeeting",method = RequestMethod.PUT)
    public JsonResult upMeeting(@RequestBody Meeting meeting){
        JsonResult result=null;
        try {
            meetingService.upMeeting(meeting);
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 查询本部门所有会议记录
     */
    @RequestMapping(value = "/getmeeting",method= RequestMethod.GET)
    public JsonResult getMeeting(String meetingCapital,@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Meeting> meetings=meetingService.getMeeting(meetingCapital);
            PageInfo pageInfo=new PageInfo(meetings);
            if(meetings!=null){
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
     * 根据会议时间搜索会议记录
     */
    @RequestMapping(value = "/getmeetingbytime",method= RequestMethod.GET)
    public JsonResult getMeetingBytime(String meetingTime,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Meeting> meetings=meetingService.getMeetingBytime(meetingTime);
            PageInfo pageInfo=new PageInfo(meetings);
            if(meetings!=null){
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
     * 根据会议标题搜索会议记录
     */
    @RequestMapping(value = "/getmeetingbytitle",method= RequestMethod.GET)
    public JsonResult getMeetingBytitle(String meetingTitle,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Meeting> meetings=meetingService.getMeetingBytitle(meetingTitle);
            PageInfo pageInfo=new PageInfo(meetings);
            if(meetings!=null){
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
