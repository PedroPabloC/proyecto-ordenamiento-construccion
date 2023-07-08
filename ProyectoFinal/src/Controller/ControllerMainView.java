/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.AlfanumericTree;
import model.NumericTree;
import view.MainView;


/**
 *
 * @author a14004103
 */
public class ControllerMainView implements ActionListener{
    MainView view;
    
    private String[][] dataMatrix = new String[626][3];    
    DefaultTableModel mT = new DefaultTableModel();
    private ArrayList<Integer> nameIndex = new ArrayList<Integer>();
    private ArrayList<Integer> averageIndex = new ArrayList<Integer>();
    private NumericTree averageTree = new NumericTree();
    private AlfanumericTree professionTree = new AlfanumericTree();


    public void setModel(){
        String[] header1 ={"Nombre", "Profesion", "Promedio"};
        mT.setColumnIdentifiers(header1);
        JTable list=view.getList();
        list.setModel(mT);
        view.setList(list);
    }
    
    /**
     *
     * Crea y llena filas de una tabla con los datos seleccionados.
     * @param dataMatrix
     * Matriz con toda la informacion del documento leido.
     * @param finalResult
     * Vector con las filas que coinciden con los requisitos de la busqueda.
     */
    public void setRows(String[][] dataMatrix, ArrayList<Integer> finalResult){
        clearTable();
        
        String[][] data=dataMatrix;
        ArrayList<Integer> result=finalResult;
        
        mT.setRowCount(result.size());
        mT.setColumnCount(3);
        
        for(int i=0; i<result.size(); i++){
            for(int j=0; j<3; j++){
                mT.setValueAt(data[result.get(i)][j], i, j);
            }
        }
    }

    /**
     *Remueve los datos de una tabla
     */
    public void clearTable(){
        setModel();
            int rows=mT.getRowCount();
            for (int i = 0;rows>i; i++) {
                mT.removeRow(0);
            }
    }
    
    /** 
     *Recibe un objeto MainView y lo personaliza aplicando funcionalidad.
     * @param view
     * Recibe un objeto MainView.
     */
    public ControllerMainView(MainView view){
        this.view=view;
        this.view.getBfilterByName().addActionListener(this);
        this.view.getBsearch().addActionListener(this);        
        this.setModel();
    }

    /**
     *Detecta cual de los botones ha sido presionado a partir de un listener.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(view.getBsearch()==e.getSource()){
            search();
        }
        
        if(view.getBfilterByName()==e.getSource()){
            setRows(dataMatrix, nameIndex);
        }
    }
    
    /**
     *Busca coincidencias definidas por un simbolo entre una lista de datos y
     * 1 o 2 parametros. Si solo un parametro es introducido el segundo parame
     * tro es 0.
     * @param averageTree
     * Recibe un arbol con los datos ordenados por promedio.
     * @param average1
     * Recibe el primer parametro a comparar.
     * @param average2
     * Recibe el segundo parametro a comparar.
     * @param simbolo
     * Recibe un entero representando una de 4 condiciones para declarar coinci-
     * dencia entre parametros y datos.
     * @return
     * Retorna un vector con las posiciones en tabla de todas las coincidencias.
     */
    public ArrayList<Integer> searchAverage(NumericTree averageTree, int average1,int average2,int simbolo){
        ArrayList<Integer> temporalAverageList = new ArrayList<Integer>();
        ArrayList<Integer> averageSearchResult = new ArrayList<Integer>();
        temporalAverageList = averageTree.inOrder();
        averageSearchResult = averageTree.search(average1,average2,simbolo,dataMatrix,averageIndex);
        
        return averageSearchResult;
    }
    
    /**
     *Busca coincidencias entre la profesion introducida y las profesiones en el
     * arbol de datos.
     * @param professionTree
     * Recibe un arbol con los datos ordenados por profesion.
     * @param profession
     * Recibe el parametro con una profesion a comparar.
     * @return
     * Retorna un vector con las posiciones en tabla de todas las coincidencias.
     */
    public ArrayList<Integer> searchProfession(AlfanumericTree professionTree, String profession){
        ArrayList<Integer> professionSearchResult = new ArrayList<Integer>();
        professionSearchResult = professionTree.search(profession);
        return professionSearchResult;
    }
    
    /**
     *Busca coincidencias entre el nombre o letra introducidas y la primera 
     * letra o los nombres en el arreglo de datos y los ordena por profesion.
     * @param professionTree
     * Recibe un arbol con los datos ordenados por profesion.
     * @param name
     * Recibe el parametro con un nombre o letra a comparar.
     * @return
     * Retorna un vector con las posiciones en tabla de todas las coincidencias.
     */
    public ArrayList<Integer> searchName(AlfanumericTree professionTree, String name){
        ArrayList<Integer> nameSearchResult = new ArrayList<Integer>();
        nameSearchResult.clear();
        nameSearchResult = professionTree.searchNameString(dataMatrix, name);
        return nameSearchResult;
    }
    
    /**
     * Busca coincidencias en los datos con dos parametros como condicionales.
     * @param finalResult
     * Recibe un vector con las coincidencias de la primera busqueda.
     * @param professionResult
     * Recibe un vector con las coincidencias de la segunda busqueda.
     * @return 
     * Retorna un vector con las posiciones en tabla de la interseccion de resul
     * tados.
     */
    private ArrayList<Integer> JointSearch2Param(ArrayList<Integer> finalResult,ArrayList<Integer> professionResult){
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> nameList = new ArrayList<Integer>();
        ArrayList<Integer> professionList = new ArrayList<Integer>();
        
        nameList=finalResult;
        professionList=professionResult;
        
        for(int i=0;i<nameList.size();i++){
            for(int j=0;j<professionList.size();j++){
                if(nameList.get(i).equals(professionList.get(j))){
                    result.add(nameList.get(i));
                }
            }
        }        
        return result;
    }
    
    /**
     * Busca coincidencias en los datos con cuatro parametros como condicionales.
     * @param finalResult
     * Recibe un vector con las coincidencias de la primera busqueda.
     * @param averageResult
     * Retorna un vector con las posiciones en tabla de la interseccion de resul
     * tados.
     * @return 
     * Retorna un vector con las posiciones en tabla de la interseccion de resul
     * tados.
     */
    private ArrayList<Integer> JointSearch4Param(ArrayList<Integer> finalResult,ArrayList<Integer> averageResult){
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> result2ParamList = new ArrayList<Integer>();
        ArrayList<Integer> averageList = new ArrayList<Integer>();
        
        result2ParamList=finalResult;
        averageList=averageResult;
        
        for(int i=0;i<result2ParamList.size();i++){
            for(int j=0;j<averageList.size();j++){
                if(result2ParamList.get(i).equals(averageList.get(j))){
                    result.add(result2ParamList.get(i));
                }
            }
        }
                                
        return result;
    }
    
    /**
     *Valida los datos introducidos y maneja que tipo de busquedas que se haran 
     * con dichos datos.
     */
    public void search(){
        String average1=view.getFsearchAverage1().getText();
        String average2=view.getFsearchAverage2().getText();
        String profession= view.getFsearchProfession().getText();
        String name=view.getFsearchName().getText();
        int symbol=view.getCBrangos();
        ArrayList<Integer> finalResult = new ArrayList<Integer>();
        ArrayList<Integer> professionResult = new ArrayList<Integer>();
        ArrayList<Integer> averageResult = new ArrayList<Integer>();
        if(name.compareTo("")!=0){                        
            finalResult = searchName(professionTree, name);
            if(finalResult.size()==0){
                    JOptionPane.showMessageDialog(null, "NO EXISTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
            }           
        }
        if(profession.compareTo("")!=0){
            if(profession.length()<=5){
                JOptionPane.showMessageDialog(null, "LA PROFESION BUSCADA NO SE ENCUENTRA, PORFAVOR INTENTE OTRA O ESCRIBA NUEVAMENTE SU BUSQUEDA");
            }else{                        
                professionResult = searchProfession(professionTree, profession);
                if(finalResult.size()==0){
                    finalResult=professionResult;                                                        
                }else{                                                        
                    finalResult=JointSearch2Param(finalResult,professionResult);
                }
                if(finalResult.size()==0){
                        JOptionPane.showMessageDialog(null, "LA PROFESION BUSCADA NO SE ENCUENTRA");
                }

            }            
        }
        if(average1.compareTo("")!=0){                        
            int numericAverage = Integer.parseInt(average1);
            if(numericAverage<60 || numericAverage>100){
                JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS CON ESE PROMEDIO");
            }
            else{
                if(symbol!=3){
                    averageResult = searchAverage(averageTree, numericAverage, 0, symbol);                    
                    if(finalResult.isEmpty()){
                        finalResult=averageResult;                                                        
                    }else{                                                        
                        finalResult=JointSearch4Param(finalResult,averageResult);
                    }
                }else if(average2.compareTo("")==0&&symbol==3){
                    JOptionPane.showMessageDialog(null, "Escribe un numero valido en el segundo promedio");
                }
                else{
                    averageResult = searchAverage(averageTree, numericAverage, Integer.parseInt(average2), symbol);                                     
                    if(finalResult.isEmpty()){
                        finalResult=averageResult;                                                        
                    }else{                                                        
                        finalResult=JointSearch4Param(finalResult,averageResult);
                    }
                }                
            }
        }

        setRows(dataMatrix, finalResult);
        view.setFsearchName("");
        view.setFsearchProfession("");
        view.setFsearchAverage1("");
        view.setFsearchAverage2("");
        finalResult.clear();  
        professionResult.clear();
        averageResult.clear();
    }
  
    /**
     *
     * @param dataMatrix
     * Recibe una matriz con todos los datos del documento.
     * @param nameIndex
     * Recibe un vector con la posicion de los datos ordenados por nombre.
     * @param averageIndex
     * Recibe un vector con la posicion de los datos ordenados por promedio.
     * @param averageTree
     * Recibe un objeto NumericTree con los datos ordenados por promedio
     * @param professionTree
     * Recibe un objeto AlfanumericTree con los datos ordenados por profesion.
     */
    public void setData(String[][] dataMatrix, ArrayList<Integer> nameIndex, ArrayList<Integer> averageIndex, NumericTree averageTree, AlfanumericTree professionTree){
        this.dataMatrix = dataMatrix;
        this.nameIndex = nameIndex;
        this.averageIndex = averageIndex;
        this.averageTree = averageTree;
        this.professionTree = professionTree;
    }
    
}