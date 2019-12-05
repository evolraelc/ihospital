package com.ihospital.pojo;

import java.io.Serializable;
import java.util.Date;

public class Consultation implements Serializable {
    private Long consultId;

    private Long physicianId;

    private String body;

    private Date time;

    private Integer replyCount;

    private Long lastReplyId;

    private Long patientId;

    public Long getConsultId() {
        return consultId;
    }

    public void setConsultId(Long consultId) {
        this.consultId = consultId;
    }

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Long getLastReplyId() {
        return lastReplyId;
    }

    public void setLastReplyId(Long lastReplyId) {
        this.lastReplyId = lastReplyId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}