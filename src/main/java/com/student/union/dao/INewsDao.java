package com.student.union.dao;

import com.student.union.entity.Images;
import com.student.union.entity.News;
import com.student.union.entity.Paragr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface INewsDao {
    /**
     * 查询新闻
     */
    List<News> getNews();
    /**
     * 根据题目查询新闻
     */
    List<News> getNewsByOne(String newsTitleOne);
    /**
     * 根据新闻标题查询新闻
     */
    List<News> getNewsByTitle(String newsTitleOne);
    /**
     * 删除新闻
     */
    void delNews( String newsId);
    /**
     * 删除新闻段落
     */
    void delParagr( String newsId);
    /**
     * 删除新闻图片
     */
    void delPirture( String newsId);
    /**
     * 添加新闻标题
     */
    void addNews(News news);
    /**
     * 添加新闻段落
     */
    void addParagr(Paragr paragr);
    /**
     * 添加新闻图片
     */
    void addPirture(Images images);
}
