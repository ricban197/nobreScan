package com.nobrescan.api.repository;

import com.nobrescan.api.model.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapituloRepository extends JpaRepository<Capitulo, Long> {
   List<Capitulo> findByIdmanga(long idmanga);

}
