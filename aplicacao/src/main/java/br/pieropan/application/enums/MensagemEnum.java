package br.pieropan.application.enums;

public enum MensagemEnum {

    USUARIO_JA_CADASTRADO("Usuário já está cadastrado!");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    MensagemEnum(String descricao) {
        this.descricao = descricao;
    }
}