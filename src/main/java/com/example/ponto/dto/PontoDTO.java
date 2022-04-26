package com.example.ponto.dto;

import javax.validation.constraints.NotNull;

public class PontoDTO {
    @NotNull
    private String tipoBatida;

    @NotNull
    private String dataRegistro;

    @NotNull
    private String justificativa;

    public String getTipoBatida() {
        return tipoBatida;
    }

    public void setTipoBatida(String tipoBatida) {
        this.tipoBatida = tipoBatida;
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
