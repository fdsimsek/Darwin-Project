package com.etiya.darwinproject1.business.concretes.product;

import com.etiya.darwinproject1.business.concretes.user.UserManager;
import com.etiya.darwinproject1.business.dtos.requests.order.CompleteOrderRequest;
import com.etiya.darwinproject1.business.dtos.requests.order.CustOrdCharValRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ContinueOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ListOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.business.dtos.requests.user.UserInfoRequest;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProdOfrManagerTest {

    @InjectMocks
    private ProdOfrManager prodOfrManager;
    @Mock
    private UserManager userManager;

    @Test
    void inquireOffers() {
        ResponseEntity<Object> responseEntity = prodOfrManager.inquireOffers(anyLong());
        assertNotNull(responseEntity);
    }

    @Test
    void continueSelectedOffer() {
        List<ProdOfrCharRequest> prodOfrCharRequests = new ArrayList<>();
        ContinueOfferRequest continueOfferRequest = new ContinueOfferRequest(5l, "Deneme", prodOfrCharRequests);
        GnlTp gnlTp = new GnlTp();
        gnlTp.setName("Deneme");
        GnlSt gnlSt = new GnlSt();
        gnlSt.setIsActv(1l);
        UserSpec userSpec = new UserSpec();
        userSpec.setId(2l);
        userSpec.setGnlTp(gnlTp);
        userSpec.setUname("deneme");
        userSpec.setGnlSt(gnlSt);
        when(userManager.getUserBySelectedOfferId(5l)).thenReturn(userSpec);
        ResponseEntity<Object> responseEntity = prodOfrManager.continueSelectedOffer(continueOfferRequest);
        assertNotNull(responseEntity);
    }

    @Test
    void completeOrder() {
        UserInfoRequest userInfoRequest = new UserInfoRequest(1l, "Admin", "etiya", 1l);
        List<ListOfferRequest> listOfferRequests = new ArrayList<>();
        List<CustOrdCharValRequest> custOrdCharValRequests = new ArrayList<>();
        CompleteOrderRequest completeOrderRequest = new CompleteOrderRequest(userInfoRequest, listOfferRequests, custOrdCharValRequests);
        ResponseEntity<Object> responseEntity = prodOfrManager.completeOrder(completeOrderRequest);
        assertNotNull(responseEntity);
    }
}