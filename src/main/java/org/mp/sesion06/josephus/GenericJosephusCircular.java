/**
 * Implementación genérica del problema de Josephus usando una lista circular.
 * Elimina cada k-ésimo elemento hasta que la lista esté vacía.
 * 
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion06.josephus;

import org.mp.sesion06.circularlist.CircularList;

public class GenericJosephusCircular<T> {

	private int k; // Paso o intervalo para eliminación
	private int n; // Número inicial de elementos
	private CircularList<T> elementos; // Lista circular de elementos

	/**
	 * Constructor de la clase.
	 *
	 * @param k Número de pasos antes de eliminar un elemento
	 * @param n Número de elementos iniciales
	 * @param elementos Arreglo con los elementos a usar
	 */
	public GenericJosephusCircular(int k, int n, T[] elementos) {
		this.k = k;
		this.n = n;
		this.elementos = new CircularList<>();
		if (elementos != null) {
			for (int i = 0; i < elementos.length; i++) {
				this.elementos.addElement(elementos[i]);
			}
		}
	}

	/**
	 * Devuelve el orden en que los elementos fueron eliminados según la lógica de Josephus.
	 *
	 * @return Cadena que representa el orden de eliminación
	 */
	public String ordenEliminar() {
		if (n == 0) {
			throw new RuntimeException("No hay ninguna persona");
		}
		if (n == 1)
			return "Solo hay una persona";

		String s = "Orden de eliminación:\n";
		int cont = 0;

		// Se recorre la lista hasta que esté vacía
		while (this.elementos.getSize() != 0) {
			T aux = elementos.getElement(0); // Se obtiene el primer elemento
			elementos.removeElement(aux);    // Se elimina temporalmente
			cont++;

			if (cont % k == 0) {
				// Si es múltiplo de k, el elemento es eliminado
				s += "Debe morir " + aux + "\n";
			} else {
				// Si no, se vuelve a encolar al final de la lista
				this.elementos.addElement(aux);
			}
		}
		return s;
	}
}
