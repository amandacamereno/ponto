package com.example.ponto.repository;

import com.example.ponto.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmpresaRepository  extends JpaRepository<Empresa, Integer> {
    Optional<Empresa> findById(Integer id);

    @Transactional(readOnly = true)
    Empresa  findByCnpj(String cnpj);
}
