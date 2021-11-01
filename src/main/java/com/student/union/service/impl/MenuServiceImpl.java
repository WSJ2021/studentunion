package com.student.union.service.impl;

import com.student.union.dao.IMenuDao;
import com.student.union.entity.Menu;
import com.student.union.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    IMenuDao imenuDao;
    /**
     * 获取菜单树
     */
    @Override
    public List<Menu> getmenu(String posiId) {
        List<Menu> menus=imenuDao.getmenu(posiId);
        return menus;
    }



}
