package com.nobrescan.api.repository;

import com.nobrescan.api.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    List<Usuarios> findByUser(String user);
}