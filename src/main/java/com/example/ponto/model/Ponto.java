package com.example.ponto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


public class Ponto {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "registro")
    private String registro;

    @ManyToOne
    @JoinColumn(name = "situacao_id")
    @JsonBackReference
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;


    public Ponto() {
    }

    public Ponto(Integer id, String registro, Situacao situacao, Usuario usuario) {
        this.id = id;
        this.registro = registro;
        this.situacao = situacao;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {this.registro = registro;}

    public Situacao getSituacao() {return situacao;}

    public void setSituacao(Situacao situacao) {this.situacao = situacao;}
}
