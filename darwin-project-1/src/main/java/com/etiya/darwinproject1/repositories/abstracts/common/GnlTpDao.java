package com.etiya.darwinproject1.repositories.abstracts.common;

import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GnlTpDao extends JpaRepository<GnlTp, Long> {

    GnlTp findByName (String name);

}
