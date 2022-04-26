package com.example.ponto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Entity(name = "ponto")
public class Ponto {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss.SSSSSS'Z'", timezone = "GMT")
    @Column(name = "registro")
    private LocalDateTime registro;

    @ManyToOne
    @JoinColumn(name = "id_situacao")
    @JsonBackReference
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @NotNull
    @Column (name = "tipobatida")
    @Enumerated (EnumType.STRING)
    private TipoBatida tipoBatida;


    public Ponto() {
    }

    public Ponto(Integer id, LocalDateTime registro, Situacao situacao, Usuario usuario) {
        this.id = id;
        this.registro = registro;
        this.situacao = situacao;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRegistro() {
        return registro;
    }

    public void setRegistro(LocalDateTime registro) {this.registro = registro;}

    public Situacao getSituacao() {return situacao;}

    public void setSituacao(Situacao situacao) {this.situacao = situacao;}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoBatida getTipoBatida() {return tipoBatida;}

    public void setTipoBatida(TipoBatida tipoBatida) {this.tipoBatida = tipoBatida;}

    public static Boolean isTipoValido(String tipoBatida){
        return tipoBatida.toUpperCase().equals(TipoBatida.ENTRADA.name())
                || tipoBatida.toUpperCase().equals(TipoBatida.SAIDA.name());
    }


    public static String getHorasTotais(Iterable<Ponto> listagemPontos) {
        Duration horasTrabalhadasTotais = Duration.ofHours(0);

        for (Ponto p :listagemPontos) {
            horasTrabalhadasTotais = horasTrabalhadasTotais
                    .plus(getHorasDiarias(p, listagemPontos, horasTrabalhadasTotais));
        }
        return String.format("%d:%02d:%02d", horasTrabalhadasTotais.toHours(),
                horasTrabalhadasTotais.toMinutesPart(), horasTrabalhadasTotais.toSecondsPart());
    }
    public static Duration getHorasDiarias(Ponto ponto, Iterable<Ponto>listagemPontos, Duration horasTrabalhadasTotais){
        Optional<Ponto> saida = Optional.empty();
        List<Ponto> pontos = StreamSupport.stream(listagemPontos.spliterator(), false).collect(Collectors.toList());


        for (int i = 0; i < pontos.size() - 1; i++) {
            if (pontos.get(i).getRegistro().isEqual(ponto.getRegistro())
                    && pontos.get(i).getTipoBatida().equals(TipoBatida.ENTRADA)) {
                saida = Optional.of(pontos.get(i + 1));
                break;
            }
        }

        if (ponto.getTipoBatida().equals(TipoBatida.SAIDA) || !saida.isPresent()
                || saida.get().getTipoBatida().equals(TipoBatida.ENTRADA)) {
            return Duration.ofHours(0);
        }

        return Duration.between(ponto.getRegistro(), saida.get().getRegistro());
    }
}
