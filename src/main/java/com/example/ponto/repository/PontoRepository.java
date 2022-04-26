package com.example.ponto.repository;

import com.example.ponto.model.Ponto;
import com.example.ponto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Integer> {

    Iterable<Ponto> findByUsuario(Usuario usuario);
}

