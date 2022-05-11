package com.example.ponto.controller;

import com.example.ponto.model.Usuario;
import com.example.ponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping
    public Iterable<Usuario> listar(){ return usuarioService.listar();}

    @GetMapping("/{id}")
    public Optional<Usuario> buscaPorId(@PathVariable Integer id){return usuarioService.buscar(id);}

//    @PostMapping("/auth")
//    public String  buscarUsuario(@RequestBody Usuario obj){
//        return usuarioService.buscarUsuario(obj.getLogin(), obj.getSenha());
//    }
//@PostMapping("/auth")
//    public Usuario buscarUsuario(@PathVariable String login, String senha, @RequestBody Usuario obj){
//      return usuarioService.login(login, senha);
//    }


    @PostMapping("/auth")
    public Usuario buscarUsuario(@RequestBody Usuario obj){
        System.out.println(obj.getLogin());
        System.out.println(obj.getSenha());
//        String resposta = usuarioService.buscarUsuario(obj.getId(), obj.getSenha());
        return usuarioService.buscarUsuario(obj.getLogin(), obj.getSenha());
    }


    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario obj){
        obj = usuarioService.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable ("id") Integer id, @Valid @RequestBody Usuario usuario) throws Exception{
        return usuarioService.editar(id, usuario);
    }
}
