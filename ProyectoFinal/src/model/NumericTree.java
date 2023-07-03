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
public class NumericTree {
    
    private static ArrayList<Integer> orderedResult = new ArrayList<Integer>();
    private static ArrayList<Integer> treeSearchResult = new ArrayList<Integer>();
    private ArrayList<Integer> averageResult = new ArrayList<Integer>();
   
    private class NumericNode{
        private NumericTree right;
        private NumericTree left;
        private int num;
        private int index;
        private boolean repeated;
        private ArrayList<Integer> nums = new ArrayList<Integer>();
    }
    
    public NumericNode root;    
    
    public boolean empty(){
        return root==null;
    }
    
    public void insert(int a, int ind){
        if(empty()){
            NumericNode nuevo = new NumericNode();
            nuevo.num = a;
            nuevo.index = ind;
            nuevo.right = new NumericTree();
            nuevo.left = new NumericTree();
            root = nuevo;
        }else{
            if(a>root.num){
                (root.right).insert(a,ind);
            }
            if(a==root.num){
                root.repeated = true;
                root.nums.add(ind);
            }
            if(a<root.num){
                (root.left).insert(a, ind);
            }
        }
    }
    
    public boolean exist(int a){
        if(!empty()){
            if(root.num==a){
                return true;
            }else{
                root.left.search(a);
                root.right.search(a);
            }
        }
        return false;
    }
    
    public ArrayList<Integer> inOrder(){
        if(!empty()){
            root.left.inOrder();
            if(root.repeated==true){
                for(int i=0; i<root.nums.size(); i++){
                    orderedResult.add(root.nums.get(i));
                }
            }else{
                orderedResult.add(root.index);
            }
            root.right.inOrder();
        }
        return orderedResult;
    }    
    
    public ArrayList<Integer> search(int a){
        if(!empty()){
            if(root.num==a){
                if(root.repeated==true){
                    for(int i=0; i<root.nums.size();i++){
                        treeSearchResult.add(root.nums.get(i));
                    }
                }
            }else{
                root.left.search(a);
                root.right.search(a);
            }
        }                
        return treeSearchResult;
    }
    
    public ArrayList<Integer> search(int a,int b,int simbolo,String[][] matriz,ArrayList<Integer> a3){
        treeSearchResult.clear();
        averageResult.clear();
        switch(simbolo) {
            case 0:
                System.out.println("caso0");
                for(int i=0;i<626;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])<=a){
                        averageResult.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                return averageResult;
            case 1:   
                System.out.println("caso1");
                for(int i=584;i>-1;i--){
                    if(Integer.parseInt(matriz[a3.get(i)][2])>=a){
                        averageResult.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                return averageResult;                
            case 2:
                System.out.println("case2");                
                for(int i=0;i<584;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])==a){
                        averageResult.add(a3.get(i));
                    }
                }
                return averageResult;
            case 3:  
                System.out.println("case3");
                ArrayList<Integer> s3 = new ArrayList<Integer>();
                
                for(int i=0;i<626;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])<=b){
                        averageResult.add(a3.get(i));
                    }else{
                        break;
                    }
                }

                for(int i=584;i>-1;i--){
                    if(Integer.parseInt(matriz[a3.get(i)][2])>=a){
                        treeSearchResult.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                
                for(int i=0;i<averageResult.size();i++){
                    for(int j=0;j<treeSearchResult.size();j++){
                        if(averageResult.get(i)==treeSearchResult.get(j)){
                            s3.add(averageResult.get(i));
                        }
                    }                    
                }
                return s3;
            default:
              return averageResult;
        }
    }

}
