package com.etiya.darwinproject1.business.concretes.product;

import com.etiya.darwinproject1.business.abstracts.common.GnlCharService;
import com.etiya.darwinproject1.business.abstracts.common.GnlStService;
import com.etiya.darwinproject1.business.abstracts.product.ProdOfrCharService;
import com.etiya.darwinproject1.business.constants.Messages;
import com.etiya.darwinproject1.business.dtos.requests.product.ListOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.core.exceptions.types.NotFoundException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfrChar;
import com.etiya.darwinproject1.repositories.abstracts.product.ProdOfrCharDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdOfrCharManager implements ProdOfrCharService {
    private final ProdOfrCharDao prodOfrCharDao;
    private final MessageService messageService;
    private final GnlCharService gnlCharService;
    private final GnlStService gnlStService;

    @Autowired
    public ProdOfrCharManager(ProdOfrCharDao prodOfrCharDao, MessageService messageService, GnlCharService gnlCharService, GnlStService gnlStService) {
        this.prodOfrCharDao = prodOfrCharDao;
        this.messageService = messageService;
        this.gnlCharService = gnlCharService;
        this.gnlStService = gnlStService;
    }

    @Override
    public List<ProdOfrChar> prodCharList(Long userId) {
        List<ProdOfrChar> prodOfrChars = prodOfrCharDao.findByProdOfrCharForUser(userId);
        return prodOfrChars;
    }

    @Override
    public List<ProdOfrChar> prodCharListForAdmin() {
        List<ProdOfrChar> prodOfrChars = prodOfrCharDao.findByProdOfrCharForAdmin();
        return prodOfrChars;
    }

    @Override
    public void insertProdOfrChar(ProdOfrCharRequest prodOfrCharRequest, ListOfferRequest listOfferRequest) {
        ProdOfrChar prodOfrChar = prodOfrCharDao.findById(listOfferRequest.getProdOfrId())
                .orElseThrow(() -> new NotFoundException(
                        messageService.getMessageWithParams(Messages.ErrorMessages.ProdOfferIdNotFound, listOfferRequest.getProdOfrId())
                ));
        prodOfrChar.setId(prodOfrChar.getId());
        prodOfrChar.setGnlChar(gnlCharService.getGnlCharFromRequest(prodOfrCharRequest));
        prodOfrChar.setName(prodOfrCharRequest.getName());
        prodOfrChar.setShrtCode(prodOfrCharRequest.getShrtCode());
        prodOfrChar.setDescr(prodOfrCharRequest.getName());
        prodOfrChar.setGnlSt(gnlStService.statusActive());
        prodOfrCharDao.save(prodOfrChar);
    }
}
