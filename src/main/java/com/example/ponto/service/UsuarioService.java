package com.example.ponto.service;

import com.example.ponto.model.Usuario;
import com.example.ponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> findAll() {return usuarioRepository.findAll();}

    public Usuario registro (Usuario obj){
        return usuarioRepository.save(obj);
    }
}
