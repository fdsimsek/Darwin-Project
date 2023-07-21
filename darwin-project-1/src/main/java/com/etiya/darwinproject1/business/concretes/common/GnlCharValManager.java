package com.etiya.darwinproject1.business.concretes.common;

import com.etiya.darwinproject1.business.abstracts.common.GnlCharService;
import com.etiya.darwinproject1.business.abstracts.common.GnlCharValService;
import com.etiya.darwinproject1.business.abstracts.common.GnlStService;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharValRequest;
import com.etiya.darwinproject1.entities.concretes.common.GnlCharVal;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlCharValDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GnlCharValManager implements GnlCharValService {

    private final GnlCharValDao gnlCharValDao;
    private final GnlStService gnlStService;
    private final GnlCharService gnlCharService;

    @Autowired
    public GnlCharValManager(GnlCharValDao gnlCharValDao, GnlStService gnlStService, GnlCharService gnlCharService) {
        this.gnlCharValDao = gnlCharValDao;
        this.gnlStService = gnlStService;
        this.gnlCharService = gnlCharService;
    }

    @Override
    public List<GnlCharVal> charValList(Long userId) {
        List<GnlCharVal> charValList = gnlCharValDao.findByCharValueListForUser(userId);
        return charValList;
    }

    @Override
    public List<GnlCharVal> charValue(Long userId) {
        List<GnlCharVal> gnlCharValList = gnlCharValDao.findFirstByDefaultSelected(userId);
        return gnlCharValList;
    }

    @Override
    public List<GnlCharVal> charValListForAdmin() {
        List<GnlCharVal> charValList = gnlCharValDao.findByCharValueListForAdmin();
        return charValList;
    }

    @Override
    public void insertProdOfrCharVal(ProdOfrCharValRequest prodOfrCharValRequest, ProdOfrCharRequest prodOfrCharRequest) {
        GnlCharVal gnlCharVal = gnlCharValDao.findById(prodOfrCharValRequest.getCharValId()).orElse((new GnlCharVal()));
        gnlCharVal.setGnlChar(gnlCharService.getGnlCharFromRequest(prodOfrCharRequest));
        gnlCharVal.setName(prodOfrCharValRequest.getName());
        gnlCharVal.setShrtCode(prodOfrCharValRequest.getShortCode());
        gnlCharVal.setVal(prodOfrCharValRequest.getValue());
        gnlCharVal.setDescr(prodOfrCharValRequest.getValue());
        gnlCharVal.setDefaultSelected(prodOfrCharValRequest.getIsSelected());
        gnlCharVal.setGnlSt(gnlStService.statusActive());
        gnlCharValDao.save(gnlCharVal);
    }
}
