package com.etiya.darwinproject1.business.concretes.order;

import com.etiya.darwinproject1.business.abstracts.order.CustOrderCharValService;
import com.etiya.darwinproject1.business.dtos.response.order.CustOrdCharValResponse;
import com.etiya.darwinproject1.entities.concretes.order.CustOrdCharVal;
import com.etiya.darwinproject1.repositories.abstracts.order.CustOrdCharValDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustOrderCharValManager implements CustOrderCharValService {

    private final CustOrdCharValDao custOrdCharValDao;

    @Autowired
    public CustOrderCharValManager(CustOrdCharValDao custOrdCharValDao) {
        this.custOrdCharValDao = custOrdCharValDao;
    }

    @Override
    public List<CustOrdCharValResponse> getCustOrdCharValResponseForSelectedOfferId(Long selectedOfferId) {
        List<CustOrdCharValResponse> custOrdCharValResponses = new ArrayList<>();
        List<CustOrdCharVal> custOrdCharVals = getCustOrdCharValForSelectedOfferId(selectedOfferId);
        for (CustOrdCharVal custOrdCharVal : custOrdCharVals) {
            CustOrdCharValResponse custOrdCharValResponse = new CustOrdCharValResponse(
                    custOrdCharVal.getGnlChar().getId(),
                    custOrdCharVal.getCharVal().getId(),
                    custOrdCharVal.getCharVal().getName(),
                    custOrdCharVal.getCharVal().getShrtCode(),
                    custOrdCharVal.getVal()
            );
            custOrdCharValResponses.add(custOrdCharValResponse);
        }
        return custOrdCharValResponses;
    }

    private List<CustOrdCharVal> getCustOrdCharValForSelectedOfferId(Long selectedOfferId) {
        return custOrdCharValDao.getCustOrdCharValBySelectedId(selectedOfferId);
    }
}
