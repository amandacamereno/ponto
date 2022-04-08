package com.example.ponto.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    @Column (name = "nome")
    private String nomeEmpresa;
    @Column (name = "cnpj")
    private String cnpj;

    public Empresa() {
    }

    public Empresa(Integer id, String nomeEmpresa, String cnpj) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
