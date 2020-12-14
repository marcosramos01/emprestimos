/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprestimo.dao;

import emprestimo.entidade.Academico;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Win10
 */
public class AcademicoDao implements Serializable {

    private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resultSet;

    public void salvar(Academico academico) throws SQLException {
        String sql = "INSERT INTO academico(cdMatricula, nmAcademico, "
                + "cpf, dsEmail, dsEndereco, idSexo, idade) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, academico.getCdMatricula());
            preparando.setString(2, academico.getNmAcademico());
            preparando.setInt(3, academico.getCpf());
            preparando.setString(4, academico.getDsEmail());
            preparando.setString(5, academico.getDsEndereco());
            preparando.setInt(6, academico.getIdSexo());
            preparando.setInt(7, academico.getIdade());
            preparando.executeUpdate();
            resultSet.next();

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Academico academico) throws SQLException {
        String sql = "UPDATE academico SET cdMatricula = ?, nmAcademico = ?,"
                + " cpf = ?, dsEmail = ?, dsEndereco = ?, idSexo = ?, idade = ? WHERE cdMatricula = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, academico.getCdMatricula());
            preparando.setString(2, academico.getNmAcademico());
            preparando.setInt(3, academico.getCpf());
            preparando.setString(4, academico.getDsEmail());
            preparando.setString(5, academico.getDsEndereco());
            preparando.setInt(6, academico.getIdSexo());
            preparando.setInt(7, academico.getIdade());
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
            preparando = conexao.prepareStatement("DELETE FROM academico WHERE cdMatricula = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
