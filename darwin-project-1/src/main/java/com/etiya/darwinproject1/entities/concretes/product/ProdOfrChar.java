package com.etiya.darwinproject1.entities.concretes.product;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.common.GnlChar;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prod_ofr_char")
public class ProdOfrChar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "prod_ofr_id")
    private ProdOfr prodOfr;

    @ManyToOne()
    @JoinColumn(name = "char_id")
    private GnlChar gnlChar;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    @Column(name = "shrt_code")
    private String shrtCode;

    @Column(name = "descr")
    private String descr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdOfr getProdOfr() {
        return prodOfr;
    }

    public void setProdOfr(ProdOfr prodOfrId) {
        this.prodOfr = prodOfrId;
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

    public GnlSt getGnlSt() {
        return gnlSt;
    }

    public void setGnlSt(GnlSt stId) {
        this.gnlSt = stId;
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

    public ProdOfrChar() {
    }

    @Autowired
    public ProdOfrChar(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, ProdOfr prodOfrId, GnlChar charId, String name, GnlSt stId, String shrtCode, String descr) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.prodOfr = prodOfrId;
        this.gnlChar = charId;
        this.name = name;
        this.gnlSt = stId;
        this.shrtCode = shrtCode;
        this.descr = descr;
    }
}
