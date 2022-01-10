package com.nobrescan.api.repository;

import com.nobrescan.api.model.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem,Long> {
     List<Imagem> findByIdcap(Long idcap);
}
