package com.pieropan.prompt.adapter;

import br.pieropan.application.ports.UsuarioPort;
import br.pieropan.application.request.UsuarioRequest;
import br.pieropan.application.response.UsuarioResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.pieropan.prompt.enums.MensagemEnum.ERRO_CRIAR_ARQUIVO;
import static com.pieropan.prompt.enums.MensagemEnum.ERRO_INESPERADO;

public class UsuarioPortAdapter implements UsuarioPort {

    private final String NOME_ARQUIVO = "prompt.csv";

    private final File file = new File(NOME_ARQUIVO);

    @Override
    public boolean usuarioJaCadastrado(String login) {
        if (file.exists()) {
            return contemUsuario(login);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(ERRO_CRIAR_ARQUIVO.getDescricao());
        }
        return false;
    }

    private boolean contemUsuario(String login) {
        try (FileReader fileReader = new FileReader(file)) {

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                String colunaLogin = linha.split(";")[2];

                if (colunaLogin.equalsIgnoreCase(login)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(ERRO_INESPERADO.getDescricao());
        }

        return false;
    }

    private int obterProximoId() {
        int id = 0;

        try (FileReader fileReader = new FileReader(file)) {

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                String colunaId = linha.split(";")[0];
                id = Integer.parseInt(colunaId);
            }

        } catch (IOException ex) {
            throw new RuntimeException(ERRO_INESPERADO.getDescricao());
        }

        return id + 1;
    }

    @Override
    public UsuarioResponse salvar(UsuarioRequest request) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {

            int id = obterProximoId();
            fileWriter.write(gerarTexto(request, id));
            return new UsuarioResponse((long) id, request.getEmail(), request.getLogin());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String gerarTexto(UsuarioRequest request, int id) {
        return new StringBuilder(String.valueOf(id))
                .append(";")
                .append(request.getEmail().toLowerCase())
                .append(";")
                .append(request.getLogin().toLowerCase())
                .append(";")
                .append(request.getSenha())
                .append("\n").toString();
    }
}