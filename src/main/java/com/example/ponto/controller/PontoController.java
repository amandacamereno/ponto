package com.example.ponto.controller;

import com.example.ponto.dto.ConsultaPontosDTO;
import com.example.ponto.dto.PontoDTO;
import com.example.ponto.model.Ponto;
import com.example.ponto.model.TipoBatida;
import com.example.ponto.model.Usuario;
import com.example.ponto.service.PontoService;
import com.example.ponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping(value = "/espelho")
public class PontoController {

    @Autowired
    PontoService pontoService;

    @Autowired
     UsuarioService usuarioService;

    @PostMapping("/{idUsuario}")
    public ResponseEntity<?> cadastrar(@PathVariable("idUsuario") int idUsuario, @Valid @RequestBody PontoDTO pontoDTO)
            throws Exception {

        Ponto ponto = new Ponto();
        Optional<Usuario> usuarioInformado = usuarioService.buscar(idUsuario);

        if (!Ponto.isTipoValido(pontoDTO.getTipoBatida())) {
            return new ResponseEntity<>("Tipo de Batida deve ser ENTRADA ou SAIDA", HttpStatus.BAD_REQUEST);
        }

        ponto.setUsuario(usuarioInformado.get());
        ponto.setTipoBatida(TipoBatida.valueOf(pontoDTO.getTipoBatida().toUpperCase()));
        ponto.setDataHoraRegistro(LocalDateTime.parse(pontoDTO.getDataHoraRegistro()));
        ponto.setJustifica(pontoDTO.getJustifica());

        return new ResponseEntity<>(pontoService.criar(ponto), HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<ConsultaPontosDTO> consultarPorUsuario(@PathVariable("idUsuario") int idUsuario)
            throws Exception {

        Iterable<Ponto> listagemPontos = pontoService.consultarPorUsuario(idUsuario);

        ConsultaPontosDTO consultaPontosDTO = new ConsultaPontosDTO();

        consultaPontosDTO.setListagemPonto(listagemPontos);
        consultaPontosDTO.setHorasTrabalhadas(Ponto.getHorasTotais(listagemPontos));

        return ResponseEntity.ok(consultaPontosDTO);
    }
//    @GetMapping("/login")
//    public String buscarPorLogin(@PathVariable String login, String senha){return pontoService.buscarLogin(login, senha);}


    @PutMapping("/{id}")
    public Usuario editar(@PathVariable("id") int id, @Valid @RequestBody Usuario usuario) throws Exception {
        return usuarioService.editar(id, usuario);
    }


}

