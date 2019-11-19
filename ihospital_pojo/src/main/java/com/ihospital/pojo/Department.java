package com.ihospital.pojo;

import java.io.Serializable;

public class Department implements Serializable {
    private Long departId;

    private String departName;

    private String phoneNumber;

    private String position;

    private String pictureUrl;

    private Long directorId;

    private String directorAvatar;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getDirectorAvatar() {
        return directorAvatar;
    }

    public void setDirectorAvatar(String directorAvatar) {
        this.directorAvatar = directorAvatar == null ? null : directorAvatar.trim();
    }
}