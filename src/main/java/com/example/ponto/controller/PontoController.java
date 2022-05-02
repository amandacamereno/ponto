package com.example.ponto.controller;

import com.example.ponto.dto.ConsultaPontosDTO;
import com.example.ponto.dto.PontoDTO;
import com.example.ponto.model.Ponto;
import com.example.ponto.model.Situacao;
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
    private UsuarioService usuarioService;

    @Autowired
    private PontoService pontoService;

    @PostMapping ("/{idUsuario}")
    public ResponseEntity<?> cadastrar(@PathVariable("idUsuario") int idUsuario, @Valid @RequestBody PontoDTO pontoDTO)
            throws Exception {

        Ponto ponto = new Ponto();
        Optional<Usuario> usuarioInformado = usuarioService.buscar(idUsuario);

        if (!Ponto.isTipoValido(pontoDTO.getSituacao())) {
            return new ResponseEntity<>("Tipo de Batida deve ser ENTRADA ou SAIDA", HttpStatus.BAD_REQUEST);
        }

        ponto.setUsuario(usuarioInformado.get());
        ponto.setSituacao(Situacao.valueOf(pontoDTO.getSituacao().toUpperCase()));
        ponto.setRegistro(LocalDateTime.parse(pontoDTO.getDataRegistro()));
        ponto.setJustificativa(pontoDTO.getJustificativa());

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
    @PutMapping("/admin/{idUsuario}")
    public Usuario editar(@PathVariable("id") int id, @Valid @RequestBody Usuario usuario) throws Exception {
        return usuarioService.editar(id, usuario);
    }
}
