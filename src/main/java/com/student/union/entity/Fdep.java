package com.student.union.entity;

import java.util.List;

public class Fdep {
    private String fdepId;
    private String name;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    private String image_url;
    private List<Department> children;

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }



    public String getFdepId() {
        return fdepId;
    }

    public void setFdepId(String fdepId) {
        this.fdepId = fdepId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
