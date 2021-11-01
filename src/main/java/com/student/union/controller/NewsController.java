package com.student.union.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.union.common.JsonResult;
import com.student.union.entity.*;
import com.student.union.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    INewsService iNewsService;
    /**
     * 查询新闻
     */
    @RequestMapping(value = "/getnews",method= RequestMethod.GET)
    public JsonResult getNews(){
        JsonResult result=null;
        try{
            List<News> news=iNewsService.getNews();
            if(news!=null){
                result=new JsonResult(200,"查询成功",news);
            }else{
                result=new JsonResult(404,"查询失败");
            }
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }

        return result;
    }
    /**
     * 根据新闻标题查询新闻
     */
    @RequestMapping(value = "/getnewsbytitle",method= RequestMethod.GET)
    public JsonResult getNewsByTitle(String newsTitleOne){
        JsonResult result=null;
        try{
            List<News> news=iNewsService.getNewsByTitle(newsTitleOne);
            if(news!=null){
                result=new JsonResult(200,"查询成功",news);
            }else{
                result=new JsonResult(404,"查询失败");
            }
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }

        return result;
    }
    /**
     * 根据新闻标题查询完整新闻
     */
    @RequestMapping(value = "/getnewsbyone",method= RequestMethod.GET)
    public JsonResult getNewsByOne(String newsTitleOne){
        JsonResult result=null;
        try{
            List<News> news=iNewsService.getNewsByOne(newsTitleOne);
            if(news!=null){
                result=new JsonResult(200,"查询成功",news);
            }else{
                result=new JsonResult(404,"查询失败");
            }
        }catch (Exception e ){
            e.printStackTrace();
            result=new JsonResult(500,"系统错误");
        }

        return result;
    }
    /**
     * 删除新闻
     */
    @RequestMapping(value = "/delnews",method = RequestMethod.POST)
    public JsonResult delNews(@RequestBody News news){
        JsonResult result=null;
        try {
            iNewsService.delNews(news.getNewsId());
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 删除新闻段落
     */
    @RequestMapping(value = "/delparagr",method = RequestMethod.DELETE)
    public JsonResult delParagr(String newsId){
        JsonResult result=null;
        try {
            iNewsService.delParagr(newsId);
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 删除新闻图片
     */
    @RequestMapping(value = "/delPirture",method = RequestMethod.DELETE)
    public JsonResult delPirture(String newsId){
        JsonResult result=null;
        try {
            iNewsService.delPirture(newsId);
            result=new JsonResult(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 添加新闻标题
     */
    @RequestMapping(value = "/addnews",method = RequestMethod.POST)
    public JsonResult addNews(@RequestBody News news){
        JsonResult result=null;
        try {
            iNewsService.addNews(news);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 添加新闻段落
     */
    @RequestMapping(value = "/addparagr",method = RequestMethod.POST)
    public JsonResult addParagr(@RequestBody Paragr paragr){
        JsonResult result=null;
        try {
            iNewsService.addParagr(paragr);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
    /**
     * 添加新闻图片
     */
    @RequestMapping(value = "/addpirture",method = RequestMethod.POST)
    public JsonResult addPirture(@RequestBody Images images){
        JsonResult result=null;
        try {
            iNewsService.addPirture(images);
            result=new JsonResult(200,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(500,"服务器内部错误");
        }
        return result;
    }
}
