/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 *
 * @author Albert
 */
public class Graduates {
    
    final int ARCHIVE_ROWS=626;
    static String[][] dataArray;
    
    /**
     *Analiza y desglosa los datos del archivo seleccionado.
     * @param nameA
     * Recibe un string con la direccion del archivo a analizar.
     * @return
     * Retorna un arreglo con los datos del archivo divididios en tres columnas:
     * Nombre, Profesion, Promedio.
     */
    public String[][] reader(String nameA){
        dataArray = new String[627][3];
        
        Scanner scan = null;
        int row = 0;
        String inputLine = "";
        String file = nameA;
        
        try{
            scan = new Scanner(new BufferedReader(new FileReader(file)));
            
            while(scan.hasNextLine()){
                inputLine = scan.nextLine();
                
                String[] inArray = inputLine.split(",");
                
                for(int i=0; i<inArray.length; i++){
                    dataArray[row][i] = inArray[i];
                }
                row++;
            }
        return dataArray;
        }catch(Exception e){
            System.out.print(e);
            return null;
        }
    }
    
    /**
     *Proporciona una matriz con todos los datos del documento analizado.
     * @return
     * Retorna una matriz con todos los datos del documento analizado.
     */
    public String[][] getMatrix(){
        return dataArray;
    }
    
    /**
     *Escribe la posicion de linea de todos los datos en el arreglo recibido.
     * @param array
     * Recibe un arreglo con todos los datos del archivo analizado.
     * @return
     * Retorna un vector con la posicion en el arreglo de todos los datos del 
     * archivo analizado.
     */
    public int[] getIndex(String[][] array){
        int[] indexArray = new int[ARCHIVE_ROWS];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            indexArray[i]=Integer.parseInt(String.valueOf(i+1));
        }
        return indexArray;
    }
    
    /**
     *Escribe el nombre en cada linea del arreglo recibido.
     * @param array
     * Recibe un arreglo con todos los datos del documento analizado.
     * @return
     * Regresa un vector con todos los nombres en los datos analizados.
     */
    public String[] getName(String[][] array){
        String[] nameData = new String[ARCHIVE_ROWS];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            nameData[i]=dataArray[i+1][0];
        }
        return nameData;
    }
    
    /**
     *Escribe la profesion en cada linea del arreglo recibido.
     * @param array
     * Recibe un arreglo con todos los datos del documento analizado.
     * @return
     * Regresa un vector con todos las profesiones en los datos analizados.
     */
    public String[] getProfession(String[][] array){
        String[] professionData = new String[ARCHIVE_ROWS];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            professionData[i]=dataArray[i+1][1];
        }
        return professionData;
    }
    
    /**
     *Escribe el promedio en cada linea del arreglo recibido.
     * @param array
     * Recibe un arreglo con todos los datos del documento analizado.
     * @return
     * Regresa un vector con todos los promedios en los datos analizados.
     */
    public int[] getAverage(String[][] array){
        int[] averageData = new int[ARCHIVE_ROWS];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            averageData[i]= Integer.parseInt(dataArray[i+1][2]);
        }
        return averageData;
    }    
    
}
