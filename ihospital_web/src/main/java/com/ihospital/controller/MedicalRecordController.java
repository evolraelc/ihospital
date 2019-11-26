package com.ihospital.controller;

import com.ihospital.pojo.Appointment;
import com.ihospital.pojo.Patient;
import com.ihospital.service.IMedicalRecordService;
import com.ihospital.service.IPatientService;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author RUANBY
 * @date 2019/11/20
 */
@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private IPatientService patientService;
    @Autowired
    private IMedicalRecordService medicalRecordService;

    @RequestMapping("findAll.do")
    public List<MedicalRecord> findAll() throws Exception {
        return  medicalRecordService.findAll();
    }

    @RequestMapping("findOneMedicalRecord.do")
    public MedicalRecord findAll(Long id) throws Exception {
        return  medicalRecordService.findAll(id);
    }

    @RequestMapping("/findPage.do")
    public PageResult findPage(int page, int size) throws Exception {
        return medicalRecordService.findPage(page, size);
    }

    @RequestMapping("/deleteMedicalRecord.do")
    public Result deleteMedicalRecord(Long[] ids) {
        try {
            medicalRecordService.delete(ids);
            return new Result(true, "Delete Success");

        } catch (Exception e) {

            return new Result(false, e.getMessage());
        }
    }


    @RequestMapping("/search.do")
    public PageResult search(@RequestBody PathographySearch pathographySearch, int page, int size) throws Exception {
        return medicalRecordService.findPage(pathographySearch,page, size);
    }


    @RequestMapping("findMedicineInformationByPathoId.do")
    public MedicineInformationResult findMedicineInformationByPathoId(Long id) {
        return  medicalRecordService.findMedicineInformationByPathoId(id);
    }

    @RequestMapping("findPatientByPathoId.do")
    public Patient findPatientByPathoId(Long id) {
        return  medicalRecordService.findPatientByPathoId(id);
    }

    @RequestMapping("findAppointmentByPathoId.do")
    public Appointment findAppointmentByPathoId(Long id) {
        return  medicalRecordService.findAppointmentByPathoId(id);
    }

    @RequestMapping("findConfigOfDepartment.do")
    public List<departSelect2> findConfigOfDepartment(){
        return medicalRecordService.findConfigOfDepartment();
    }

}
