package com.etiya.darwinproject1.business.concretes.common;

import com.etiya.darwinproject1.business.abstracts.common.GnlTpService;
import com.etiya.darwinproject1.business.constants.Messages;
import com.etiya.darwinproject1.core.exceptions.types.BusinessException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlTpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GnlTpManager implements GnlTpService {

    private final GnlTpDao gnlTpDao;
    private final MessageService messageService;

    @Autowired
    public GnlTpManager(GnlTpDao gnlTpDao, MessageService messageService) {
        this.gnlTpDao = gnlTpDao;
        this.messageService = messageService;
    }

    @Override
    public GnlTp typeUser() {
        GnlTp gnlTp = new GnlTp();
        gnlTp.setId(1l);
        return gnlTp;
    }

    @Override
    public GnlTp typeAdmin() {
        GnlTp gnlTp = new GnlTp();
        gnlTp.setId(2l);
        return gnlTp;
    }

    @Override
    public void checkUserType(String name) {
        GnlTp nameToFind = gnlTpDao.findByName(name);
        if (nameToFind == null) {
            throw new BusinessException(messageService.getMessage(Messages.ErrorMessages.UserTypeNotFound));
        }
    }

}
