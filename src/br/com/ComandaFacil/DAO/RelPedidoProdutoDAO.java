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
import static br.com.ComandaFacil.util.Sessao.cliente;
import static br.com.ComandaFacil.util.Sessao.relPedidoProduto;
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
public class RelPedidoProdutoDAO {

    private Connection conexao;

    public RelPedidoProdutoDAO() {
        conexao = new ConectionFactory().conexao();
    }

    public void incluirProduto(RelPedidoProduto relPedidoProduto) {

        System.out.println("codigo====" + relPedidoProduto.getIdProduto());
        try {
            conexao.setAutoCommit(false);
            String sql = "INSERT INTO rel_pedido_produto(quantidadeProd,"
                    + " idProduto , idPedido,liberado) values(?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, relPedidoProduto.getQuantidadeProd());
            ps.setInt(2, relPedidoProduto.getIdProduto());
            ps.setInt(3, relPedidoProduto.getIdPedido());
            ps.setBoolean(4, relPedidoProduto.isLiberado());
            ps.execute();
            conexao.commit();
            conexao.setAutoCommit(true);
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inclusão dos seus itens"
                    + ex.getSQLState()
                    + "Descrição\n"
                    + ex.getMessage());
        }
    }

    public ArrayList<RelPedidoProduto> consultarProdutos() {

        String sql = "select rpp.idPedido, p.numMesa from pedido p,\n"
                + " rel_pedido_produto rpp, produto pr where rpp.idPedido = p.id_ped and "
                + "rpp.idProduto = pr.id_prod and rpp.liberado = false group by rpp.idPedido";

        //String sql = ("SELECT  idPedido FROM rel_pedido_produto;");
        ArrayList<RelPedidoProduto> relPedidoProdutos = new ArrayList<>();
        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);

            ResultSet rs = preparedState.executeQuery();
            while (rs.next()) {
                RelPedidoProduto relPedidoProduto = new RelPedidoProduto();

                relPedidoProduto.setIdPedido(rs.getInt(1));
                relPedidoProduto.setId(rs.getInt(2));
                relPedidoProdutos.add(relPedidoProduto);

            }
            return relPedidoProdutos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "relPedidoProdutoDAO" + e.getMessage());
            return null;
        }

    }

    public ArrayList<RelPedidoProduto> consultarItem(int p) {
        String sql = "select p.descricao , rpp.quantidadeProd, pe.id_ped\n"
                + "from produto p, rel_pedido_produto rpp,pedido pe\n"
                + "where rpp.idProduto = p.id_prod and rpp.idPedido = pe.id_ped and pe.id_ped = " + p;

        ArrayList<RelPedidoProduto> relPedidoProdutos = new ArrayList<>();
        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);

            ResultSet rs = preparedState.executeQuery();
            while (rs.next()) {
                RelPedidoProduto relPedidoProduto = new RelPedidoProduto();

                relPedidoProduto.setProduto(rs.getString(1));
                relPedidoProduto.setQuantidadeProd(rs.getInt(2));
                relPedidoProduto.setIdPedido(rs.getInt(3));
                relPedidoProdutos.add(relPedidoProduto);

            }
            return relPedidoProdutos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "relPedidoProdutoDAO" + e.getMessage());
            return null;
        }
    }

    public void atualizarTabela(int p) {
        String sql = "UPDATE rel_pedido_produto\n"
                + "SET liberado = ? \n"
                + "WHERE idPedido =" + p;

        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);

            preparedState.setBoolean(1, true);

            preparedState.executeUpdate();
            preparedState.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "relPedidoProdutoDAO " + e.getMessage());

        }
    }

    public void excluirProdutoComanda(int p, int codProduto) {
        System.out.println(codProduto);
        String sql = "delete from rel_pedido_produto where idPedido = ? and idProduto = ?";

        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);

            preparedState.setInt(1, p);
            preparedState.setInt(2, codProduto);

            preparedState.execute();
            preparedState.close();
            JOptionPane.showMessageDialog(null, "Atualizado" + JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "relPedidoProdutoDAO " + e.getMessage());

        }
    }

    public ArrayList<RelPedidoProduto> historico() {
        System.out.println();
        String sql = "select  p.id_ped,rpp.idPedido, p.dataPedido from pedido p, rel_pedido_produto rpp"
                + " where p.id_ped= rpp.idPedido"
                + " and p.idCliente = " + Sessao.idCliente
                + " group by p.id_ped";

        ArrayList<RelPedidoProduto> relPedidoProdutos = new ArrayList<>();
        try {
            PreparedStatement preparedState = conexao.prepareStatement(sql);

            ResultSet rs = preparedState.executeQuery();
            while (rs.next()) {
                RelPedidoProduto relPedidoProduto = new RelPedidoProduto();

                relPedidoProduto.setIdPedido(rs.getInt(1));
                relPedidoProduto.setIdPedido(rs.getInt(2));
                relPedidoProduto.setData(rs.getDate(3));
                relPedidoProdutos.add(relPedidoProduto);

            }
            return relPedidoProdutos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "relPedidoProdutoDAO" + e.getMessage());
            return null;
        }
    }
}

// inserir método para consultar


//idProduto, qnt, idPedido
