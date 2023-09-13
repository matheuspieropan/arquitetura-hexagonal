package com.pieropan.prompt.enums;

public enum MensagemEnum {

    ERRO_CRIAR_ARQUIVO("Não foi possível criar arquivo!"),

    ERRO_INESPERADO("Aconteceu um erro inesperado!");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    MensagemEnum(String descricao) {
        this.descricao = descricao;
    }
}