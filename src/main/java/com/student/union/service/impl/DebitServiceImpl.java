package com.student.union.service.impl;

import com.student.union.dao.IDebitDao;
import com.student.union.entity.Debit;
import com.student.union.service.IDebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DebitServiceImpl implements IDebitService {
    @Autowired
    IDebitDao iDebitDao;
    /**
     * 添加借记表
     */
    @Override
    public void addDebit(Debit debit) {
        iDebitDao.addDebit(debit);
    }
    /**
     * 搜索所有未归还借记表
     */
    @Override
    public List<Debit> getNDebit(String debitDepart) {
        return iDebitDao.getNDebit(debitDepart);
    }
    /**
     * 搜索所有已归还借记表
     */
    @Override
    public List<Debit> getIDebit(String debitDepart) {
        return iDebitDao.getIDebit(debitDepart);
    }

    /**
     * 按物品名搜索已归还借记表
     */
    @Override
    public List<Debit> igetDebitByGoods(String debitGoodsName,String debitDepart) {
        return iDebitDao.igetDebitByGoods(debitGoodsName,debitDepart);
    }
    /**
     * 按物品名搜索未归还借记表
     */
    @Override
    public List<Debit> ngetDebitByGoods(String debitGoodsName,String debitDepart) {
        return iDebitDao.ngetDebitByGoods(debitGoodsName,debitDepart);
    }
    /**
     * 根据借记表id删除借记表
     */
    @Override
    public void delDebit(String debitId) {
        iDebitDao.delDebit(debitId);
    }

    /**
     * 根据id改变借记表状态
     */
    @Override
    public void isnDebit(String debitState, String debitId) {
        iDebitDao.isnDebit(debitState,debitId);
    }




}
