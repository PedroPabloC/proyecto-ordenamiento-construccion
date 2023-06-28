/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.ArbolAlfanum;
import model.ArbolNum;
import vista.mainView;


/**
 *
 * @author a14004103
 */
public class ControllerMainView implements ActionListener{
    mainView view;
    
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

    
        public void setModel(){
        String[] header1 ={"Nombre", "Profesion", "Promedio"};
        mT.setColumnIdentifiers(header1);
        JTable lista=view.getLista();
        lista.setModel(mT);
        view.setLista(lista);
        //lista.setModel(mT);
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
    
    public ControllerMainView(mainView view){
        this.view=view;
        this.view.getAdvSearch().addActionListener(this);
        this.view.getFilNomb().addActionListener(this);
        this.view.getFilProm().addActionListener(this);
        this.view.getFiltProf().addActionListener(this);
        this.view.getSearchByN().addActionListener(this);
        this.view.getSearchByProf().addActionListener(this);
        this.view.getSearchByProm().addActionListener(this);
        this.view.getSearchNaPr().addActionListener(this);
        this.view.getSearchNaProm().addActionListener(this);
        this.view.getSearchPromProf().addActionListener(this);
        this.view.getSimpleSearch().addActionListener(this);
        this.setModel();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.getAdvSearch()==e.getSource()){
            view.setSearchByN(false);
            view.setSearchByProm(false);
            view.setSearchByProf(false);
            view.setSearchNaPr(true);
            view.setSearchNaProm(true);
            view.setSearchPromProf(true);
            view.setSimpleSearch(true);
            view.setAdvSearch(false);            
        }
        if(view.getFilNomb()==e.getSource()){
            setRows(matriz, a1);
        }
        if(view.getFilProm()==e.getSource()){
            setRows(matriz, a3);
        }
        if(view.getFiltProf()==e.getSource()){
            setRows(matriz, a2);  
        }
        if(view.getSearchByN()==e.getSource()){
            ArrayList<Integer> a4 = new ArrayList<Integer>();
            String nom = getNom();
            if(nom.compareTo("")!=0){
                        a4 = searchNom(treeAlf1, nom);
                        setRows(matriz, a4);
                        if(a4.size()==0){
                                JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                    }
            }else{
                JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE UN DATO PARA SU BUSQUEDA");
            }
            view.setSearchNom("");
            a4.clear();
        }
        if(view.getSearchByProf()==e.getSource()){
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
            view.setSearchProf("");
            a4.clear();
        }

        if(view.getSearchByProm()==e.getSource()){
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

            view.setSearchProm("");
            a4.clear();
        }
        if(view.getSearchNaPr()==e.getSource()){
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
            view.setSearchProf("");
            view.setSearchProm("");
            view.setSearchNom("");
            a4.clear();
        }
        if(view.getSearchNaProm()==e.getSource()){
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
            view.setSearchProf("");
            view.setSearchProm("");
            view.setSearchNom("");
            a4.clear();
        }
        if(view.getSearchPromProf()==e.getSource()){
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
            view.setSearchProf("");
            view.setSearchProm("");
            view.setSearchNom("");
            a4.clear();
        }
        if(view.getSimpleSearch()==e.getSource()){
            view.setSearchByN(true);
            view.setSearchByProm(true);
            view.setSearchByProf(true);
            view.setSearchNaPr(false);
            view.setSearchNaProm(false);
            view.setSearchPromProf(false);
            view.setSimpleSearch(false);
            view.setAdvSearch(true);
        }
    }
    
    public String getProm(){
        String prom;
        prom = view.getSearchProm().getText();
        return prom;
    }
    
    public String getNom(){
        String nom;
        nom = view.getSearchNom().getText();
        return nom;
    }
    
    public String getProf(){
        String prof;
        prof = view.getSearchProf().getText();
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
    
}