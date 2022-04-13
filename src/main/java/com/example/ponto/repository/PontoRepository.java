package com.example.ponto.repository;

import com.example.ponto.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Integer> {
        Optional<Ponto> findById(Integer id);
    }

