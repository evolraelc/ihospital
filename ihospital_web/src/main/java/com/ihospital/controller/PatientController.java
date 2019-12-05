package com.ihospital.controller;

import com.ihospital.pojo.Patient;
import com.ihospital.service.IPatientService;
import entity.MyException;
import entity.PageResult;
import entity.PatientInfo;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: ihospital
 * @description:
 * @author: Mr.King
 * @create: 2019-11-15 15:38
 **/

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @RequestMapping("/findAll.do")
    public List<Patient> findAll() throws Exception {
        return patientService.findAll();
    }

    @RequestMapping("/findPage.do")
    public PageResult findPage(int page, int size) {
        return patientService.findPage(page, size);
    }


    @ResponseBody
    @RequestMapping("/addPatient.do")
    public Result addPatient(@RequestBody Patient patient) {
        try {
            patientService.addPatient(patient);
            return new Result(true, "Add Success");

        } catch (Exception e) {

            return new Result(false, e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/updatePatient.do")
    public Result updatePatient(@RequestBody PatientInfo patientInfo) {
        try {
            patientService.updatePatient(patientInfo);
            return new Result(true, "Update Success");

        } catch (Exception e) {

            return new Result(false, e.getMessage());
        }
    }


    @RequestMapping("/reversePatient.do")
    public Result reversePatient(Long id) {
        try {
            patientService.updateStatus(id);
            return new Result(true, "Reverse Success");

        } catch (Exception e) {

            return new Result(false, e.getMessage());
        }
    }


    @RequestMapping("/deletePatient.do")
    public Result deletePatient(Long[] ids) {
        try {
            patientService.delete(ids);
            return new Result(true, "Delete Success");

        } catch (Exception e) {

            return new Result(false, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/searchPatient.do")
    public PageResult searchPatient(@RequestBody Patient patient, int page, int size) {

        return patientService.findPage(patient, page, size);


    }

    @RequestMapping("/changeStatus.do")
    public Result changeStatus(Long id, String target) {
        try {
            patientService.setStatus(id, target);
            return new Result(true, "Change Success");
        }
        catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/getPatient.do")
    public Patient getPatient(String phone) {
        return patientService.getPatientByPhone(phone);
    }

    @RequestMapping("/findOne.do")
    public Patient findOne(Long patientId) {
        return patientService.findOne(patientId);
    }
}
