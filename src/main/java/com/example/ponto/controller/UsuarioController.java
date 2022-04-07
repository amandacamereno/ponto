package com.example.ponto.controller;

import com.example.ponto.model.Usuario;
import com.example.ponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario teste = new Usuario(1, "Silvia", "Costa", "silviacosta@gmail.com", "silvia123");
        return ResponseEntity.ok().body(teste);
    }

    @PostMapping
    public ResponseEntity<Usuario> registro(@RequestBody Usuario obj){
        obj = usuarioService.registro(obj);
        return ResponseEntity.ok().body(obj);
    }
}
