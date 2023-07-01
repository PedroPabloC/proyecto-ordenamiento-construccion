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
public class ArbolNum {
    
    private static ArrayList<Integer> arr = new ArrayList<Integer>();
    private static ArrayList<Integer> s1 = new ArrayList<Integer>();
   private ArrayList<Integer> s2 = new ArrayList<Integer>();
    private class nodoArbolNum{
        private ArbolNum right;
        private ArbolNum left;
        private int num;
        private int index;
        private boolean repetido;
        private ArrayList<Integer> nums = new ArrayList<Integer>();
        private ArrayList<Integer> s1 = new ArrayList<Integer>();
        
        private void nodoArbolNum(){
            right = null;
            left = null;
            num = 0;
            index = 0;
            nums = null;
            s1 = null;
            repetido = false;
        }
    }
    
    public nodoArbolNum raiz;
    
    public void Arbol(){
        nodoArbolNum raiz = new nodoArbolNum();
    }
    
    public boolean empty(){
        if(raiz==null){
            return true;
        }
        return false;
    }
    
    public void insertar(int a, int ind){
        if(empty()){
            nodoArbolNum nuevo = new nodoArbolNum();
            nuevo.num = a;
            nuevo.index = ind;
            nuevo.right = new ArbolNum();
            nuevo.left = new ArbolNum();
            raiz = nuevo;
        }else{
            if(a>raiz.num){
                (raiz.right).insertar(a,ind);
            }
            if(a==raiz.num){
                raiz.repetido = true;
                raiz.nums.add(ind);
            }
            if(a<raiz.num){
                (raiz.left).insertar(a, ind);
            }
        }
    }
    
    public boolean existe(int a){
        if(!empty()){
            if(raiz.num==a){
                return true;
            }else{
                raiz.left.search(a);
                raiz.right.search(a);
            }
        }
        return false;
    }
    
    public ArrayList<Integer> enOrden(){
        if(!empty()){
            raiz.left.enOrden();
            if(raiz.repetido==true){
                for(int i=0; i<raiz.nums.size(); i++){
                    arr.add(raiz.nums.get(i));
                }
            }else{
                arr.add(raiz.index);
            }
            raiz.right.enOrden();
        }
        return arr;
    }    
    
    public ArrayList<Integer> search(int a){
        if(!empty()){
            if(raiz.num==a){
                if(raiz.repetido==true){
                    for(int i=0; i<raiz.nums.size();i++){
                        s1.add(raiz.nums.get(i));
                    }
                }
            }else{
                raiz.left.search(a);
                raiz.right.search(a);
            }
        }                
        return s1;
    }
    
    public ArrayList<Integer> search(int a,int b,int simbolo,String[][] matriz,ArrayList<Integer> a3){
        s1.clear();
        s2.clear();
        switch(simbolo) {
            case 0:
                System.out.println("caso0");
                for(int i=0;i<626;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])<=a){
                        s2.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                return s2;
            case 1:   
                System.out.println("caso1");
                for(int i=584;i>-1;i--){
                    if(Integer.parseInt(matriz[a3.get(i)][2])>=a){
                        s2.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                return s2;                
            case 2:
                System.out.println("case2");                
                for(int i=0;i<584;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])==a){
                        s2.add(a3.get(i));
                    }
                }
                return s2;
            case 3:  
                System.out.println("case3");
                ArrayList<Integer> s3 = new ArrayList<Integer>();
                
                for(int i=0;i<626;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])<=b){
                        s2.add(a3.get(i));
                    }else{
                        break;
                    }
                }

                for(int i=584;i>-1;i--){
                    if(Integer.parseInt(matriz[a3.get(i)][2])>=a){
                        s1.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                
                for(int i=0;i<s2.size();i++){
                    for(int j=0;j<s1.size();j++){
                        if(s2.get(i)==s1.get(j)){
                            s3.add(s2.get(i));
                        }
                    }                    
                }
                return s3;
            default:
              return s2;
        }
    }

}
