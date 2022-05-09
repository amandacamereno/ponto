package com.example.ponto.repository;

import com.example.ponto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  Usuario findByLoginAndSenha(String login, String senha);

//     Optional<Usuario> findByLoginSenha(String login, String senha);

}
