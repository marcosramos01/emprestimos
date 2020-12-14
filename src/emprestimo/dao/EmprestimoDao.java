/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.dao;

import emprestimo.entidade.Emprestimos;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Win10
 */
public class EmprestimoDao implements Serializable{
    
    private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvar(Emprestimos emprestimos) throws SQLException {
        String sql = "INSERT INTO emprestimo(cdEmprestimo, cdUsuario, "
                + "cdBibliotecario, cdLivro, dtDevolucao, dtRetirada) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, emprestimos.getCdEmprestimo());
            preparando.setInt(2, emprestimos.getCdUsuario());
            preparando.setInt(3, emprestimos.getCdBibliotecario());
            preparando.setInt(4, emprestimos.getCdLivro());
            preparando.setString(5, emprestimos.getDtDevolucao());
            preparando.setString(6, emprestimos.getDtRetirada());
            preparando.executeUpdate();
            resultSet.next();

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Emprestimos emprestimos) throws SQLException {
        String sql = "UPDATE emprestimo SET cdEmprestimo = ?, cdUsuario = ?,"
                + " cdBibliotecario = ?, cdLivro = ?, dtDevolucao = ?, dtRetirada = ? WHERE cdEmprestimo = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, emprestimos.getCdEmprestimo());
            preparando.setInt(2, emprestimos.getCdUsuario());
            preparando.setInt(3, emprestimos.getCdBibliotecario());
            preparando.setInt(4, emprestimos.getCdLivro());
            preparando.setString(5, emprestimos.getDtDevolucao());
            preparando.setString(6, emprestimos.getDtRetirada());
            preparando.executeUpdate();
            resultSet.next();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());

        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM emprestimo WHERE cdEmprestimo = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
    
}
