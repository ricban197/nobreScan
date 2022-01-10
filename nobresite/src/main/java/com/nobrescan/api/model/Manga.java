package com.nobrescan.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Manga")
public class Manga {
    @Id @GeneratedValue()
    private Long id;/*ID único por obra*/
    private String nome;/*titulo da obra*/
    private String src_capa;/*link da capa da obra*/
    private String autor; /*autor da obra*/
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private int total_caps;/*numero total de caps armazenados*/
    @Temporal(TemporalType.DATE)
    private Date ultima_atu;/*Ultima atualização registrada na obra*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSrc_capa() {
        return src_capa;
    }

    public void setSrc_capa(String src_capa) {
        this.src_capa = src_capa;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotal_caps() {
        return total_caps;
    }

    public void setTotal_caps(int total_caps) {
        this.total_caps = total_caps;
    }

    public Date getUltima_atu() {
        return ultima_atu;
    }

    public void setUltima_atu(Date ultima_atu) {
        this.ultima_atu = ultima_atu;
    }
}
