package com.student.union.service;

import com.student.union.entity.Department;
import com.student.union.entity.Fdep;

import java.util.List;

public interface IDepartService {
    /**
     * 查询团委学生会结构
     */
    List<Department> getDepart(String departType);
    /**
     * 查询架构
     */
    List<Fdep> allDepart();
}
