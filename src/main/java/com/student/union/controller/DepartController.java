package com.student.union.controller;

import com.student.union.common.JsonResult;
import com.student.union.entity.Department;
import com.student.union.entity.Fdep;
import com.student.union.service.IDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartController {
    @Autowired
    IDepartService iDepartService;
    /**
     * 查询部门
     */
    @RequestMapping(value = "/getdepart",method= RequestMethod.GET)
    public JsonResult getDeparts(String departType){
        JsonResult result=null;
        try{
            List<Department> departments =iDepartService.getDepart(departType);
            if(departments!=null){
                result=new JsonResult(200,"查询成功",departments);
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
     * 查询团委学生会结构
     */
    @RequestMapping(value = "/alldepart",method= RequestMethod.GET)
    public JsonResult allDepart(){
        JsonResult result=null;
        try{
            List<Fdep> fdep =iDepartService.allDepart();
            if(fdep!=null){
                result=new JsonResult(200,"查询成功",fdep);
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
