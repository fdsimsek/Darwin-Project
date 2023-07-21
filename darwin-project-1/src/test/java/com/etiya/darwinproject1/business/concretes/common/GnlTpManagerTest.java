package com.etiya.darwinproject1.business.concretes.common;

import com.etiya.darwinproject1.business.constants.Messages;
import com.etiya.darwinproject1.core.exceptions.types.BusinessException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlTpDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GnlTpManagerTest {

    @Mock
    private GnlTpDao gnlTpDao;
    @Mock
    private MessageService messageService;
    @InjectMocks
    private GnlTpManager gnlTpManager;

    @Test
    void testCheckUserTypeUserTypeNotFound() {
        String name = "some_name";
        when(gnlTpDao.findByName(name)).thenReturn(null);
        when(messageService.getMessage(Messages.ErrorMessages.UserTypeNotFound)).thenReturn("User type not found!");

        assertThrows(BusinessException.class, () -> {
            gnlTpManager.checkUserType(name);
        });
    }

    @Test
    public void testCheckUserType_UserTypeFound() {
        String name = "some_name";
        GnlTp gnlTp = new GnlTp();
        when(gnlTpDao.findByName(name)).thenReturn(gnlTp);

        gnlTpManager.checkUserType(name);

    }
}