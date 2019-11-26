package com.ihospital.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ihospital.mapper.DepartmentMapper;
import com.ihospital.mapper.MedicineMapper;
import com.ihospital.pojo.Department;
import com.ihospital.pojo.DepartmentExample;
import com.ihospital.pojo.Patient;
import com.ihospital.pojo.PatientExample;
import com.ihospital.service.IDepartmentService;
import entity.MyException;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public PageResult findPage(Department department, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria= departmentExample.createCriteria();

//        filter criteria
        if (department!=null){
            if (department.getDepartName()!=null&&department.getDepartName().length()>0){
                criteria.andDepartNameLike("%"+department.getDepartName()+"%");
            }
//            if (department.getPhoneNumber()!=null&&department.getPhoneNumber().length()>0){
//                criteria.andPhoneNumberLike("%"+department.getPhoneNumber()+"%");
//            }
            if (department.getDepartId()!=null && department.getDepartId()>0){
                criteria.andDepartIdEqualTo(department.getDepartId());
            }
        }

        Page<Department> departments = (Page<Department>) departmentMapper.selectByExample(departmentExample);
        return new PageResult(departments.getTotal(), departments.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //分页，调用插件
        PageHelper.startPage(pageNum, pageSize);
        Page<Department> departmentPage = (Page<Department>) departmentMapper.selectByExample(null);
        return new PageResult(departmentPage.getTotal(), departmentPage.getResult());
    }

    @Override
    public void deleteDepartments(Long[] ids) {
        for (Long id: ids){
            departmentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Department findOneDepartment(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateByPrimaryKey(department);
    }

    @Override
    public List<Department> getAllDepartment() throws MyException{
        try{
            return departmentMapper.selectByExample(null);
        }catch (Exception e){
            throw new MyException("ERROR"+e.toString());
        }
    }

    @Override
    public Long departNameToId(String departName) throws MyException {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();

        if (departName.length()>0){
            criteria.andDepartNameEqualTo(departName);
        }
        List<Department> departments=departmentMapper.selectByExample(departmentExample); // list of only one item
        if (departments.size()==0){
            return null;
        }
        else
            return departments.get(0).getDepartId();
    }


    @Override
    public void addDepartment(Department department) throws MyException {
        try{
            departmentMapper.insert(department);
        }catch (Exception e){
            System.out.println("ERROR"+e.toString());
            throw new MyException("ERROR"+e.toString());
        }
    }




}
