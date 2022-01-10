package com.nobrescan.api.model.validacao;

import com.nobrescan.api.model.Imagem;

import javax.persistence.Column;

public class ImagemValida {
    private long id;
    private long idcap;
    private String src;
    private int numpag;

    private static ImagemValida converter(Imagem i){
        ImagemValida iv = new ImagemValida();
        iv.setId(i.getId());
        iv.setIdcap(i.getIdcap());
        iv.setNumpag(i.getNumpag());
        iv.setSrc(i.getSrc());
        return iv;
    }
    public ImagemValida() {
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
