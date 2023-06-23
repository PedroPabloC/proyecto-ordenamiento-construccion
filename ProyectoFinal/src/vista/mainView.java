/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author Albert
 */
public class mainView extends javax.swing.JFrame {
    private String[][] matriz = new String[626][3];    
    DefaultTableModel mT = new DefaultTableModel();
    private ArrayList<Integer> a1 = new ArrayList<Integer>();
    private ArrayList<Integer> a2 = new ArrayList<Integer>();
    private ArrayList<Integer> a3 = new ArrayList<Integer>();
    private ArbolNum treeNum = new ArbolNum();
    private ArbolAlfanum treeAlf1 = new ArbolAlfanum();
    private ArbolAlfanum treeAlf2 = new ArbolAlfanum();
    private ArbolAlfanum treeAlf3 = new ArbolAlfanum();
    private ArbolAlfanum treeAlf4 = new ArbolAlfanum();
    
    
    public mainView() {
        initComponents();
        setModel();
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
    
    public void setModel(){
        String[] header1 ={"Nombre", "Profesion", "Promedio"};
        mT.setColumnIdentifiers(header1);
        lista.setModel(mT);
    }
    
    public void setRows(String[][] m, ArrayList<Integer> ind){
        mT.setRowCount(ind.size());
        mT.setColumnCount(3);
        
        for(int i=0; i<ind.size(); i++){
            for(int j=0; j<3; j++){
                mT.setValueAt(m[ind.get(i)][j], i, j);
            }
        }
    }
    
    public void clearTable(){
        setModel();
            int filas=mT.getRowCount();
            for (int i = 0;filas>i; i++) {
                mT.removeRow(0);
            }
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
        filProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filPromActionPerformed(evt);
            }
        });

        filNomb.setText("jButton1");
        filNomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filNombActionPerformed(evt);
            }
        });

        filtProf.setText("jButton1");
        filtProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtProfActionPerformed(evt);
            }
        });

        searchProm.setText("jTextField1");
        searchProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPromActionPerformed(evt);
            }
        });

        searchByProm.setText("jButton1");
        searchByProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByPromActionPerformed(evt);
            }
        });

        searchByProf.setText("jButton1");
        searchByProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByProfActionPerformed(evt);
            }
        });

        searchByN.setText("jButton1");
        searchByN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNActionPerformed(evt);
            }
        });

        searchProf.setText("jTextField1");

        searchNom.setText("jTextField2");

        label1.setText("jLabel1");

        label2.setText("jLabel2");

        label3.setText("jLabel3");

        searchNaPr.setText("jButton1");
        searchNaPr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNaPrActionPerformed(evt);
            }
        });

        searchNaProm.setText("jButton1");
        searchNaProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNaPromActionPerformed(evt);
            }
        });

        searchPromProf.setText("jButton1");
        searchPromProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPromProfActionPerformed(evt);
            }
        });

        advSearch.setText("jButton1");
        advSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advSearchActionPerformed(evt);
            }
        });

        simpleSearch.setText("jButton2");
        simpleSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleSearchActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(advSearch)
                            .addComponent(simpleSearch))
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

    private void filPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filPromActionPerformed

    setRows(matriz, a3);
        
    }//GEN-LAST:event_filPromActionPerformed

    private void filNombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filNombActionPerformed
    
    setRows(matriz, a1);
    
    }//GEN-LAST:event_filNombActionPerformed

    private void filtProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtProfActionPerformed
    
    setRows(matriz, a2);    
    
    }//GEN-LAST:event_filtProfActionPerformed

    private void searchByPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByPromActionPerformed
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        String prom = getProm();
        if(prom.compareTo("")!=0){
                int aux = Integer.parseInt(getProm());
                if(aux<60 || aux>100){
                    JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS CON ESE PROMEDIO");
                }else if(treeNum.existe(aux)){
                    JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS CON ESE PROMEDIO");
                }else{
                    a4 = searchProm(treeNum, aux);
                    setRows(matriz, a4);
                }
            }else{
            JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE UN DATO PARA SU BUSQUEDA");
        }
        searchProm.setText("");
        a4.clear();
    }//GEN-LAST:event_searchByPromActionPerformed

    private void searchPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchPromActionPerformed

    private void searchByNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNActionPerformed
      ArrayList<Integer> a4 = new ArrayList<Integer>();
        String nom = getNom();
        if(nom.compareTo("")!=0){
                if(nom.length()<=10){
                    JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS CON ESOS DATOS, PORFAVOR REVISE LOS DATOS O ESCRIBA DE NUEVO EL NOMBRE");
                }else{
                    a4 = searchNom(treeAlf1, nom);
                    setRows(matriz, a4);
                    if(a4.size()==0){
                            JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                        }
                }
            }else{
            JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE UN DATO PARA SU BUSQUEDA");
        }
        searchNom.setText("");
        a4.clear();
    }//GEN-LAST:event_searchByNActionPerformed

    private void searchByProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByProfActionPerformed
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        String prof = getProf();
        if(prof.compareTo("")!=0){
                if(prof.length()<=5){
                    JOptionPane.showMessageDialog(null, "LA PROFESION BUSCADA NO SE ENCUENTRA, PORFAVOR INTENTE OTRA O ESCRIBA NUEVAMENTE SU BUSQUEDA");
                }else{
                    a4 = searchProf(treeAlf1, prof);
                    setRows(matriz, a4);
                    if(a4.size()==0){
                            JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                        }
                }
            }else{
            JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE UN DATO PARA SU BUSQUEDA");
        }
        searchProf.setText("");
        a4.clear();
    }//GEN-LAST:event_searchByProfActionPerformed
        
    private void searchNaPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNaPromActionPerformed
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        String prof = getProf();
        String prom = getProm();
        String nom = getNom();
        if(prof.compareTo("")!=0){
            JOptionPane.showMessageDialog(null, "ESTA BUSQUEDA SOLO PERMITE DATOS DE NOMBRE Y PROMEDIO, INGRESE OTROS DATOS");
        }else if(nom.compareTo("")!=0 || prom.compareTo("")!=0){
                if(nom.length()<=10){
                    JOptionPane.showMessageDialog(null, "EL NOMBRE INTRODUCIDO ES INCORRECTO, POR FAVOR INGRESELO DE NUEVO");
                }else{
                    int aux = Integer.parseInt(getProm());
                    if(aux<100){
                        String aux2 = nom + "0" + prom;
                        a4 = searchProf(treeAlf3, aux2);
                        if(a4.size()==0){
                            JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                        }
                        setRows(matriz, a4);
                    }else if(aux==100){
                        String aux2 = nom + prom;
                        a4 = searchProf(treeAlf3, aux2);
                        setRows(matriz, a4);
                        if(a4.size()==0){
                            JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                        }
                    }else if(aux<60 || aux>100){
                    JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO CON ESE PROMEDIO INTENTELO DE NUEVO");
                }
                }
        }else{
            JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE ALGUN DATO PARA BUSQUEDA");
        }
        searchProf.setText("");
        searchProm.setText("");
        searchNom.setText("");
        a4.clear();
    }//GEN-LAST:event_searchNaPromActionPerformed

    private void searchNaPrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNaPrActionPerformed
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        String prof = getProf();
        String prom = getProm();
        String nom = getNom();
        if(prom.compareTo("")!=0){
            JOptionPane.showMessageDialog(null, "ESTA BUSQUEDA SOLO PERMITE DATOS DE NOMBRE Y PROFESION, INGRESE OTROS DATOS");
        }else if(nom.compareTo("")!=0 || prof.compareTo("")!=0){
                if(nom.length()<=10){
                    JOptionPane.showMessageDialog(null, "EL NOMBRE INTRODUCIDO ES INCORRECTO, POR FAVOR INGRESELO DE NUEVO");
                }else{
                    if(prof.length()<=5){
                        JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS CON ESA PROFESION, POR FAVOR INTENTELO DE NUEVO");
                }else{
                        String aux2 = nom + prof;
                        a4 = searchProf(treeAlf2, aux2);
                        setRows(matriz, a4);
                        if(a4.size()==0){
                            JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                        }
                    }
                }
        }else{
            JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE ALGUN DATO PARA BUSQUEDA");
        }
        searchProf.setText("");
        searchProm.setText("");
        searchNom.setText("");
        a4.clear();
    }//GEN-LAST:event_searchNaPrActionPerformed

    private void searchPromProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPromProfActionPerformed
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        String prof = getProf();
        String prom = getProm();
        String nom = getNom();
        if(nom.compareTo("")!=0){
            JOptionPane.showMessageDialog(null, "ESTA BUSQUEDA SOLO PERMITE DATOS DE PROFESION Y PROMEDIO, INGRESE OTROS DATOS");
        }else if(prof.compareTo("")!=0 || prom.compareTo("")!=0){
                if(prof.length()<=5){
                    JOptionPane.showMessageDialog(null, "LA PROFESION INTRODUCIDA ES INCORRECTA, POR FAVOR INGRESELO DE NUEVO");
                }else{
                    int aux = Integer.parseInt(getProm());
                    if(aux<100){
                        String aux2 = prof + "0" + prom;
                        a4 = searchProf(treeAlf4, aux2);
                        if(a4.size()==0){
                            JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                        }
                        setRows(matriz, a4);
                    }else if(aux==100){
                        String aux2 = prof + prom;
                        a4 = searchProf(treeAlf4, aux2);
                        setRows(matriz, a4);
                        if(a4.size()==0){
                            JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                        }
                    }else if(aux<60 || aux>100){
                    JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO CON ESE PROMEDIO INTENTELO DE NUEVO");
                }
                }
        }else{
            JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE ALGUN DATO PARA BUSQUEDA");
        }
        searchProf.setText("");
        searchProm.setText("");
        searchNom.setText("");
        a4.clear();
    }//GEN-LAST:event_searchPromProfActionPerformed

    private void advSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advSearchActionPerformed
        searchByN.setVisible(false);
        searchByProm.setVisible(false);
        searchByProf.setVisible(false);
        searchNaPr.setVisible(true);
        searchNaProm.setVisible(true);
        searchPromProf.setVisible(true);
        simpleSearch.setVisible(true);
        advSearch.setVisible(false);
    }//GEN-LAST:event_advSearchActionPerformed

    private void simpleSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleSearchActionPerformed
        searchByN.setVisible(true);
        searchByProm.setVisible(true);
        searchByProf.setVisible(true);
        searchNaPr.setVisible(false);
        searchNaProm.setVisible(false);
        searchPromProf.setVisible(false);
        simpleSearch.setVisible(false);
        advSearch.setVisible(true);
    }//GEN-LAST:event_simpleSearchActionPerformed

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
    
    public String getProm(){
        String prom;
        prom = searchProm.getText();
        return prom;
    }
    
    public String getNom(){
        String nom;
        nom = searchNom.getText();
        return nom;
    }
    
    public String getProf(){
        String prof;
        prof = searchProf.getText();
        return prof;
    }
    
    public ArrayList<Integer> searchProm(ArbolNum t, int prom){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        ArrayList<Integer> aux2 = new ArrayList<Integer>();
        aux = t.enOrden();
        aux2 = t.search(prom);
        return aux2;
    }
    
    public ArrayList<Integer> searchProf(ArbolAlfanum t, String prof){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        ArrayList<Integer> aux2 = new ArrayList<Integer>();
        aux2 = t.search(prof);
        System.out.println(aux2);
        return aux2;
    }
    
    public ArrayList<Integer> searchNom(ArbolAlfanum t, String nom){
        ArrayList<Integer> aux2 = new ArrayList<Integer>();
        this.matriz = matriz;
        aux2 = t.searchSequence(matriz, nom);
        return aux2;
    }

    
    public void setData(String[][] m, ArrayList<Integer> i1, ArrayList<Integer> i2, ArrayList<Integer> i3, ArbolNum t1, ArbolAlfanum t2, ArbolAlfanum t3, ArbolAlfanum t4, ArbolAlfanum t5){
        matriz = m;
        a1 = i1;
        a2 = i2;
        a3 = i3;
        treeNum = t1;
        treeAlf1 = t2;
        treeAlf2 = t3;
        treeAlf3 = t4;
        treeAlf4 = t5;
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
}
