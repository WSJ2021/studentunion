package com.student.union.service.impl;

import com.student.union.dao.ICapitalDao;
import com.student.union.entity.Capital;
import com.student.union.service.ICapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CapitalServiceImpl implements ICapitalService {
    @Autowired
    ICapitalDao iCapitalDao;
    /**
     * 添加资金申请表
     */
    @Override
    public void addCapital(Capital capital) {
        iCapitalDao.addCapital(capital);
    }
    /**
     * 根据id修改资金申请表
     */
    @Override
    public void upCapital(Capital capital) {
        iCapitalDao.upCapital(capital);
    }
    /**
     * 搜索审核未通过资金申请表
     */
    @Override
    public List<Capital> getNCapital() {
        return iCapitalDao.getNCapital();
    }
    /**
     * 搜索审核通过资金申请表
     */
    @Override
    public List<Capital> getICapital() {
        return iCapitalDao.getICapital();
    }
    /**
     * 根据id删除资金申请表
     */
    @Override
    public void delCapital(String capitalId) {
        iCapitalDao.delCapital(capitalId);
    }
    /**
     * 改变资金申请表状态
     */
    @Override
    public void isnCapital(String capitalState, String capitalId) {
        iCapitalDao.isnCapital(capitalState,capitalId);
    }
    /**
     * 按名称搜索通过资金申请表
     */
    @Override
    public List<Capital> igetCapitalByName(String capitalActName,String capitalDepart) {
         return iCapitalDao.igetCapitalByName(capitalActName,capitalDepart);
    }
    /**
     * 按名称搜索未通过资金申请表
     */
    @Override
    public List<Capital> ngetCapitalByName(String capitalActName,String capitalDepart) {
         return iCapitalDao.ngetCapitalByName(capitalActName,capitalDepart);
    }
    /**
     * 按部门搜索通过资金申请表
     */
    @Override
    public List<Capital> igetCapitalByDep(String capitalDepart) {
        return iCapitalDao.igetCapitalByDep(capitalDepart);
    }
    /**
     * 按部门搜索未通过资金申请表
     */
    @Override
    public List<Capital> ngetCapitalByDep(String capitalDepart) {
        return iCapitalDao.ngetCapitalByDep(capitalDepart);
    }
    /**
     * 按申请人搜索通过资金申请表
     */
    @Override
    public List<Capital> igetCapitalByPer(String capitalActName, String capitalPerson) {
        return iCapitalDao.igetCapitalByPer(capitalActName,capitalPerson);
    }
    /**
     * 按申请人搜索未通过资金申请表
     */
    @Override
    public List<Capital> ngetCapitalByPer(String capitalActName, String capitalPerson) {
        return iCapitalDao.ngetCapitalByPer(capitalActName,capitalPerson);
    }


}
