package com.student.union.dao;

import com.student.union.entity.Department;
import com.student.union.entity.Fdep;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IDepartDao {
    /**
     * 查询部门
     */
    List<Department> getDepart(String departType);
    /**
     * 查询架构
     */
    List<Fdep> allDepart();
}
