package com.example.ponto.controller;

import com.example.ponto.model.Empresa;
import com.example.ponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RequestMapping(value = "/empresa")
@RestController
public class EmpresaController {

    @Autowired
    public EmpresaService empresaService;

    @GetMapping
    public Iterable<Empresa> listar(){ return empresaService.listar();}

    @GetMapping("/{id}")
    public Optional<Empresa> buscaPorId(@PathVariable Integer id){return empresaService.buscar(id);}

//    @GetMapping("/{cnpj}")
//    public Optional<Empresa> buscaPorCnpj (@PathVariable String cnpj){return empresaService.buscarPorCnpj(cnpj);}


    @PostMapping("/admin/criarEmpresa")
    public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa){
        empresa = empresaService.criar(empresa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(empresa);
    }
    @PutMapping("/admin/{id}")
    public Empresa atualizar(@PathVariable ("id") Integer id, @Valid @RequestBody Empresa empresa) throws Exception{
        return empresaService.editar(id, empresa);
    }
}
