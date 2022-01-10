package com.nobrescan.api.repository;

import com.nobrescan.api.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MangasRepository extends JpaRepository<Manga, Long> {
    List<Manga> findByNomeContains(String nome);


}
