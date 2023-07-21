package com.etiya.darwinproject1.entities.concretes.common;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.order.CustOrdCharVal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gnl_char_val")
public class GnlCharVal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "char_id")
    private GnlChar gnlChar;

    @Column(name = "name")
    private String name;

    @Column(name = "shrt_code")
    private String shrtCode;

    @Column(name = "descr")
    private String descr;

    @Column(name = "val")
    private String val;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    @Column(name = "default_selected")
    private String defaultSelected;

    @OneToMany(mappedBy = "charVal", cascade = CascadeType.ALL)
    private List<CustOrdCharVal> custOrdCharVals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GnlChar getGnlChar() {
        return gnlChar;
    }

    public void setGnlChar(GnlChar charId) {
        this.gnlChar = charId;
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

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public GnlSt getGnlSt() {
        return gnlSt;
    }

    public void setGnlSt(GnlSt stId) {
        this.gnlSt = stId;
    }

    public String getDefaultSelected() {
        return defaultSelected;
    }

    public void setDefaultSelected(String defaultSelected) {
        this.defaultSelected = defaultSelected;
    }

    public List<CustOrdCharVal> getCustOrdCharVals() {
        return custOrdCharVals;
    }

    public void setCustOrdCharVals(List<CustOrdCharVal> custOrdCharVals) {
        this.custOrdCharVals = custOrdCharVals;
    }

    public GnlCharVal() {
    }

    @Autowired
    public GnlCharVal(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, GnlChar charId, String name, String shrtCode, String descr, String val, GnlSt stId, String defaultSelected, List<CustOrdCharVal> custOrdCharVals) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.gnlChar = charId;
        this.name = name;
        this.shrtCode = shrtCode;
        this.descr = descr;
        this.val = val;
        this.gnlSt = stId;
        this.defaultSelected = defaultSelected;
        this.custOrdCharVals = custOrdCharVals;
    }
}
