package com.etiya.darwinproject1.business.dtos.response.user;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserResponse {


    private Long userId;

    public CreateUserResponse() {
    }

    @Autowired
    public CreateUserResponse(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
