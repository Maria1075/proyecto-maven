/**
 * Clase que implementa el cálculo del factorial de un número,
 * tanto de forma recursiva como iterativa.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.basicos;

public class Factorial {

	/**
	 * Calcula el factorial de un número de forma recursiva.
	 *
	 * @param n Número entero no negativo
	 * @return El factorial de n (n!)
	 */
	public static Integer factorialRec(int n) {
		if (n <= 1) return 1; // Caso base
		return n * factorialRec(n - 1); // Llamada recursiva
	}

	/**
	 * Calcula el factorial de un número de forma iterativa.
	 *
	 * @param n Número entero no negativo
	 * @return El factorial de n (n!)
	 */
	public static Integer factorialIter(int n) {
		int producto = 1;
		for (int i = 2; i <= n; i++) {
			producto *= i;
		}
		return producto;
	}
}
