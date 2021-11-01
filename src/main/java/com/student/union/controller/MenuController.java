package com.student.union.controller;

import com.student.union.common.JsonResult;
import com.student.union.entity.Menu;
import com.student.union.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    IMenuService imenuService;
    /**
     * 查询菜单树
     */

    @RequestMapping(value = "/menu",method= RequestMethod.GET)
    public JsonResult getmenu(String posiId){
        JsonResult result=null;

        try{
            List<Menu> menus =imenuService.getmenu(posiId);
            if(menus!=null){
                result=new JsonResult(200,"查询成功",menus);
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
