package com.student.union.entity;

import java.util.List;

public class Paragr {
    private String paragrId;
    private String paragrNumber;
    private String paragrContent;
    private String newsId;
    private List<Images> parImages;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public List<Images> getParImages() {
        return parImages;
    }

    public void setParImages(List<Images> parImages) {
        this.parImages = parImages;
    }

    public String getParagrId() {
        return paragrId;
    }

    public void setParagrId(String paragrId) {
        this.paragrId = paragrId;
    }

    public String getParagrNumber() {
        return paragrNumber;
    }

    public void setParagrNumber(String paragrNumber) {
        this.paragrNumber = paragrNumber;
    }

    public String getParagrContent() {
        return paragrContent;
    }

    public void setParagrContent(String paragrContent) {
        this.paragrContent = paragrContent;
    }
}
