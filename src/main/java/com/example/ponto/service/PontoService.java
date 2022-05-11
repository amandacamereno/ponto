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

    public Ponto criar(Ponto ponto) {

        Usuario usuario = ponto.getUsuario();

        Optional<Usuario> usuarioSelecionado = usuarioService.buscar(usuario.getId());

        if (!usuarioSelecionado.isPresent()) {
            throw new PontoException("Id", "Usuário não encontrado");
        }

        return pontoRepository.save(ponto);

    }
//    public String buscarLogin(String login, String senha){
//        Optional<Usuario>obj = Optional.ofNullable(pontoRepository.findByLoginAndSenha(login, senha));
//        if (!obj.isPresent()){
//            throw new PontoException("login","Login não encontrado");
//        }
////        System.out.println(obj.get().getSenha());
//        if (obj.get().getSenha().equals(senha)){
////           System.out.println("passou");
//            return "Login existente";
//        } else { throw new PontoException("senha", "senha inválida");
//
//        }
//
//    }

    public  Iterable<Ponto> consultarPorUsuario(int idUsuario) {

        Optional<Usuario> usuarioSelecionado = usuarioService.buscar(idUsuario);

        if (!usuarioSelecionado.isPresent()) {
            throw new PontoException("Id", "Usuário não encontrado");
        }

        return pontoRepository.findByUsuario(usuarioSelecionado.get());
    }


    public Iterable<Ponto> listar() {return pontoRepository.findAll();}
}

