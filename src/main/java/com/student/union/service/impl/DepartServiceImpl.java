package com.student.union.service.impl;

import com.student.union.dao.IDepartDao;
import com.student.union.entity.Department;
import com.student.union.entity.Fdep;
import com.student.union.service.IDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartServiceImpl implements IDepartService {
    @Autowired
    IDepartDao iDepartDao;
    @Override
    public List<Department> getDepart(String departType) {
        return iDepartDao.getDepart(departType);
    }

    @Override
    public List<Fdep> allDepart() {
        List<Fdep> fdeps=iDepartDao.allDepart();
        return fdeps;
    }
}
