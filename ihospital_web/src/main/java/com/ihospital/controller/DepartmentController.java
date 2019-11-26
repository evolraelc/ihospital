package com.ihospital.controller;

import com.ihospital.pojo.Department;
import com.ihospital.pojo.Patient;
import com.ihospital.service.IDepartmentService;
import entity.PageResult;
import entity.Result;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;


    @ResponseBody
    @RequestMapping("/findPage.do")
    public PageResult findPage(int page, int size) {
        return departmentService.findPage(page, size);
    }


    @ResponseBody
    @RequestMapping("/addDepartment.do")
    public Result addDepartment(@RequestBody Department department){
        try {
            departmentService.addDepartment(department);
            return new Result(true, "Add Success");
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/searchDepartment.do")
    public PageResult searchDepartment(@RequestBody Department department, int page, int size) {
        return departmentService.findPage(department, page, size);
    }


    @RequestMapping("/deleteDepartments.do")
    public Result deleteDepartments(Long[] ids){
        try{
            departmentService.deleteDepartments(ids);
            return new Result(true,"success");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"failure");
        }
    }

    @RequestMapping("/findOne.do")
    public Department findOneDepartment(Long id){
        return departmentService.findOneDepartment(id);
    }

    @RequestMapping("/updateDepartment.do")
    public Result updateDepartment(@RequestBody Department department){
        try{
            departmentService.updateDepartment(department);
            return new Result(true,"success");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"failure");
        }
    }

    @ResponseBody
    @RequestMapping("/findAll.do")
    public List<Department> findAll(){
        try{
            return departmentService.getAllDepartment();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
