package com.etiya.darwinproject1.business.concretes.common;

import com.etiya.darwinproject1.business.abstracts.common.GnlCharService;
import com.etiya.darwinproject1.business.constants.Messages;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.core.exceptions.types.NotFoundException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlCharDao;
import org.springframework.stereotype.Service;

@Service
public class GnlCharManager implements GnlCharService {

    private final GnlCharDao gnlCharDao;
    private final MessageService messageService;

    public GnlCharManager(GnlCharDao gnlCharDao, MessageService messageService) {
        this.gnlCharDao = gnlCharDao;
        this.messageService = messageService;
    }

    @Override
    public GnlChar getGnlCharFromRequest(ProdOfrCharRequest prodOfrCharRequest) {
        GnlChar gnlChar = gnlCharDao.findById(prodOfrCharRequest.getCharId())
                .orElseThrow(() -> new NotFoundException(
                        messageService.getMessageWithParams(Messages.ErrorMessages.CharIdNotFound, prodOfrCharRequest.getCharId())
                ));
        gnlChar.setId(prodOfrCharRequest.getCharId());
        return gnlChar;
    }
}
