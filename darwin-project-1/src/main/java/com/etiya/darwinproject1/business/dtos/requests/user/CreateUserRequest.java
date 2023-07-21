package com.etiya.darwinproject1.business.dtos.requests.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserRequest {

    @JsonProperty("userType")
    private String name;
    @JsonProperty("userName")
    private String uname;
    @JsonProperty("password")
    private String pwd;

    @Autowired
    public CreateUserRequest(String name,String uname, String pwd) {
        this.name = name;
        this.uname = uname;
        this.pwd = pwd;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
