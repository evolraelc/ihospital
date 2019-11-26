package com.ihospital.service;

import com.ihospital.pojo.Department;
import com.ihospital.pojo.Patient;
import entity.MyException;
import entity.PageResult;

import java.util.List;

/**
 * @author eyisheng
 */
public interface IDepartmentService {


    /**
     * 分页条件查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(Department department, int pageNum, int pageSize);


    /**
     * 添加 department
     * @param department
     * @throws MyException
     */
    public void addDepartment(Department department) throws MyException;

    /**
     * @Description: 分页列表
     * @Param: [pageNum, pageSize] 当前页面，每页记录数
     * @return: entity.PageResult
     */
    public PageResult findPage(int pageNum, int pageSize);


    public void deleteDepartments(Long[] ids);


    public Department findOneDepartment(Long id);

    public void updateDepartment(Department department);

    public List<Department> getAllDepartment() throws MyException;

    public Long departNameToId(String departName) throws MyException;
}
