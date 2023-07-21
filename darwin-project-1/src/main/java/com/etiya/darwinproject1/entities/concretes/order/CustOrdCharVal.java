package com.etiya.darwinproject1.entities.concretes.order;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;
import com.etiya.darwinproject1.entities.concretes.common.GnlCharVal;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cust_ord_char_val")
public class CustOrdCharVal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "cust_ord_id")
    private CustOrd custOrd;

    @ManyToOne()
    @JoinColumn(name = "char_id")
    private GnlChar gnlChar;

    @ManyToOne()
    @JoinColumn(name = "char_val_id")
    private GnlCharVal charVal;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    @Column(name = "val")
    private String val;

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

    public GnlChar getGnlChar() {
        return gnlChar;
    }

    public void setGnlChar(GnlChar charId) {
        this.gnlChar = charId;
    }

    public GnlCharVal getCharVal() {
        return charVal;
    }

    public void setCharVal(GnlCharVal charValId) {
        this.charVal = charValId;
    }

    public GnlSt getGnlSt() {
        return gnlSt;
    }

    public void setGnlSt(GnlSt stId) {
        this.gnlSt = stId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public CustOrdCharVal() {
    }

    @Autowired
    public CustOrdCharVal(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, CustOrd custOrdId, GnlChar charId, GnlCharVal charValId, GnlSt stId, String val) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.custOrd = custOrdId;
        this.gnlChar = charId;
        this.charVal = charValId;
        this.gnlSt = stId;
        this.val = val;
    }
}
