/**
 * Clase que implementa varios algoritmos de ordenación para arrays de elementos comparables.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.ordenacion;

import java.util.Arrays;

public class Ordenacion {

    /**
     * Ordena un array usando el algoritmo de ordenación por inserción.
     *
     * @param array Array de elementos que implementan Comparable
     */
    public static void ordenacionPorInsercion(Comparable[] array) {
        Comparable actual;
        int j = 0;

        for (int i = 1; i <= array.length - 1; i++) {
            actual = array[i];
            j = i - 1;

            // Desplaza elementos mayores hacia la derecha
            while (j >= 0 && array[j].compareTo(actual) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = actual; // Inserta en la posición correcta
        }
    }

    /**
     * Ordena un array usando el algoritmo Merge Sort.
     *
     * @param arr Array de elementos que implementan Comparable
     */
    public static void mergeSort(Comparable[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Método recursivo que divide el array en mitades y las ordena.
     *
     * @param arr   Array a ordenar
     * @param left  Índice izquierdo del subarray
     * @param right Índice derecho del subarray
     */
    private static void mergeSort(Comparable[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);       // Ordenar mitad izquierda
            mergeSort(arr, middle + 1, right);  // Ordenar mitad derecha
            merge(arr, left, middle, right);    // Combinar mitades ordenadas
        }
    }

    /**
     * Combina dos subarrays ordenados en uno solo ordenado.
     *
     * @param arr    Array principal
     * @param left   Índice del primer elemento
     * @param middle Índice medio que separa las mitades
     * @param right  Índice del último elemento
     */
    private static void merge(Comparable[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arrays temporales para las mitades
        Comparable[] L = new Comparable[n1];
        Comparable[] R = new Comparable[n2];

        // Copiar datos a arrays temporales
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[middle + 1 + j];
        }

        // Combinar arrays L y R
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar cualquier elemento restante de L
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copiar cualquier elemento restante de R
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Ordena un array utilizando el método sort de la clase Arrays.
     *
     * @param array Array a ordenar
     */
    public static void sort(Comparable[] array) {
        Arrays.sort(array);
    }
}
