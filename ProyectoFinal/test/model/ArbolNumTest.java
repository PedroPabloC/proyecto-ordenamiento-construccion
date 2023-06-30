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
        ArbolNum arbolPrueba = new ArbolNum();
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.empty();
        assertEquals(resultadoEsperado, resultadoVerdadero);
       
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        int numNodo = 27;
        int indexNodo = 1;
        ArbolNum arbolPrueba = new ArbolNum();
        arbolPrueba.insertar(numNodo, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.existe(numNodo);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

   
     
    @Test
    public void testExiste() {
        System.out.println("existe");
        int numNodo = 220;
        int indexNodo = 1;
        ArbolNum arbolPrueba = new ArbolNum();
        arbolPrueba.insertar(numNodo, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.existe(numNodo);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

    
     
    @Test
    public void testEnOrden() {
        System.out.println("enOrden");
        ArbolNum arbolPrueba = new ArbolNum();
        arbolPrueba.insertar(11, 0);
        arbolPrueba.insertar(12, 1);
        ArrayList<Integer> resultadoVerdadero = arbolPrueba.enOrden();
        ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
        resultadoEsperado.add(0);
        resultadoEsperado.add(1);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }
    
}
