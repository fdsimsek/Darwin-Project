package com.etiya.darwinproject1.entities.concretes.user;

import com.etiya.darwinproject1.entities.abstracts.BaseEntity;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import com.etiya.darwinproject1.entities.concretes.order.CustOrd;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_spec")//user tablosu
public class UserSpec extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "scr_name")
    private String scrName;

    @Column(name = "uname")
    private String uname;

    @Column(name = "pwd")
    private String pwd;

    @ManyToOne()
    @JoinColumn(name = "st_id")
    private GnlSt gnlSt;

    @ManyToOne()
    @JoinColumn(name = "tp_id")
    private GnlTp gnlTp;

    @OneToMany(mappedBy = "userSpec", cascade = CascadeType.ALL)
    private List<CustOrd> custOrds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScrName() {
        return scrName;
    }

    public void setScrName(String scrName) {
        this.scrName = scrName;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public List<CustOrd> getCustOrds() {
        return custOrds;
    }

    public void setCustOrds(List<CustOrd> custOrds) {
        this.custOrds = custOrds;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public UserSpec() {
    }

    @Autowired
    public UserSpec(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser, Long id, String scrName, String uname, String pwd, GnlSt gnlSt, GnlTp gnlTp, List<CustOrd> custOrds) {
        super(cDate, cUser, uDate, uUser);
        this.id = id;
        this.scrName = scrName;
        this.uname = uname;
        this.pwd = pwd;
        this.gnlSt = gnlSt;
        this.gnlTp = gnlTp;
        this.custOrds = custOrds;
    }


}
