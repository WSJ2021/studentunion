package com.student.union.service;

import com.student.union.entity.Menu;

import java.util.List;

public interface IMenuService {
    /**
     * 获取菜单树
     */
    List<Menu> getmenu(String posiId);
}
