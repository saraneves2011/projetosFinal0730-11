/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Pedido extends Cliente {

    protected Integer idPedido = null;
    protected String NumMesa;
    protected int idCliente;
    protected java.util.Date dataPedido;
    protected ArrayList<RelPedidoProduto> relPedidoProduto = new ArrayList<>();

    public Pedido() {

    }

    public int getIdCliente() {
        return idCliente; 
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<RelPedidoProduto> getRelPedidoProduto() {
        return relPedidoProduto;
    }

    public void setRelPedidoProduto(ArrayList<RelPedidoProduto> relPedidoProduto) {
        this.relPedidoProduto = relPedidoProduto;
    }

    public void addRelPedidoProduto(RelPedidoProduto relPedidoProduto) {
        this.relPedidoProduto.add(relPedidoProduto);
    }

    public void removeRelPedidoProduto(RelPedidoProduto relPedidoProduto) {
        this.relPedidoProduto.remove(relPedidoProduto);
    }

    public Pedido(int idPedido, int idCliente, Date dataPedido, String NumMesa) {
        this.idCliente = idCliente;
        this.NumMesa = NumMesa;
        this.dataPedido = dataPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNumMesa() {
        return NumMesa;
    }

    public void setNumMesa(String NumMesa) {
        this.NumMesa = NumMesa;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

}
