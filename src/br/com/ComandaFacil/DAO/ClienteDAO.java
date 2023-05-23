/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.DAO;

import br.com.ComandaFacil.controller.ctrlCliente;
import br.com.ComandaFacil.model.Cliente;
import br.com.ComandaFacil.util.ConectionFactory;
import static br.com.ComandaFacil.util.Sessao.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ClienteDAO implements InterfaceDAO {

    ctrlCliente ctrlCliente = new ctrlCliente();
    private Connection conexao;

    public ClienteDAO() {
        conexao = new ConectionFactory().conexao();

    }

    @Override
    public void salvar(Object objeto) {

        try {
            Cliente cliente = (Cliente) objeto;
            String cpf = cliente.getCpf();
            String testeCPF1 = cpf.replace(".", "");
            String testeCPF2 = testeCPF1.replace("-", "");
            
            String telefone = cliente.getTelefone();
            String testeTel = telefone.replace("-", "");
            String testeTel1 = testeTel.replace("(", "");
            String testeTel2 = testeTel1.replace(")","");
                    
                    
            java.sql.Date dataNasc = new java.sql.Date(cliente.getDataNasc().getTime());
            conexao.setAutoCommit(false);
            String sql = "INSERT INTO cliente(nomeCliente,telefone,cpf,email,dataNasc,senha) values(?,?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, testeTel2);
            ps.setString(3, testeCPF2);
            ps.setString(4, cliente.getEmail());
            ps.setDate(5, dataNasc);
            ps.setString(6, ctrlCliente.validarSenha(cliente.getSenha()));
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

    public Cliente autenticar(String login, String senha, int idCliente) throws Exception {

        Cliente cliente = null;

        PreparedStatement preparedStatement
                = conexao.prepareStatement("SELECT * FROM cliente WHERE email like ? and senha like ? ");

        preparedStatement.setString(1, login);
        preparedStatement.setString(2, senha);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cli"));
            cliente.setNome(resultSet.getString("nomeCliente"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setDataNasc(resultSet.getDate("dataNasc"));
            cliente.setSenha(resultSet.getString("senha"));

        }

        return cliente;
    }

}
