/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.model;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Cozinheiro {
    private int idCozinheiro;
    private String NomeCozi;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;

    public Cozinheiro(){
        
    }

    public Cozinheiro (int idCozinheiro,String NomeCozi,String cpf,String telefone,java.util.Date dataNasc,String email,String senha){
        this.idCozinheiro = idCozinheiro;
        this.NomeCozi = NomeCozi;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    };
    
    public int getIdCozinheiro() {
        return idCozinheiro;
    }

    public void setIdCozinheiro(int idCozinheiro) {
        this.idCozinheiro = idCozinheiro;
    }

    public String getNomeCozi() {
        return NomeCozi;
    }

    public void setNomeCozi(String NomeCozi) {
        this.NomeCozi = NomeCozi;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
