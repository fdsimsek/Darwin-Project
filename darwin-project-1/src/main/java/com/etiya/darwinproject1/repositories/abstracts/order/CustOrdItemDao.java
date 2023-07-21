package com.etiya.darwinproject1.repositories.abstracts.order;

import com.etiya.darwinproject1.entities.concretes.order.CustOrdItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustOrdItemDao extends JpaRepository<CustOrdItem, Long> {
}
