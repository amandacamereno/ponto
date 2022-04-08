package com.example.ponto.service;

import com.example.ponto.model.Usuario;
import com.example.ponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> findAll() {return usuarioRepository.findAll();}

    public Usuario findById(Integer id) {
        Optional<Usuario> filme = usuarioRepository.findById(id);
        return filme.get();
    }

    public Usuario registro (Usuario obj){
        return usuarioRepository.save(obj);
    }

    public void deletar(Integer id) {usuarioRepository.deleteById(id);
    }

    public Usuario atualizar(Integer id,Usuario obj) {
       Usuario usuario = usuarioRepository.getOne(id);
        updateData(usuario,obj);
        return usuarioRepository.save(usuario);
    }

    private void updateData(Usuario usuario, Usuario obj) {
        usuario.setNome(obj.getNome());
        usuario.setSobrenome(obj.getSobrenome());
        usuario.setLogin(obj.getLogin());
        usuario.setSenha(obj.getSenha());
    }

}
