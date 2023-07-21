package com.etiya.darwinproject1.business.dtos.requests.user;

import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoRequest {

    private Long userId;
    private String userType;
    private String uname;
    private Long isActive;

    @Autowired
    public UserInfoRequest(Long userId, String userType, String uname, Long isActive) {
        this.userId = userId;
        this.userType = userType;
        this.uname = uname;
        this.isActive = isActive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }
}
