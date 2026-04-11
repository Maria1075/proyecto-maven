/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion03.matriz;

import java.util.Arrays;
/**
 * {@code MatrizEnteros}: Representa una matriz de números enteros y ofrece operaciones básicas.
 * Permite sumar, multiplicar y transponer matrices de enteros.
 *
 * @author Maria Camila Soto Zapata
 * @since 2025
 */
public class MatrizEnteros {
    private int[][] matriz;
    /**
     * Constructor: Inicializa una nueva matriz de enteros con las dimensiones especificadas.
     * @param filas Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     */
    public MatrizEnteros(int filas, int columnas) {
        matriz = new int[filas][columnas];
    }
    /**
     * Suma esta matriz con otra matriz de enteros.
     * @param otraMatriz La matriz de enteros a sumar. Debe tener las mismas dimensiones.
     * @return Una nueva matriz de enteros que representa la suma de las dos matrices.
     * @throws IllegalArgumentException Si las matrices no tienen el mismo tamaño.
     */
    public MatrizEnteros sumar(MatrizEnteros otraMatriz) {
        if (this.matriz.length != otraMatriz.matriz.length || this.matriz[0].length != otraMatriz.matriz[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño para poder sumarlas.");
        }

        int filas = this.matriz.length;
        int columnas = this.matriz[0].length;
        MatrizEnteros resultado = new MatrizEnteros(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[i][j] = this.matriz[i][j] + otraMatriz.matriz[i][j];
            }
        }

        return resultado;
    }
    /**
     * Multiplica esta matriz con otra matriz de enteros.
     * @param otraMatriz La matriz de enteros por la cual multiplicar. El número de columnas de esta matriz debe ser igual al número de filas de la otra matriz.
     * @return Una nueva matriz de enteros que representa el producto de las dos matrices.
     * @throws IllegalArgumentException Si el número de columnas de la primera matriz no es igual al número de filas de la segunda matriz.
     */
    public MatrizEnteros multiplicar(MatrizEnteros otraMatriz) {
        if (this.matriz[0].length != otraMatriz.matriz.length) {
            throw new IllegalArgumentException("El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz para poder multiplicarlas.");
        }

        int filasA = this.matriz.length;
        int columnasA = this.matriz[0].length;
        int columnasB = otraMatriz.matriz[0].length;

        MatrizEnteros resultado = new MatrizEnteros(filasA, columnasB);

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado.matriz[i][j] += this.matriz[i][k] * otraMatriz.matriz[k][j];
                }
            }
        }

        return resultado;
    }
    /**
     * Calcula la transpuesta de esta matriz de enteros.
     * @return Una nueva matriz de enteros que es la transpuesta de esta matriz.
     */
    public MatrizEnteros transponer() {
        int filas = this.matriz.length;
        int columnas = this.matriz[0].length;
        MatrizEnteros resultado = new MatrizEnteros(columnas, filas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[j][i] = this.matriz[i][j];
            }
        }

        return resultado;
    }
    /**
     * Establece el valor de un elemento en la matriz en la fila y columna especificadas.
     * @param fila El índice de la fila (comenzando desde 0).
     * @param columna El índice de la columna (comenzando desde 0).
     * @param valor El valor entero a establecer.
     */
    public void setValor(int fila, int columna, int valor) {
        matriz[fila][columna] = valor;
    }
    /**
     * Obtiene una copia de la matriz interna.
     * @return Una copia bidimensional del array de enteros que representa la matriz.
     */
    public int[][] getMatriz() {
        return matriz.clone();
    }
    
    
    /**
     * Devuelve una representación en cadena de la matriz.
     * @return Una cadena formateada que muestra los elementos de la matriz.
     */
    @Override
	public String toString() {
    	String salida = "";
    	for (int[] fila : this.matriz) {
            for (int elemento : fila) {
               salida = salida + elemento + "\t";
            }
            salida = salida + "\n";
        }
    	return salida;
	}
    /**
     * Imprime la matriz en la consola.
     */
	public void imprimir() {
        for (int[] fila : this.matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}