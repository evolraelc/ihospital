package com.ihospital.controller;


import com.ihospital.pojo.News;
import com.ihospital.pojo.Patient;
import com.ihospital.service.INewsService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @RequestMapping("/findAll.do")
    public List<News> findAll() throws Exception {
        return newsService.findAll();
    }

    @RequestMapping("/findPage.do")
    public PageResult findPage(int page, int size){
        return newsService.findPage(page, size);
    }

    @RequestMapping("/addNews.do")
    public Result add(@RequestBody News news){
        try {
            newsService.addNews(news);
            return new Result(true, "Add News Success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/deleteNews.do")
    public Result deletePatient(Long[] ids) {
        try {
            newsService.delete(ids);
            return new Result(true, "Delete Success");

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/searchNews.do")
    public PageResult search(@RequestBody News news, int page, int rows  ){
        return newsService.findPage(news, page, rows);
    }

    @RequestMapping("/updateNews.do")
    public Result update(@RequestBody News news){
        try {
            newsService.updateNews(news);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne.do")
    public News findOne(Long id){
        return newsService.findOne(id);
    }
}
