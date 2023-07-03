/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Albert
 */
public class Graduates {
    
    private BufferedReader lector;
    private String line;
    static String[][] array;
    
    public String[][] lector(String nombreA){
        array = new String[627][3];
        
        Scanner scan = null;
        int filC = 0;
        int fil = 0;
        int colC = 0;
        int col = 0;
        String[] index = new String[627];
        String inputLine = "";
        String file = nombreA;
        
        try{
            scan = new Scanner(new BufferedReader(new FileReader(file)));
            
            while(scan.hasNextLine()){
                inputLine = scan.nextLine();
                
                String[] inArray = inputLine.split(",");
                
                for(int x=0; x<inArray.length; x++){
                    array[filC][x] = inArray[x];
                }
                filC++;
            }
        return array;
        }catch(Exception e){
            System.out.print(e);
            return null;
        }
    }
    
    public String[][] getMatriz(){
        return array;
    }
    
    public int[] getIndex(String[][] array){
        int[] aux = new int[626];
        
        for(int i=0; i<array.length-1; i++){
            aux[i]=Integer.parseInt(String.valueOf(i+1));
        }
        return aux;
    }
    
    public String[] getNombre(String[][] array){
        String[] aux = new String[626];
        
        for(int i=0; i<array.length-1; i++){
            aux[i]=array[i+1][0];
        }
        return aux;
    }
    
    public String[] getProfesion(String[][] array){
        String[] aux = new String[626];
        
        for(int i=0; i<array.length-1; i++){
            aux[i]=array[i+1][1];
        }
        return aux;
    }
    
    public int[] getPromedio(String[][] array){
        int[] aux = new int[626];
        for(int i=0; i<array.length-1; i++){
            aux[i]= Integer.parseInt(array[i+1][2]);
        }
        return aux;
    }
    
    public String[] getnombProf(String[][] array){
        String[] aux = new String[626];
        for(int i=0; i<array.length-1; i++){
            aux[i]=array[i+1][0] + array[i+1][1];
        }
        return aux;
    }
    
    public String[] getnombProm(String[][] array){
        String[] aux = new String[626];
        String aux2;
        int aux3;
        for(int i=0; i<array.length-1; i++){
            aux2 = array[i+1][2];
            aux3 = Integer.parseInt(aux2);
            if(aux3<10){
                aux[i]=array[i+1][0]  + "00" + array[i+1][2];
            }else if(aux3<100){
                aux[i]=array[i+1][0]  + "0" + array[i+1][2];
            }else{
                aux[i]=array[i+1][0]  + array[i+1][2];
            }
        }
        return aux;
    }
    
    public String[] getprofProm(String[][] array){
        String[] aux = new String[626];
        String aux2;
        int aux3;
        for(int i=0; i<array.length-1; i++){
            aux2 = array[i+1][2];
            aux3 = Integer.parseInt(aux2);
            if(aux3<10){
                aux[i]=array[i+1][1]  + "00" + array[i+1][2];
            }else if(aux3<100){
                aux[i]=array[i+1][1]  + "0" + array[i+1][2];
            }else{
                aux[i]=array[i+1][1]  + array[i+1][2];
            }
        }
        return aux;
    }
    
}
