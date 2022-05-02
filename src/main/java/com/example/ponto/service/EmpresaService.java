package com.example.ponto.service;

import com.example.ponto.exception.PontoException;
import com.example.ponto.model.Empresa;
import com.example.ponto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa criar (Empresa obj){
        return empresaRepository.save(obj);
    }

    public Optional<Empresa> buscar(int id){
        Optional<Empresa>empresa = empresaRepository.findById(id);
        if (!empresa.isPresent()){
            throw new PontoException("id","Empresa não encontrada");
        }
        return empresa;
    }

//    public Optional<Empresa> buscarPorCnpj(String cnpj) {
//        Optional<Empresa> empresa = Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
//        if (!empresa.isPresent()) {
//            throw new PontoException("cnpj", "Empresa buscada por cnpj não encontrada");
//        }
//        return empresa;
//    }

    public Iterable <Empresa> listar(){return empresaRepository.findAll();}

    public  Empresa editar (int id, Empresa empresa) throws Exception{
        Optional<Empresa> empresaSelecionada = empresaRepository.findById(id);
        if (!empresaSelecionada.isPresent()){
            throw new PontoException("id", "Empresa selecionada para alteração não encontrada");
        }
        empresaSelecionada.get().setNomeEmpresa(Optional.ofNullable(empresa.getNomeEmpresa()).isPresent() ? empresa.getNomeEmpresa()
                : empresaSelecionada.get().getNomeEmpresa());

        empresaSelecionada.get().setCnpj(Optional.ofNullable(empresa.getCnpj()).isPresent() ? empresa.getCnpj()
                :empresaSelecionada.get().getCnpj());


        return empresaRepository.save(empresaSelecionada.get());
    }
}
