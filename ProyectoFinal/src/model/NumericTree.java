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
    final int ARCHIVE_ROWS=626;
    final int DATA_ROWS=584;
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
    public void insert(int a, int ind){
        if(empty()){
            NumericNode nuevo = new NumericNode();
            nuevo.right = new NumericTree();
            nuevo.left = new NumericTree();
            nuevo.num = a;
            nuevo.index = ind;                        
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
    
    /**
     *Determina si existe cierto nodo.
     * @param a
     * Recibe el dato del nodo a comprobar.
     * @return
     * Retorna un booleano true si existe y false si no existe.
     */
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
    
    /**
     *Ordena las posiciones de los datos del arreglo por promedio.
     * @return
     * Regresa un vector con las posiciones de los datos del arreglo ordenadas 
     * por promedio.
     */
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
    
    /**
     *Busca en el arbol numerico coincidencias con el parametro recibido.
     * @param a
     * Recibe un entero a buscar en el arbol numerico.
     * @return
     * Regresa un vector con las posiciones de los datos de las coincidencias 
     * con el parametro recibido.
     */
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
    
    /**
     *Busca en el arbol numerico coincidencias con 2 parametros int recibidos.
     * @param a
     * Recibe un parametro tipo int que se buscara en el arbol.
     * @param b
     * Recibe un parametro tipo int que se buscara en el arbol.
     * @param simbolo
     * Recibe un parametro tipo int representando el tipo de coincidencia que se
     * quiere evaluar.
     * @param matriz
     * Recibe un arreglo con todos los datos.
     * @param a3
     * Recibe un vector con los resultados de coincidencias de otras busquedas,
     * si no hay otras busquedas el vector esta vacio.
     * @return
     * Regresa un vector con las posiciones de los datos de las coincidencias 
     * con el parametro recibido.
     */
    public ArrayList<Integer> search(int a,int b,int simbolo,String[][] matriz,ArrayList<Integer> a3){
        treeSearchResult.clear();
        averageResult.clear();
        switch(simbolo) {
            case 0:
                System.out.println("caso0");
                for(int i=0;i<ARCHIVE_ROWS;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])<=a){
                        averageResult.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                return averageResult;
            case 1:   
                System.out.println("caso1");
                for(int i=DATA_ROWS;i>-1;i--){
                    if(Integer.parseInt(matriz[a3.get(i)][2])>=a){
                        averageResult.add(a3.get(i));
                    }else{
                        break;
                    }
                }
                return averageResult;                
            case 2:
                System.out.println("case2");                
                for(int i=0;i<DATA_ROWS;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])==a){
                        averageResult.add(a3.get(i));
                    }
                }
                return averageResult;
            case 3:  
                System.out.println("case3");
                ArrayList<Integer> s3 = new ArrayList<Integer>();
                
                for(int i=0;i<ARCHIVE_ROWS;i++){
                    if(Integer.parseInt(matriz[a3.get(i)][2])<=b){
                        averageResult.add(a3.get(i));
                    }else{
                        break;
                    }
                }

                for(int i=DATA_ROWS;i>-1;i--){
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
