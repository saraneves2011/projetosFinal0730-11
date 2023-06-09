/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ComandaFacil.view;

import br.com.ComandaFacil.DAO.PedidoDAO;
import br.com.ComandaFacil.DAO.RelPedidoProdutoDAO;
import br.com.ComandaFacil.model.Pedido;
import br.com.ComandaFacil.model.RelPedidoProduto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class JFrmHistorico extends javax.swing.JFrame {

    int pedido = 0;
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    /**
     * Creates new form JFrmHistorico
     */
    public JFrmHistorico() {
        initComponents();
        listaHistorico();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorico = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaHistorico = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableHistorico.setBackground(new java.awt.Color(248, 241, 241));
        jTableHistorico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableHistorico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Pedido", "Nº do Pedido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHistorico);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 340, 240));

        jPanel2.setBackground(new java.awt.Color(185, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Pedidos");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Histórico de ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ComandaFacil/Imagem/Comanda facil logo 50px.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 80));

        jTextAreaHistorico.setColumns(20);
        jTextAreaHistorico.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextAreaHistorico.setRows(5);
        jTextAreaHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextAreaHistoricoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTextAreaHistorico);
        jTextAreaHistorico.getAccessibleContext().setAccessibleParent(jPanel1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 280, 240));

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel3.setMinimumSize(new java.awt.Dimension(1000, 1000));
        jPanel3.setPreferredSize(new java.awt.Dimension(760, 403));

        jButtonVoltar.setBackground(new java.awt.Color(185, 0, 0));
        jButtonVoltar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(254, 254, 254));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(889, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 760, 403));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistoricoMouseClicked
        // TODO add your handling code here:
        jTextAreaHistorico.setText("");

        int linha = jTableHistorico.getSelectedRow();
        int coluna = jTableHistorico.getSelectedColumn();
        pedido = (int) jTableHistorico.getValueAt(linha, 1);

        ArrayList<RelPedidoProduto> pedidos = new RelPedidoProdutoDAO().consultarItem(pedido);

        for (RelPedidoProduto ped : pedidos) {
            jTextAreaHistorico.append(String.valueOf(ped.getProduto()) + "\n");
        }

    }//GEN-LAST:event_jTableHistoricoMouseClicked

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        JFrmMenu frmmenu = new JFrmMenu();
        frmmenu.setVisible(true);
        dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextAreaHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaHistoricoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaHistoricoMouseClicked

    public void listaHistorico() {

        ArrayList<RelPedidoProduto> pedidos = new RelPedidoProdutoDAO().historico();
        jTableHistorico.getColumnModel().getColumn(0);
        jTableHistorico.getColumnModel().getColumn(1);

        DefaultTableModel modelo = (DefaultTableModel) jTableHistorico.getModel();

        for (RelPedidoProduto rpp : pedidos) {
            String data  = df.format(rpp.getData());
            modelo.addRow(new Object[]{data, rpp.getIdPedido()});
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableHistorico;
    private javax.swing.JTextArea jTextAreaHistorico;
    // End of variables declaration//GEN-END:variables
}
