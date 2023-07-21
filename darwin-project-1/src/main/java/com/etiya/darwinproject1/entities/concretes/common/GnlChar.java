package com.etiya.darwinproject1.entities.concretes.common;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.order.CustOrdCharVal;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfrChar;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gnl_char")
public class GnlChar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shrt_code")
    private String shrtCode;

    @Column(name = "descr")
    private String descr;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    @OneToMany(mappedBy = "gnlChar", cascade = CascadeType.ALL)
    private List<GnlCharVal> gnlCharVals;

    @OneToMany(mappedBy = "gnlChar", cascade = CascadeType.ALL)
    private List<CustOrdCharVal> custOrdCharVals;

    @OneToMany(mappedBy = "gnlChar", cascade = CascadeType.ALL)
    private List<ProdOfrChar> prodOfrChars;

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

    public String getShrtCode() {
        return shrtCode;
    }

    public void setShrtCode(String shrtCode) {
        this.shrtCode = shrtCode;
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

    public List<GnlCharVal> getGnlCharVals() {
        return gnlCharVals;
    }

    public void setGnlCharVals(List<GnlCharVal> gnlCharVals) {
        this.gnlCharVals = gnlCharVals;
    }

    public List<CustOrdCharVal> getCustOrdCharVals() {
        return custOrdCharVals;
    }

    public void setCustOrdCharVals(List<CustOrdCharVal> custOrdCharVals) {
        this.custOrdCharVals = custOrdCharVals;
    }

    public List<ProdOfrChar> getProdOfrChars() {
        return prodOfrChars;
    }

    public void setProdOfrChars(List<ProdOfrChar> prodOfrChars) {
        this.prodOfrChars = prodOfrChars;
    }

    public GnlChar() {

    }

    @Autowired
    public GnlChar(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, String name, String shrtCode, String descr, GnlSt stId, List<GnlCharVal> gnlCharVals, List<CustOrdCharVal> custOrdCharVals, List<ProdOfrChar> prodOfrChars) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.name = name;
        this.shrtCode = shrtCode;
        this.descr = descr;
        this.gnlSt = stId;
        this.gnlCharVals = gnlCharVals;
        this.custOrdCharVals = custOrdCharVals;
        this.prodOfrChars = prodOfrChars;
    }
}
