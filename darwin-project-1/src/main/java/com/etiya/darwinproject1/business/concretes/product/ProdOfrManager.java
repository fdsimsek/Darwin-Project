package com.etiya.darwinproject1.business.concretes.product;

import com.etiya.darwinproject1.business.abstracts.common.GnlCharValService;
import com.etiya.darwinproject1.business.abstracts.order.CustOrderCharValService;
import com.etiya.darwinproject1.business.abstracts.product.ProdOfrCharService;
import com.etiya.darwinproject1.business.abstracts.product.ProdOfrService;
import com.etiya.darwinproject1.business.concretes.user.UserManager;
import com.etiya.darwinproject1.business.constants.Messages;
import com.etiya.darwinproject1.business.dtos.requests.order.CompleteOrderRequest;
import com.etiya.darwinproject1.business.dtos.requests.order.CustOrdCharValRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ContinueOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ListOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharValRequest;
import com.etiya.darwinproject1.business.dtos.response.order.CompleteOrderResponse;
import com.etiya.darwinproject1.business.dtos.response.order.CustOrdCharValResponse;
import com.etiya.darwinproject1.business.dtos.response.order.CustOrderResponse;
import com.etiya.darwinproject1.business.dtos.response.product.ListOfferResponse;
import com.etiya.darwinproject1.business.dtos.response.product.ProdOfrCharResponse;
import com.etiya.darwinproject1.business.dtos.response.product.ProdOfrCharValResponse;
import com.etiya.darwinproject1.business.dtos.response.user.UserInfoResponse;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.core.utilities.responseHandler.ResponseHandler;
import com.etiya.darwinproject1.entities.concretes.common.GnlCharVal;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfr;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfrChar;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import com.etiya.darwinproject1.repositories.abstracts.product.ProdOfrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdOfrManager implements ProdOfrService {

    private final ProdOfrDao prodOfrDao;
    private final ProdOfrCharService prodOfrCharService;
    private final GnlCharValService gnlCharValService;
    private final UserManager userManager;
    private final MessageService messageService;
    private final CustOrderCharValService custOrderCharValService;

    @Autowired
    public ProdOfrManager(ProdOfrDao prodOfrDao, ProdOfrCharService prodOfrCharService, GnlCharValService gnlCharValService, UserManager userManager, MessageService messageService, CustOrderCharValService custOrderCharValService) {
        this.prodOfrDao = prodOfrDao;
        this.prodOfrCharService = prodOfrCharService;
        this.gnlCharValService = gnlCharValService;
        this.userManager = userManager;
        this.messageService = messageService;
        this.custOrderCharValService = custOrderCharValService;
    }

    @Override
    public ResponseEntity<Object> inquireOffers(Long userId) {
        return userOrAdminChecker(userId);
    }

    @Override
    public ResponseEntity<Object> continueSelectedOffer(ContinueOfferRequest continueOfferRequest) {
        ResponseEntity<Object> responseEntity = ResponseHandler.responseBuilder(messageService.getMessage(Messages.Order.OffersListed), HttpStatus.OK,
                getCustOrderResponse(
                        continueOfferRequest.getSelectedOfferId(),
                        continueOfferRequest.getProdOfferChars(),
                        getProdOfrCharValRequest(continueOfferRequest),
                        getProdOfrCharValRequest(continueOfferRequest)
                ));
        return responseEntity;
    }

    @Override
    public ResponseEntity<Object> completeOrder(CompleteOrderRequest completeOrderRequest) {
        ResponseEntity<Object> responseEntity = ResponseHandler.responseBuilder("Order completed", HttpStatus.OK, getCompleteOrderResponse(completeOrderRequest));
        return responseEntity;
    }

    private CompleteOrderResponse getCompleteOrderResponse(CompleteOrderRequest completeOrderRequest) {
        CompleteOrderResponse completeOrderResponse = new CompleteOrderResponse(
                getUserInfoResponseFromRequest(completeOrderRequest),
                getListOfferResponseForCompleteOrder(
                        completeOrderRequest,
                        getProdOfrCharRequestForCompleteOrder(completeOrderRequest),
                        getProdOfrCharValRequestForCompleteOrder(completeOrderRequest),
                        getProdOfrCharValRequestForCompleteOrder(completeOrderRequest)),
                getCustOrdCharValResponseFromRequest(completeOrderRequest)
        );
        return completeOrderResponse;
    }

    private UserInfoResponse getUserInfoResponseFromRequest(CompleteOrderRequest completeOrderRequest) {
        userManager.checkIfUserWithUserIdExists(completeOrderRequest.getUserInfoRequest().getUserId());
        UserInfoResponse userInfoResponse = new UserInfoResponse(
                completeOrderRequest.getUserInfoRequest().getUserId(),
                completeOrderRequest.getUserInfoRequest().getUserType(),
                completeOrderRequest.getUserInfoRequest().getUname(),
                completeOrderRequest.getUserInfoRequest().getIsActive()
        );
        return userInfoResponse;
    }

    private List<CustOrdCharValResponse> getCustOrdCharValResponseFromRequest(CompleteOrderRequest completeOrderRequest) {
        List<CustOrdCharValResponse> custOrdCharValResponses = new ArrayList<>();
        List<CustOrdCharValRequest> custOrdCharValRequests = completeOrderRequest.getCustOrdCharValRequests();
        for (CustOrdCharValRequest custOrdCharValRequest : custOrdCharValRequests) {
            CustOrdCharValResponse custOrdCharValResponse = new CustOrdCharValResponse(
                    custOrdCharValRequest.getCharId(),
                    custOrdCharValRequest.getCharValId(),
                    custOrdCharValRequest.getName(),
                    custOrdCharValRequest.getShortCode(),
                    custOrdCharValRequest.getValue()
            );
            custOrdCharValResponses.add(custOrdCharValResponse);
        }
        return custOrdCharValResponses;
    }

    private List<ProdOfrCharValResponse> getProdOfrCharValResponseListForCompleteOrder(List<ProdOfrCharValRequest> prodOfrCharValRequests, ProdOfrCharRequest prodOfrCharRequest) {
        List<ProdOfrCharValResponse> prodOfrCharValResponses = new ArrayList<>();
        for (ProdOfrCharValRequest prodOfrCharValRequest : prodOfrCharValRequests) {
            ProdOfrCharValResponse prodOfrCharValResponse = new ProdOfrCharValResponse(
                    prodOfrCharValRequest.getCharValId(),
                    prodOfrCharValRequest.getName(),
                    prodOfrCharValRequest.getShortCode(),
                    prodOfrCharValRequest.getValue(),
                    prodOfrCharValRequest.getIsSelected()
            );
            prodOfrCharValResponses.add(prodOfrCharValResponse);
            gnlCharValService.insertProdOfrCharVal(prodOfrCharValRequest, prodOfrCharRequest);
        }
        return prodOfrCharValResponses;
    }

    private List<ProdOfrCharValResponse> getProdOfrCharValResponses(List<ProdOfrCharValRequest> prodOfrCharValRequests) {
        List<ProdOfrCharValResponse> prodOfrCharValResponses = new ArrayList<>();
        for (ProdOfrCharValRequest prodOfrCharValRequest : prodOfrCharValRequests) {
            if (prodOfrCharValRequest.getIsSelected().equals("1")){
                ProdOfrCharValResponse prodOfrCharValResponse = new ProdOfrCharValResponse(
                        prodOfrCharValRequest.getCharValId(),
                        prodOfrCharValRequest.getName(),
                        prodOfrCharValRequest.getShortCode(),
                        prodOfrCharValRequest.getValue(),
                        prodOfrCharValRequest.getIsSelected()
                );
                prodOfrCharValResponses.add(prodOfrCharValResponse);
            }
        }
        return prodOfrCharValResponses;
    }

    private List<ProdOfrCharResponse> getProdOfrCharResponseForCompleteOrder(List<ProdOfrCharRequest> prodOfrCharRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests1, ListOfferRequest listOfferRequest) {
        List<ProdOfrCharResponse> prodOfrCharResponses = new ArrayList<>();
        for (ProdOfrCharRequest prodOfrCharRequest : prodOfrCharRequests) {
            ProdOfrCharResponse prodOfrCharResponse = new ProdOfrCharResponse(
                    prodOfrCharRequest.getCharId(),
                    prodOfrCharRequest.getName(),
                    prodOfrCharRequest.getShrtCode(),
                    prodOfrCharRequest.getIsActive(),
                    getProdOfrCharValResponses(prodOfrCharValRequests1),
                    getProdOfrCharValResponseListForCompleteOrder(prodOfrCharValRequests, prodOfrCharRequest)
            );
            prodOfrCharResponses.add(prodOfrCharResponse);
            prodOfrCharService.insertProdOfrChar(prodOfrCharRequest, listOfferRequest);
        }
        return prodOfrCharResponses;
    }

    private List<ListOfferResponse> getListOfferResponseForCompleteOrder(CompleteOrderRequest completeOrderRequest, List<ProdOfrCharRequest> prodOfrCharRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests1) {
        List<ListOfferResponse> listOfferResponses = new ArrayList<>();
        List<ListOfferRequest> listOfferRequests = completeOrderRequest.getListOfferRequests();
        for (ListOfferRequest listOfferRequest : listOfferRequests) {
            ListOfferResponse listOfferResponse = new ListOfferResponse(
                    listOfferRequest.getProdOfrId(),
                    listOfferRequest.getName(),
                    listOfferRequest.getDescr(),
                    listOfferRequest.getGnlStName(),
                    listOfferRequest.getGnlStName(),
                    getProdOfrCharResponseForCompleteOrder(prodOfrCharRequests, prodOfrCharValRequests, prodOfrCharValRequests1, listOfferRequest)
            );
            listOfferResponses.add(listOfferResponse);
        }
        return listOfferResponses;
    }

    private List<ProdOfrCharRequest> getProdOfrCharRequestForCompleteOrder(CompleteOrderRequest completeOrderRequest) {
        List<ProdOfrCharRequest> prodOfrCharRequestList = new ArrayList<>();
        List<ListOfferRequest> listOfferRequestList = completeOrderRequest.getListOfferRequests();
        for (ListOfferRequest listOfferRequest : listOfferRequestList) {
            List<ProdOfrCharRequest> innerProdOfrCharRequestList = listOfferRequest.getProdOfferChars();
            prodOfrCharRequestList.addAll(innerProdOfrCharRequestList);
        }
        return prodOfrCharRequestList;
    }

    private List<ProdOfrCharValRequest> getProdOfrCharValRequestForCompleteOrder(CompleteOrderRequest completeOrderRequest) {
        List<ProdOfrCharValRequest> prodOfferCharValRequestList = new ArrayList<>();
        List<ProdOfrCharRequest> prodOfferCharRequestList = getProdOfrCharRequestForCompleteOrder(completeOrderRequest);
        for (ProdOfrCharRequest prodOfferCharRequest : prodOfferCharRequestList) {
            List<ProdOfrCharValRequest> innerProdOfferCharValRequestList = prodOfferCharRequest.getCharValueList();
            prodOfferCharValRequestList.addAll(innerProdOfferCharValRequestList);
        }
        return prodOfferCharValRequestList;
    }

    private List<ProdOfrCharValRequest> getProdOfrCharValRequest(ContinueOfferRequest continueOfferRequest) {
        List<ProdOfrCharValRequest> prodOfferCharValRequestList = new ArrayList<>();
        List<ProdOfrCharRequest> prodOfferCharRequestList = continueOfferRequest.getProdOfferChars();
        for (ProdOfrCharRequest prodOfferCharRequest : prodOfferCharRequestList) {
            List<ProdOfrCharValRequest> innerProdOfferCharValRequestList = prodOfferCharRequest.getCharValueList();
            prodOfferCharValRequestList.addAll(innerProdOfferCharValRequestList);
        }
        return prodOfferCharValRequestList;
    }

    private CustOrderResponse getCustOrderResponse(Long selectedOfferId, List<ProdOfrCharRequest> prodOfrCharRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests1 ) {
        CustOrderResponse custOrderResponse = new CustOrderResponse(
                getUserInfoResponse(selectedOfferId),
                getListOfferResponseForSelectedOffer(selectedOfferId, prodOfrCharRequests, prodOfrCharValRequests, prodOfrCharValRequests1),
                custOrderCharValService.getCustOrdCharValResponseForSelectedOfferId(selectedOfferId)
        );
        return custOrderResponse;
    }

    private ResponseEntity<Object> userOrAdminChecker(Long userId) {
        userManager.checkIfUserWithUserIdExists(userId);
        if (userManager.isAdmin(userId)) {
            return ResponseHandler.responseBuilder(messageService.getMessage(Messages.Order.OffersListed), HttpStatus.OK, getListOfferResponseForAdmin());
        } else {
            return ResponseHandler.responseBuilder(messageService.getMessage(Messages.Order.OffersListed), HttpStatus.OK, getListOfferResponseForUser(userId));
        }
    }

    private List<ListOfferResponse> getListOfferResponseForSelectedOffer(Long selectedOfferId, List<ProdOfrCharRequest> prodOfrCharRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests1) {
        List<ListOfferResponse> listOfferResponses = new ArrayList<>();
        List<ProdOfr> prodOfrList = prodOfrDao.getProdOfrListForSelectedOfferId(selectedOfferId);
        for (ProdOfr prodOfr : prodOfrList) {
            ListOfferResponse listOfferResponse = new ListOfferResponse(
                    prodOfr.getId(),
                    prodOfr.getName(),
                    prodOfr.getDescr(),
                    prodOfr.getGnlSt().getName(),
                    prodOfr.getGnlTp().getName(),
                    getProdOfrCharResponseForSelectedOffer(prodOfrCharRequests, prodOfrCharValRequests, prodOfrCharValRequests1)
            );
            listOfferResponses.add(listOfferResponse);
        }
        return listOfferResponses;
    }

    private UserInfoResponse getUserInfoResponse(Long selectedOfferId) {
        UserSpec selectedUser = userManager.getUserBySelectedOfferId(selectedOfferId);
        UserInfoResponse userInfoResponse = new UserInfoResponse(
                selectedUser.getId(),
                selectedUser.getGnlTp().getName(),
                selectedUser.getUname(),
                selectedUser.getGnlSt().getIsActv());
        return userInfoResponse;
    }

    private List<ProdOfrCharResponse> getProdOfrCharResponseForSelectedOffer(List<ProdOfrCharRequest> prodOfrCharRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests, List<ProdOfrCharValRequest> prodOfrCharValRequests1 ) {
        List<ProdOfrCharResponse> prodOfrCharResponses = new ArrayList<>();
        for (ProdOfrCharRequest prodOfrCharRequest : prodOfrCharRequests) {
            ProdOfrCharResponse prodOfrCharResponse = new ProdOfrCharResponse(
                    prodOfrCharRequest.getCharId(),
                    prodOfrCharRequest.getName(),
                    prodOfrCharRequest.getShrtCode(),
                    prodOfrCharRequest.getIsActive(),
                    getProdOfrCharValResponses(prodOfrCharValRequests),
                    getProdOfrCharValResponseListForSelectedOffer(prodOfrCharValRequests1)
            );
            prodOfrCharResponses.add(prodOfrCharResponse);
        }
        return prodOfrCharResponses;
    }

    private List<ProdOfrCharValResponse> getProdOfrCharValResponseListForSelectedOffer(List<ProdOfrCharValRequest> prodOfrCharValRequests) {
        List<ProdOfrCharValResponse> prodOfrCharValResponses = new ArrayList<>();
        for (ProdOfrCharValRequest prodOfrCharValRequest : prodOfrCharValRequests) {
                ProdOfrCharValResponse prodOfrCharValResponse = new ProdOfrCharValResponse(
                        prodOfrCharValRequest.getCharValId(),
                        prodOfrCharValRequest.getName(),
                        prodOfrCharValRequest.getShortCode(),
                        prodOfrCharValRequest.getValue(),
                        prodOfrCharValRequest.getIsSelected()
                );
                prodOfrCharValResponses.add(prodOfrCharValResponse);
        }
        return prodOfrCharValResponses;
    }

    private List<ListOfferResponse> getListOfferResponseForUser(Long userId) {
        List<ListOfferResponse> listOfferResponses = new ArrayList<>();
        List<ProdOfr> prodOfrList = prodOfrDao.getProdOfrList(userId);
        for (ProdOfr prodOfr : prodOfrList) {
            ListOfferResponse listOfferResponse = new ListOfferResponse(
                    prodOfr.getId(),
                    prodOfr.getName(),
                    prodOfr.getDescr(),
                    prodOfr.getGnlSt().getName(),
                    prodOfr.getGnlTp().getName(),
                    getProdOfrCharResponseForUser(userId)
            );
            listOfferResponses.add(listOfferResponse);
        }
        return listOfferResponses;
    }

    private List<ProdOfrCharResponse> getProdOfrCharResponseForUser(Long userId) {
        List<ProdOfrCharResponse> prodOfrCharResponses = new ArrayList<>();
        List<ProdOfrChar> prodOfrCharList = prodOfrCharService.prodCharList(userId);
        for (ProdOfrChar prodOfrChar : prodOfrCharList) {
            ProdOfrCharResponse prodOfrCharResponse = new ProdOfrCharResponse(
                    prodOfrChar.getId(),
                    prodOfrChar.getName(),
                    prodOfrChar.getShrtCode(),
                    prodOfrChar.getGnlSt().getIsActv(),
                    getProdOfrCharValResponseForUser(userId),
                    getProdOfrCharValResponseListForUser(userId)
            );
            prodOfrCharResponses.add(prodOfrCharResponse);
        }
        return prodOfrCharResponses;
    }

    private List<ProdOfrCharValResponse> getProdOfrCharValResponseForUser(Long userId) {
        List<ProdOfrCharValResponse> prodOfrCharValResponses = new ArrayList<>();
        List<GnlCharVal> gnlCharValList = gnlCharValService.charValue(userId);
        for (GnlCharVal gnlCharVal : gnlCharValList) {
            ProdOfrCharValResponse prodOfrCharValResponse = new ProdOfrCharValResponse(
                    gnlCharVal.getId(),
                    gnlCharVal.getName(),
                    gnlCharVal.getShrtCode(),
                    gnlCharVal.getVal(),
                    gnlCharVal.getDefaultSelected()
            );
            prodOfrCharValResponses.add(prodOfrCharValResponse);
        }
        return prodOfrCharValResponses;
    }

    private List<ProdOfrCharValResponse> getProdOfrCharValResponseListForUser(Long userId) {
        List<ProdOfrCharValResponse> prodOfrCharValResponses = new ArrayList<>();
        List<GnlCharVal> gnlCharValList = gnlCharValService.charValList(userId);
        for (GnlCharVal gnlCharVal : gnlCharValList) {
            ProdOfrCharValResponse prodOfrCharValResponse = new ProdOfrCharValResponse(
                    gnlCharVal.getId(),
                    gnlCharVal.getName(),
                    gnlCharVal.getShrtCode(),
                    gnlCharVal.getVal(),
                    gnlCharVal.getDefaultSelected()
            );
            prodOfrCharValResponses.add(prodOfrCharValResponse);
        }
        return prodOfrCharValResponses;
    }

    private List<ListOfferResponse> getListOfferResponseForAdmin() {
        List<ListOfferResponse> listOfferResponses = new ArrayList<>();
        List<ProdOfr> prodOfrList = prodOfrDao.getProdOfrListForAdmin();
        for (ProdOfr prodOfr : prodOfrList) {
            ListOfferResponse listOfferResponse = new ListOfferResponse(
                    prodOfr.getId(),
                    prodOfr.getName(),
                    prodOfr.getDescr(),
                    prodOfr.getGnlSt().getName(),
                    prodOfr.getGnlTp().getName(),
                    getProdOfrCharResponseForAdmin()
            );
            listOfferResponses.add(listOfferResponse);
        }
        return listOfferResponses;
    }

    private List<ProdOfrCharResponse> getProdOfrCharResponseForAdmin() {
        List<ProdOfrCharResponse> prodOfrCharResponses = new ArrayList<>();
        List<ProdOfrChar> prodOfrCharList = prodOfrCharService.prodCharListForAdmin();
        for (ProdOfrChar prodOfrChar : prodOfrCharList) {
            ProdOfrCharResponse prodOfrCharResponse = new ProdOfrCharResponse(
                    prodOfrChar.getId(),
                    prodOfrChar.getName(),
                    prodOfrChar.getShrtCode(),
                    prodOfrChar.getGnlSt().getIsActv(),
                    getProdOfrCharValResponseListForAdmin()
            );
            prodOfrCharResponses.add(prodOfrCharResponse);
        }
        return prodOfrCharResponses;
    }

    private List<ProdOfrCharValResponse> getProdOfrCharValResponseListForAdmin() {
        List<ProdOfrCharValResponse> prodOfrCharValResponses = new ArrayList<>();
        List<GnlCharVal> gnlCharValList = gnlCharValService.charValListForAdmin();
        for (GnlCharVal gnlCharVal : gnlCharValList) {
            ProdOfrCharValResponse prodOfrCharValResponse = new ProdOfrCharValResponse(
                    gnlCharVal.getId(),
                    gnlCharVal.getName(),
                    gnlCharVal.getShrtCode(),
                    gnlCharVal.getVal()
            );
            prodOfrCharValResponses.add(prodOfrCharValResponse);
        }
        return prodOfrCharValResponses;
    }

}
