package com.example.ponto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity (name = "justificativa")
public class Justificativa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    @Column (name = "textojus")
    private String textojus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ponto")
    private Ponto ponto;

    public Justificativa() {
    }

    public Justificativa(Integer id, String textojus, Ponto ponto) {
        this.id = id;
        this.textojus = textojus;
        this.ponto = ponto;
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

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public Ponto getPonto() {
        return ponto;
    }
}
