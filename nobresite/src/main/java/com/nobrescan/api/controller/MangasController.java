package com.nobrescan.api.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nobrescan.api.model.Usuarios;
import com.nobrescan.api.model.ajax.AjaxCapitulo;
import com.nobrescan.api.model.ajax.AjaxManga;
import com.nobrescan.api.model.Manga;
import com.nobrescan.api.model.validacao.MangaValida;
import com.nobrescan.api.repository.MangasRepository;
import com.nobrescan.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "192.168.0.106:8080")
@RestController
@RequestMapping("/manga")
public class MangasController {
    @Autowired
    private MangasRepository mangasRepository;
    private Manga manga;
    private MultipartFile capa;

    @GetMapping("/todos")
    public List<Manga> todos(){
        return mangasRepository.findAll() ;
    }
    /* VALIDAÇÃO DE USUARIO*/
    @Autowired
    UsuarioRepository usuarioRepository;

    /* FIM */



    private static String pathImage="C:/Users/Usuario/Desktop/spring boot/nobresite/src/main/resources/static/imagens/capas/";
    @PostMapping("/salva")
    public Manga salva(@RequestParam("user") String user, @RequestParam("manga") String manga, @RequestParam("capa") MultipartFile capa/*,Errors errors*/){
        AjaxCapitulo result = new AjaxCapitulo();        
        Manga novo = new Manga();
        Usuarios verificando = new Usuarios();
/*
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            novo.setNome("erro no recebimento");
            return novo;
        }
  */ ObjectMapper mapperManga = new ObjectMapper();
        try {
            novo = mapperManga.readValue(manga, Manga.class);
        } catch (IOException e) {
               novo.setNome("erro na conversao "+manga);
               return novo;
        }
        ObjectMapper mapperUsuario = new ObjectMapper();
        try {
            verificando = mapperUsuario.readValue(user, Usuarios.class);
        } catch (IOException e) {

            novo.setNome("erro na conversao "+manga);
            return novo;
        }
        List<Usuarios> a = usuarioRepository.findByUser(verificando.getUser());
        if(a.isEmpty()){
            verificando.setId((long)-1);//-1 usuario invalido
            return  null;
        }else if((a.get(0).getSenha()).equals(verificando.getSenha())){
            String nome_capa= GeraSrc(40);
            novo.setSrc_capa(nome_capa);
            //Long data;
            //data = Calendar;
            //novo.setUltima_atu(data);
            novo.setTotal_caps(0);
            try{
                if(!capa.isEmpty()){
                    byte[] bytes = capa.getBytes();
                    Path SRC= Paths.get(pathImage+nome_capa);
                    Files.write(SRC,bytes);
                    mangasRepository.save(novo);
                }
                return novo;
            }catch(IOException e){
                e.printStackTrace();
                novo.setNome("ERRO NA IMAGEM");
                return novo;
            }


        }else{
            verificando.setId((long)-2);//-2 senha invalida
            return null;
        }



    }
    @GetMapping("/capa/{imagem}")
    public byte[] capas(@PathVariable("imagem") String nome) throws IOException {
        File capa= new File(pathImage+nome);
        if( nome!= null || nome.trim().length()>0){
            return Files.readAllBytes(capa.toPath());
        }
        else return null;
    }
    @PostMapping("/pesquisa")
    public  List<MangaValida> pesquisa(@RequestBody MangaValida e, Errors errors){
        AjaxManga result = new AjaxManga();
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return null;

        }
        return (mangasRepository.findByNomeContains(e.getNome())).stream().map(MangaValida::converter).collect(Collectors.toList());

    }
    @PostMapping("/id")
    public Optional<Manga> pesquisaid(@RequestBody MangaValida id, Errors errors){
        AjaxManga result = new AjaxManga();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return null;
        }
        Optional<Manga> manga = mangasRepository.findById(id.getId());
        return manga;
    }





    /**/
    /**/
    static String GeraSrc(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789"
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
