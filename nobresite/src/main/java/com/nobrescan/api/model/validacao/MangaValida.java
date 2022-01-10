package com.nobrescan.api.model.validacao;

import com.nobrescan.api.model.Manga;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class MangaValida {
    private Long id;/*ID único por obra*/
    private String nome;/*titulo da obra*/
    private String src_capa;/*link da capa da obra*/
    private String autor; /*autor da obra*/
    private int total_caps;/*numero total de caps armazenados*/

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;/*descricao*/
    public static MangaValida converter(Manga p){
        MangaValida a =new MangaValida();
        a.setAutor(p.getAutor());
        a.setId(p.getId());
        a.setNome(p.getNome());
        a.setSrc_capa(p.getSrc_capa());
        a.setTotal_caps(p.getTotal_caps());
        a.setDescricao(p.getDescricao());

        return  a;
    }

    public MangaValida() {
        super();
    }

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



}
