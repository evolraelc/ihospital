package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author RUANBY
 * @date 2019/11/20 12:21
 * @description 自定义dto，作为查询就诊信息表、挂号单表、医生表、病人表、科室表的返回类型
 *               用于medicalRecord列表页的查询
 */
public class MedicalRecord implements Serializable {
    //就诊记录ID
    private Long pathoId;
    //挂号单ID
    private Long appointmentId;
    private String departName;
    //医生名字
    private String physicianName;
    //医生ID
    private Long physicianId;

      //就诊时间,如果不加JasonFormat注解，会显示为另一种时间格式
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
    private Long patientId;
    private String patientName;
    //诊断结果
    private String diagnosis;
    //医嘱
    private String narrative;
    //有效位
    private Boolean pathoValid;
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public Boolean getPathoValid() {
        return pathoValid;
    }

    public void setPathoValid(Boolean pathoValid) {
        this.pathoValid = pathoValid;
    }



    public MedicalRecord(Long pathoId, Long appointmentId, String departName, String physicianName, Long physicianId, Date time, Long patientId, String patientName, String diagnosis, String narrative, Boolean pathoValid) {
        this.pathoId = pathoId;
        this.appointmentId = appointmentId;
        this.departName = departName;
        this.physicianName = physicianName;
        this.physicianId = physicianId;
        this.time = time;
        this.patientId = patientId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.narrative = narrative;
        this.pathoValid = pathoValid;
    }

    public MedicalRecord() {
    }

    public Long getPathoId() {
        return pathoId;
    }

    public void setPathoId(Long pathoId) {
        this.pathoId = pathoId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


}
