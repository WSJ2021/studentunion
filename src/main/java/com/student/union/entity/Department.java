package com.student.union.entity;

public class Department {
    private String departId;
    private String name;
    private String departType;
    private String departIntro;
    private String image_url;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }



    public String getDepartType() {
        return departType;
    }

    public void setDepartType(String departType) {
        this.departType = departType;
    }

    public String getDepartIntro() {
        return departIntro;
    }

    public void setDepartIntro(String departIntro) {
        this.departIntro = departIntro;
    }
}
