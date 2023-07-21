package com.etiya.darwinproject1.business.dtos.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginResponse {

    private Long userId;
    @JsonProperty("userType")
    private String name;
    private String uname;
    private Long isActv;

    public UserLoginResponse() {
    }

    @Autowired
    public UserLoginResponse(Long userId, String name, String uname, Long isActv) {
        this.userId = userId;
        this.name = name;
        this.uname = uname;
        this.isActv = isActv;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getIsActv() {
        return isActv;
    }

    public void setIsActv(Long isActv) {
        this.isActv = isActv;
    }
}
