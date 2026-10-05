/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.dominio;

import java.net.URL;
import java.util.ArrayList;

/**

[ ]
* Sexo (com opção "Outro"), Link do Lattes e Telefone.

[ ] O sistema deve validar a unicidade do CPF (não permitir dois usuários com o mesmo CPF).
 *
 * @author ALUNOS
 */
public class Usuario{
   
    public enum Sexo {
        MASCULINO,
        FEMININO,
        OUTRO
    }
    public enum Titulacao{
   
    TECNICO,
    GRADUACAO,
    ESPECIALIZACAO,
    MESTRADO,
    DOUTORADO
    }
   
    public enum Campus {
    RECIFE,
    JABOATAO,
    PALMARES,
    PESQUEIRA,
    GARANHUNS,
    CARUARU,
    IPOJUCA,
    VITORIA_DE_SANTO_ANTAO,
    BARREIROS,
    AFOGADOS_DA_INGAZEIRA,
    BELO_JARDIM
}
   
    private String CPF;
    private String nomeCompleto;
    private String nomeSocial;
    private String email;
    private String senha;
    private String telefone;
    private Campus campus;
    private String areaFormacao[];
    private Titulacao titulacao[];
    private Sexo sexo;
    private URL lattesUrl;
     private ArrayList<Perfil> perfis = new ArrayList<>();

    public Usuario(String CPF, String nomeCompleto, String nomeSocial, String email, String senha, String telefone, Campus campus, String[] areaFormacao, Titulacao[] titulacao, Sexo sexo, URL lattesUrl) {
        this.CPF = CPF;
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.campus = campus;
        this.areaFormacao = areaFormacao;
        this.titulacao = titulacao;
        this.sexo = sexo;
        this.lattesUrl = lattesUrl;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public String[] getAreaFormacao() {
        return areaFormacao;
    }

    public void setAreaFormacao(String[] areaFormacao) {
        this.areaFormacao = areaFormacao;
    }

    public Titulacao[] getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao[] titulacao) {
        this.titulacao = titulacao;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public URL getLattesUrl() {
        return lattesUrl;
    }

    public void setLattesUrl(URL lattesUrl) {
        this.lattesUrl = lattesUrl;
    }

    public ArrayList<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(ArrayList<Perfil> perfis) {
        this.perfis = perfis;
    }

   

   
   
}