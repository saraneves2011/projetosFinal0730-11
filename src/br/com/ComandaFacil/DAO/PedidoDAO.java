/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.DAO;

import br.com.ComandaFacil.model.Cliente;
import br.com.ComandaFacil.model.Pedido;
import br.com.ComandaFacil.model.Produto;
import br.com.ComandaFacil.model.RelPedidoProduto;
import br.com.ComandaFacil.util.ConectionFactory;
import br.com.ComandaFacil.util.Sessao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class PedidoDAO implements InterfaceDAO {

    private Connection conexao;

    public PedidoDAO() {
        conexao = new ConectionFactory().conexao();
    }

    public Pedido fazerPedido(Pedido pedido) {
        try {
            conexao.setAutoCommit(false);
            Cliente cliente = Sessao.cliente;
            String sql = "INSERT INTO pedido(NumMesa,dataPedido,idCliente) values(?,?,?)";
            java.sql.Date dataPedido = new java.sql.Date(pedido.getDataPedido().getTime());

            PreparedStatement ps = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pedido.getNumMesa());
            ps.setDate(2, dataPedido);
            ps.setInt(3, cliente.getIdCliente());
            ps.execute();
            conexao.commit();
            conexao.setAutoCommit(true);

            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                pedido.setIdPedido(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inclusão do cliente. Código"
                    + ex.getSQLState()
                    + "Descrição\n"
                    + ex.getMessage());
        }

        return pedido;
    }

    public Pedido autPedido() {
        Pedido pedido = null;
        String sql = ("SELECT max(id_ped) as id_ped FROM pedido;");

        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);

            preparedState.executeQuery();

            ResultSet rs = preparedState.executeQuery();

            while (rs.next()) {

                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_ped"));

                System.out.println(pedido.getIdPedido());
            }
            return pedido;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "PedidoDAO" + e.getMessage());
            return null;
        }
    }

    public void incluirProduto(Pedido pedido, Produto produto, int quantidade) {

    }

    @Override
    public void salvar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
