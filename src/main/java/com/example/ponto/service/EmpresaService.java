package com.example.ponto.service;

import com.example.ponto.model.Empresa;

import java.util.Optional;

public interface EmpresaService {
    Optional<Empresa> buscarPorCnpj(String cnpj);
    Empresa persistir (Empresa empresa);

}
