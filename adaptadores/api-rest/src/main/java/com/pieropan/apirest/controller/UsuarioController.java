package com.pieropan.apirest.controller;

import br.pieropan.application.request.UsuarioRequest;
import br.pieropan.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(usuarioService.cadastrar(request));
    }
}