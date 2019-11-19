package com.ihospital.pojo;

import java.io.Serializable;

public class Patient implements Serializable {
    private Long patientId;

    private String patientName;

    private Integer patientAge;

    private Boolean patientGender;

    private String utype;

    private String userAvatar;

    private String idcard;

    private String phoneNumber;

    private String uid;

    private String pwd;

    private String patientGenderStr;

    public String getPatientGenderStr() {
        if (patientGender!=null){
            if (patientGender){
                patientGenderStr="Male";
            }
            else {
                patientGenderStr="Female";
            }
        }

        return patientGenderStr;
    }

    public void setPatientGenderStr(String patientGenderStr) {

        if (patientGenderStr.equals("Male")){
            patientGender=true;

        } else {
            patientGender=false;
        }

        this.patientGenderStr = patientGenderStr;
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
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Boolean getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Boolean patientGender) {
        this.patientGender = patientGender;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype == null ? null : utype.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}