package com.pieropan.apirest.mapper;

import br.pieropan.application.request.UsuarioRequest;
import br.pieropan.application.response.UsuarioResponse;
import com.pieropan.apirest.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioResponse toUsuarioResponse(UsuarioEntity usuarioEntity);

    UsuarioEntity toUsuario(UsuarioRequest request);
}