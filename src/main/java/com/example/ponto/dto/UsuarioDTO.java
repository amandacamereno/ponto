package com.example.ponto.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class UsuarioDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    @NotEmpty(message = "Usuário não pode ser vazio.")
    @Length(min = 3, max = 30, message = "Nome deve conter entre 3 e 30 caracteres.")
    private String login;
    @NotEmpty(message = "Senha não pode ser vazia.")
    @Length(min = 7, max = 11, message = "A senha deve conter entre 7 e 11 caracteres.")
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String nome, String sobrenome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.senha = senha;
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


}
