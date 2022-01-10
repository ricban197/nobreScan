package com.nobrescan.api.model.validacao;

import com.nobrescan.api.model.Capitulo;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class CapituloValida {
    private Long id;
    private Date upload;
    private String nome;
    private Long idmanga;
    private int total_paginas;
    public static CapituloValida Converter(Capitulo c){
        CapituloValida cv =new CapituloValida();
        cv.setId(c.getId());
        cv.setId_manga(c.getId_manga());
        cv.setUpload(c.getUpload());
        cv.setNome(c.getNome());
        return cv;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpload() {
        return upload;
    }

    public void setUpload(Date upload) {
        this.upload = upload;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_manga() {
        return idmanga;
    }

    public void setId_manga(Long id_manga) {
        this.idmanga = id_manga;
    }

    public int getTotal_paginas() {
        return total_paginas;
    }

    public void setTotal_paginas(int total_paginas) {
        this.total_paginas = total_paginas;
    }
}
