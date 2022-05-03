package com.example.ponto.dto;

import javax.validation.constraints.NotNull;

public class PontoDTO {
    @NotNull
    private String tipoBatida;

    @NotNull
    private String dataHoraRegistro;


    public String getTipoBatida() {
        return tipoBatida;
    }

    public void setTipoBatida(String tipoBatida) {
        this.tipoBatida = tipoBatida;
    }

    public String getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(String dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }
}
