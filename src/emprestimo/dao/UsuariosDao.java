/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.dao;

import emprestimo.entidade.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Win10
 */
public class UsuariosDao implements Serializable{
    
     private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario(cdUsuario, nome, "
                + "login, senha, logradouro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, usuario.getCdUsuario());
            preparando.setString(2, usuario.getNome());
            preparando.setString(3, usuario.getLogin());
            preparando.setString(4, usuario.getSenha());
            preparando.setString(5, usuario.getLogradouro());
            preparando.setString(6, usuario.getCidade());
            preparando.setString(7, usuario.getEstado());
            preparando.setString(8, usuario.getCep());
            preparando.executeUpdate();
            resultSet.next();

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET cdUsuario = ?, nome = ?,"
                + " login = ?, senha = ?, logradouro = ?, cidade = ?, estado = ?, cep = ? WHERE cdUsuario = ?";

        try {
           conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, usuario.getCdUsuario());
            preparando.setString(2, usuario.getNome());
            preparando.setString(3, usuario.getLogin());
            preparando.setString(4, usuario.getSenha());
            preparando.setString(5, usuario.getLogradouro());
            preparando.setString(6, usuario.getCidade());
            preparando.setString(7, usuario.getEstado());
            preparando.setString(8, usuario.getCep());
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
            preparando = conexao.prepareStatement("DELETE FROM usuario WHERE cdUsuario = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
    
}
