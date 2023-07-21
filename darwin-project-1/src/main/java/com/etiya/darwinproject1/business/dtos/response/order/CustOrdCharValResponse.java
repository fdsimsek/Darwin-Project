package com.etiya.darwinproject1.business.dtos.response.order;

import org.springframework.beans.factory.annotation.Autowired;

public class CustOrdCharValResponse {

    private Long charId;
    private Long charValId;
    private String name;
    private String shortCode;
    private String value;

    @Autowired
    public CustOrdCharValResponse(Long charId, Long charValId, String name, String shortCode, String value) {
        this.charId = charId;
        this.charValId = charValId;
        this.name = name;
        this.shortCode = shortCode;
        this.value = value;
    }

    public Long getCharId() {
        return charId;
    }

    public void setCharId(Long charId) {
        this.charId = charId;
    }

    public Long getCharValId() {
        return charValId;
    }

    public void setCharValId(Long charValId) {
        this.charValId = charValId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
