package com.ihospital.service;

import com.ihospital.pojo.Appointment;
import entity.DrugSelect2;
import entity.PatientTreating;
import entity.TreatmentInfo;

import java.util.Date;
import java.util.List;

/**
 * @program: ihospital
 * @description: 医生工作功能接口
 * @author: Mr.King
 * @create: 2019-11-26 20:49
 **/

public interface ITreatService {

    /**
    * @Description: 得到医生下一位诊断的病人
    * @Param: []
    * @return: entity.PatientTreating
    * @Author: Mr.King
    * @Date: 2019/11/26
    */
    PatientTreating getNextPatient(Date date,Long deptId);

    /**
    * @Description: 得到诊断队列
    * @Param: []
    * @return: java.util.List<entity.PatientTreating>
    * @Author: Mr.King
    * @Date: 2019/11/26
    */
    List<PatientTreating> getPatients(Date date,Long deptId);


    /**
    * @Description: 医生提交诊断信息
    * @Param: [treatmentInfo]
    * @return: void
    * @Author: Mr.King
    * @Date: 2019/11/27
    */

    void addTreatment(TreatmentInfo treatmentInfo);

    /**
    * @Description: 药物下拉列表
    * @Param: []
    * @return: java.util.List<entity.DrugSelect2>
    * @Author: Mr.King
    * @Date: 2019/11/27
    */

    List<DrugSelect2> findConfigOfDrug();


    /**
    * @Description: 获取选择的药物价格
    * @Param: [id]
    * @return: java.lang.Integer
    * @Author: Mr.King
    * @Date: 2019/11/27
    */

    Integer getPrice(Long id);

    /**
    * @Description: 挂号
    * @Param: [appointment]
    * @return: void
    * @Author: Mr.King
    * @Date: 2019/11/28
    */

    Integer addAppointment(Appointment appointment);
}
