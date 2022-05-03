package com.example.ponto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@Entity(name = "ponto")
public class Ponto {
    @Id
    @Column(name = "idponto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nomefuncionario")
    private String nome;
    @Column(name = "sobrenomefuncionario")
    private String sobrenome;

    // @CreationTimestamp
    //@Temporal(TemporalType.TIMESTAMP)
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss.SSSSSS'Z'", timezone = "GMT")
    @Column(name = "horaregistro")
    private LocalDateTime dataHoraRegistro;

    @Column(name = "tipobatida")
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoBatida tipoBatida;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    public Ponto(int id,String nome,String sobrenome,LocalDateTime dataHoraRegistro) {
        this.id = id;
        this.nome = nome;
        this.sobrenome =sobrenome;
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public Ponto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDateTime getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoBatida getTipoBatida() {
        return tipoBatida;
    }

    public void setTipoBatida(TipoBatida tipoBatida) {
        this.tipoBatida = tipoBatida;
    }

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
            if (pontos.get(i).getDataHoraRegistro().isEqual(ponto.getDataHoraRegistro())
                    && pontos.get(i).getTipoBatida().equals(TipoBatida.ENTRADA)) {
                saida = Optional.of(pontos.get(i + 1));
                break;
            }
        }

        if (ponto.getTipoBatida().equals(TipoBatida.SAIDA) || !saida.isPresent()
                || saida.get().getTipoBatida().equals(TipoBatida.ENTRADA)) {
            return Duration.ofHours(0);
        }

        return Duration.between(ponto.getDataHoraRegistro(), saida.get().getDataHoraRegistro());
    }
}

