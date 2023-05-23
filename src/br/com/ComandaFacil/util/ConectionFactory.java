/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectionFactory {

    public Connection conexao() {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/comanda1", "root", "root");
        } catch (SQLException ex) {
            throw new RuntimeException();
        }

    }
}
