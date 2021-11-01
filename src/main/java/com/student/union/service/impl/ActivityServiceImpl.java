package com.student.union.service.impl;

import com.student.union.dao.IActivityDao;
import com.student.union.entity.Activity;
import com.student.union.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl implements IActivityService {
    @Autowired
    IActivityDao activityDao;
    /**
     * 添加活动
     */
    @Override
    public void addAct(Activity activity) {
        activityDao.addAct(activity);
    }
    /**
     * 根据id删除活动
     */
    @Override
    public void delAct(String actId) {
        activityDao.delAct(actId);
    }
    /**
     * 根据id修改活动
     */

    @Override
    public void upAct(Activity activity) {
        activityDao.upAct(activity);
    }
    /**
     * 根据活动开始时间检索活动
     */
    @Override
    public List<Activity> getActByTime(String actStartTime) {

        return activityDao.getActByTime(actStartTime);
    }
    /**
     * 查询某部门所有审核通过的活动
     */
    @Override
    public List<Activity> getIActByDepart(String actApplyDepart) {
        return activityDao.getIActByDepart(actApplyDepart);
    }
    /**
     * 查询某部门所有审核未通过的活动
     */
    @Override
    public List<Activity> getNActByDepart(String actApplyDepart) {
        return activityDao.getNActByDepart(actApplyDepart);
    }
    /**
     * 审核活动
     */
    @Override
    public void isnAct(String actState,String actId) {
        activityDao.isnAct(actState,actId);
    }
    /**
     * 查询所有部门审核通过的活动
     */
    @Override
    public List<Activity> getIAct() {
        return activityDao.getIAct();
    }
    /**
     * 查询所有部门审核未通过的活动
     */
    @Override
    public List<Activity> getNAct() {
        return activityDao.getNAct();
    }
    /**
     * 查询最近开始的活动
     */
    @Override
    public List<Activity> getActByStartTime() {
        return activityDao.getActByStartTime();
    }
    /**
     * 根据活动标题检索活动
     */
    @Override
    public List<Activity> getActByName(String actName) {
        return activityDao.getActByName(actName);
    }


}
