package com.etiya.darwinproject1.business.dtos.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class    ProdOfrCharResponse {

    private Long charId;
    private String name;
    @JsonProperty("shortCode")
    private String shrtCode;
    private Long isActive;
    private List<ProdOfrCharValResponse> selectedCharValueList;
    private List<ProdOfrCharValResponse> charValueList;

    @Autowired
    public ProdOfrCharResponse(Long charId, String name, String shrtCode, Long isActive, List<ProdOfrCharValResponse> selectedCharValueList, List<ProdOfrCharValResponse> charValueList) {
        this.charId = charId;
        this.name = name;
        this.shrtCode = shrtCode;
        this.isActive = isActive;
        this.selectedCharValueList = selectedCharValueList;
        this.charValueList = charValueList;
    }

    @Autowired
    public ProdOfrCharResponse(Long charId, String name, String shrtCode, Long isActive, List<ProdOfrCharValResponse> charValueList) {
        this.charId = charId;
        this.name = name;
        this.shrtCode = shrtCode;
        this.isActive = isActive;
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

    public List<ProdOfrCharValResponse> getSelectedCharValue() {
        return selectedCharValueList;
    }

    public void setSelectedCharValue(List<ProdOfrCharValResponse> selectedCharValueList) {
        this.selectedCharValueList = selectedCharValueList;
    }

    public List<ProdOfrCharValResponse> getCharValueList() {
        return charValueList;
    }

    public void setCharValueList(List<ProdOfrCharValResponse> charValueList) {
        this.charValueList = charValueList;
    }
}
