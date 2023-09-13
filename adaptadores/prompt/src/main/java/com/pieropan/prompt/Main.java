package com.pieropan.prompt;

import br.pieropan.application.request.UsuarioRequest;
import br.pieropan.application.response.UsuarioResponse;
import br.pieropan.application.service.UsuarioService;
import com.pieropan.prompt.adapter.UsuarioPortAdapter;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private final static UsuarioService usuarioService = new UsuarioService(new UsuarioPortAdapter());

    public static void main(String[] args) {

        System.out.print("Digite e-mail: ");
        String email = scanner.next();

        System.out.print("Digite login: ");
        String login = scanner.next();

        System.out.print("Digite senha: ");
        String senha = scanner.next();

        UsuarioResponse usuarioCadastrado =
                usuarioService.cadastrar(new UsuarioRequest(login, email, senha));

        System.out.println("Usuário cadastrado id: " + usuarioCadastrado.getId());
    }
}