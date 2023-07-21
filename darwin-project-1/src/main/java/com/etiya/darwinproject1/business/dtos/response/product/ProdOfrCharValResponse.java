package com.etiya.darwinproject1.business.dtos.response.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdOfrCharValResponse {

    private Long charValId;
    private String name;
    @JsonProperty("shortCode")
    private String shrtCode;
    @JsonProperty("value")
    private String val;
    @JsonProperty("isSelected")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String defaultSelected;

    @Autowired
    public ProdOfrCharValResponse(Long charValId, String name, String shrtCode, String val, String defaultSelected) {
        this.charValId = charValId;
        this.name = name;
        this.shrtCode = shrtCode;
        this.val = val;
        this.defaultSelected = defaultSelected;
    }

    @Autowired
    public ProdOfrCharValResponse(Long charValId, String name, String shrtCode, String val) {
        this.charValId = charValId;
        this.name = name;
        this.shrtCode = shrtCode;
        this.val = val;
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

    public String getShrtCode() {
        return shrtCode;
    }

    public void setShrtCode(String shrtCode) {
        this.shrtCode = shrtCode;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDefaultSelected() {
        return defaultSelected;
    }

    public void setDefaultSelected(String defaultSelected) {
        this.defaultSelected = defaultSelected;
    }
}
