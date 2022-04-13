package com.example.ponto.service;

import com.example.ponto.model.Ponto;
import com.example.ponto.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;


    public List<Ponto> findAll() {return pontoRepository.findAll();}

    public Ponto findById(Integer id) {
        Optional<Ponto> ponto = pontoRepository.findById(id);
        return ponto.get();
    }

    public Ponto registro (Ponto obj){
        return pontoRepository.save(obj);
    }


    public Ponto atualizar(Integer id,Ponto obj) {
        Ponto ponto = pontoRepository.getOne(id);
        updateData(ponto,obj);
        return pontoRepository.save(ponto);
    }

    public void deletar(Integer id) {pontoRepository.deleteById(id);}

    private void updateData(Ponto ponto, Ponto obj) {
        ponto.setRegistro(obj.getRegistro());
    }

}
