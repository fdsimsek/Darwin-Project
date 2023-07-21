package com.etiya.darwinproject1.repositories.abstracts.product;

import com.etiya.darwinproject1.entities.concretes.product.ProdOfrChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdOfrCharDao extends JpaRepository<ProdOfrChar, Long> {

    @Query("select poc from ProdOfrChar poc join poc.prodOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u " +
            "where (u.id =:userSpecId and u.gnlTp.id = 1l) ")
    List<ProdOfrChar> findByProdOfrCharForUser(Long userSpecId);

    @Query("select poc from ProdOfrChar poc join poc.prodOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u ")
    List<ProdOfrChar> findByProdOfrCharForAdmin();

}
