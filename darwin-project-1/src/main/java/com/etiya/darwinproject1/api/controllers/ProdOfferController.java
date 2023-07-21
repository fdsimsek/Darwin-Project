package com.etiya.darwinproject1.api.controllers;

import com.etiya.darwinproject1.business.abstracts.product.ProdOfrService;
import com.etiya.darwinproject1.business.dtos.requests.order.CompleteOrderRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ContinueOfferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offers")
public class ProdOfferController {

    private final ProdOfrService prodOfrService;

    @Autowired
    public ProdOfferController(ProdOfrService prodOfrService) {
        this.prodOfrService = prodOfrService;
    }

    @GetMapping("inquireOffers")
    public ResponseEntity<Object> inquireOffers(@RequestParam Long userId) {
        return prodOfrService.inquireOffers(userId);
    }

    @PostMapping("continueSelectedOffer")
    public ResponseEntity<Object> continueSelectedOffer(@RequestBody ContinueOfferRequest continueOfferRequest) {
        return prodOfrService.continueSelectedOffer(continueOfferRequest);
    }

    @PostMapping("completeOrder")
    public ResponseEntity<Object> completeOrder(@RequestBody CompleteOrderRequest completeOrderRequest) {
        return prodOfrService.completeOrder(completeOrderRequest);
    }
}
