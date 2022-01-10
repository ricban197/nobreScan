package com.nobrescan.api.controller;

import com.nobrescan.api.model.Imagem;
import com.nobrescan.api.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImagemController {
    @Autowired
    private ImagemRepository imagemRepository;

    public String salva(Long idCap,int NumPag,String src){
        Imagem novaPagina = new Imagem();
        novaPagina.setNumpag(NumPag);
        novaPagina.setIdcap(idCap);
        novaPagina.setSrc(src);
        imagemRepository.save(novaPagina);
        return "e";
    }

}
