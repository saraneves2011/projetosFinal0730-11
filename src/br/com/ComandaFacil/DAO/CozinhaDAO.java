/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.DAO;

import br.com.ComandaFacil.model.Cozinheiro;
import br.com.ComandaFacil.util.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class CozinhaDAO {

    private Connection conexao;

    public CozinhaDAO() {
        conexao = new ConectionFactory().conexao();
    }

    public void salvar(Object objeto) {
        try {
            Cozinheiro cozinheiro = (Cozinheiro) objeto;
            conexao.setAutoCommit(false);
            String sql = "INSERT INTO cliente(nomeCozinhei,telefone,cpf,email,senha) values(?,?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cozinheiro.getNomeCozi());
            ps.setString(2, cozinheiro.getTelefone());
            ps.setString(3, cozinheiro.getCpf());
            ps.setString(4, cozinheiro.getEmail());
            ps.setString(5, cozinheiro.getSenha());
            ps.execute();
            conexao.commit();
            conexao.setAutoCommit(true);
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inclusão do cliente. Código"
                    + ex.getSQLState()
                    + "Descrição\n"
                    + ex.getMessage());
        }
    }
}
