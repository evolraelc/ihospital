package com.ihospital.pojo;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {
    private Long scheduleId;

    private Long physicianId;

    private Date date;

    private Date startTime;

    private Date endTime;

    private String dayScheduleType;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDayScheduleType() {
        return dayScheduleType;
    }

    public void setDayScheduleType(String dayScheduleType) {
        this.dayScheduleType = dayScheduleType == null ? null : dayScheduleType.trim();
    }
}