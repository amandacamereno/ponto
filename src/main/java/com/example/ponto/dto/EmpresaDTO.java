package com.example.ponto.dto;


public class EmpresaDTO {
    private Integer id;
    private String nomeEmpresa;
    private String cnpj;


    public EmpresaDTO() {
    }

    public EmpresaDTO(Integer id, String nomeEmpresa, String cnpj) {
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


