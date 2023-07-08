/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ArbolAlfanumTest {
    
    public ArbolAlfanumTest() {
    }


    /**
     * Test of empty method, of class ArbolAlfanum.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        AlfanumericTree arbolPrueba = new AlfanumericTree();
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.empty();
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

    /**
     * Test of insertar method, of class ArbolAlfanum.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        String pruebaString = "example";
        int indexNodo = 1;
        AlfanumericTree arbolPrueba = new AlfanumericTree();
        arbolPrueba.insert(pruebaString, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.exist(pruebaString);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

    /**
     * Test of enOrden method, of class ArbolAlfanum.
     */
    @Test
    public void testEnOrden() {
        System.out.println("enOrden");
        AlfanumericTree arbolPrueba = new AlfanumericTree();
        arbolPrueba.insert("example1", 0);
        arbolPrueba.insert("example2", 1);
        ArrayList<Integer> resultadoVerdadero = arbolPrueba.inOrder();
        ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
        resultadoEsperado.add(1);
        resultadoEsperado.add(2);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

    /**
     * Test of existe method, of class ArbolAlfanum.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        String pruebaString = "example";
        int indexNodo = 1;
        AlfanumericTree arbolPrueba = new AlfanumericTree();
        arbolPrueba.insert(pruebaString, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.exist(pruebaString);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

    /**
     * Test of search method, of class ArbolAlfanum.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String nombrePruebaUno = "Pedro";
        String nombrePruebaDos = "Carlos";
        String nombrePruebaTres = "Anto";
        String nombrePruebaCuatro = "Pedro";
        AlfanumericTree arbolPrueba = new AlfanumericTree();
        arbolPrueba.insert(nombrePruebaUno, 0);
        arbolPrueba.insert(nombrePruebaDos,1);
        arbolPrueba.insert(nombrePruebaTres, 2);
        arbolPrueba.insert(nombrePruebaCuatro, 3);
        ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
        resultadoEsperado.add(4);
        ArrayList<Integer> resultadoVerdadero = arbolPrueba.search(nombrePruebaUno);
        assertEquals(resultadoEsperado, resultadoVerdadero);
        
    }
}
