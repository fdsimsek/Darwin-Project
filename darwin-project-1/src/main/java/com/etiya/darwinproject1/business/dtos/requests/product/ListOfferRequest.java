package com.etiya.darwinproject1.business.dtos.requests.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListOfferRequest {

    private Long prodOfrId;
    private String name;
    @JsonProperty("description")
    private String descr;
    @JsonProperty("status")
    private String gnlStName;
    @JsonProperty("prodOfferType")
    private String gnlTpName;
    private List<ProdOfrCharRequest> prodOfferChars;

    @Autowired
    public ListOfferRequest(Long prodOfrId, String name, String descr, String gnlStName, String gnlTpName, List<ProdOfrCharRequest> prodOfferChars) {
        this.prodOfrId = prodOfrId;
        this.name = name;
        this.descr = descr;
        this.gnlStName = gnlStName;
        this.gnlTpName = gnlTpName;
        this.prodOfferChars = prodOfferChars;
    }

    @Autowired
    public ListOfferRequest(List<ProdOfrCharRequest> prodOfferChars) {
        this.prodOfferChars = prodOfferChars;
    }

    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
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

    public List<ProdOfrCharRequest> getProdOfferChars() {
        return prodOfferChars;
    }

    public void setProdOfferChars(List<ProdOfrCharRequest> prodOfferChars) {
        this.prodOfferChars = prodOfferChars;
    }
}
