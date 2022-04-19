package com.example.ponto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "ponto")
public class Ponto {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss.SSSSSS'Z'", timezone = "GMT")
    @Column(name = "registro")
    private Date registro;

    @ManyToOne
    @JoinColumn(name = "id_situacao")
    @JsonBackReference
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;


    public Ponto() {
    }

    public Ponto(Integer id, Date registro, Situacao situacao, Usuario usuario) {
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

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {this.registro = registro;}

    public Situacao getSituacao() {return situacao;}

    public void setSituacao(Situacao situacao) {this.situacao = situacao;}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
