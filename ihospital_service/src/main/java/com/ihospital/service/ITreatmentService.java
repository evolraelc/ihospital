package com.ihospital.service;

import com.ihospital.pojo.Appointment;
import com.ihospital.pojo.Pathography;
import com.ihospital.pojo.Patient;
import com.ihospital.pojo.Physician;
import entity.MedicalRecord;
import entity.PageResult;
import entity.PathographySearch;


import java.util.Date;
import java.util.List;

/**
 * @author ruanby
 * @date
 * @return
 * @function 用于医生和病人查看各自的就诊记录
*/
public interface ITreatmentService {
    //按条件查询分页，返回当前医生的所有就诊记录
    public PageResult findPage(PathographySearch pathographySearch, int page, int size, long id);

    public List<MedicalRecord> findAll(List<Pathography> pathographies);
    public Patient findOnePatient(Long id);
    public Physician findOnePhysician(Long id);
    public String findDeptNameById(Long id);
    //根据挂号单id获得挂号单
    public Appointment findAppointmentById(Long id);


    //根据手机号，返回pathography，直接得到就诊时间，诊断结果，医嘱；
    //根据它的doctorID，返回医生实体，可以间接得到医生名字，科室名字
    //根据它的appointID，可以得到病人的类型
    //根据它的id，可以调用medicalRecordService已经实现的findMedicineInformationByPathoId（id）
    //方法得到MedicineInformationResult

    //根据手机号，返回病人实体
    public Patient findOnePatientByPhoneNumber(String phoneNumber);
    //根据病人实体的id和就诊时间，得到相关的所有pathography
    public List<Pathography> findAllPathographyByPatientAndTime(Patient patient, PathographySearch pathographySearch);
    //用于病人查看自己的就诊记录,参数是病人用于登录的手机号

}
