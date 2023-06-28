/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Albert
 */
public class ArbolAlfanum {
    
    private static ArrayList<Integer> arr = new ArrayList<Integer>();
    private static ArrayList<Integer> s1 = new ArrayList<Integer>();
    private static ArrayList<Integer> s2 = new ArrayList<Integer>();
   
    private class nodoArbolAlfanum{
        private ArbolAlfanum right;
        private ArbolAlfanum left;
        private String dato;
        private int index;
        private boolean repetido;
        private ArrayList<Integer> nums = new ArrayList<Integer>();
        
        private void nodoArbolAlfanum(){
            right = null;
            left = null;
            dato = null;
            index = 0;
            nums = null;
            repetido = false;
        }
    }
    
    public nodoArbolAlfanum raiz;
    
    public void Arbol(){
        nodoArbolAlfanum raiz = new nodoArbolAlfanum();
    }
    
    public boolean empty(){
        if(raiz==null){
            return true;
        }
        return false;
    }
    
    public void insertar(String a, int ind){
        if(empty()){
            nodoArbolAlfanum nuevo = new nodoArbolAlfanum();
            nuevo.dato = a;
            nuevo.index = ind;
            nuevo.right = new ArbolAlfanum();
            nuevo.left = new ArbolAlfanum();
            raiz = nuevo;
        }else{
            int cmp = raiz.dato.compareTo(a);
            if(cmp>0){
                (raiz.right).insertar(a,ind);
            }
            if(cmp==0){
                raiz.repetido = true;
                raiz.nums.add(ind);
            }
            if(cmp<0){
                (raiz.left).insertar(a, ind);
            }
        }
    }
    
    public ArrayList<Integer> enOrden(){
        if(!empty()){
            raiz.right.enOrden();
            if(raiz.repetido==true){
                for(int i=0; i<raiz.nums.size(); i++){
                    arr.add(raiz.nums.get(i)+1);
                }
            }else{
                arr.add(raiz.index+1);
            }
            raiz.left.enOrden();
        }
        return arr;
    }
    
    public boolean existe(String a){
        boolean exist = false;
        if(!empty()){
            int cmp = raiz.dato.compareTo(a);
            if(cmp==0){
                exist = true;
                return exist;
            }else{
                raiz.right.search(a);
                raiz.left.search(a);
                
            }
        }
        return exist;
    }
    
    public ArrayList<Integer> search(String a){
        if(!empty()){
            int cmp = raiz.dato.compareTo(a);
            if(cmp==0){
                if(raiz.repetido==true){
                    for(int i=0; i<raiz.nums.size();i++){
                        s1.add(raiz.nums.get(i)+1);
                    }
                }else{
                    s1.add(raiz.index+1);
                }
            }else{
                raiz.right.search(a);
                raiz.left.search(a);
                
            }
        }
        return s1;
    }
    
    public ArrayList<Integer> searchSequence(String[][] arreglo,String a){
        if(a.length()>1){
            for(int i = 1; i <627; i++){
                if(arreglo[i][0].contains(a)){
                    s2.add(i);
                    //break;
                }
            }
        }else{
            for(int i = 1; i <627; i++){
                if(arreglo[i][0].substring(0, 1).equalsIgnoreCase(a)){
                    s2.add(i);
                    //break;
                }
            }
        }
        
       return s2;
    }
}
