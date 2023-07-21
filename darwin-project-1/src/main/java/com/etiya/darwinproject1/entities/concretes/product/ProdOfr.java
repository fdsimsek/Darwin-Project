package com.etiya.darwinproject1.entities.concretes.product;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import com.etiya.darwinproject1.entities.concretes.order.CustOrdItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "prod_ofr")
public class ProdOfr extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String descr;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    @ManyToOne()
    @JoinColumn(name = "tp_id")
    private GnlTp gnlTp;

    @OneToMany(mappedBy = "prodOfr", cascade = CascadeType.ALL)
    private List<ProdOfrChar> prodOfrChars;

    @OneToMany(mappedBy = "prodOfr", cascade = CascadeType.ALL)
    private List<CustOrdItem> custOrdItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
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

    public List<ProdOfrChar> getProdOfrChars() {
        return prodOfrChars;
    }

    public void setProdOfrChars(List<ProdOfrChar> prodOfrChars) {
        this.prodOfrChars = prodOfrChars;
    }

    public List<CustOrdItem> getCustOrdItems() {
        return custOrdItems;
    }

    public void setCustOrdItems(List<CustOrdItem> custOrdItems) {
        this.custOrdItems = custOrdItems;
    }

    public ProdOfr() {
    }

    @Autowired
    public ProdOfr(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, String name, String descr, GnlSt stId, GnlTp tpId, List<ProdOfrChar> prodOfrChars, List<CustOrdItem> custOrdItems) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.gnlSt = stId;
        this.gnlTp = tpId;
        this.prodOfrChars = prodOfrChars;
        this.custOrdItems = custOrdItems;
    }
}
