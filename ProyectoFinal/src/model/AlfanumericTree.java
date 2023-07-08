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
    
    /**
     *Determina si el nodo del arbol esta vacio.
     * @return
     * Retorna un booleano true si esta vacio y false si no esta vacio.
     */
    public boolean empty(){
        return root==null;
    }
    
    /**
     *Incerta un nuevo dato en el arbol
     * @param a
     * Recibe el dato a insertar
     * @param ind
     * Recibe la posicion del dato a insertar
     */
    public void insert(String a, int ind){
        if(empty()){
            AlfanumericNode newNode = new AlfanumericNode();
            newNode.right = new AlfanumericTree();
            newNode.left = new AlfanumericTree();
            newNode.dato = a;
            newNode.index = ind;                        
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
    
    /**
     *Determina si existe cierto nodo.
     * @param a
     * Recibe el dato del nodo a comprobar.
     * @return
     * Retorna un booleano true si existe y false si no existe.
     */
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
    
    /**
     *Ordena las posiciones de los datos del arreglo por profesion.
     * @return
     */
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
    
    /**
     *Busca en el arbol alfanumerico coincidencias con el parametro recibido.
     * @param a
     * Recibe una cadena a buscar en el arbol alfanumerico.
     * @return
     * Regresa un vector con las posiciones de los datos de las coincidencias 
     * con el parametro recibido.
     */
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
    
    /**
     *Busqueda por letra de nombres en los datos del documento leido.
     * @param arreglo
     * Recibe un arreglo con todos los datos del documento.
     * @param a
     * Recibe una cadena con la letra a buscar.
     * @return
     * Regresa un vector con las posiciones de los datos de las coincidencias 
     * con el parametro recibido.
     */
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
