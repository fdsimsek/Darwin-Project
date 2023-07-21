package com.etiya.darwinproject1.repositories.abstracts.order;

import com.etiya.darwinproject1.entities.concretes.order.CustOrdCharVal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustOrdCharValDao extends JpaRepository<CustOrdCharVal, Long> {

    @Query("select cocv from CustOrdCharVal cocv join cocv.custOrd co join co.custOrdItems coi join coi.prodOfr po " +
            "where po.id=:selectedOfferId")
    List<CustOrdCharVal> getCustOrdCharValBySelectedId(Long selectedOfferId);
}
