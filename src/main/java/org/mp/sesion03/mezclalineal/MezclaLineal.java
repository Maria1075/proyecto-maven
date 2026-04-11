package org.mp.sesion03.mezclalineal;
import java.util.Arrays;
/**
 * La clase {@code MezclaLineal} proporciona métodos para realizar una mezcla lineal
 * de dos arrays ordenados.
 */
public class MezclaLineal {
	/**
     * Realiza una mezcla lineal de dos arrays de enteros ordenados.
     * Combina los elementos de ambos arrays en un nuevo array ordenado.
     *
     * @param arr1 El primer array de enteros ordenado.
     * @param arr2 El segundo array de enteros ordenado.
     * @return Un nuevo array de enteros que contiene todos los elementos de {@code arr1} y {@code arr2} en orden ascendente.
     */
    public static int[] mezclaLinealInt(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }
    /**
     * Realiza una mezcla lineal de dos arrays ordenados de objetos que implementan la interfaz {@link Comparable}.
     * Combina los elementos de ambos arrays en un nuevo array ordenado.
     *
     * @param <T> El tipo de los elementos de los arrays, que debe ser comparable.
     * @param arr1 El primer array ordenado de objetos comparables.
     * @param arr2 El segundo array ordenado de objetos comparables.
     * @return Un nuevo array de objetos de tipo {@code T} que contiene todos los elementos de {@code arr1} y {@code arr2} en orden ascendente.
     */
    public static  <T extends Comparable<T>> T[] mezclaLinealGenericos(T[] arr1, T[] arr2) {
        T[] result = (T[]) new Comparable[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) <= 0) { //arr1[i] <= arr2[j]
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

 }
