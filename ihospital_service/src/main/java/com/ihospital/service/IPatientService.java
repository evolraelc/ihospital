package com.ihospital.service;

import com.ihospital.pojo.Patient;
import entity.MyException;
import entity.PageResult;

import java.util.List;

/**
 * @program: ihospital
 * @description:
 * @author: Mr.King
 * @create: 2019-11-15 15:24
 **/

public interface IPatientService {

    public List<Patient> findAll() throws Exception;

    /** 
    * @Description: 病人列表分页
    * @Param: [pageNum, pageSize] 当前页面，每页记录数
    * @return: entity.PageResult 
    * @Author: Mr.King 
    * @Date: 2019/11/16 
    */
    
    public PageResult findPage(int pageNum,int pageSize);

    /** 
    * @Description: 添加病人，注册可复用 
    * @Param: [] 
    * @return: void 
    * @Author: Mr.King 
    * @Date: 2019/11/17 
    */
    
    public void addPatient(Patient patient) throws MyException;


    /** 
    * @Description: 通过页面的id获取病人实体，修改可复用 
    * @Param: [id] 
    * @return: com.ihospital.pojo.Patient 
    * @Author: Mr.King 
    * @Date: 2019/11/17 
    */
    
    public Patient findOne(Long id);

    /**
    * @Description: 通过界面id获取实体，然后修改其状态
    * @Param: [patient]
    * @return: com.ihospital.pojo.Patient
    * @Author: Mr.King
    * @Date: 2019/11/17
    */

    public void updateStatus(Long id);
    
    
    /** 
    * @Description: 通过多选框实现多删除 
    * @Param: [ids] 
    * @return: void 
    * @Author: Mr.King 
    * @Date: 2019/11/18 
    */
    
    public void delete(Long[] ids);

    /** 
    * @Description: 多条件查询
    * @Param: [patient, pagenum, pageSize] 
    * @return: entity.PageResult 
    * @Author: Mr.King 
    * @Date: 2019/11/18 
    */
    
    public PageResult findPage(Patient patient,int pageNum,int pageSize);

    /**
     * 设置病人状态
     * @param id 病人id
     * @param status 状态
     */
    void setStatus(Long id, String status);

    /**
     * 根据电话获取病人信息
     * @param phone 电话号码
     * @return 病人实体
     */
    Patient getPatientByPhone(String phone);
}
