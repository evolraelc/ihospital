package com.ihospital.service;

import com.ihospital.pojo.Department;
import com.ihospital.pojo.Physician;
import entity.MyException;
import entity.PageResult;

public interface IPhysicianService {
    /**
     * 分页条件查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(Physician physician, int pageNum, int pageSize);


    /**
     * 添加 department
     * @param physician
     * @throws MyException
     */
    public void addPhysician(Physician physician) throws MyException;

    /**
     * @Description: 分页列表
     * @Param: [pageNum, pageSize] 当前页面，每页记录数
     * @return: entity.PageResult
     */
    public PageResult findPage(int pageNum, int pageSize);


    public void deletePhysicians(Long[] ids);


    public Physician findOnePhysician(Long id);

    public void updatePhysician(Physician physician);

    public Long departNameToId(String departName) throws MyException;
}
