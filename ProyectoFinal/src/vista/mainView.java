/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author Albert
 */
public class mainView extends javax.swing.JFrame {
   
    public mainView() {
        initComponents();
        filProm.setText("Filtrar por Promedio");
        filNomb.setText("Filtrar por Nombre");
        filtProf.setText("Filtrar por Profesión");
        searchByProm.setText("Buscar por Promedio");
        searchNom.setText(null);
        searchProf.setText(null);
        searchProm.setText(null);
        searchByProf.setText("Buscar por Profesion");
        searchByN.setText("Buscar por Nombre");
        label1.setText("Nombre:");
        label2.setText("Profesión:");
        label3.setText("Promedio:");
        searchNaPr.setVisible(false);
        searchNaProm.setVisible(false);
        searchPromProf.setVisible(false);
        advSearch.setText("Busqueda Avanzada");
        simpleSearch.setVisible(false);
        simpleSearch.setText("Busqueda Simple");
        searchNaPr.setText("Buscar por Nombre y Profesión");
        searchNaProm.setText("Buscar por Nombre y Promedio");
        searchPromProf.setText("Buscar por Profesion y Promedio");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JTable();
        filProm = new javax.swing.JButton();
        filNomb = new javax.swing.JButton();
        filtProf = new javax.swing.JButton();
        searchProm = new javax.swing.JTextField();
        searchByProm = new javax.swing.JButton();
        searchByProf = new javax.swing.JButton();
        searchByN = new javax.swing.JButton();
        searchProf = new javax.swing.JTextField();
        searchNom = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        searchNaPr = new javax.swing.JButton();
        searchNaProm = new javax.swing.JButton();
        searchPromProf = new javax.swing.JButton();
        advSearch = new javax.swing.JButton();
        simpleSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(217, 255, 255));

        lista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(lista);

        filProm.setText("jButton1");

        filNomb.setText("jButton1");

        filtProf.setText("jButton1");

        searchProm.setText("jTextField1");

        searchByProm.setText("jButton1");

        searchByProf.setText("jButton1");

        searchByN.setText("jButton1");

        searchProf.setText("jTextField1");

        searchNom.setText("jTextField2");

        label1.setText("jLabel1");

        label2.setText("jLabel2");

        label3.setText("jLabel3");

        searchNaPr.setText("jButton1");

        searchNaProm.setText("jButton1");

        searchPromProf.setText("jButton1");

        advSearch.setText("jButton1");

        simpleSearch.setText("jButton2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(advSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpleSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filNomb)
                            .addComponent(filProm)
                            .addComponent(filtProf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label3)
                            .addComponent(label2)
                            .addComponent(label1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchNom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchProf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchProm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchByN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchNaPr))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchByProm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchPromProf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchByProf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchNaProm))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filNomb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtProf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filProm)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1)
                            .addComponent(searchByN)
                            .addComponent(searchNaPr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(searchByProf)
                            .addComponent(searchNaProm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchProm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchByProm)
                                .addComponent(searchPromProf)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(simpleSearch)
                            .addComponent(advSearch))
                        .addContainerGap())))
        );

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
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton advSearch;
    private javax.swing.JButton filNomb;
    private javax.swing.JButton filProm;
    private javax.swing.JButton filtProf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JTable lista;
    private javax.swing.JButton searchByN;
    private javax.swing.JButton searchByProf;
    private javax.swing.JButton searchByProm;
    private javax.swing.JButton searchNaPr;
    private javax.swing.JButton searchNaProm;
    private javax.swing.JTextField searchNom;
    private javax.swing.JTextField searchProf;
    private javax.swing.JTextField searchProm;
    private javax.swing.JButton searchPromProf;
    private javax.swing.JButton simpleSearch;
    // End of variables declaration//GEN-END:variables

    public JButton getAdvSearch() {
        return advSearch;
    }

    public JButton getFilNomb() {
        return filNomb;
    }

    public JButton getFilProm() {
        return filProm;
    }

    public JButton getFiltProf() {
        return filtProf;
    }

    public JButton getSearchByN() {
        return searchByN;
    }

    public JButton getSearchByProf() {
        return searchByProf;
    }

    public JButton getSearchByProm() {
        return searchByProm;
    }

    public JButton getSearchNaPr() {
        return searchNaPr;
    }

    public JButton getSearchNaProm() {
        return searchNaProm;
    }

    public JButton getSearchPromProf() {
        return searchPromProf;
    }

    public JButton getSimpleSearch() {
        return simpleSearch;
    }

    public JTextField getSearchNom() {
        return searchNom;
    }

    public JTextField getSearchProf() {
        return searchProf;
    }

    public JTextField getSearchProm() {
        return searchProm;
    }

    public void setLista(JTable lista) {
        this.lista = lista;
    }

    public JTable getLista() {
        return lista;
    }

    public void setSearchProm(String searchProm) {
        this.searchProm.setText(searchProm);
    }

    public void setSearchNom(String searchNom) {
        this.searchNom.setText(searchNom);
    }

    public void setSearchProf(String searchProf) {
        this.searchProf.setText(searchProf);
    }

    public void setAdvSearch(boolean advSearch) {
        this.advSearch.setVisible(advSearch);
    }

    public void setSearchByN(boolean searchByN) {
        this.searchByN.setVisible(searchByN);
    }

    public void setSearchByProf(boolean searchByProf) {
        this.searchByProf.setVisible(searchByProf);
    }

    public void setSearchByProm(boolean searchByProm) {
        this.searchByProm.setVisible(searchByProm);
    }

    public void setSearchNaPr(boolean searchNaPr) {
        this.searchNaPr.setVisible(searchNaPr);
    }

    public void setSearchNaProm(boolean searchNaProm) {
        this.searchNaProm.setVisible(searchNaProm);
    }

    public void setSearchPromProf(boolean searchPromProf) {
        this.searchPromProf.setVisible(searchPromProf);
    }

    public void setSimpleSearch(boolean simpleSearch) {
        this.simpleSearch.setVisible(simpleSearch);
    }

}
