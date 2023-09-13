package com.pieropan.apirest.adapter;

import br.pieropan.application.ports.UsuarioPort;
import br.pieropan.application.request.UsuarioRequest;
import br.pieropan.application.response.UsuarioResponse;
import com.pieropan.apirest.entity.UsuarioEntity;
import com.pieropan.apirest.mapper.UsuarioMapper;
import com.pieropan.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPortAdapter implements UsuarioPort {

    @Autowired
    UsuarioRepository repository;

    @Override
    public boolean usuarioJaCadastrado(String login) {
        return repository.findByLogin(login).isPresent();
    }

    @Override
    public UsuarioResponse salvar(UsuarioRequest request) {
        UsuarioEntity usuario = repository.save(UsuarioMapper.INSTANCE.toUsuario(request));
        return UsuarioMapper.INSTANCE.toUsuarioResponse(usuario);
    }
}