package com.nobrescan.api.model;
import javax.persistence.*;


@Entity
@Table(name="Usuario")
public class Usuarios{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;/*ID único por obra*/
    @Column(name="user")
    private String user;
    @Column(name="senha")
    private String senha;
    @Column(name="nickname")
    private String nickname;
    @Column(name="Autorizacao")
    private int Autorizacao;//0- apenas ler 1-add e excluir suas obras 2- add e excluir qualquer obra 3-mudar Autorização dos outros usuarios

    public Usuarios() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuarios(String user, String senha, String nickname) {
        this.id = id;
        this.user = user;
        this.senha = senha;
        this.nickname = nickname;
        Autorizacao = 0;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAutorizacao() {
        return Autorizacao;
    }

    public void setAutorizacao(int autorizacao) {
        Autorizacao = autorizacao;
    }
}
