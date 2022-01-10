package com.nobrescan.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
@CrossOrigin(origins = "192.168.0.106:8080")
@Controller
public class WebController {
    @GetMapping("/adm")
    public String accesarAdm(){
        return "adm/home_adm";
    }
    @GetMapping("/home")
    public String acessarHome(){ return "usuarios/home";
    }
    @GetMapping("/add")
    public  String acessarAddObra(){return "usuarios/add_obra";}
    @GetMapping("/login")
    public  String acessarLogin(){return  "usuarios/login";}
    @GetMapping("/ler")
    public  String acessarLer(){return  "usuarios/ler";}
}
