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
        ArbolAlfanum arbolPrueba = new ArbolAlfanum();
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
        ArbolAlfanum arbolPrueba = new ArbolAlfanum();
        arbolPrueba.insertar(pruebaString, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.existe(pruebaString);
        assertEquals(resultadoEsperado, resultadoVerdadero);
    }

    /**
     * Test of enOrden method, of class ArbolAlfanum.
     */
    @Test
    public void testEnOrden() {
        System.out.println("enOrden");
        ArbolAlfanum arbolPrueba = new ArbolAlfanum();
        arbolPrueba.insertar("example1", 0);
        arbolPrueba.insertar("example2", 1);
        ArrayList<Integer> resultadoVerdadero = arbolPrueba.enOrden();
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
        ArbolAlfanum arbolPrueba = new ArbolAlfanum();
        arbolPrueba.insertar(pruebaString, indexNodo);
        boolean resultadoEsperado = true;
        boolean resultadoVerdadero = arbolPrueba.existe(pruebaString);
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
        ArbolAlfanum arbolPrueba = new ArbolAlfanum();
        arbolPrueba.insertar(nombrePruebaUno, 0);
        arbolPrueba.insertar(nombrePruebaDos,1);
        arbolPrueba.insertar(nombrePruebaTres, 2);
        arbolPrueba.insertar(nombrePruebaCuatro, 3);
        ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
        resultadoEsperado.add(4);
        ArrayList<Integer> resultadoVerdadero = arbolPrueba.search(nombrePruebaUno);
        assertEquals(resultadoEsperado, resultadoVerdadero);
        
    }
}
