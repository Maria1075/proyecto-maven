/**
 * Clase que implementa tres formas de calcular la sumatoria de los primeros n números naturales.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.basicos;

public class Sumatoria {

	/**
	 * Calcula la suma de los primeros n números usando la fórmula de Gauss.
	 *
	 * @param n Número natural mayor o igual a 1
	 * @return Suma de 1 hasta n
	 */
	public static int sumaGaus(int n) {
		return (n * (n + 1) / 2);
	}

	/**
	 * Calcula la suma de los primeros n números usando recursión.
	 *
	 * @param n Número natural mayor o igual a 1
	 * @return Suma de 1 hasta n
	 */
	public static int sumaRec(int n) {
		if (n == 1)
			return 1;
		return sumaRec(n - 1) + n;
	}

	/**
	 * Calcula la suma de los primeros n números usando un bucle iterativo.
	 *
	 * @param n Número natural mayor o igual a 1
	 * @return Suma de 1 hasta n
	 */
	public static int sumaIter(int n) {
		int suma = 0;
		for (int i = 1; i <= n; i++) {
			suma += i;
		}
		return suma;
	}
}
