/**
 * Clase que implementa distintos algoritmos de búsqueda sobre una colección de datos ordenados.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.busqueda;

import java.util.Arrays;

public class SolucionesBusqueda {

    /**
     * Realiza una búsqueda lineal sobre el arreglo.
     *
     * @param busqueda Objeto que contiene el arreglo y el número a buscar
     * @return Índice del elemento encontrado
     * @throws ElementoNoEncontradoException si el elemento no se encuentra
     */
    public static int busquedaLineal(Busqueda<Integer> busqueda) throws ElementoNoEncontradoException {
        Comparable numBuscado = busqueda.getNumBuscado();
        Comparable[] array = busqueda.getDatos();
        for (int i = 0; i < busqueda.getNumElementos(); i++) {
            if (array[i] == numBuscado) {
                return i;
            }
        }
        throw new ElementoNoEncontradoException("Elemento " + numBuscado + " no encontrado en el array.");
    }

    /**
     * Realiza una búsqueda binaria iterativa sobre el arreglo ordenado.
     *
     * @param busqueda Objeto con el número buscado y los datos
     * @return Índice del elemento encontrado
     * @throws ElementoNoEncontradoException si el elemento no se encuentra
     */
    public static int busquedaBinariaIter(Busqueda<Integer> busqueda) throws ElementoNoEncontradoException {
        Integer numBuscado = busqueda.getNumBuscado();
        Comparable[] array = busqueda.getDatos();
        int izq = 0;
        int der = array.length - 1;

        while (izq <= der) {
            int medio = izq + (der - izq) / 2;

            if (array[medio] == numBuscado)
                return medio;

            if ((int) array[medio] > numBuscado)
                der = medio - 1;
            else
                izq = medio + 1;
        }
        throw new ElementoNoEncontradoException("Elemento " + numBuscado + " no encontrado en el array.");
    }

    /**
     * Inicia una búsqueda binaria recursiva sobre el arreglo ordenado.
     *
     * @param busqueda Objeto con el número buscado y los datos
     * @return Índice del elemento encontrado
     * @throws ElementoNoEncontradoException si el elemento no se encuentra
     */
    public static int busquedaBinariaRec(Busqueda<Integer> busqueda) throws ElementoNoEncontradoException {
        Integer numBuscado = busqueda.getNumBuscado();
        Comparable[] array = busqueda.getDatos();
        int izq = 0;
        int der = array.length - 1;

        if (izq > der)
            throw new ElementoNoEncontradoException("Elemento " + numBuscado + " no encontrado en el array.");

        int medio = izq + (der - izq) / 2;
        if (array[medio] == numBuscado)
            return medio;
        else if ((int) array[medio] > numBuscado)
            return busquedaBinariaRec(busqueda, izq, medio - 1);
        else
            return busquedaBinariaRec(busqueda, medio + 1, der);
    }

    /**
     * Método recursivo auxiliar para búsqueda binaria.
     */
    private static int busquedaBinariaRec(Busqueda<Integer> busqueda, int izq, int der)
            throws ElementoNoEncontradoException {

        Integer numBuscado = busqueda.getNumBuscado();
        Comparable[] array = busqueda.getDatos();

        if (izq > der)
            throw new ElementoNoEncontradoException("Elemento " + numBuscado + " no encontrado en el array.");

        int medio = izq + (der - izq) / 2;

        if (array[medio] == numBuscado)
            return medio;
        else if ((int) array[medio] > numBuscado)
            return busquedaBinariaRec(busqueda, izq, medio - 1);
        else
            return busquedaBinariaRec(busqueda, medio + 1, der);
    }

    /**
     * Utiliza el método built-in de Java Arrays para realizar búsqueda binaria.
     *
     * @param busqueda Objeto que contiene los datos y el número a buscar
     * @return Índice del elemento (o valor negativo si no se encuentra)
     */
    public static int busquedaArraysBinarySearch(Busqueda<Integer> busqueda) {
        Integer numBuscado = busqueda.getNumBuscado();
        Comparable[] array = busqueda.getDatos();
        return Arrays.binarySearch(array, numBuscado);
    }
}
