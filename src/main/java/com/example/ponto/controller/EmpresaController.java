package com.example.ponto.controller;

import com.example.ponto.dto.EmpresaDTO;
import com.example.ponto.model.Empresa;
import com.example.ponto.response.Response;
import com.example.ponto.service.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {
    private static final Logger message = LoggerFactory.getLogger(EmpresaController.class);
    @Autowired
    private EmpresaService empresaService;
    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<Response<EmpresaDTO>> buscaPorCnpj(@PathVariable("cnpj") String cnpj) {
        message.info("Buscando empresa por CNPJ {} informado",cnpj);
        Response<EmpresaDTO> response = new Response<EmpresaDTO>();
        Optional<Empresa> empresa =empresaService.buscarPorCnpj(cnpj);

        if (!empresa.isPresent()) {
            message.info("Empresa nao encontrada pelo CNPJ: {}",cnpj);
            response.getErrors().add("Empresa nao encontrada pelo CNPJ " + cnpj);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.converterEmpresaDto(empresa.get()));
        return ResponseEntity.ok(response);

    }

    private EmpresaDTO converterEmpresaDto(Empresa empresa) {
        EmpresaDTO empresaDto = new EmpresaDTO();
        empresaDto.setId(empresa.getId());
        empresaDto.setNomeEmpresa(empresa.getNomeEmpresa());
        empresaDto.setCnpj(empresa.getCnpj());
        return empresaDto;
    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Empresa> findById(@PathVariable Integer id){
//        Empresa obj = empresaService.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }
//    @GetMapping
//    public ResponseEntity<List<Empresa>> findAll() {
//        List<Empresa> list = empresaService.findAll();
//        return ResponseEntity.ok().body(list);
//    }
//
//    @PostMapping
//    public ResponseEntity<Empresa> registro(@RequestBody Empresa obj){
//        obj = empresaService.registro(obj);
//        return ResponseEntity.ok().body(obj);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Empresa> atualizar(@PathVariable Integer id, @RequestBody Empresa obj){
//        obj= empresaService.atualizar(id, obj);
//        return ResponseEntity.ok().body(obj);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
//        empresaService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }

}

