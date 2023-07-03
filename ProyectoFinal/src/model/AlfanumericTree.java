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
public class AlfanumericTree {
    
    private static ArrayList<Integer> orderedResult = new ArrayList<Integer>();
    private static ArrayList<Integer> result = new ArrayList<Integer>();
    private static ArrayList<Integer> nameResult = new ArrayList<Integer>();
   
    private class AlfanumericNode{
        private AlfanumericTree right;
        private AlfanumericTree left;
        private String dato;
        private int index;
        private boolean repeated;
        private ArrayList<Integer> nums = new ArrayList<Integer>();
        
    }
    
    public AlfanumericNode root;
    
    public boolean empty(){
        return root==null;
    }
    
    public void insert(String a, int ind){
        if(empty()){
            AlfanumericNode newNode = new AlfanumericNode();
            newNode.dato = a;
            newNode.index = ind;
            newNode.right = new AlfanumericTree();
            newNode.left = new AlfanumericTree();
            root = newNode;
        }else{
            int result = root.dato.compareTo(a);
            if(result>0){
                (root.right).insert(a,ind);
            }
            if(result==0){
                root.repeated = true;
                root.nums.add(ind);
            }
            if(result<0){
                (root.left).insert(a, ind);
            }
        }
    }
    
    public boolean exist(String a){
        boolean exist = false;
        if(!empty()){
            int cmp = root.dato.compareTo(a);
            if(cmp==0){
                exist = true;
                return exist;
            }else{
                root.right.search(a);
                root.left.search(a);
                
            }
        }
        return exist;
    }    
    
    public ArrayList<Integer> inOrder(){
        if(!empty()){
            root.right.inOrder();
            if(root.repeated==true){
                for(int i=0; i<root.nums.size(); i++){
                    orderedResult.add(root.nums.get(i)+1);
                }
            }else{
                orderedResult.add(root.index+1);
            }
            root.left.inOrder();
        }
        return orderedResult;        
    }    
    
    public ArrayList<Integer> search(String a){
        if(!empty()){
            int cmp = root.dato.compareTo(a);
            if(cmp==0){
                if(root.repeated==true){
                    for(int i=0; i<root.nums.size();i++){
                        result.add(root.nums.get(i)+1);
                    }
                }else{
                    result.add(root.index+1);
                }
            }else{
                root.right.search(a);
                root.left.search(a);
                
            }
        }
        return result;
    }
    
    public ArrayList<Integer> searchNameString(String[][] arreglo,String a){
        nameResult.clear();
        if(a.length()>1){
            for(int i = 1; i <627; i++){
                if(arreglo[i][0].contains(a)){
                    nameResult.add(i);
                }
            }
        }else{
            for(int i = 1; i <627; i++){
                if(arreglo[i][0].substring(0, 1).equalsIgnoreCase(a)){
                    nameResult.add(i);
                }
            }
        }
        
       return nameResult;
    }
}
