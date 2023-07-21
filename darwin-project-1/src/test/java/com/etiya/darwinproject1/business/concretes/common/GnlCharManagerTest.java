package com.etiya.darwinproject1.business.concretes.common;

import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharValRequest;
import com.etiya.darwinproject1.core.exceptions.types.BusinessException;
import com.etiya.darwinproject1.core.exceptions.types.NotFoundException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlCharDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GnlCharManagerTest {

    @InjectMocks
    private GnlCharManager gnlCharManager;
    @Mock
    private GnlCharDao gnlCharDao;
    @Mock
    private MessageService messageService;

    @Test
    void getGnlCharFromRequest() {
        GnlChar expectedGnlChar = new GnlChar();
        expectedGnlChar.setId(1l);
        when(gnlCharDao.findById(1l)).thenReturn(Optional.of(new GnlChar()));
        ProdOfrCharRequest prodOfrCharRequest = new ProdOfrCharRequest(1l,"deneme","deneme",1l, new ArrayList<>(), new ArrayList<>());
        GnlChar gnlChar = gnlCharManager.getGnlCharFromRequest(prodOfrCharRequest);
        gnlChar.setId(prodOfrCharRequest.getCharId());
        assertEquals(gnlChar.getId(), expectedGnlChar.getId());
    }

    @Test
    void getGnlCharFromRequestThrowException() {
        when(gnlCharDao.findById(1l)).thenReturn(Optional.empty());
        ProdOfrCharRequest prodOfrCharRequest = new ProdOfrCharRequest(1l,"deneme","deneme",1l, new ArrayList<>(), new ArrayList<>());
        assertThrows(NotFoundException.class, () -> {
            gnlCharManager.getGnlCharFromRequest(prodOfrCharRequest);
        });

    }
}