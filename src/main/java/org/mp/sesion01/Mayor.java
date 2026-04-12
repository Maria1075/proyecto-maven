/*
 * @author Maria Camila Soto Zapata
 * @since 2025
 */
package org.mp.sesion01;
/**
 * La clase Mayor proporciona un metodo estatico para encontrar el valor entero mas grande
 * dentro de un array de enteros.
 *
 * Esta clase es útil cuando se necesita determinar el elemento máximo en un conjunto de datos
 * representados como un array de enteros.
 */
public class Mayor {

    /**
     * Encuentra el entero mayor en un array de enteros dado.
     *
     * Este metodo recorre el array de entrada y compara cada elemento con el valor maximo
     * encontrado hasta el momento. Si un elemento es mayor que el maximo actual, se actualiza
     * el valor maximo.
     * si el array esta vacio va a lanzar una excepcion     
     * @param a El array de enteros en el que se desea encontrar el mayor.
     * @return El valor entero mas grande encontrado en el array.
     * @throws RuntimeException Si el array de entrada es nulo o esta vacio.
     *
     * Ejemplo de uso:
     * int[] numeros = {10, 5, 20, 8, 15};
     * int maximo = Mayor.elEnteroMayor(numeros); // maximo sera 20
     */
    public static int elEnteroMayor(int[] a) {
        // Verifica si el array es nulo o vacío
        if (a == null || a.length == 0) {
            // Lanza una excepcion si el array es nulo o vacío
            throw new RuntimeException("Array vacio");
        }

        // Inicializa el valor máximo con el valor mínimo posible para un entero
        int max = Integer.MIN_VALUE;

        // Recorre el array y compara cada elemento con el valor máximo actual
        for (int indice = 0; indice < a.length; indice++) {
            if (a[indice] > max) {
                // Actualiza el valor máximo si se encuentra un elemento mayor
                max = a[indice];
            }
        }

        // Devuelve el valor máximo encontrado
        return max;
    }
}
	 