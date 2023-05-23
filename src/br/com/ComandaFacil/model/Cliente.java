package br.com.ComandaFacil.model;

import java.util.Date;
import javax.swing.JTextField;


public class Cliente {
    private int idCliente;
    private String Nome;
    private String cpf;
    private String telefone;
    private java.util.Date dataNasc; 
    private String email;
    private String senha;
    
    public Cliente(){
        
    }

    public Cliente (int idCliente,String Nome,String cpf,String telefone,java.util.Date dataNasc,String email,String senha){
        super();
        this.idCliente = idCliente;
        this.Nome = Nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senha = senha;
    };

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
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

    public void setNome(JTextField jTextFieldNome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
