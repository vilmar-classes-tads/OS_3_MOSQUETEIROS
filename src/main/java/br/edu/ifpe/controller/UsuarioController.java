package br.edu.ifpe.controller;

import br.edu.ifpe.dominio.Usuario;
import br.edu.ifpe.service.CadastroUsuarioService;

import java.net.URL;

public class UsuarioController {

    private final CadastroUsuarioService service;

    public UsuarioController() {
        this.service = new CadastroUsuarioService();
    }

    public String cadastrarUsuario(
            String CPF,
            String nomeCompleto,
            String nomeSocial,
            String email,
            String senha,
            String telefone,
            Usuario.Campus campus,
            String[] areaFormacao,
            Usuario.Titulacao[] titulacao,
            Usuario.Sexo sexo,
            URL lattesUrl) {

        try {

            service.cadastrarUsuario(
                    CPF,
                    nomeCompleto,
                    nomeSocial,
                    email,
                    senha,
                    telefone,
                    campus,
                    areaFormacao,
                    titulacao,
                    sexo,
                    lattesUrl
            );

            return "Usuário cadastrado com sucesso!";

        } catch (IllegalArgumentException e) {

            return "Erro no cadastro: " + e.getMessage();
        }
    }
}