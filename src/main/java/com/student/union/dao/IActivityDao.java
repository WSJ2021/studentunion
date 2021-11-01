package com.student.union.dao;

import com.student.union.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IActivityDao {
    /**
     * 添加活动
     */
    void addAct(Activity activity);
    /**
     * 根据id删除活动
     */
    void delAct(String actId);
    /**
     * 根据id修改活动
     */
    void upAct(Activity activity);
    /**
     * 根据活动开始时间检索活动
     */
    List<Activity> getActByTime(String actStartTime);
    /**
     * 根据活动标题检索活动
     */
    List<Activity> getActByName(String actName);
    /**
     * 查询最近开始的活动
     */
    List<Activity> getActByStartTime();
    /**
     * 查询某部门所有审核通过的活动
     */
    List<Activity> getIActByDepart(String actApplyDepart);
    /**
     * 查询某部门所有审核未通过的活动
     */
    List<Activity> getNActByDepart(String actApplyDepart);
    /**
     * 审核活动
     */
    void isnAct(String actState,String actId);
    /**
     * 查询所有部门审核通过的活动
     */
    List<Activity> getIAct();
    /**
     * 查询所有部门审核未通过的活动
     */
    List<Activity> getNAct();
}
