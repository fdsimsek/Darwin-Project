package com.etiya.darwinproject1.business.concretes.common;

import com.etiya.darwinproject1.business.abstracts.common.GnlStService;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlStDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GnlStManager implements GnlStService {

    @Override
    public GnlSt statusActive() {
        GnlSt gnlSt = new GnlSt();
        gnlSt.setId(1l);
        return gnlSt;
    }
}
