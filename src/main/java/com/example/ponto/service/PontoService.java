package com.example.ponto.service;

import com.example.ponto.exception.PontoException;
import com.example.ponto.model.Ponto;
import com.example.ponto.model.Usuario;
import com.example.ponto.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PontoService {
    @Autowired
    private PontoRepository pontoRepository;

    @Autowired
    public UsuarioService usuarioService;

    public Ponto criar (Ponto ponto){

        Usuario usuario = ponto.getUsuario();

        Optional<Usuario> usuarioSelecionado = usuarioService.buscar(usuario.getId());

        if (!usuarioSelecionado.isPresent()){
            throw new PontoException("id", "Usuario não encontrado");

        }
        return pontoRepository.save(ponto);
    }

    public Iterable<Ponto> consultarPorUsuario(int idUsuario){

        Optional<Usuario> usuarioSelecionado = usuarioService.buscar(idUsuario);

            if (!usuarioSelecionado.isPresent()){
                throw new PontoException("id", "Usuário não encontrado");

            }
            return pontoRepository.findByUsuario(usuarioSelecionado.get());
        }
        public Iterable<Ponto> listar(){return  pontoRepository.findAll();}

    }

