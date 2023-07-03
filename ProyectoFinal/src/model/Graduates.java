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
    
    static String[][] dataArray;
    
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
    
    public String[][] getMatrix(){
        return dataArray;
    }
    
    public int[] getIndex(String[][] array){
        int[] indexArray = new int[626];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            indexArray[i]=Integer.parseInt(String.valueOf(i+1));
        }
        return indexArray;
    }
    
    public String[] getName(String[][] array){
        String[] nameData = new String[626];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            nameData[i]=dataArray[i+1][0];
        }
        return nameData;
    }
    
    public String[] getProfession(String[][] array){
        String[] professionData = new String[626];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            professionData[i]=dataArray[i+1][1];
        }
        return professionData;
    }
    
    public int[] getAverage(String[][] array){
        int[] averageData = new int[626];
        String[][] dataArray=array;
        
        for(int i=0; i<dataArray.length-1; i++){
            averageData[i]= Integer.parseInt(dataArray[i+1][2]);
        }
        return averageData;
    }    
    
}
