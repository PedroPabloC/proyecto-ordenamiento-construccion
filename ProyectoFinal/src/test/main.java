/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import view.MainView;
import Controller.ControllerMainView;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author Albert
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainView view = new MainView();
        view.setVisible(true);
        String[][] matriz = new String[627][3];
        String[][] dataMatrix = new String[626][3];
        String[] nombre = new String[626];
        String[] prof = new String[626];
        int[] prom = new int[626];
        int[] index = new int[626];
        ArrayList<Integer> nameIndex = new ArrayList<Integer>();
        ArrayList<Integer> averageIndex = new ArrayList<Integer>();
        Graduates reader = new Graduates();
        NumericTree averageTree = new NumericTree();
        AlfanumericTree professionTree = new AlfanumericTree();
        
        matriz = reader.reader("D:\\Documentos\\NetBeansProjects\\proyecto-ordenamiento-construccion\\ProyectoFinal\\Egresados.csv");
        
        dataMatrix = reader.getMatrix();
        index = reader.getIndex(matriz);
        nombre = reader.getName(matriz);
        prof = reader.getProfession(matriz);
        prom = reader.getAverage(matriz);
        
        for(int i=0; i<nombre.length; i++){
            nameIndex.add(index[i]);
        }
        
        ControllerMainView controller=new ControllerMainView(view);
        controller.setRows(dataMatrix,nameIndex);
        
        for(int i=0; i<prom.length; i++){
            averageTree.insert(prom[i], index[i]);
        }
        
        for(int i=0; i<prof.length; i++){
            professionTree.insert(prof[i], i);
        }        
        
        averageIndex = averageTree.inOrder();
                               
        controller.setData(dataMatrix, nameIndex, averageIndex, averageTree, professionTree);
        
    }
    
}
