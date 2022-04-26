package com.example.ponto.service;

import com.example.ponto.exception.PontoException;
import com.example.ponto.model.Usuario;
import com.example.ponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criar (Usuario obj){
        return usuarioRepository.save(obj);
    }
    public Optional<Usuario>buscar(int id){
        Optional<Usuario>obj = usuarioRepository.findById(id);
        if (!obj.isPresent()){
            throw new PontoException("id","Usuário não encontrado");
        }
        return obj;
    }

    public Iterable <Usuario> listar(){return  usuarioRepository.findAll();}

    public  Usuario editar (int id, Usuario usuario) throws Exception{
        Optional<Usuario> usuarioSelecionado = usuarioRepository.findById(id);
        if (!usuarioSelecionado.isPresent()){
            throw new PontoException("id", "Usuario selecionado para alteração não encontrado");
        }
        usuarioSelecionado.get().setNome(Optional.ofNullable(usuario.getNome()).isPresent() ? usuario.getNome()
                : usuarioSelecionado.get().getNome());

        usuarioSelecionado.get().setSobrenome(Optional.ofNullable(usuario.getSobrenome()).isPresent() ? usuario.getSobrenome()
                :usuarioSelecionado.get().getSobrenome());

        usuarioSelecionado.get().setLogin(Optional.ofNullable(usuario.getLogin()).isPresent() ? usuario.getLogin()
                : usuarioSelecionado.get().getLogin());

        usuarioSelecionado.get().setSenha(Optional.ofNullable(usuario.getSenha()).isPresent() ? usuario.getSenha()
                : usuarioSelecionado.get().getSenha());

        return usuarioRepository.save(usuarioSelecionado.get());
    }
}
