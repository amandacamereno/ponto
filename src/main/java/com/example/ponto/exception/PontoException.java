package com.example.ponto.exception;

public class PontoException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String atributo;

    public String getAtributo() {return atributo;}

    public PontoException(String atributo,String message) {
        super(message);
        this.atributo = atributo;
    }

}
