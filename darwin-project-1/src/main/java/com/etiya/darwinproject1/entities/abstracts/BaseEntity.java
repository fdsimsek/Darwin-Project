package com.etiya.darwinproject1.entities.abstracts;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "cdate")
    private LocalDateTime cDate;

    @Column(name = "cuser")
    private Long cUser;

    @Column(name = "udate")
    private LocalDateTime uDate;

    @Column(name = "uuser")
    private Long uUser;

    public BaseEntity() {
    }

    @Autowired
    public BaseEntity(LocalDateTime cDate, Long cUser, LocalDateTime uDate, Long uUser) {
        this.cDate = cDate;
        this.cUser = cUser;
        this.uDate = uDate;
        this.uUser = uUser;
    }

    public LocalDateTime getcDate() {
        return cDate;
    }

    public void setcDate(LocalDateTime cDate) {
        this.cDate = cDate;
    }

    public Long getcUser() {
        return cUser;
    }

    public void setcUser(Long cUser) {
        this.cUser = cUser;
    }

    public LocalDateTime getuDate() {
        return uDate;
    }

    public void setuDate(LocalDateTime uDate) {
        this.uDate = uDate;
    }

    public Long getuUser() {
        return uUser;
    }

    public void setuUser(Long uUser) {
        this.uUser = uUser;
    }



}
