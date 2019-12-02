package com.ihospital.controller;

import com.ihospital.pojo.Appointment;
import com.ihospital.service.ITreatService;
import entity.DrugSelect2;
import entity.PatientTreating;
import entity.Result;
import entity.TreatmentInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.jsp.tagext.TryCatchFinally;
import java.util.Date;
import java.util.List;

/**
 * @program: ihospital
 * @description: 医生工作控制器
 * @author: Mr.King
 * @create: 2019-11-26 20:32
 **/

@RestController
@RequestMapping("/treat")
public class TreatController {
    @Autowired
    private ITreatService treatService;

    @RequestMapping("/getPatients.do")
    public List<PatientTreating> getPatients(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd")Date date, Long deptId){
        return treatService.getPatients(date,deptId);
    }

    @RequestMapping("/getNextPatient.do")
    public PatientTreating getNextPatient(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd")Date date, Long deptId){
        return treatService.getNextPatient(date,deptId);
    }

    @RequestMapping("/addTreatment.do")
    @ResponseBody
    public Result addTreatment(@RequestBody TreatmentInfo treatmentInfo){
        try {
            treatService.addTreatment(treatmentInfo);
            return new Result(true,"submit success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"submit fail");
        }
    }


    @RequestMapping("/addAppointment.do")
    @ResponseBody
    public Result addAppointment(@RequestBody Appointment appointment){
        try {
            Integer num = treatService.addAppointment(appointment);
            return new Result(true,"appoint success NO."+num);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"appoint fail");
        }
    }

    @RequestMapping("/findConfigOfDrug.do")
    public List<DrugSelect2> findConfigOfDrug(){
        return treatService.findConfigOfDrug();
    }

    @RequestMapping("/getPrice.do")
    public  Integer getPrice(Long id){
        return treatService.getPrice(id);
    }


}
