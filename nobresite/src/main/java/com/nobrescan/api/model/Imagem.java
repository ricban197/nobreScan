package com.nobrescan.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Imagem {
    @Id @GeneratedValue()
    private long id;
    @Column(name="idcap")
    private long idcap;
    @Column(name="src")
    private String src;
    @Column (name="numpag")
    private int numpag;

    public Imagem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdcap() {
        return idcap;
    }

    public void setIdcap(long idcap) {
        this.idcap = idcap;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getNumpag() {
        return numpag;
    }

    public void setNumpag(int numpag) {
        this.numpag = numpag;
    }
}
