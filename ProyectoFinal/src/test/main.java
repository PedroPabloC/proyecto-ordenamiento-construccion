/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.ArrayList;
import model.*;
import vista.*;
/**
 *
 * @author Albert
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainView view = new mainView();
        view.setVisible(true);
        String aux, aux2;
        int aux3, aux4;
        String[][] matriz = new String[627][3];
        String[][] newMat = new String[626][3];
        String[] nombre = new String[626];
        String[] prof = new String[626];
        int[] prom = new int[626];
        int[] index = new int[626];
        ArrayList<Integer> indexNom = new ArrayList<Integer>();
        ArrayList<Integer> indexProf = new ArrayList<Integer>();
        ArrayList<Integer> indexProm = new ArrayList<Integer>();
        ArrayList<Integer> indexNomProm = new ArrayList<Integer>();
        ArrayList<Integer> indexNomProf = new ArrayList<Integer>();
        ArrayList<Integer> indexProfProm = new ArrayList<Integer>();
        String[] nombProf = new String[626];
        String[] nombProm = new String[626];
        String[] profProm = new String[626];
        Egresados reader = new Egresados();
        ArbolNum bNum = new ArbolNum();
        ArbolAlfanum bAlf = new ArbolAlfanum();
        ArbolAlfanum bAlf2 = new ArbolAlfanum();
        ArbolAlfanum bAlf3 = new ArbolAlfanum();
        ArbolAlfanum bAlf4 = new ArbolAlfanum();
        
        matriz = reader.lector("C:\\Users\\Albert\\Documents\\NetBeansProjects\\ProyectoFinal\\Egresados.csv");
        
        newMat = reader.getMatriz();
        index = reader.getIndex(matriz);
        nombre = reader.getNombre(matriz);
        prof = reader.getProfesion(matriz);
        prom = reader.getPromedio(matriz);
        nombProf = reader.getnombProf(matriz);
        nombProm = reader.getnombProm(matriz);
        profProm = reader.getprofProm(matriz);
        
        for(int i=0; i<nombre.length; i++){
            indexNom.add(index[i]);
        }
        
        view.setRows(newMat,indexNom);
        
        for(int i=0; i<prom.length; i++){
            bNum.insertar(prom[i], index[i]);
        }
        
        for(int i=0; i<prof.length; i++){
            bAlf.insertar(prof[i], i);
        }
        
        for(int i=0; i<nombProf.length; i++){
            bAlf2.insertar(nombProf[i], i);
        }
        
        for(int i=0; i<nombProm.length; i++){
            bAlf3.insertar(nombProm[i], i);
        }
        
        for(int i=0; i<profProm.length; i++){
            bAlf4.insertar(profProm[i], i);
        }
        
        indexProf = bAlf.enOrden();
        
        indexProm = bNum.enOrden();
        
        indexNomProf = bAlf2.enOrden();
        
        indexNomProm = bAlf3.enOrden();
        
        indexProfProm = bAlf4.enOrden();
        
        
        
        view.setData(newMat, indexNom, indexProf, indexProm, bNum, bAlf, bAlf2, bAlf3, bAlf4);
        
    }
    
}
