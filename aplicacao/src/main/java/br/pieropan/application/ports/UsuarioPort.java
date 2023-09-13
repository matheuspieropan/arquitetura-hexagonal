package br.pieropan.application.ports;

import br.pieropan.application.request.UsuarioRequest;
import br.pieropan.application.response.UsuarioResponse;

public interface UsuarioPort {

    boolean usuarioJaCadastrado(String login);

    UsuarioResponse salvar(UsuarioRequest request);
}