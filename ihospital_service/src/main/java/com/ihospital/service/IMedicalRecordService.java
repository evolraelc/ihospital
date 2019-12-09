package com.ihospital.service;

import com.ihospital.pojo.*;
import entity.*;

import java.util.List;

public interface IMedicalRecordService {
    //查出所有的就诊详细信息
    public List<MedicalRecord> findAll() throws Exception;
    //根据特定的就诊信息查出所有的就诊详细信息
    public List<MedicalRecord> findAll(List<Pathography> pathographies);
    //查出所有的就诊信息
    public List<Pathography> findAllPathography();
    //根据病人ID查询病人实体
    public Patient findOnePatient(Long id);
    //根据医生ID查询医生实体
    public Physician findOnePhysician(Long id);
    //根据医生ID查所属科室名字
    public String findDeptNameById(Long id);
    //无条件分页
    public PageResult findPage(int pageNum, int pageSize) throws Exception;
    //根据就诊信息的ID链表删除对应的就诊信息
    public void delete(Long[] ids);


    //按条件查询分页
    public PageResult findPage(PathographySearch pathographySearch, int page , int size);

    //根据名字查询ID列表
    public List<Long> findPatientByName(String name);
    public List<Long> findPhysicianByName(String name);
    public List<Long> findDepartmentByName(String name);
    //根据科室ID，查询到这些科室下的所有医生id
    public List<Long> findPhysicianIdByDepart(List<Long> departIds);
    //根据就诊信息Id查找一条对应的就诊记录
    public Pathography findOnePathographyById(Long id);
    //根据就诊信息Id查找一条对应的就诊记录详细信息
    public MedicalRecord findAll(Long id) throws Exception;

    //根据药的ID查询药名
    public String findNameByMedicineId(Long id);
    //根据就诊信息ID查药单
    public MedicineInformationResult findMedicineInformationByPathoId(Long id);
    //根据就诊信息ID查病人的详细信息
    public Patient findPatientByPathoId(Long id);
    //根据就诊信息ID查挂号单的详细信息
    public Appointment findAppointmentByPathoId(Long id);
    //用于匹配select2的config
    public List<departSelect2> findConfigOfDepartment();

    //查询病人的预约列表
    public List<AppointInfo> findAppointmentList(Long patientId);
}


