package com.etiya.darwinproject1.business.abstracts.product;

import com.etiya.darwinproject1.business.dtos.requests.order.CompleteOrderRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ContinueOfferRequest;
import org.springframework.http.ResponseEntity;

public interface ProdOfrService {

    ResponseEntity<Object> inquireOffers(Long userId);

    ResponseEntity<Object> continueSelectedOffer(ContinueOfferRequest continueOfferRequest);

    ResponseEntity<Object> completeOrder(CompleteOrderRequest completeOrderRequest);
}
