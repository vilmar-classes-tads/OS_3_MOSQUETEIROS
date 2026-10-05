package br.edu.ifpe.service;

import br.edu.ifpe.dominio.Perfil;
import br.edu.ifpe.dominio.Usuario;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CadastroUsuarioService {

    // Simulação do banco de dados
    private static final List<Usuario> usuarios = new ArrayList<>();

    /**
     * Realiza o cadastro de um novo usuário.
     */
    public Usuario cadastrarUsuario(
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

        // Validação dos campos obrigatórios
        if (CPF == null || CPF.isBlank()) {
            throw new IllegalArgumentException("CPF é obrigatório.");
        }

        if (nomeCompleto == null || nomeCompleto.isBlank()) {
            throw new IllegalArgumentException("Nome completo é obrigatório.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail é obrigatório.");
        }

        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Senha é obrigatória.");
        }

        if (campus == null) {
            throw new IllegalArgumentException("Campus é obrigatório.");
        }

        if (areaFormacao == null || areaFormacao.length == 0) {
            throw new IllegalArgumentException("Área de formação é obrigatória.");
        }

        if (titulacao == null || titulacao.length == 0) {
            throw new IllegalArgumentException("Titulação é obrigatória.");
        }

        // Validação da senha
        if (senha.length() < 6) {
            throw new IllegalArgumentException(
                    "A senha deve possuir no mínimo 6 caracteres."
            );
        }

        // Validação de CPF único
        if (cpfExiste(CPF)) {
            throw new IllegalArgumentException(
                    "CPF já cadastrado."
            );
        }

        // Validação de e-mail único
        if (emailExiste(email)) {
            throw new IllegalArgumentException(
                    "E-mail já cadastrado."
            );
        }

        // Criptografa a senha antes de salvar
        String senhaHash = gerarHashSenha(senha);

        // Cria o usuário
        Usuario usuario = new Usuario(
                CPF,
                nomeCompleto,
                nomeSocial,
                email,
                senhaHash,
                telefone,
                campus,
                areaFormacao,
                titulacao,
                sexo,
                lattesUrl
        );

        // Adiciona os perfis padrão
        usuario.getPerfis().add(Perfil.ROLE_COORDENADOR);
        usuario.getPerfis().add(Perfil.ROLE_AVALIADOR);

        // Salva na lista que simula o banco
        usuarios.add(usuario);

        return usuario;
    }

    /**
     * Verifica se o CPF já está cadastrado.
     */
    public boolean cpfExiste(String CPF) {

        for (Usuario usuario : usuarios) {
            if (usuario.getCPF().equals(CPF)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica se o e-mail já está cadastrado.
     */
    public boolean emailExiste(String email) {

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Retorna todos os usuários cadastrados.
     */
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    /**
     * Gera um hash seguro para a senha usando PBKDF2.
     */
    private String gerarHashSenha(String senha) {

        try {
            // Gera um salt aleatório
            byte[] salt = new byte[16];
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);

            // Configura o algoritmo PBKDF2
            PBEKeySpec spec = new PBEKeySpec(
                    senha.toCharArray(),
                    salt,
                    65536,
                    256
            );

            SecretKeyFactory factory =
                    SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            byte[] hash = factory.generateSecret(spec).getEncoded();

            // Salva salt + hash em Base64
            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String hashBase64 = Base64.getEncoder().encodeToString(hash);

            return saltBase64 + ":" + hashBase64;

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalStateException(
                    "Erro ao gerar hash da senha.", e
            );
        }
    }
}