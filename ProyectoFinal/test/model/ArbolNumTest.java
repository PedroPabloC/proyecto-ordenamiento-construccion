/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ArbolNumTest {
    
    public ArbolNumTest() {
    }
    
  
    
    @Test
    public void testEmpty() {
        System.out.println("empty");
        NumericTree arbolPrueba = new NumericTree();
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.empty();
        assertEquals(resultadoEsperado, resultadoVerdadero);
       
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        int numNodo = 27;
        int indexNodo = 1;
        NumericTree arbolPrueba = new NumericTree();
        arbolPrueba.insert(numNodo, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.exist(numNodo);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

   
     
    @Test
    public void testExiste() {
        System.out.println("existe");
        int numNodo = 220;
        int indexNodo = 1;
        NumericTree arbolPrueba = new NumericTree();
        arbolPrueba.insert(numNodo, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.exist(numNodo);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

    
     
    @Test
    public void testEnOrden() {
        System.out.println("enOrden");
        NumericTree arbolPrueba = new NumericTree();
        arbolPrueba.insert(11, 0);
        arbolPrueba.insert(12, 1);
        ArrayList<Integer> resultadoVerdadero = arbolPrueba.inOrder();
        ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
        resultadoEsperado.add(0);
        resultadoEsperado.add(1);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }
    
}
