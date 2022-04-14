package com.example.ponto.model;


import javax.persistence.*;

@Entity(name = "situacao")
public class Situacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    @Column (name = "nome")
    private String nome;



    public Situacao() {
    }

    public Situacao(Integer id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
