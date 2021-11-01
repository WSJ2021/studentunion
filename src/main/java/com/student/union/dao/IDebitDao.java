package com.student.union.dao;

import com.student.union.entity.Debit;

import java.util.List;

public interface IDebitDao {
    /**
     * 添加借记表
     */
    void addDebit(Debit debit);
    /**
     * 搜索所有未归还借记表
     */
    List<Debit> getNDebit(String debitDepart);
    /**
     * 搜索所有已归还借记表
     */
    List<Debit> getIDebit(String debitDepart);
    /**
     * 按物品名搜索已归还借记表
     */
    List<Debit> igetDebitByGoods(String debitGoodsName,String debitDepart);
    /**
     * 按物品名搜索未归还借记表
     */
    List<Debit> ngetDebitByGoods(String debitGoodsName,String debitDepart);
    /**
     * 根据借记表id删除借记表
     */
    void delDebit (String debitId);
    /**
     * 根据id改变借记表状态
     */
    void isnDebit(String debitState,String debitId);
}
