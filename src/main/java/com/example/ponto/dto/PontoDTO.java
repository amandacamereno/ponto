package com.example.ponto.dto;

import java.util.Date;

public class PontoDTO {

    private Integer id;
    private Date registro;

    public PontoDTO() {
    }

    public PontoDTO(Integer id, Date registro) {
        this.id = id;
        this.registro = registro;
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

}
