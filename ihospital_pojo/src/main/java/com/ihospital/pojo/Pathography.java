package com.ihospital.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Pathography implements Serializable {
    private Long pathoId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    private Long patientId;

    private Long physicianId;

    private String diagnosis;

    private String narrative;

    private Boolean pathoValid;

    private Long appointId;

    public Long getPathoId() {
        return pathoId;
    }

    public void setPathoId(Long pathoId) {
        this.pathoId = pathoId;
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

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative == null ? null : narrative.trim();
    }

    public Boolean getPathoValid() {
        return pathoValid;
    }

    public void setPathoValid(Boolean pathoValid) {
        this.pathoValid = pathoValid;
    }

    public Long getAppointId() {
        return appointId;
    }

    public void setAppointId(Long appointId) {
        this.appointId = appointId;
    }
}