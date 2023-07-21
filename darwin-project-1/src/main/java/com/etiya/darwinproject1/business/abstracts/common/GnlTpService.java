package com.etiya.darwinproject1.business.abstracts.common;

import com.etiya.darwinproject1.entities.concretes.common.GnlTp;

public interface GnlTpService {

    GnlTp typeUser();

    GnlTp typeAdmin();

    void checkUserType(String name);

}
