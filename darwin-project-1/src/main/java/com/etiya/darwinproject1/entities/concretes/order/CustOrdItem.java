package com.etiya.darwinproject1.entities.concretes.order;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfr;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cust_ord_item")
public class CustOrdItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "cust_ord_id")
    private CustOrd custOrd;

    @ManyToOne()
    @JoinColumn(name = "prod_ofr_id")
    private ProdOfr prodOfr;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustOrd getCustOrd() {
        return custOrd;
    }

    public void setCustOrd(CustOrd custOrdId) {
        this.custOrd = custOrdId;
    }

    public ProdOfr getProdOfr() {
        return prodOfr;
    }

    public void setProdOfr(ProdOfr prodOfrId) {
        this.prodOfr = prodOfrId;
    }

    public GnlSt getGnlSt() {
        return gnlSt;
    }

    public void setGnlSt(GnlSt stId) {
        this.gnlSt = stId;
    }

    public CustOrdItem() {
    }

    @Autowired
    public CustOrdItem(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, CustOrd custOrdId, ProdOfr prodOfrId, GnlSt stId) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.custOrd = custOrdId;
        this.prodOfr = prodOfrId;
        this.gnlSt = stId;
    }
}
