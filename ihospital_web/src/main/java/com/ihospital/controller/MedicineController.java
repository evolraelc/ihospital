package com.ihospital.controller;

import com.ihospital.pojo.Medicine;
import com.ihospital.service.IMedicineService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: Drug control by Manager
 * @autho: Cheng
 * @created: 2019-11-19-12-29
 **/

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;

    @RequestMapping("/findAll.do")
    public List<Medicine> findAll() throws Exception{
        return medicineService.findAll();
    }

    @RequestMapping("/addMedicine.do")
    public Result add(@RequestBody Medicine medicine)  {
        try{
            medicineService.add(medicine);
            return new Result(true,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }


    @RequestMapping("/updateMedicine.do")
    public Result update(@RequestBody Medicine medicine)  {
        try{
            medicineService.update(medicine);
            return new Result(true,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    @RequestMapping("/findOne.do")
    public Medicine findOne(Long medicineId){
        return medicineService.findOne(medicineId);
    }


    @RequestMapping("/findPage.do")
    public PageResult findPage(int page, int size) {
        return medicineService.findPage(page, size);
    }

    @RequestMapping("/deleteMedicine.do")
    public Result delete(Long[] ids){
        try{
            medicineService.delete(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }

    }

    @RequestMapping("/searchMedicine.do")
    public PageResult search(@RequestBody Medicine medicine, int page,int size){
        return  medicineService.findPage(medicine,page,size);

    }

}


