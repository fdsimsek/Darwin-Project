package com.etiya.darwinproject1.repositories.abstracts.product;

import com.etiya.darwinproject1.entities.concretes.product.ProdOfr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdOfrDao extends JpaRepository<ProdOfr, Long> {

    @Query("select po from ProdOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u " +
            "where (u.id =:userSpecId and u.gnlTp.id = 1l) ")
    List<ProdOfr> getProdOfrList(Long userSpecId);

    @Query("select po from ProdOfr po left join po.custOrdItems coi left join coi.custOrd co left join co.userSpec u ")
    List<ProdOfr> getProdOfrListForAdmin();

    @Query("select po from ProdOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u " +
            "where co.id=:selectedOfferId ")
    List<ProdOfr> getProdOfrListForSelectedOfferId(Long selectedOfferId);

}
