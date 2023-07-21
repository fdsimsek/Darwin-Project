package com.etiya.darwinproject1.business.dtos.response.order;

import com.etiya.darwinproject1.business.dtos.response.product.ListOfferResponse;
import com.etiya.darwinproject1.business.dtos.response.user.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustOrderResponse {

    private UserInfoResponse userInfoResponse;
    private List<ListOfferResponse> listOfferResponses;
    private List<CustOrdCharValResponse> custOrdCharValResponses;

    @Autowired
    public CustOrderResponse(UserInfoResponse userInfoResponse, List<ListOfferResponse> listOfferResponses, List<CustOrdCharValResponse> custOrdCharValResponses) {
        this.userInfoResponse = userInfoResponse;
        this.listOfferResponses = listOfferResponses;
        this.custOrdCharValResponses = custOrdCharValResponses;
    }

    public UserInfoResponse getUserInfoResponse() {
        return userInfoResponse;
    }

    public void setUserInfoResponse(UserInfoResponse userInfoResponse) {
        this.userInfoResponse = userInfoResponse;
    }

    public List<ListOfferResponse> getListOfferResponses() {
        return listOfferResponses;
    }

    public void setListOfferResponses(List<ListOfferResponse> listOfferResponses) {
        this.listOfferResponses = listOfferResponses;
    }

    public List<CustOrdCharValResponse> getCustOrdCharValResponses() {
        return custOrdCharValResponses;
    }

    public void setCustOrdCharValResponses(List<CustOrdCharValResponse> custOrdCharValResponses) {
        this.custOrdCharValResponses = custOrdCharValResponses;
    }
}
