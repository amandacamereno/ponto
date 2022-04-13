package com.example.ponto.service;

import com.example.ponto.model.Empresa;
import com.example.ponto.model.Ponto;
import com.example.ponto.repository.EmpresaRepository;
import com.example.ponto.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;


    public List<Empresa> findAll() {return empresaRepository.findAll();}

    public Empresa findById(Integer id) {
        Optional<Empresa> ponto = empresaRepository.findById(id);
        return ponto.get();
    }

    public Empresa registro (Empresa obj){
        return empresaRepository.save(obj);
    }


    public Empresa atualizar(Integer id,Empresa obj) {
        Empresa empresa = empresaRepository.getOne(id);
        updateData(empresa,obj);
        return empresaRepository.save(empresa);
    }

    public void deletar(Integer id) {empresaRepository.deleteById(id);}

    private void updateData(Empresa empresa, Empresa obj) {
        empresa.setNomeEmpresa(obj.getNomeEmpresa());
        empresa.setCnpj(obj.getCnpj());
    }

}
