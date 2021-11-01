package com.student.union.service.impl;

import com.student.union.dao.INewsDao;
import com.student.union.entity.Images;
import com.student.union.entity.News;
import com.student.union.entity.Paragr;
import com.student.union.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    INewsDao iNewsDao;
    /**
     * 查询新闻
     */
    @Override
    public List<News> getNews() {
        List<News> news=iNewsDao.getNews();
        return news;
    }
    /**
     * 删除新闻
     */
    @Override
    public void delNews(String newsId) {
        iNewsDao.delNews(newsId);
        iNewsDao.delParagr(newsId);
        iNewsDao.delPirture(newsId);
    }
    /**
     * 删除新闻段落
     */

    @Override
    public void delParagr(String newsId) {
        iNewsDao.delParagr(newsId);
    }
    /**
     * 删除新闻图片
     */
    @Override
    public void delPirture(String newsId) {
        iNewsDao.delPirture(newsId);
    }
    /**
     * 添加新闻标题
     */

    @Override
    public void addNews(News news) {
        iNewsDao.addNews(news);
    }
    /**
     * 添加新闻段落
     */
    @Override
    public void addParagr(Paragr paragr) {
        iNewsDao.addParagr(paragr);
    }
    /**
     * 添加新闻图片
     */
    @Override
    public void addPirture(Images images) {
        iNewsDao.addPirture(images);
    }
    /**
     * 根据新闻标题查询新闻
     */
    @Override
    public List<News> getNewsByTitle(String newsTitleOne) {
        return iNewsDao.getNewsByTitle(newsTitleOne);
    }
    /**
     * 根据题目查询新闻
     */
    @Override
    public List<News> getNewsByOne(String newsTitleOne) {
        return iNewsDao.getNewsByOne(newsTitleOne);
    }


}
