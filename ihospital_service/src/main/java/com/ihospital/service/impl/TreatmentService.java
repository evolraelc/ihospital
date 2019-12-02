package com.ihospital.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ihospital.mapper.*;
import com.ihospital.pojo.*;
import com.ihospital.service.IMedicalRecordService;
import com.ihospital.service.ITreatmentService;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RUANBY
 * @date 2019/11/28 19:00
 */
@Service
@Transactional
public class TreatmentService implements ITreatmentService {
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PhysicianMapper physicianMapper;
    @Autowired
    private PathographyMapper pathographyMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private IMedicalRecordService medicalRecordService;

    /**
     * @author ruanby
     * @date
     * @return
     * @function 根据病人ID返回病人实体
     */
    @Override
    public Patient findOnePatient(Long id) {
        return patientMapper.selectByPrimaryKey(id);
    }
    //根据医生ID返回医生实体
    @Override
    public Physician findOnePhysician(Long id) {
        return physicianMapper.selectByPrimaryKey(id);
    }
    //根据医生的ID查科室名字
    @Override
    public String findDeptNameById(Long id) {
        String departmentName=physicianMapper.selectByPrimaryKey(id).getDepartName();
        return departmentName;
    }
    @Override
    public Appointment findAppointmentById(Long id){
        return appointmentMapper.selectByPrimaryKey(id);
    }

    //提取出需要多次调用的代码，返回就诊记录详细信息
    @Override
    public List<MedicalRecord> findAll(List<Pathography> pathographies){
        //就诊信息的总条数
        Integer sumItems= pathographies.size();
        //创建DTO链表，用于返回给展示层
        List<MedicalRecord> mrs=new ArrayList<>();

        for(int i=0;i<sumItems;i++)
        {
            mrs.add(i,new MedicalRecord());
            //设置病人ID
            Long patientId=pathographies.get(i).getPatientId();
            mrs.get(i).setPatientId(patientId);
            //设置病人姓名
            String patientName=findOnePatient(mrs.get(i).getPatientId()).getPatientName();
            mrs.get(i).setPatientName(patientName);
            //设置医生ID
            Long physicianId=pathographies.get(i).getPhysicianId();
            mrs.get(i).setPhysicianId(physicianId);
            //设置医生姓名
            String physicianName=findOnePhysician(mrs.get(i).getPhysicianId()).getPhysicianName();
            mrs.get(i).setPhysicianName(physicianName);
            //设置就诊信息ID
            Long PathoId=pathographies.get(i).getPathoId();
            mrs.get(i).setPathoId(PathoId);
            //设置挂号单ID
            Long AppointmentId=pathographies.get(i).getAppointId();
            mrs.get(i).setAppointmentId(AppointmentId);
            //设置就诊时间
            Date time=pathographies.get(i).getTime();
            mrs.get(i).setTime(time);
            //通过医生ID，设置科室name
            String departName=findDeptNameById(physicianId);
            mrs.get(i).setDepartName(departName);
            //设置有效位
            boolean pathoValid=pathographies.get(i).getPathoValid();
            mrs.get(i).setPathoValid(pathoValid);
            //设置诊断结果
            String diagnosis=pathographies.get(i).getDiagnosis();
            mrs.get(i).setDiagnosis(diagnosis);
            //设置医嘱
            String narrative=pathographies.get(i).getNarrative();
            mrs.get(i).setNarrative(narrative);
        }
        return mrs;
    }

    @Override
    public PageResult findPage(PathographySearch pathographySearch, int pageNum, int pageSize, long id) {

        //根据用户输入的姓名，返回对应的IDList，因为有同姓名的人

        List<Long> patientIdList=medicalRecordService.findPatientByName(pathographySearch.getPatientName());
        //分页，调用插件
        PageHelper.startPage(pageNum, pageSize);
        PathographyExample pathographyExample =new PathographyExample();
        PathographyExample.Criteria criteria=pathographyExample.createCriteria();
        //返回医生id等于登录者id的条目
        criteria.andPhysicianIdEqualTo(id);
        //不要在 criteria.andXXX()的参数列表里有操作数据库的操作
        if(pathographySearch!=null){
            if(pathographySearch.getPatientName()!=null&&pathographySearch.getPatientName().length()>0){
                criteria.andPatientIdIn(patientIdList);
            }
            if(pathographySearch.getTime()!=null){
                //pathographySearch.getTime()获取前端传过来的日期，只精确到天，跟着的getTime会精确到毫秒
                Date minDate = new Date(pathographySearch.getTime().getTime() / 86400000L * 86400000L - 8 * 3600000);
                Date maxDate = new Date(minDate.getTime() + 86399000L);
                criteria.andTimeBetween(minDate, maxDate);
            }
        }
        Page<Pathography> pageOfpathography = (Page<Pathography>) pathographyMapper.selectByExample(pathographyExample);
        List listOfPathography=pageOfpathography.getResult();
        List<MedicalRecord> medicalRecords=findAll(listOfPathography);
        return new PageResult(pageOfpathography.getTotal(),medicalRecords );
    }
    //下面是病人的部分
    //根据手机号，返回病人实体
    @Override
    public Patient findOnePatientByPhoneNumber(String phoneNumber) {
        PatientExample patientExample= new PatientExample();
        PatientExample.Criteria criteria= patientExample.createCriteria();
        criteria.andPhoneNumberEqualTo(phoneNumber);
        return patientMapper.selectByExample(patientExample).get(0);
    }
    //根据病人实体的id和就诊时间，得到相关的所有pathography
    @Override
    public List<Pathography> findAllPathographyByPatientAndTime(Patient patient,PathographySearch pathographySearch) {
        PathographyExample pathographyExample=new PathographyExample();
        PathographyExample.Criteria criteria=pathographyExample.createCriteria();
        if(pathographySearch!=null){
            if(pathographySearch.getTime()!=null)
            {
                Date minDate = new Date(pathographySearch.getTime().getTime() / 86400000L * 86400000L - 8 * 3600000);
                Date maxDate = new Date(minDate.getTime() + 86399000L);
                criteria.andTimeBetween(minDate, maxDate);
            }
        }
        criteria.andPatientIdEqualTo(patient.getPatientId());

        return pathographyMapper.selectByExample(pathographyExample);
    }

    //根据Pathography的id，可以调用medicalRecordService已经实现的findMedicineInformationByPathoId（id）
    //方法得到总价和药品

    //这个给controller调用
//    @Override
//    public List<PatientMedicalInfo> findPatientMedicalInfo(String phoneNumber){
//        Patient patient=findOnePatientByPhoneNumber(phoneNumber);
//        List<Pathography> pathographies=findAllPathographyByPatient(patient);
//        return findPatientMedicalInfo(pathographies);
//    }

    //为病人信息查询添加了一个时间搜索


}
