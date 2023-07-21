package com.etiya.darwinproject1.business.abstracts.order;

import com.etiya.darwinproject1.business.dtos.response.order.CustOrdCharValResponse;

import java.util.List;

public interface CustOrderCharValService {

    List<CustOrdCharValResponse> getCustOrdCharValResponseForSelectedOfferId(Long selectedOfferId);
}
