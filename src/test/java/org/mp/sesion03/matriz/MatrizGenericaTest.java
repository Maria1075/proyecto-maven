package org.mp.sesion03.matriz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class MatrizGenericaTest {

    @Test
    public void testSumarMatricesEnteras() {
        MatrizEntera matriz1 = new MatrizEntera(2, 2);
        matriz1.setValor(0, 0, 1);
        matriz1.setValor(0, 1, 2);
        matriz1.setValor(1, 0, 3);
        matriz1.setValor(1, 1, 4);

        MatrizEntera matriz2 = new MatrizEntera(2, 2);
        matriz2.setValor(0, 0, 5);
        matriz2.setValor(0, 1, 6);
        matriz2.setValor(1, 0, 7);
        matriz2.setValor(1, 1, 8);

        MatrizGenerica<?> resultado = matriz1.sumar(matriz2);

        assertEquals(6, resultado.getMatriz()[0][0]);
        assertEquals(8, resultado.getMatriz()[0][1]);
        assertEquals(10, resultado.getMatriz()[1][0]);
        assertEquals(12, resultado.getMatriz()[1][1]);
    }

    @Test
    public void testMultiplicarMatricesEnteras() {
        MatrizEntera matriz1 = new MatrizEntera(2, 2);
        matriz1.setValor(0, 0, 1);
        matriz1.setValor(0, 1, 2);
        matriz1.setValor(1, 0, 3);
        matriz1.setValor(1, 1, 4);

        MatrizEntera matriz2 = new MatrizEntera(2, 2);
        matriz2.setValor(0, 0, 5);
        matriz2.setValor(0, 1, 6);
        matriz2.setValor(1, 0, 7);
        matriz2.setValor(1, 1, 8);

        MatrizGenerica<?>  resultado = matriz1.multiplicar(matriz2);

        //no es necesario intValue() hay conversión automática
        assertEquals(19, resultado.getMatriz()[0][0].intValue());
        assertEquals(22, resultado.getMatriz()[0][1].intValue());
        assertEquals(43, resultado.getMatriz()[1][0].intValue());
        assertEquals(50, resultado.getMatriz()[1][1].intValue());
    }

    @Test
    public void testTransponerMatrizEntera() {
        MatrizEntera matriz = new MatrizEntera(2, 3);
        matriz.setValor(0, 0, 1);
        matriz.setValor(0, 1, 2);
        matriz.setValor(0, 2, 3);
        matriz.setValor(1, 0, 4);
        matriz.setValor(1, 1, 5);
        matriz.setValor(1, 2, 6);
        //System.out.println(matriz);
        MatrizGenerica<?>  resultado = matriz.transponer();
        //System.out.println(resultado);
        assertEquals(1, resultado.getMatriz()[0][0].intValue());
        assertEquals(4, resultado.getMatriz()[0][1].intValue());
        assertEquals(2, resultado.getMatriz()[1][0].intValue());
        assertEquals(5, resultado.getMatriz()[1][1].intValue());
        assertEquals(3, resultado.getMatriz()[2][0].intValue());
        assertEquals(6, resultado.getMatriz()[2][1].intValue());
    }

    @Test
    public void testSumarMatricesDouble() {
        MatrizDouble matriz1 = new MatrizDouble(2, 2);
        matriz1.setValor(0, 0, 1.5);
        matriz1.setValor(0, 1, 2.5);
        matriz1.setValor(1, 0, 3.5);
        matriz1.setValor(1, 1, 4.5);

        MatrizDouble matriz2 = new MatrizDouble(2, 2);
        matriz2.setValor(0, 0, 0.5);
        matriz2.setValor(0, 1, 1.5);
        matriz2.setValor(1, 0, 2.5);
        matriz2.setValor(1, 1, 3.5);

        MatrizGenerica<?> resultado = matriz1.sumar(matriz2);

        assertEquals(2.0, resultado.getMatriz()[0][0].doubleValue(), 0.01);
        assertEquals(4.0, resultado.getMatriz()[0][1].doubleValue(), 0.01);
        assertEquals(6.0, resultado.getMatriz()[1][0].doubleValue(), 0.01);
        assertEquals(8.0, resultado.getMatriz()[1][1].doubleValue(), 0.01);
    }

    @Test
    public void testMultiplicarMatricesDouble() {
        MatrizDouble matriz1 = new MatrizDouble(2, 2);
        matriz1.setValor(0, 0, 1.5);
        matriz1.setValor(0, 1, 2.5);
        matriz1.setValor(1, 0, 3.5);
        matriz1.setValor(1, 1, 4.5);
        //System.out.println(matriz1);
        MatrizDouble matriz2 = new MatrizDouble(2, 2);
        matriz2.setValor(0, 0, 0.5);
        matriz2.setValor(0, 1, 1.5);
        matriz2.setValor(1, 0, 2.5);
        matriz2.setValor(1, 1, 3.5);
        //System.out.println(matriz2);
        MatrizGenerica<?> resultado = matriz1.multiplicar(matriz2);
        //System.out.println(resultado);
        assertEquals(7.0, resultado.getMatriz()[0][0].doubleValue(), 0.01);
        assertEquals(11.0, resultado.getMatriz()[0][1].doubleValue(), 0.01);
        assertEquals(13.0, resultado.getMatriz()[1][0].doubleValue(), 0.01);
        assertEquals(21.0, resultado.getMatriz()[1][1].doubleValue(), 0.01);
    }

    @Test
    public void testTransponerMatrizDouble() {
        MatrizDouble matriz = new MatrizDouble(2, 3);
        matriz.setValor(0, 0, 1.5);
        matriz.setValor(0, 1, 2.5);
        matriz.setValor(0, 2, 3.5);
        matriz.setValor(1, 0, 4.5);
        matriz.setValor(1, 1, 5.5);
        matriz.setValor(1, 2, 6.5);

        MatrizGenerica<?> resultado = matriz.transponer();
        //System.out.println(resultado);
        assertEquals(1.5, resultado.getMatriz()[0][0].doubleValue(), 0.01);
        assertEquals(4.5, resultado.getMatriz()[0][1].doubleValue(), 0.01);
        assertEquals(2.5, resultado.getMatriz()[1][0].doubleValue(), 0.01);
        assertEquals(5.5, resultado.getMatriz()[1][1].doubleValue(), 0.01);
        assertEquals(3.5, resultado.getMatriz()[2][0].doubleValue(), 0.01);
        assertEquals(6.5, resultado.getMatriz()[2][1].doubleValue(), 0.01);
    }
    
    @Test
    public void testSumarMatricesConTamanosDiferentes() {
        MatrizDouble matrizDouble = new MatrizDouble(2, 3);
        MatrizDouble otraMatrizDouble = new MatrizDouble(3, 2);
        try {
            matrizDouble.sumar(otraMatrizDouble);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }

        MatrizEntera matrizEntera = new MatrizEntera(2, 3);
        MatrizEntera otraMatrizEntera = new MatrizEntera(3, 2);
        try {
            matrizEntera.sumar(otraMatrizEntera);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }
    }

    @Test
    public void testMultiplicarMatricesConTamanosIncompatibles() {
        MatrizDouble matrizDouble = new MatrizDouble(2, 3);
        MatrizDouble otraMatrizDouble = new MatrizDouble(1, 4);
        try {
            matrizDouble.multiplicar(otraMatrizDouble);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        MatrizEntera matrizEntera = new MatrizEntera(2, 3);
        MatrizEntera otraMatrizEntera = new MatrizEntera(6, 4);
        try {
            matrizEntera.multiplicar(otraMatrizEntera);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }
    }
    
    @Test
    public void testMultiplicarMatricesConElementosNulos() {
        MatrizDouble matrizDouble = new MatrizDouble(2, 2);
        matrizDouble.setValor(0, 0, 1.0);
        matrizDouble.setValor(0, 1, null);
        matrizDouble.setValor(1, 0, 2.0);
        matrizDouble.setValor(1, 1, 3.0);

        MatrizDouble otraMatrizDouble = new MatrizDouble(2, 2);
        otraMatrizDouble.setValor(0, 0, 4.0);
        otraMatrizDouble.setValor(0, 1, 5.0);
        otraMatrizDouble.setValor(1, 0, null);
        otraMatrizDouble.setValor(1, 1, 6.0);

        try {
            matrizDouble.multiplicar(otraMatrizDouble);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }
    }
}

