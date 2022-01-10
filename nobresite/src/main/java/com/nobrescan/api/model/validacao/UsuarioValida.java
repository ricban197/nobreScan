package com.nobrescan.api.model.validacao;

import com.nobrescan.api.model.Usuarios;

import javax.persistence.Column;

public class UsuarioValida
{

        String user;
        String senha;
        String nickname;
        Long id;
        int Autorizacao;
        public static UsuarioValida converter(Usuarios p){
                UsuarioValida a =new UsuarioValida();
                a.setNickname(p.getNickname());
                a.setId(p.getId());
                a.setAutorizacao(p.getAutorizacao());
                a.setSenha(p.getSenha());
                a.setUser(p.getUser());
                return a;
        }
        public int getAutorizacao() {
                return Autorizacao;
        }
        public void setAutorizacao(int autorizacao) {
                Autorizacao = autorizacao;
        }
        public String getNickname() {return nickname;}
        public void setNickname(String nickname) {this.nickname = nickname;}
        public String getUser() {
            return user;
        }
        public String getSenha(){return senha;}
        public  Long getId(){return id;}
        public void setUser(String user) {this.user = user;}
        public void setSenha(String senha){this.senha =senha;}
        public void setId(Long id){this.id =id;}
    }
