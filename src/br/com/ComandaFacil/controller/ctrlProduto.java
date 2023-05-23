/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.controller;

import br.com.ComandaFacil.DAO.ProdutoDAO;
import br.com.ComandaFacil.model.Produto;
import br.com.ComandaFacil.model.Pedido;
import br.com.ComandaFacil.model.RelPedidoProduto;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ctrlProduto {

    public ResultSet consultarPedidosCombo() {
        ProdutoDAO objProd = new ProdutoDAO();
        ResultSet rs = objProd.autProduto();
        
        return rs;
    }

    public boolean quantidade(RelPedidoProduto relPedidoProduto) {

        int quant = relPedidoProduto.getQuantidadeProd();

        if (quant > 10) {
            JOptionPane.showMessageDialog(null, "A quantidade máxima deve ser de 10 unidades!");
            return false;
        }

        return true;
    }
}
