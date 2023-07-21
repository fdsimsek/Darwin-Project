package com.etiya.darwinproject1.business.dtos.requests.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProdOfrCharRequest {

    private Long charId;
    private String name;
    @JsonProperty("shortCode")
    private String shrtCode;
    private Long isActive;
    private List<ProdOfrCharValRequest> selectedCharValue;
    private List<ProdOfrCharValRequest> charValueList;

    @Autowired
    public ProdOfrCharRequest(Long charId, String name, String shrtCode, Long isActive, List<ProdOfrCharValRequest> selectedCharValue, List<ProdOfrCharValRequest> charValueList) {
        this.charId = charId;
        this.name = name;
        this.shrtCode = shrtCode;
        this.isActive = isActive;
        this.selectedCharValue = selectedCharValue;
        this.charValueList = charValueList;
    }

    public Long getCharId() {
        return charId;
    }

    public void setCharId(Long charId) {
        this.charId = charId;
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

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public List<ProdOfrCharValRequest> getSelectedCharValue() {
        return selectedCharValue;
    }

    public void setSelectedCharValue(List<ProdOfrCharValRequest> selectedCharValue) {
        this.selectedCharValue = selectedCharValue;
    }

    public List<ProdOfrCharValRequest> getCharValueList() {
        return charValueList;
    }

    public void setCharValueList(List<ProdOfrCharValRequest> charValueList) {
        this.charValueList = charValueList;
    }
}
