package com.example.ponto.exception;

public class PontoException extends RuntimeException{
// CASO NO POSTMAN O ID DO USUARIO NAO ESTEJA CADASTRADO (TRATAMENTO DE ERRO)
    private static final long serialVersionUID = 1L;
    private String atributo;

    public String getAtributo() {return atributo;}

    public PontoException(String atributo,String message) {
        super(message);
        this.atributo = atributo;
    }

}
