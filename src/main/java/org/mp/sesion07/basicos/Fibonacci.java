/**
 * Clase que implementa el cálculo de términos de la sucesión de Fibonacci,
 * mediante enfoques recursivo e iterativo.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.basicos;

public class Fibonacci {

	/**
	 * Calcula el n-ésimo término de la sucesión de Fibonacci usando recursión.
	 *
	 * @param n Índice del término (0 o mayor)
	 * @return Valor del término en la posición n
	 */
	public static Integer fibonacciRec(int n) {
		if (n <= 1) return n;
		return fibonacciRec(n - 1) + fibonacciRec(n - 2);
	}

	/**
	 * Calcula el n-ésimo término de la sucesión de Fibonacci usando iteración.
	 *
	 * @param n Índice del término (0 o mayor)
	 * @return Valor del término en la posición n
	 */
	public static Integer fibonacciIter(int n) {
		if (n == 1)
			return 1;
		else if (n == 0)
			return 0;

		int a = 0, b = 1, temp;

		for (int i = 1; i < n; i++) {
			temp = b;
			b = b + a;
			a = temp;
		}

		return b;
	}
}
