package com.student.union.dao;
import com.student.union.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMenuDao {
    /**
     * 获取菜单树
     */
     List<Menu> getmenu(String posiId);
}
