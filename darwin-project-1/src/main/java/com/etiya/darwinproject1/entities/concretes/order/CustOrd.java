package com.etiya.darwinproject1.entities.concretes.order;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cust_ord")
public class CustOrd extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserSpec userSpec;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    @ManyToOne()
    @JoinColumn(name = "tp_id")
    private GnlTp gnlTp;

    @OneToMany(mappedBy = "custOrd", cascade = CascadeType.ALL)
    private List<CustOrdCharVal> custOrdCharVals;

    @OneToMany(mappedBy = "custOrd", cascade = CascadeType.ALL)
    private List<CustOrdItem> custOrdItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserSpec getUser() {
        return userSpec;
    }

    public void setUser(UserSpec userSpecId) {
        this.userSpec = userSpecId;
    }

    public GnlSt getGnlSt() {
        return gnlSt;
    }

    public void setGnlSt(GnlSt stId) {
        this.gnlSt = stId;
    }

    public GnlTp getGnlTp() {
        return gnlTp;
    }

    public void setGnlTp(GnlTp tpId) {
        this.gnlTp = tpId;
    }

    public List<CustOrdCharVal> getCustOrdCharVals() {
        return custOrdCharVals;
    }

    public void setCustOrdCharVals(List<CustOrdCharVal> custOrdCharVals) {
        this.custOrdCharVals = custOrdCharVals;
    }

    public List<CustOrdItem> getCustOrdItems() {
        return custOrdItems;
    }

    public void setCustOrdItems(List<CustOrdItem> custOrdItems) {
        this.custOrdItems = custOrdItems;
    }

    public CustOrd() {
    }

    @Autowired
    public CustOrd(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, UserSpec userSpecId, GnlSt stId, GnlTp tpId, List<CustOrdCharVal> custOrdCharVals, List<CustOrdItem> custOrdItems) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.userSpec = userSpecId;
        this.gnlSt = stId;
        this.gnlTp = tpId;
        this.custOrdCharVals = custOrdCharVals;
        this.custOrdItems = custOrdItems;
    }
}
