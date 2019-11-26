package com.ihospital.pojo;

import java.io.Serializable;

public class Physician  implements Serializable {
    private Long physicianId;

    private String physicianName;

    private String worktitle;

    private Integer physicianAge;

    private Boolean physicianGender;

    private String physicianAvatar;

    private Long departId;

    private String departName;

    private String expertise;

    private String phoneNumber;

    private String briefIntroduction;

    private String pwd;

    private String email;

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName == null ? null : physicianName.trim();
    }

    public String getWorktitle() {
        return worktitle;
    }

    public void setWorktitle(String worktitle) {
        this.worktitle = worktitle == null ? null : worktitle.trim();
    }

    public Integer getPhysicianAge() {
        return physicianAge;
    }

    public void setPhysicianAge(Integer physicianAge) {
        this.physicianAge = physicianAge;
    }

    public Boolean getPhysicianGender() {
        return physicianGender;
    }

    public void setPhysicianGender(Boolean physicianGender) {
        this.physicianGender = physicianGender;
    }

    public String getPhysicianAvatar() {
        return physicianAvatar;
    }

    public void setPhysicianAvatar(String physicianAvatar) {
        this.physicianAvatar = physicianAvatar == null ? null : physicianAvatar.trim();
    }

    public Long getDepartId() {
        return departId;
    }

    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise == null ? null : expertise.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction == null ? null : briefIntroduction.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}