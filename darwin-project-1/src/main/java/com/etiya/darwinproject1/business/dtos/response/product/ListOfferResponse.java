package com.etiya.darwinproject1.business.dtos.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListOfferResponse {

    private Long prodOfrId;
    private String name;
    @JsonProperty("description")
    private String descr;
    @JsonProperty("status")
    private String gnlStName;
    @JsonProperty("prodOfferType")
    private String gnlTpName;
    private List<ProdOfrCharResponse> prodOfrChars;

    @Autowired
    public ListOfferResponse(Long prodOfferId, String name, String descr, String gnlStName,String gnlTpName, List<ProdOfrCharResponse> prodOfrChars) {
        this.prodOfrId = prodOfferId;
        this.name = name;
        this.descr = descr;
        this.gnlStName = gnlStName;
        this.gnlTpName = gnlTpName;
        this.prodOfrChars = prodOfrChars;
    }

    public Long getProdOfferId() {
        return prodOfrId;
    }

    public void setProdOfferId(Long prodOfferId) {
        this.prodOfrId = prodOfferId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getGnlStName() {
        return gnlStName;
    }

    public void setGnlStName(String gnlStName) {
        this.gnlStName = gnlStName;
    }

    public String getGnlTpName() {
        return gnlTpName;
    }

    public void setGnlTpName(String gnlTpName) {
        this.gnlTpName = gnlTpName;
    }

    public List<ProdOfrCharResponse> getProdOfrChars() {
        return prodOfrChars;
    }

    public void setProdOfrChars(List<ProdOfrCharResponse> prodOfrChars) {
        this.prodOfrChars = prodOfrChars;
    }
}
