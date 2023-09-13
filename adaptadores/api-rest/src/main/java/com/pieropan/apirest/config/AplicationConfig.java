package com.pieropan.apirest.config;

import br.pieropan.application.service.UsuarioService;
import com.pieropan.apirest.adapter.UsuarioPortAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfig {

    @Bean
    public UsuarioService usuarioService(UsuarioPortAdapter usuarioPortAdapter) {
        return new UsuarioService(usuarioPortAdapter);
    }
}