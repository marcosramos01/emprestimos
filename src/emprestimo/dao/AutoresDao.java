/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.dao;

import emprestimo.entidade.Autores;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Win10
 */
public class AutoresDao implements Serializable{
    
       private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvar(Autores autores) throws SQLException {
        String sql = "INSERT INTO autores(cdAutores, nmAutor, cdLivro_FK) VALUES (?, ?, ?)";
                
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, autores.getCdAutores());
            preparando.setString(2, autores.getNmAutor());
            preparando.setInt(3, autores.getCdlivro_FK());
            preparando.executeUpdate();
            resultSet.next();

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Autores autores) throws SQLException {
        String sql = "UPDATE autores SET cdAutores = ?, nmAutor = ?, cdLivro_FK = ? WHERE cdAutores = ?";
                

        try {
           conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, autores.getCdAutores());
            preparando.setString(2, autores.getNmAutor());
            preparando.setInt(3, autores.getCdlivro_FK());
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
            preparando = conexao.prepareStatement("DELETE FROM autores WHERE cdAutores = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
    
}
