package com.etiya.darwinproject1.repositories.abstracts.order;

import com.etiya.darwinproject1.entities.concretes.order.CustOrd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustOrdDao extends JpaRepository<CustOrd, Long> {

}
