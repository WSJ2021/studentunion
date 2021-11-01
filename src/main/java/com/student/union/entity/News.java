package com.student.union.entity;

import java.util.List;

public class News {
    private String newsId;
    private String newsTitleOne;
    private String newsTitleTwo;
    private String newsAuthor;
    private String newsTime;
    private String newsOutline;

    public String getNewsOutline() {
        return newsOutline;
    }

    public void setNewsOutline(String newsOutline) {
        this.newsOutline = newsOutline;
    }

    public String getNewsTitleOne() {
        return newsTitleOne;
    }

    public void setNewsTitleOne(String newsTitleOne) {
        this.newsTitleOne = newsTitleOne;
    }

    public String getNewsTitleTwo() {
        return newsTitleTwo;
    }

    public void setNewsTitleTwo(String newsTitleTwo) {
        this.newsTitleTwo = newsTitleTwo;
    }


    private List<Paragr> pargers;

    public List<Paragr> getPargers() {
        return pargers;
    }

    public void setPargers(List<Paragr> pargers) {
        this.pargers = pargers;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }





    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }
}
