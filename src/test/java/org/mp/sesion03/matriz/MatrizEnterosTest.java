package org.mp.sesion03.matriz;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class MatrizEnterosTest {

    @Test
    public void testMatrizEnteros() {
        MatrizEnteros m1 = new MatrizEnteros(2, 3);
        MatrizEnteros m2 = new MatrizEnteros(3, 2);
        MatrizEnteros m3 = new MatrizEnteros(2, 3);

        m1.setValor(0, 0, 1);
        m1.setValor(0, 1, 2);
        m1.setValor(0, 2, 3);
        m1.setValor(1, 0, 4);
        m1.setValor(1, 1, 5);
        m1.setValor(1, 2, 6);
        
        m2.setValor(0, 0, 7);
        m2.setValor(0, 1, 8);
        m2.setValor(1, 0, 10);
        m2.setValor(1, 1, 11);
        m2.setValor(2, 0, 8);
        m2.setValor(2, 1, 12);
        
        m3.setValor(0, 0, 1);
        m3.setValor(0, 1, 2);
        m3.setValor(0, 2, 3);
        m3.setValor(1, 0, 4);
        m3.setValor(1, 1, 5);
        m3.setValor(1, 2, 6);
              
        MatrizEnteros sumado = m1.sumar(m3);
        MatrizEnteros multiplicado = m1.multiplicar(m2);
        MatrizEnteros transpuesta = m1.transponer();

        int[][] esperadoSuma = {{2, 4, 6}, {8,10,12}};
        int[][] esperadoMultiplicacion = {{51,66}, {126,159}};
        int[][] esperadoTranspuesta = {{1, 4}, {2, 5}, {3, 6}};

        assertArrayEquals(esperadoSuma, sumado.getMatriz());
        assertArrayEquals(esperadoMultiplicacion, multiplicado.getMatriz());
        assertArrayEquals(esperadoTranspuesta, transpuesta.getMatriz());
    }
    
    @Test
    public void testSumarMatricesConTamanosDiferentes() {
        MatrizEnteros matrizA = new MatrizEnteros(2, 3);
        MatrizEnteros matrizB = new MatrizEnteros(3, 2);

        try {
            matrizA.sumar(matrizB);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }
    }

    @Test
    public void testMultiplicarMatricesConTamanosIncompatibles() {
        MatrizEnteros matrizA = new MatrizEnteros(2, 3);
        MatrizEnteros matrizB = new MatrizEnteros(2, 4);

        try {
            matrizA.multiplicar(matrizB);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }
    }


    
}