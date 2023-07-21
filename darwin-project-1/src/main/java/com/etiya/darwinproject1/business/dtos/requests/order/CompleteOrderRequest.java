package com.etiya.darwinproject1.business.dtos.requests.order;

import com.etiya.darwinproject1.business.dtos.requests.product.ListOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.user.UserInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompleteOrderRequest {

    private UserInfoRequest userInfoRequest;
    private List<ListOfferRequest> listOfferRequests;
    private List<CustOrdCharValRequest> custOrdCharValRequests;

    @Autowired
    public CompleteOrderRequest(UserInfoRequest userInfoRequest, List<ListOfferRequest> listOfferRequests,List<CustOrdCharValRequest> custOrdCharValRequests) {
        this.userInfoRequest = userInfoRequest;
        this.listOfferRequests = listOfferRequests;
        this.custOrdCharValRequests = custOrdCharValRequests;
    }

    public UserInfoRequest getUserInfoRequest() {
        return userInfoRequest;
    }

    public void setUserInfoRequest(UserInfoRequest userInfoRequest) {
        this.userInfoRequest = userInfoRequest;
    }

    public List<ListOfferRequest> getListOfferRequests() {
        return listOfferRequests;
    }

    public void setListOfferRequests(List<ListOfferRequest> listOfferRequests) {
        this.listOfferRequests = listOfferRequests;
    }

    public List<CustOrdCharValRequest> getCustOrdCharValRequests() {
        return custOrdCharValRequests;
    }

    public void setCustOrdCharValRequests(List<CustOrdCharValRequest> custOrdCharValRequests) {
        this.custOrdCharValRequests = custOrdCharValRequests;
    }
}
