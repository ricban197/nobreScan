package com.nobrescan.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nobrescan.api.model.Capitulo;
import com.nobrescan.api.model.Imagem;
import com.nobrescan.api.model.Manga;
import com.nobrescan.api.model.Usuarios;
import com.nobrescan.api.model.ajax.AjaxCapitulo;
import com.nobrescan.api.model.validacao.CapituloValida;
import com.nobrescan.api.repository.CapituloRepository;
import com.nobrescan.api.repository.ImagemRepository;
import com.nobrescan.api.repository.MangasRepository;
import com.nobrescan.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "192.168.0.106:8080")
@RestController
@RequestMapping("/capitulo")
public class CapitulosController {
    @Autowired
    ImagemController pagRepository;
    @Autowired
    private CapituloRepository capituloRepository;
    /* VALIDAÇÃO DE USUARIO*/
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    MangasRepository mangaRepository;
    /* FIM */
    private static String pathImage="C:/Users/Usuario/Desktop/spring boot/nobresite/src/main/resources/static/imagens/pags/";

    @PostMapping("/todos")
    public Manga capitulos(@RequestBody Manga a/*, Errors errors*/)
    {
        AjaxCapitulo result = new AjaxCapitulo();
        /*if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return null;
        }
        Manga ler=new Manga();
        ObjectMapper mapperManga = new ObjectMapper();
        try {
            ler = mapperManga.readValue(a, Manga.class);
        } catch (IOException e) {

            return null;
        }*//*
        return capituloRepository.findByIdmanga(a.getId())

                .stream()
                .map(CapituloValida::Converter)
                .collect(Collectors.toList());*/
        return a;

    }
    @PostMapping("/salva")
    public String salva(@RequestParam("user") String user, @RequestParam("capitulo") String capitulo, @RequestParam("pags") MultipartFile[] pags){
       Imagem img = new Imagem();
        Capitulo novo = new Capitulo();
        Usuarios verificando = new Usuarios();
        ObjectMapper mapperUsuario = new ObjectMapper();
        try {
            verificando = mapperUsuario.readValue(user, Usuarios.class);
        } catch (IOException e) {
            return "erro ao converter usuario";
        }
        ObjectMapper mapperManga = new ObjectMapper();
        try {
            novo = mapperManga.readValue(capitulo, Capitulo.class);
        } catch (IOException e) {

            return "erro ao converter capitulo: "+e;
        }


        List<Usuarios> a = usuarioRepository.findByUser(verificando.getUser());
        if(a.isEmpty()){
            verificando.setId((long)-1);//-1 usuario invalido
            return  null;
        }else if((a.get(0).getSenha()).equals(verificando.getSenha())){
            String nome_pag= GeraSrc(40);
            int i;
            try{
                novo = capituloRepository.save(novo);

                i=0;
                for(MultipartFile pag : pags) {

                    nome_pag= GeraSrc(40);
                    i++;
                    if(!pag.isEmpty()){

                        byte[] bytes = pag.getBytes();
                        Path SRC= Paths.get(pathImage+nome_pag);
                        Files.write(SRC,bytes);

                       pagRepository.salva(novo.getId(),i,nome_pag);
                    }
                }
                var s = mangaRepository.findById(novo.getId_manga());
                if(s.isPresent()) {
                    var manga_atualiza = s.get();
                    var antigoNumCap = manga_atualiza.getTotal_caps();
                    manga_atualiza.setTotal_caps(antigoNumCap + 1);
                    mangaRepository.save(manga_atualiza);
                }else {
                return "s vazio id passado: "+novo.getId_manga();
                }
                return "foi";
            }catch(IOException e){
                e.printStackTrace();
                novo.setNome("ERRO NA IMAGEM");
                return "erro nas imagens"+e;
            }
        }else{
            verificando.setId((long)-2);//-2 senha invalida
            return null;
        }


    }

    /**/
    static String GeraSrc(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }






}
