/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.dao;

import emprestimo.entidade.Livros;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Win10
 */
public class LivrosDao implements Serializable {

    private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvar(Livros livros) throws SQLException {
        String sql = "INSERT INTO livros(cdLivro, titulo, "
                + "resumo, dtPublicacao, edicao, nmEditora, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, livros.getCdLivro());
            preparando.setString(2, livros.getTitulo());
            preparando.setString(3, livros.getResumo());
            preparando.setString(4, livros.getDtPublicacao());
            preparando.setString(5, livros.getEdicao());
            preparando.setString(6, livros.getNmEditora());
            preparando.setString(7, livros.getCidade());
            preparando.setString(8, livros.getEstado());
            preparando.executeUpdate();
            resultSet.next();

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Livros livros) throws SQLException {
        String sql = "UPDATE livros SET cdLivro = ?, titulo = ?,"
                + " resumo = ?, dtPublicacao = ?, edicao = ?, nmEditora = ?, cidade = ?, estado = ? WHERE cdLivro = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, livros.getCdLivro());
            preparando.setString(2, livros.getTitulo());
            preparando.setString(3, livros.getResumo());
            preparando.setString(4, livros.getDtPublicacao());
            preparando.setString(5, livros.getEdicao());
            preparando.setString(6, livros.getNmEditora());
            preparando.setString(7, livros.getCidade());
            preparando.setString(8, livros.getEstado());
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
            preparando = conexao.prepareStatement("DELETE FROM livros WHERE cdLivro = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
