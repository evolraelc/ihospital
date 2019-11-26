package com.ihospital.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ihospital.mapper.NewsMapper;
import com.ihospital.pojo.News;
import com.ihospital.pojo.NewsExample;
import com.ihospital.pojo.Patient;
import com.ihospital.service.INewsService;
import entity.MyException;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NewsService implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> findAll() throws Exception {
        return newsMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //分页，调用插件
        PageHelper.startPage(pageNum, pageSize);
        Page<News> news = (Page<News>) newsMapper.selectByExample(null);


        return new PageResult(news.getTotal(), news.getResult());
    }

    @Override
    public void addNews(News news)  {
        newsMapper.insert(news);
    }

    @Override
    public News findOne(Long id) {
        return newsMapper.selectByPrimaryKey(id);

    }

    @Override
    public void updateNews(News news) {
       newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            newsMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(News news, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        NewsExample newsExample=new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        if(news!=null){
            if(news.getTime()!=null ){
                Date minDate=new Date(news.getTime().getTime()/86400000L*86400000L-8*3600000);
               Date maxDate=new Date(minDate.getTime()+86399000L);
                criteria.andTimeBetween(minDate,maxDate);
            }
            if(news.getTitle()!=null && news.getTitle().length()>0){
                criteria.andTitleLike("%"+news.getTitle()+"%");
            }
        }
        Page<News> newsPage= (Page<News>)newsMapper.selectByExample(newsExample);
        return new PageResult(newsPage.getTotal(), newsPage.getResult());
    }
}
