package com.student.union.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.union.common.JsonResult;
import com.student.union.entity.Department;
import com.student.union.entity.User;
import com.student.union.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    IUserService userService;
    /**
     * 注册
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonResult addUser(@RequestBody User user){
        JsonResult result=null;
        try {
            userService.addUser(user);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;

    }
    /**
     * 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult Login(@RequestBody User user){
        JsonResult result=null;
        try{
            User user1=userService.login(user);
            if(user1!=null){
                result=new JsonResult(200,"登录成功",user1);
            }else {
                result=new JsonResult(404,"账号或密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(404,"账号或密码错误",e.getMessage());
        }
        return result;
    }
    /**
     * 按照部门名称查用户
     */
    @RequestMapping(value = "/userbydepart",method= RequestMethod.GET)
    public JsonResult userByDepart(String departValue,
                                   @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<User> users = userService.userByDepart(departValue);
            PageInfo pageInfo=new PageInfo(users);
            if(users!=null){
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
     * 部长查询本部门人员
     */
    @RequestMapping(value = "/getuserdepart",method= RequestMethod.GET)
    public JsonResult getUserDepart(String departValue,
                                    @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<User> users = userService.getUserDepart(departValue);
            PageInfo pageInfo=new PageInfo(users);
            if(users!=null){
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
     * 改变账号状态
     */
    @RequestMapping(value = "/isnuser",method= RequestMethod.PUT)
    public JsonResult isnUser(@RequestBody User user){
        JsonResult result=null;
        try{
            userService.isnUser(user.getUserId(),user.getUserState());
            result=new JsonResult(200,"操作成功");
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }
        return result;
    }
    /**
     * 按照用户id查用户
     */
    @RequestMapping(value = "/getuserbyid",method= RequestMethod.GET)
    public JsonResult getUserById(String userId){
        JsonResult result=null;
        try{
            User user = userService.getUserById(userId);
            if(user!=null){
                result=new JsonResult(200,"查询成功",user);
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
     * 根据用户修改用户信息
     */
    @RequestMapping(value = "/upuserinfo",method= RequestMethod.PUT)
    public JsonResult upUserInfo(@RequestBody User user){
        JsonResult result=null;
        try{
            userService.upUserInfo(user);
            result=new JsonResult(200,"操作成功");
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }
        return result;
    }
    /**
     * 管理员修改用户所有信息
     */
    @RequestMapping(value = "/upuser",method= RequestMethod.PUT)
    public JsonResult upUser(@RequestBody User user){
        JsonResult result=null;
        try{
            userService.upUser(user);
            result=new JsonResult(200,"操作成功");
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }
        return result;
    }
    /**
     * 上传头像
     */
    @RequestMapping(value = "/addphotopath",method = RequestMethod.POST)
    public JsonResult addPhotoPath(@RequestBody User user){
        JsonResult result=null;
        try {
            userService.addPhotoPath(user.getPhotoPath(),user.getUserId());
            result=new JsonResult(200,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;


    }
    /**
     * 根据用户id删用户
     */
    @RequestMapping(value = "/deluserbyid",method= RequestMethod.DELETE)
    public JsonResult delUserById(String userId){
        JsonResult result=null;
        try{
            userService.delUserById(userId);
            result=new JsonResult(200,"删除成功");
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }

        return result;
    }
    /**
     * 后台查所有人赋权
     */
    @RequestMapping(value = "/usercon",method= RequestMethod.GET)
    public JsonResult userCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<User> user = userService.userCon();
            PageInfo pageInfo=new PageInfo(user);
            if(user!=null){
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
     * 查部长副部
     */
    @RequestMapping(value = "/minister",method= RequestMethod.GET)
    public JsonResult minister(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",required = true,defaultValue = "7") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<User> user = userService.minister();
            PageInfo pageInfo=new PageInfo(user);
            if(user!=null){
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
     * 赋予权限
     */
    @RequestMapping(value = "/empower",method= RequestMethod.PUT)
    public JsonResult empower(@RequestBody User user){
        JsonResult result=null;
        try{
            userService.empower(user.getPosition(),user.getUserId());
            result=new JsonResult(200,"操作成功");
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }
        return result;
    }
}
