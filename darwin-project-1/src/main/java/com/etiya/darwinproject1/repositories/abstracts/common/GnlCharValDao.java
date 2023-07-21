package com.etiya.darwinproject1.repositories.abstracts.common;

import com.etiya.darwinproject1.entities.concretes.common.GnlCharVal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GnlCharValDao extends JpaRepository<GnlCharVal, Long> {

    @Query("select gcv from GnlCharVal gcv join gcv.gnlChar gc join gc.prodOfrChars poc join poc.prodOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u ")
    List<GnlCharVal> findByCharValueListForAdmin();

    @Query("select gcv from GnlCharVal gcv join gcv.gnlChar gc join gc.prodOfrChars poc join poc.prodOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u " +
            "where (u.id =:userSpecId and u.gnlTp.id = 1l)")
    List<GnlCharVal> findByCharValueListForUser(Long userSpecId);

    @Query("select gcv from GnlCharVal gcv join gcv.gnlChar gc join gc.prodOfrChars poc join poc.prodOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u " +
            "WHERE gcv.defaultSelected = '1' and (u.id =:userSpecId and u.gnlTp.id = 1)")
    List<GnlCharVal> findFirstByDefaultSelected(Long userSpecId);

}
