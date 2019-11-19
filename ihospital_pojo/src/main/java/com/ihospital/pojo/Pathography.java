package com.ihospital.pojo;

import java.io.Serializable;
import java.util.Date;

public class Pathography implements Serializable {
    private Long pathoId;

    private Date createTime;

    private Long patientId;

    private Long physicianId;

    private String diagnosis;

    private String narrative;

    private Date lastEditTime;

    private Boolean pathoValid;

    public Long getPathoId() {
        return pathoId;
    }

    public void setPathoId(Long pathoId) {
        this.pathoId = pathoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Boolean getPathoValid() {
        return pathoValid;
    }

    public void setPathoValid(Boolean pathoValid) {
        this.pathoValid = pathoValid;
    }
}