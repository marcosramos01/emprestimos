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
public class Emprestimos implements Serializable {

    private Integer cdEmprestimo;
    private Integer cdUsuario;
    private Integer cdBibliotecario;
    private Integer cdLivro;
    private String dtDevolucao;
    private String dtRetirada;

    public Emprestimos() {
    }

    public Emprestimos(Integer cdEmprestimo, Integer cdUsuario, Integer cdBibliotecario, Integer cdLivro, String dtDevolucao, String dtRetirada) {
        this.cdEmprestimo = cdEmprestimo;
        this.cdUsuario = cdUsuario;
        this.cdBibliotecario = cdBibliotecario;
        this.cdLivro = cdLivro;
        this.dtDevolucao = dtDevolucao;
        this.dtRetirada = dtRetirada;
    }

    public Integer getCdEmprestimo() {
        return cdEmprestimo;
    }

    public void setCdEmprestimo(Integer cdEmprestimo) {
        this.cdEmprestimo = cdEmprestimo;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public Integer getCdBibliotecario() {
        return cdBibliotecario;
    }

    public void setCdBibliotecario(Integer cdBibliotecario) {
        this.cdBibliotecario = cdBibliotecario;
    }

    public Integer getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(Integer cdLivro) {
        this.cdLivro = cdLivro;
    }

    public String getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(String dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public String getDtRetirada() {
        return dtRetirada;
    }

    public void setDtRetirada(String dtRetirada) {
        this.dtRetirada = dtRetirada;
    }

}
