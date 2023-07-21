package com.etiya.darwinproject1.business.abstracts.product;

import com.etiya.darwinproject1.business.dtos.requests.product.ListOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfrChar;

import java.util.List;

public interface ProdOfrCharService {

    List<ProdOfrChar> prodCharList(Long userId);

    List<ProdOfrChar> prodCharListForAdmin();

    void insertProdOfrChar(ProdOfrCharRequest prodOfrCharRequest, ListOfferRequest listOfferRequest);
}
