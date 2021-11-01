package com.student.union.entity;

import java.util.List;

public class Menu {
    private String menuId;
    private String menuName;
    private List<Cmenu> cmenus;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Cmenu> getCmenus() {
        return cmenus;
    }

    public void setCmenus(List<Cmenu> cmenus) {
        this.cmenus = cmenus;
    }
}
