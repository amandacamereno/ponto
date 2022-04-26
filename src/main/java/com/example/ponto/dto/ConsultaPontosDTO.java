package com.example.ponto.dto;

import com.example.ponto.model.Ponto;

import javax.validation.constraints.NotNull;

public class ConsultaPontosDTO {
    @NotNull
    private Iterable<Ponto> listagemPonto;

    @NotNull
    private String horasTrabalhadas;

    public Iterable<Ponto> getListagemPonto() {
        return listagemPonto;
    }

    public void setListagemPonto(Iterable<Ponto> listagemPonto) {
        this.listagemPonto = listagemPonto;
    }

    public String getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(String horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}
