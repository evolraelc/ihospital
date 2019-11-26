package com.ihospital.service;

import com.ihospital.pojo.Medicine;
import entity.PageResult;

import java.util.List;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-19-12-34
 **/
public interface IMedicineService {

    /**
    * @description: 查询数据库中所有药
    * @Param:
    * @return: List<Medicine>
    * @author: Cheng
    * @created: 2019/11/19/12:53
    **/
    public List<Medicine> findAll() throws Exception;

    /**
    * @description: 分页显示
    * @Param: pageNum， pageSize
    * @return: PageResult
    * @author: Cheng
    * @created: 2019/11/19/12:53
    **/
    public PageResult findPage(int pageNum, int pageSize);

    /**
    * @description: 添加药
    * @Param: Medicine medicine
    * @return:
    * @author: Cheng
    * @created: 2019/11/19/12:54
    **/
    public void add(Medicine medicine) ;

    /**
    * @description: 搜索药
    * @Param:
    * @return:
    * @author: Cheng
    * @created: 2019/11/19/12:54
    **/
    public Medicine findOne(Long medicineId);

    /**
    * @description: 删除药
    * @Param:
    * @return:
    * @author: Cheng
    * @created: 2019/11/19/12:54
    **/
    public void delete(Long[] ids);

    /**
    * @description: 更新药库
    * @Param:
    * @return:
    * @author: Cheng
    * @created: 2019/11/19/12:55
    **/
    public void update(Medicine medicine);


    /**
    * @description: 多条件查询
    * @Param:
    * @return:
    * @author: Cheng
    * @created: 2019/11/19/13:07
    **/
    public PageResult findPage(Medicine medicine, int pageNum, int pageSize);



}
