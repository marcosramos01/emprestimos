/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.entidade;

import java.io.Serializable;

/**
 *
 * @author Win10
 */
public class Biblitecario implements Serializable{
    
    private Integer cdBiblitecario;
    private String login;
    private String senha;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

    public Biblitecario() {
    }

    public Biblitecario(Integer cdBiblitecario, String login, String senha, String nome, String logradouro, String cidade, String estado, String cep) {
        this.cdBiblitecario = cdBiblitecario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Integer getCdBiblitecario() {
        return cdBiblitecario;
    }

    public void setCdBiblitecario(Integer cdBiblitecario) {
        this.cdBiblitecario = cdBiblitecario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
    
}
