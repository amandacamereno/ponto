package com.example.ponto.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Justificativa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    @Column (name = "textojus")
    private String textojus;

    public Justificativa() {
    }

    public Justificativa(Integer id, String textojus) {
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
