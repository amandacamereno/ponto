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

    @GetMapping("/admin/{id}")
    public Iterable<Usuario> listar(){ return usuarioService.listar();}

    @GetMapping("/{id}")
    public Optional<Usuario> buscaPorId(@PathVariable Integer id){return usuarioService.buscar(id);}

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario obj){
        obj = usuarioService.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @PutMapping("/admin/{id}")
    public Usuario atualizar(@PathVariable ("id") Integer id, @Valid @RequestBody Usuario usuario) throws Exception{
        return usuarioService.editar(id, usuario);
    }
}
