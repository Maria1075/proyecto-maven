/**
 * Comparador de objetos {@link Accion} basado en el volumen de negociación.
 * Ordena de menor a mayor volumen.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.comparator;

import java.util.Comparator;

public class VolumenComparator implements Comparator<Accion> {

	/**
	 * Compara dos acciones según su volumen de negociación.
	 *
	 * @param a1 Primera acción
	 * @param a2 Segunda acción
	 * @return -1 si a1 es menor que a2, 1 si a1 es mayor que a2, 0 si son iguales
	 */
	@Override
	public int compare(Accion a1, Accion a2) {
		if (a1.getVolumen() > a2.getVolumen())
			return 1;
		else if (a1.getVolumen() < a2.getVolumen())
			return -1;
		else
			return 0;
	}
}
