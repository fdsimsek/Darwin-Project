package com.etiya.darwinproject1.entities.concretes.common;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.order.CustOrd;
import com.etiya.darwinproject1.entities.concretes.order.CustOrdCharVal;
import com.etiya.darwinproject1.entities.concretes.order.CustOrdItem;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfr;
import com.etiya.darwinproject1.entities.concretes.product.ProdOfrChar;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gnl_st")
public class GnlSt extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String descr;

    @Column(name = "shrt_code")
    private String shrtCode;

    @Column(name = "ent_code_name")
    private String entCodeName;

    @Column(name = "is_actv")
    private Long isActv;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<CustOrdItem> custOrdItems;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<ProdOfr> prodOfrs;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<ProdOfrChar> prodOfrChars;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<UserSpec> userSpecs;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<CustOrd> custOrds;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<CustOrdCharVal> custOrdCharVals;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<GnlChar> gnlChars;

    @OneToMany(mappedBy = "gnlSt", cascade = CascadeType.ALL)
    private List<GnlCharVal> gnlCharVals;

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

    public String getShrtCode() {
        return shrtCode;
    }

    public void setShrtCode(String shrtCode) {
        this.shrtCode = shrtCode;
    }

    public String getEntCodeName() {
        return entCodeName;
    }

    public void setEntCodeName(String entCodeName) {
        this.entCodeName = entCodeName;
    }

    public Long getIsActv() {
        return isActv;
    }

    public void setIsActv(Long isActv) {
        this.isActv = isActv;
    }

    public List<CustOrdItem> getCustOrdItems() {
        return custOrdItems;
    }

    public void setCustOrdItems(List<CustOrdItem> custOrdItems) {
        this.custOrdItems = custOrdItems;
    }

    public List<ProdOfr> getProdOfrs() {
        return prodOfrs;
    }

    public void setProdOfrs(List<ProdOfr> prodOfrs) {
        this.prodOfrs = prodOfrs;
    }

    public List<ProdOfrChar> getProdOfrChars() {
        return prodOfrChars;
    }

    public void setProdOfrChars(List<ProdOfrChar> prodOfrChars) {
        this.prodOfrChars = prodOfrChars;
    }

    public List<UserSpec> getCusts() {
        return userSpecs;
    }

    public void setCusts(List<UserSpec> userSpecs) {
        this.userSpecs = userSpecs;
    }

    public List<CustOrd> getCustOrds() {
        return custOrds;
    }

    public void setCustOrds(List<CustOrd> custOrds) {
        this.custOrds = custOrds;
    }

    public List<CustOrdCharVal> getCustOrdCharVals() {
        return custOrdCharVals;
    }

    public void setCustOrdCharVals(List<CustOrdCharVal> custOrdCharVals) {
        this.custOrdCharVals = custOrdCharVals;
    }

    public List<GnlChar> getGnlChars() {
        return gnlChars;
    }

    public void setGnlChars(List<GnlChar> gnlChars) {
        this.gnlChars = gnlChars;
    }

    public List<GnlCharVal> getGnlCharVals() {
        return gnlCharVals;
    }

    public void setGnlCharVals(List<GnlCharVal> gnlCharVals) {
        this.gnlCharVals = gnlCharVals;
    }

    public GnlSt() {
    }

    @Autowired
    public GnlSt(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, String name, String descr, String shrtCode, String entCodeName, Long isActv, List<CustOrdItem> custOrdItems, List<ProdOfr> prodOfrs, List<ProdOfrChar> prodOfrChars, List<UserSpec> userSpecs, List<CustOrd> custOrds, List<CustOrdCharVal> custOrdCharVals, List<GnlChar> gnlChars, List<GnlCharVal> gnlCharVals) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.shrtCode = shrtCode;
        this.entCodeName = entCodeName;
        this.isActv = isActv;
        this.custOrdItems = custOrdItems;
        this.prodOfrs = prodOfrs;
        this.prodOfrChars = prodOfrChars;
        this.userSpecs = userSpecs;
        this.custOrds = custOrds;
        this.custOrdCharVals = custOrdCharVals;
        this.gnlChars = gnlChars;
        this.gnlCharVals = gnlCharVals;
    }
}
