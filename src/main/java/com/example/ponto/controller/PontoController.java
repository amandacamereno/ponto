package com.example.ponto.controller;

import com.example.ponto.model.Ponto;
import com.example.ponto.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ponto")
public class PontoController {
    @Autowired
    private PontoService pontoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ponto> findById(@PathVariable Integer id){
        Ponto obj = pontoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Ponto>> findAll() {
        List<Ponto> list = pontoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Ponto> registro(@RequestBody Ponto obj){
        obj = pontoService.registro(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ponto> atualizar(@PathVariable Integer id, @RequestBody Ponto obj){
        obj= pontoService.atualizar(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        pontoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
