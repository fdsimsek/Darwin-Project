package com.etiya.darwinproject1.business.dtos.requests.product;

import org.springframework.beans.factory.annotation.Autowired;

public class ProdOfrCharValRequest {

    private Long charValId;
    private String name;
    private String shortCode;
    private String value;
    private String isSelected;

    @Autowired
    public ProdOfrCharValRequest(Long charValId, String name, String shortCode, String value, String isSelected) {
        this.charValId = charValId;
        this.name = name;
        this.shortCode = shortCode;
        this.value = value;
        this.isSelected = isSelected;
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

    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }
}
