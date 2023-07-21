package com.etiya.darwinproject1.business.dtos.requests.product;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContinueOfferRequest {

    private Long selectedOfferId;
    private String prodOfferType;
    private List<ProdOfrCharRequest> prodOfferChars;

    @Autowired
    public ContinueOfferRequest(Long selectedOfferId, String prodOfferType, List<ProdOfrCharRequest> prodOfferChars) {
        this.selectedOfferId = selectedOfferId;
        this.prodOfferType = prodOfferType;
        this.prodOfferChars = prodOfferChars;
    }

    public Long getSelectedOfferId() {
        return selectedOfferId;
    }

    public void setSelectedOfferId(Long selectedOfferId) {
        this.selectedOfferId = selectedOfferId;
    }

    public String getProdOfferType() {
        return prodOfferType;
    }

    public void setProdOfferType(String prodOfferType) {
        this.prodOfferType = prodOfferType;
    }

    public List<ProdOfrCharRequest> getProdOfferChars() {
        return prodOfferChars;
    }

    public void setProdOfferChars(List<ProdOfrCharRequest> prodOfferChars) {
        this.prodOfferChars = prodOfferChars;
    }
}
