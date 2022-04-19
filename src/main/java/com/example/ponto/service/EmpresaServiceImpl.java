package com.example.ponto.service;

import com.example.ponto.model.Empresa;
import com.example.ponto.repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private static final Logger message = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> buscarPorCnpj(String cnpj) {
       message.info("Busca por cnpj: {}", cnpj);
       return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa persistir(Empresa empresa) {
        message.info("Persistir empresa: {}", empresa);
        return this.empresaRepository.save(empresa);
    }
}
