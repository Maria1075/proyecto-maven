/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion03.arraydinamico;
import java.util.Arrays;

/**
 * Representa una lista de valores enteros que puede crecer y disminuir.
 * @param <T>
 */
public class ArrayDinamico<T> {
    
    private T[] elementos;  
    private int numElementos;

    
    public ArrayDinamico() {
		super();
		elementos = (T[]) new Object[10];
		numElementos=0;
	}
    
	/**
     * Devuelve el elemento en un índice dado en el array. 
     * Lanza ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public T obtener(int indice) {
        if (indice < 0 || indice >= numElementos)
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        return elementos[indice];
    }
    
    /**
     * Establece el valor del elemento del array en un índice dado. 
     * Lanza ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public void establecer(int indice, T elemento) {
        if (indice < 0 || indice >= numElementos)
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        elementos[indice] = elemento;
    }
    
    /**
     * Devuelve la cantidad de elementos actualmente en el array.
     */
    public int capacidad() {
        return numElementos;
    }
    
    /**
     * Agrega un nuevo elemento al final del array. El tamaño aumenta en uno.
     */
    public void agregar(T elemento) {
    	
    	if (numElementos == elementos.length) {
    	    T[] nuevosElementos = (T[]) new Object[2 * elementos.length];
    	    for (int i = 0; i < elementos.length; i++) {
    	        nuevosElementos[i] = elementos[i];
    	    }
    	    elementos = nuevosElementos;
    	}       
        elementos[numElementos] = elemento;
        numElementos++;
    }
    
    /**
     * Elimina el elemento en un índice dado en el array. El tamaño del array
     * disminuye en uno. Los elementos siguientes al elemento eliminado se mueven
     * una posición hacia abajo en el array.
     * Lanza ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public void eliminar(int indice) {
        if (indice < 0 || indice >= numElementos)
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        for (int j = indice + 1; j < numElementos; j++)
            elementos[j - 1] = elementos[j];
        numElementos--;
    }
    
}
