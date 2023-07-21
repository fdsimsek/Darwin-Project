package com.etiya.darwinproject1.business.concretes.order;

import com.etiya.darwinproject1.business.dtos.response.order.CustOrdCharValResponse;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;
import com.etiya.darwinproject1.entities.concretes.common.GnlCharVal;
import com.etiya.darwinproject1.entities.concretes.order.CustOrdCharVal;
import com.etiya.darwinproject1.repositories.abstracts.order.CustOrdCharValDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CustOrderCharValManagerTest {

    @Mock
    private CustOrdCharValDao custOrdCharValDao;
    @InjectMocks
    private CustOrderCharValManager custOrderCharValManager;

    @Test
    void getCustOrdCharValResponseForSelectedOfferId() {
        Long selectedOfferId = 1L;
        GnlChar gnlChar = new GnlChar();
        gnlChar.setId(1l);
        GnlCharVal gnlCharVal = new GnlCharVal();
        gnlCharVal.setGnlChar(gnlChar);
        List<CustOrdCharVal> mockCustOrdCharVals = new ArrayList<>();
        CustOrdCharVal mockCustOrdCharVal = new CustOrdCharVal();
        mockCustOrdCharVal.setGnlChar(gnlChar);
        mockCustOrdCharVal.setCharVal(gnlCharVal);

        mockCustOrdCharVals.add(mockCustOrdCharVal);

        when(custOrdCharValDao.getCustOrdCharValBySelectedId(selectedOfferId)).thenReturn(mockCustOrdCharVals);

        List<CustOrdCharValResponse> result = custOrderCharValManager.getCustOrdCharValResponseForSelectedOfferId(selectedOfferId);

        assertEquals(1, result.size());

        assertEquals(mockCustOrdCharVal.getGnlChar().getId(), 1l);

        verify(custOrdCharValDao, times(1)).getCustOrdCharValBySelectedId(selectedOfferId);
    }

}
