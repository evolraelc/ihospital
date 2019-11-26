package com.ihospital.service;

import com.ihospital.pojo.News;
import com.ihospital.pojo.Patient;
import entity.MyException;
import entity.PageResult;

import java.util.List;

public interface INewsService {

    /**
     * @Description: 查询所有新闻
     * @Param: [pageNum, pageSize] 当前页面，每页记录数
     * @return: List of com.ihospital.pojo.News
     * @Author: HAD
     * @Date: 2019/11/19
     */
    public List<News> findAll() throws Exception;

    /**
     * @Description: 新闻列表分页
     * @Param: [pageNum, pageSize] 当前页面，每页记录数
     * @return: entity.PageResult
     * @Author: HAD
     * @Date: 2019/11/19
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * @Description: 添加新闻
     * @Param: com.ihospital.pojo.News
     * @return: void
     * @Author: HAD
     * @Date: 2019/11/19
     */

    public void addNews(News news) ;


    /**
     * @Description: 通过页面的id获取新闻实体
     * @Param: [id]
     * @return: com.ihospital.pojo.News
     * @Author: HAD
     * @Date: 2019/11/19
     */

    public News findOne(Long id);


    /**
     * @Description: 通过界面id获取新闻实体，然后编辑其内容
     * @Param: [id]
     * @return: void
     * @Author: HAD
     * @Date: 2019/11/19
     */

    public void updateNews(News news);


    /**
     * @Description: 通过多选框实现多删除
     * @Param: [ids]
     * @return: void
     * @Author: HAD
     * @Date: 2019/11/19
     */

    public void delete(Long[] ids);

    /**
     * @Description: 多条件查询
     * @Param: [news, pagenum, pageSize]
     * @return: entity.PageResult
     * @Author: HAD
     * @Date: 2019/11/20
     */

    public PageResult findPage(News news, int pageNum, int pageSize);

}
