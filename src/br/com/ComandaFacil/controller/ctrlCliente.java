/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.controller;

import br.com.ComandaFacil.model.Cliente;
import br.com.ComandaFacil.view.JFrmTelaInicial;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author aluno
 */
public class ctrlCliente {

    Cliente cliente = new Cliente();


    public static String validarSenha(String senha) {
        String md5 = null;

        if (null == senha) {
            return null;
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            digest.update(senha.getBytes(), 0, senha.length());

            md5 = new BigInteger(1, digest.digest()).toString(16);

            //System.out.println(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }

    public boolean validarEmailRegex(Cliente cliente) {
        System.out.println(cliente.getEmail());
        boolean isEmailIdValid = false;

        if (cliente.getEmail() != null || cliente.getEmail().length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cliente.getEmail());

            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }

        return isEmailIdValid;
    }

    public boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
  
        String testeCPF1 = CPF.replace(".","");
        String testeCPF2 = testeCPF1.replace("-", "");
        
        if (testeCPF2.equals("00000000000")
                || testeCPF2.equals("11111111111")
                || testeCPF2.equals("22222222222") || testeCPF2.equals("33333333333")
                || testeCPF2.equals("44444444444") || testeCPF2.equals("55555555555")
                || testeCPF2.equals("66666666666") || testeCPF2.equals("77777777777")
                || testeCPF2.equals("88888888888") || testeCPF2.equals("99999999999")
                || (testeCPF2.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do testeCPF2 em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (testeCPF2.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (testeCPF2.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == testeCPF2.charAt(9)) && (dig11 == testeCPF2.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
