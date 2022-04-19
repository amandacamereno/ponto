package com.example.ponto.dto;


public class JustificativaDTO {

    private Integer id;

    private String textojus;


    public JustificativaDTO() {
    }

    public JustificativaDTO(Integer id, String textojus) {
        this.id = id;
        this.textojus = textojus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextojus() {
        return textojus;
    }

    public void setTextojus(String textojus) {
        this.textojus = textojus;
    }

}


