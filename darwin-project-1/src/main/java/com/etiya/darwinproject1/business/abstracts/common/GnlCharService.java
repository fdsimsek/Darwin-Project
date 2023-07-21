package com.etiya.darwinproject1.business.abstracts.common;

import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;

public interface GnlCharService {
    GnlChar getGnlCharFromRequest(ProdOfrCharRequest prodOfrCharRequest);
}
