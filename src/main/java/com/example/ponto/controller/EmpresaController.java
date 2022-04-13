package com.example.ponto.controller;

import com.example.ponto.model.Empresa;
import com.example.ponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Integer id){
        Empresa obj = empresaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> list = empresaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Empresa> registro(@RequestBody Empresa obj){
        obj = empresaService.registro(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Integer id, @RequestBody Empresa obj){
        obj= empresaService.atualizar(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        empresaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

