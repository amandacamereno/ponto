package com.example.ponto.dto;

import javax.validation.constraints.NotNull;

public class PontoDTO {
    @NotNull
    private String situacao;

    @NotNull
    private String dataRegistro;

    @NotNull
    private String justificativa;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
