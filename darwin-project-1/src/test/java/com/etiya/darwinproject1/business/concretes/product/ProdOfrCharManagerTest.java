package com.etiya.darwinproject1.business.concretes.product;

import com.etiya.darwinproject1.business.abstracts.common.GnlCharService;
import com.etiya.darwinproject1.business.abstracts.common.GnlStService;
import com.etiya.darwinproject1.business.dtos.requests.product.ListOfferRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharValRequest;
import com.etiya.darwinproject1.core.exceptions.types.NotFoundException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfrChar;
import com.etiya.darwinproject1.repositories.abstracts.product.ProdOfrCharDao;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProdOfrCharManagerTest {

    @InjectMocks
    private ProdOfrCharManager prodOfrCharManager;
    @Mock
    private ProdOfrCharDao prodOfrCharDao;
    @Mock
    private GnlCharService gnlCharService;
    @Mock
    private GnlStService gnlStService;
    @Mock
    private MessageService messageService;

    @Test
    void prodCharList() {
        Long userId = 1l;
        List<ProdOfrChar> mockedProdOfrChars = new ArrayList<>();
        when(prodOfrCharDao.findByProdOfrCharForUser(userId)).thenReturn(mockedProdOfrChars);
        List<ProdOfrChar> result = prodOfrCharManager.prodCharList(userId);
        assertEquals(mockedProdOfrChars, result);
        verify(prodOfrCharDao, times(1)).findByProdOfrCharForUser(userId);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void prodCharListForAdmin() {
        List<ProdOfrChar> mockedProdOfrChars = new ArrayList<>();
        mockedProdOfrChars.add(new ProdOfrChar());
        when(prodOfrCharDao.findByProdOfrCharForAdmin()).thenReturn(mockedProdOfrChars);
        List<ProdOfrChar> result = prodOfrCharManager.prodCharListForAdmin();
        assertEquals(mockedProdOfrChars, result);
        verify(prodOfrCharDao, times(1)).findByProdOfrCharForAdmin();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void insertProdOfrChar() {
        List<ProdOfrCharRequest> prodOfrCharRequests = new ArrayList<>();
        List<ProdOfrCharValRequest> prodOfrCharValRequests = new ArrayList<>();
        ProdOfrCharRequest prodOfrCharRequest = new ProdOfrCharRequest(1l,"Deneme","Deneme",1l, prodOfrCharValRequests, prodOfrCharValRequests);
        ListOfferRequest listOfferRequest = new ListOfferRequest(1l,"Deneme","Deneme","Deneme","Deneme", prodOfrCharRequests);

        GnlChar gnlChar = new GnlChar();
        GnlSt gnlSt = new GnlSt();
        ProdOfrChar prodOfrChar = new ProdOfrChar();
        when(messageService.getMessageWithParams("message", listOfferRequest.getProdOfrId())).thenThrow(new NotFoundException("message"));
        when(prodOfrCharDao.findById(listOfferRequest.getProdOfrId())).thenReturn(Optional.of(prodOfrChar));
        when(gnlCharService.getGnlCharFromRequest(prodOfrCharRequest)).thenReturn(gnlChar);
        when(gnlStService.statusActive()).thenReturn(gnlSt);
        prodOfrCharManager.insertProdOfrChar(prodOfrCharRequest, listOfferRequest);

        verify(prodOfrCharDao, times(1)).findById(listOfferRequest.getProdOfrId());
        verify(prodOfrCharDao, times(1)).save(prodOfrChar);
    }
}