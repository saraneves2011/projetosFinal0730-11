/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.model;

public class Produto {
    
    protected int idProduto;
    protected String descricao;
    
    public Produto(){
        
    }

    public Produto(int idProduto, String descricao){
        this.idProduto = idProduto;
        this.descricao = descricao;
    }
     
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
