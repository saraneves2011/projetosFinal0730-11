/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.DAO;

import br.com.ComandaFacil.model.Produto;
import br.com.ComandaFacil.util.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO() {
        conexao = new ConectionFactory().conexao();
    }

    public ResultSet autProduto() {

        String sql = ("SELECT id_prod, descricao FROM produto;");

        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);
            return preparedState.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO" + e.getMessage());
            return null;
        }
    }
    
    

    public ArrayList<Produto> consultarProdutos() {

        String sql = ("SELECT id_prod, descricao FROM produto;");
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);

            ResultSet rs = preparedState.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt(1));
                produto.setDescricao(rs.getString(2));
                produtos.add(produto);
                
            }
            return produtos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO" + e.getMessage());
            return null;
        }

    }
}
