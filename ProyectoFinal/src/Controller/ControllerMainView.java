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
        this.view.getFilNomb().addActionListener(this);
        this.view.getSearchByProm().addActionListener(this);
        this.view.getSearch().addActionListener(this);        
        this.setModel();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(view.getSearch()==e.getSource()){
            search();
        }
        
        if(view.getFilNomb()==e.getSource()){
            setRows(matriz, a1);
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
        return aux2;
    }
    
    public ArrayList<Integer> searchNom(ArbolAlfanum t, String nom){
        ArrayList<Integer> aux2 = new ArrayList<Integer>();
        aux2.clear();
        aux2 = t.searchSequence(matriz, nom);
        System.out.println(aux2);
        return aux2;
    }
    
    public void search(){
        String promedio=view.getSearchProm().getText();
        String profesion= view.getSearchProf().getText();;
        String nombre=view.getSearchNom().getText();;
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        ArrayList<Integer> a5 = new ArrayList<Integer>();
        ArrayList<Integer> a6 = new ArrayList<Integer>();
        
        if(nombre.compareTo("")!=0){                        
            a4.clear();
            a4 = searchNom(treeAlf1, nombre);
            if(a4.size()==0){
                    JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
            }           
        }
        if(profesion.compareTo("")!=0){
            if(profesion.length()<=5){
                JOptionPane.showMessageDialog(null, "LA PROFESION BUSCADA NO SE ENCUENTRA, PORFAVOR INTENTE OTRA O ESCRIBA NUEVAMENTE SU BUSQUEDA");
            }else{                        
                a5 = searchProf(treeAlf1, profesion);
                if(a4.size()==0){
                    a4=a5;                                                        
                }else{                                                        
                    for(int i=0;i<a4.size();i++){
                        for(int j=0;j<a5.size();j++){
                            if(a4.get(i).equals(a5.get(j))){
                                a6.add(a4.get(i));
                            }
                        }
                    }
                    a4=a6;
                }
                if(a4.size()==0){
                        JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
                }

            }            
        }
        if(promedio.compareTo("")!=0){
            String prom = getProm();
            if(prom.compareTo("")!=0){
                    int aux = Integer.parseInt(getProm());
                    if(aux<60 || aux>100){
                        JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS CON ESE PROMEDIO");
                    }else if(treeNum.existe(aux)){
                        JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS CON ESE PROMEDIO");
                    }else{
                        a4 = searchProm(treeNum, aux);
                        //setRows(matriz, a4);
                    }
                }else{
                JOptionPane.showMessageDialog(null, "LOS CAMPOS ESTAN VACIOS AGREGUE UN DATO PARA SU BUSQUEDA");
            }
        }
        setRows(matriz, a4);
        view.setSearchNom("");
        view.setSearchProf("");
        view.setSearchProm("");
        a4.clear();  
        a5.clear();
        a6.clear();
        
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