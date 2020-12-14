/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.dao;

import emprestimo.entidade.Biblitecario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Win10
 */
public class BibliotecarioDao implements Serializable{
    
    private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvar(Biblitecario biblitecario) throws SQLException {
        String sql = "INSERT INTO biblitecario(cdBibliotecario, login, "
                + "senha, nome, logradouro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, biblitecario.getCdBiblitecario());
            preparando.setString(2, biblitecario.getLogin());
            preparando.setString(3, biblitecario.getSenha());
            preparando.setString(4, biblitecario.getNome());
            preparando.setString(5, biblitecario.getLogradouro());
            preparando.setString(6, biblitecario.getCidade());
            preparando.setString(7, biblitecario.getEstado());
            preparando.setString(8, biblitecario.getCep());
            preparando.executeUpdate();
            resultSet.next();

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Biblitecario biblitecario) throws SQLException {
        String sql = "UPDATE bibliotecario SET cdBibliotecario = ?, login = ?,"
                + " senha = ?, nome = ?, logradouro = ?, cidade = ?, estado = ?, cep = ? WHERE cdBibliotecario = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, biblitecario.getCdBiblitecario());
            preparando.setString(2, biblitecario.getLogin());
            preparando.setString(3, biblitecario.getSenha());
            preparando.setString(4, biblitecario.getNome());
            preparando.setString(5, biblitecario.getLogradouro());
            preparando.setString(6, biblitecario.getCidade());
            preparando.setString(7, biblitecario.getEstado());
            preparando.setString(8, biblitecario.getCep());
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
            preparando = conexao.prepareStatement("DELETE FROM bibliotecario WHERE cdBibliotecario = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
}
