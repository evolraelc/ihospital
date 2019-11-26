package com.ihospital.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ihospital.mapper.PatientMapper;
import com.ihospital.pojo.Patient;
import com.ihospital.pojo.PatientExample;
import com.ihospital.service.IPatientService;
import entity.MyException;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: ihospital
 * @description:
 * @author: Mr.King
 * @create: 2019-11-15 15:26
 **/
@Service
@Transactional
public class PatientService implements IPatientService {
    @Autowired
    private PatientMapper patientMapper;


    @Override
    public List<Patient> findAll() throws Exception {
        return patientMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {

        //分页，调用插件
        PageHelper.startPage(pageNum, pageSize);
        Page<Patient> patients = (Page<Patient>) patientMapper.selectByExample(null);


        return new PageResult(patients.getTotal(), patients.getResult());
    }

    @Override
    public void addPatient(Patient patient) throws MyException {

        PatientExample patientExample = new PatientExample();
        patientExample.or().andIdcardEqualTo(patient.getIdcard());
        patientExample.or().andPhoneNumberEqualTo(patient.getPhoneNumber());
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        if (!patients.isEmpty()) {
            throw new MyException("ID number or mobile number has been registered");


        } else{

            //patient.setUtype("Approved");
            patientMapper.insert(patient);
        }


    }

    @Override
    public Patient findOne(Long id) {
        return patientMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateStatus(Long id) {
        Patient patient = new Patient();
        patient = patientMapper.selectByPrimaryKey(id);
        if (patient.getUtype()==null){
            patient.setUtype("Denied");
        }
        else if (patient.getUtype().equals("Approved")){
            patient.setUtype("Denied");
        } else{
            patient.setUtype("Approved");
        }
        patientMapper.updateByPrimaryKeySelective(patient);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids){
            patientMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(Patient patient, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PatientExample patientExample= new PatientExample();

        PatientExample.Criteria criteria= patientExample.createCriteria();

        if (patient!=null){
            if (patient.getPatientName()!=null&&patient.getPatientName().length()>0){

                criteria.andPatientNameLike("%"+patient.getPatientName()+"%");
            }
            if (patient.getPhoneNumber()!=null&&patient.getPhoneNumber().length()>0){

                criteria.andPhoneNumberLike("%"+patient.getPhoneNumber()+"%");            }

        }




        Page<Patient> patients = (Page<Patient>) patientMapper.selectByExample(patientExample);


        return new PageResult(patients.getTotal(), patients.getResult());
    }


    @Override
    public void setStatus(Long id, String status) {
        Patient patient = patientMapper.selectByPrimaryKey(id);
        patient.setUtype(status);
        patientMapper.updateByPrimaryKeySelective(patient);
    }
}
