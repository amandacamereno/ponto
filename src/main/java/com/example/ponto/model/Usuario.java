package com.example.ponto.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;
//    @NotNull
    @Column (name = "nome")
    private String nome;
//    @NotNull
    @Column(name = "sobrenome")
    private String sobrenome;
    @NotNull
    @Column(name = "login")
    private String login;
    @NotNull
    @Column(name = "senha")
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;



    public Usuario() {
    }

    public Usuario(int id, String nome, String sobrenome, String login, String senha, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.senha = senha;
        this.empresa = empresa;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
