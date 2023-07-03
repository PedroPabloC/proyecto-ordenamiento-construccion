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
    
    public void clearTable(){
        setModel();
            int rows=mT.getRowCount();
            for (int i = 0;rows>i; i++) {
                mT.removeRow(0);
            }
    }
    
    public ControllerMainView(MainView view){
        this.view=view;
        this.view.getBfilterByName().addActionListener(this);
        this.view.getBsearch().addActionListener(this);        
        this.setModel();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(view.getBsearch()==e.getSource()){
            search();
        }
        
        if(view.getBfilterByName()==e.getSource()){
            setRows(dataMatrix, nameIndex);
        }
    }
    
    public ArrayList<Integer> searchAverage(NumericTree averageTree, int average1,int average2,int simbolo){
        ArrayList<Integer> temporalAverageList = new ArrayList<Integer>();
        ArrayList<Integer> averageSearchResult = new ArrayList<Integer>();
        temporalAverageList = averageTree.enOrden();
        averageSearchResult = averageTree.search(average1,average2,simbolo,dataMatrix,averageIndex);
        
        return averageSearchResult;
    }
    
    public ArrayList<Integer> searchProfession(AlfanumericTree professionTree, String profession){
        ArrayList<Integer> professionSearchResult = new ArrayList<Integer>();
        professionSearchResult = professionTree.search(profession);
        return professionSearchResult;
    }
    
    public ArrayList<Integer> searchName(AlfanumericTree professionTree, String name){
        ArrayList<Integer> nameSearchResult = new ArrayList<Integer>();
        nameSearchResult.clear();
        nameSearchResult = professionTree.searchSequence(dataMatrix, name);
        return nameSearchResult;
    }
    
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
                    JOptionPane.showMessageDialog(null, "NO ESXTTEN COINCIDENCIAS DE REGISTRO, INTENTELOS NUEVAMENTE");
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
  
    public void setData(String[][] dataMatrix, ArrayList<Integer> nameIndex, ArrayList<Integer> averageIndex, NumericTree averageTree, AlfanumericTree professionTree){
        this.dataMatrix = dataMatrix;
        this.nameIndex = nameIndex;
        this.averageIndex = averageIndex;
        this.averageTree = averageTree;
        this.professionTree = professionTree;
    }
    
}