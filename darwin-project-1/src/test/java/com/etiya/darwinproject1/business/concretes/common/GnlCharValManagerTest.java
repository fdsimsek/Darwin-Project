package com.etiya.darwinproject1.business.concretes.common;

import com.etiya.darwinproject1.business.abstracts.common.GnlCharService;
import com.etiya.darwinproject1.business.abstracts.common.GnlStService;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharRequest;
import com.etiya.darwinproject1.business.dtos.requests.product.ProdOfrCharValRequest;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;
import com.etiya.darwinproject1.entities.concretes.common.GnlCharVal;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlCharValDao;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GnlCharValManagerTest {

    @Mock
    private GnlCharValDao gnlCharValDao;

    @Mock
    private GnlStService gnlStService;

    @Mock
    private GnlCharService gnlCharService;

    @InjectMocks
    private GnlCharValManager gnlCharValManager;

    @Test
    public void testCharValList() {
        Long userId = 1L;
        List<GnlCharVal> expectedCharValList = new ArrayList<>();

        when(gnlCharValDao.findByCharValueListForUser(userId)).thenReturn(expectedCharValList);

        List<GnlCharVal> result = gnlCharValManager.charValList(userId);

        assertEquals(expectedCharValList, result);
    }

    @Test
    public void testCharValue() {
        Long userId = 1L;
        List<GnlCharVal> expectedGnlCharValList = new ArrayList<>();

        when(gnlCharValDao.findFirstByDefaultSelected(userId)).thenReturn(expectedGnlCharValList);

        List<GnlCharVal> result = gnlCharValManager.charValue(userId);

        assertEquals(expectedGnlCharValList, result);
    }

    @Test
    public void testCharValListForAdmin() {
        List<GnlCharVal> expectedCharValList = new ArrayList<>();
        expectedCharValList.add(new GnlCharVal());
        when(gnlCharValDao.findByCharValueListForAdmin()).thenReturn(expectedCharValList);

        List<GnlCharVal> result = gnlCharValManager.charValListForAdmin();

        assertEquals(expectedCharValList, result);
    }

    @Test
    public void testInsertProdOfrCharVal() {
        List<ProdOfrCharValRequest> prodOfrCharValRequests = new ArrayList<>();
        ProdOfrCharValRequest prodOfrCharValRequest = new ProdOfrCharValRequest(1l,"Deneme","Deneme","Deneme","Deneme");
        ProdOfrCharRequest prodOfrCharRequest = new ProdOfrCharRequest(1l,"Deneme","Deneme",1l, prodOfrCharValRequests, prodOfrCharValRequests);
        GnlCharVal gnlCharVal = new GnlCharVal();
        gnlCharVal.setId(prodOfrCharValRequest.getCharValId());
        GnlSt gnlSt = new GnlSt();
        GnlChar gnlChar = new GnlChar();

        when(gnlCharValDao.findById(prodOfrCharValRequest.getCharValId())).thenReturn(Optional.of(gnlCharVal));
        when(gnlCharService.getGnlCharFromRequest(prodOfrCharRequest)).thenReturn(gnlChar);
        when(gnlStService.statusActive()).thenReturn(gnlSt);

        gnlCharValManager.insertProdOfrCharVal(prodOfrCharValRequest, prodOfrCharRequest);

        verify(gnlCharValDao).save(gnlCharVal);
    }
}