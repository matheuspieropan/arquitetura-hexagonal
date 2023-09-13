package br.pieropan.application.service;

import br.pieropan.application.ports.UsuarioPort;
import br.pieropan.application.request.UsuarioRequest;
import br.pieropan.application.response.UsuarioResponse;

import static br.pieropan.application.enums.MensagemEnum.USUARIO_JA_CADASTRADO;

public class UsuarioService {

    private final UsuarioPort usuarioPort;

    public UsuarioService(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public UsuarioResponse cadastrar(UsuarioRequest request) {
        boolean usuarioCadastrado = usuarioPort.usuarioJaCadastrado(request.getLogin());

        if (usuarioCadastrado) {
            throw new RuntimeException(USUARIO_JA_CADASTRADO.getDescricao());
        }

        return usuarioPort.salvar(request);
    }
}