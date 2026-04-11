/**
 * Clase que implementa una lista ordenada usando una lista enlazada.
 * Los elementos se insertan en orden creciente de acuerdo con su comparación natural.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion06.orderedlist;

import org.mp.sesion04.list.linkedlist.LinkedList;

public class OrderedList<T extends Comparable<T>> {

	private LinkedList<T> list; // Lista enlazada subyacente

	/**
	 * Constructor que inicializa una lista vacía.
	 */
	public OrderedList() {
		this.list = new LinkedList<>();
	}

	/**
	 * Agrega un elemento manteniendo el orden creciente.
	 *
	 * @param element Elemento a insertar
	 */
	public void addElement(T element) {
		for (int i = 0; i < getSize(); i++) {
			if (element.compareTo(getElement(i)) < 0) {
				this.list.add(i, element); // Inserta antes del primer elemento mayor
				return;
			}
		}
		this.list.add(element); // Si no hay mayor, lo agrega al final
	}

	/**
	 * Elimina un elemento si está presente en la lista.
	 *
	 * @param element Elemento a eliminar
	 * @return true si fue eliminado, false si no estaba en la lista
	 */
	public boolean removeElement(T element) {
		int pos = getIndex(element);
		if (pos == -1) return false;
		this.list.remove(pos);
		return true;
	}

	/**
	 * Devuelve el elemento en la posición especificada.
	 *
	 * @param index Índice del elemento
	 * @return Elemento en la posición dada
	 */
	public T getElement(int index) {
		return this.list.get(index);
	}

	/**
	 * Devuelve el índice del elemento buscado.
	 *
	 * @param element Elemento a buscar
	 * @return Índice del elemento o -1 si no se encuentra
	 */
	public int getIndex(T element) {
		return this.list.indexOf(element);
	}

	/**
	 * Devuelve el tamaño actual de la lista.
	 *
	 * @return Número de elementos en la lista
	 */
	public int getSize() {
		return this.list.size();
	}

	/**
	 * Verifica si la lista está vacía.
	 *
	 * @return true si no hay elementos, false en caso contrario
	 */
	public boolean isEmpty() {
		return this.list.size() == 0;
	}
}
