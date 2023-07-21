package com.etiya.darwinproject1.business.abstracts.common;

import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharValRequest;
import com.etiya.darwinproject1.entities.concretes.common.GnlCharVal;

import java.util.List;

public interface GnlCharValService {

    List<GnlCharVal> charValList(Long userId);

    List<GnlCharVal> charValue(Long userId);

    List<GnlCharVal> charValListForAdmin();

    void insertProdOfrCharVal(ProdOfrCharValRequest prodOfrCharValRequest, ProdOfrCharRequest prodOfrCharRequest);
}
