package com.nobrescan.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Capitulo")
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="upload")
    @Temporal(TemporalType.DATE)
    private Date upload;
    @Column(name="nome")
    private String nome;
    @Column(name="numCap")
    private int numCap;

    public int getNumCap() {
        return numCap;
    }

    public void setNumCap(int numCap) {
        this.numCap = numCap;
    }

    public Long getIdmanga() {
        return idmanga;
    }

    public void setIdmanga(Long idmanga) {
        this.idmanga = idmanga;
    }

    @Column(name="id_manga")
    private Long idmanga;
    @Column(name="total_paginas")
    private int total_paginas;

    public Capitulo() {
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
