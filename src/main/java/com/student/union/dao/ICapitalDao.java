package com.student.union.dao;

import com.student.union.entity.Capital;

import java.util.List;

public interface ICapitalDao {
    /**
     * 添加资金申请表
     */
    void addCapital(Capital capital);
    /**
     * 根据id修改资金申请表
     */
    void upCapital(Capital capital);
    /**
     * 搜索审核未通过资金申请表
     */
    List<Capital> getNCapital();
    /**
     * 搜索审核通过资金申请表
     */
    List<Capital> getICapital();
    /**
     * 按名称搜索通过资金申请表
     */
    List<Capital> igetCapitalByName(String capitalActName,String capitalDepart);
    /**
     * 按名称搜索未通过资金申请表
     */
    List<Capital> ngetCapitalByName(String capitalActName,String capitalDepart);
    /**
     * 按部门搜索通过资金申请表
     */
    List<Capital> igetCapitalByDep(String capitalDepart);
    /**
     * 按部门搜索未通过资金申请表
     */
    List<Capital> ngetCapitalByDep(String capitalDepart);
    /**
     * 根据id删除资金申请表
     */
    void delCapital(String capitalId);
    /**
     * 改变资金申请表状态
     */
    void isnCapital(String capitalState,String capitalId);
    /**
     * 按申请人搜索通过资金申请表
     */
    List<Capital> igetCapitalByPer(String capitalActName,String capitalPerson);
    /**
     * 按申请人搜索未通过资金申请表
     */
    List<Capital> ngetCapitalByPer(String capitalActName,String capitalPerson);
}
