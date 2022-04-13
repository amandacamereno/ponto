package com.example.ponto.repository;

import com.example.ponto.model.Empresa;
import com.example.ponto.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository  extends JpaRepository<Empresa, Integer> {
    Optional<Empresa> findById(Integer id);
}
