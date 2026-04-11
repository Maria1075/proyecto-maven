package org.mp.sesion04.list;

import java.util.Iterator;
/**
 * La interfaz {@code List<E>} representa una colección ordenada de elementos de tipo {@code E}.
 * Proporciona métodos para añadir, eliminar, acceder y modificar elementos en la lista,
 * así como para consultar su estado (tamaño, si está vacía, si contiene un elemento).
 * Esta interfaz extiende {@link Iterable}, lo que permite recorrer los elementos de la lista
 * utilizando un bucle for-each.
 *
 * @param <E> El tipo de los elementos que contiene esta lista.
 */
public interface List<E> extends Iterable<E> {

	/**
	 * Añade un nuevo elemento al final de la lista.
	 *
	 * @param e El elemento que se va a añadir a la lista.
	 */
	public void add(E e);

	/**
	 * Añade un nuevo elemento en la posición especificada por el índice en la lista.
	 * Los elementos posteriores al índice se desplazan hacia la derecha.
	 *
	 * @param index El índice en el que se va a insertar el elemento (comenzando desde 0).
	 * @param e     El elemento que se va a añadir a la lista.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index > size()}).
	 */
	public void add(int index, E e);

	/**
	 * Borra todos los elementos de la lista, dejándola vacía.
	 */
	public void clear();

	/**
	 * Devuelve {@code true} si la lista contiene el elemento especificado.
	 *
	 * @param e El elemento cuya presencia en la lista se va a verificar.
	 * @return {@code true} si la lista contiene el elemento {@code e}, {@code false} en caso contrario.
	 */
	public boolean contains(E e);

	/**
	 * Devuelve el elemento de la lista que se encuentra en la posición especificada por el índice.
	 *
	 * @param index El índice del elemento que se va a devolver (comenzando desde 0).
	 * @return El elemento en la posición especificada por el índice.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	public E get(int index);

	/**
	 * Devuelve el índice de la primera ocurrencia del elemento especificado en la lista.
	 *
	 * @param e El elemento cuyo índice se va a buscar.
	 * @return El índice de la primera ocurrencia del elemento {@code e} en la lista, o -1 si el elemento no está presente.
	 */
	public int indexOf(E e);

	/**
	 * Devuelve {@code true} si la lista no contiene elementos.
	 *
	 * @return {@code true} si la lista está vacía, {@code false} en caso contrario.
	 */
	public boolean isEmpty();

	/**
	 * Devuelve el índice de la última ocurrencia del elemento especificado en la lista.
	 *
	 * @param e El elemento cuyo último índice se va a buscar.
	 * @return El índice de la última ocurrencia del elemento {@code e} en la lista, o -1 si el elemento no está presente.
	 */
	public int lastIndexOf(E e);

	/**
	 * Borra la primera ocurrencia del elemento especificado en la lista.
	 * Si el elemento se encuentra, los elementos posteriores se desplazan hacia la izquierda.
	 *
	 * @param e El elemento que se va a borrar de la lista (si está presente).
	 * @return {@code true} si el elemento fue borrado de la lista, {@code false} en caso contrario (si el elemento no estaba presente).
	 */
	public boolean remove(E e);

	/**
	 * Borra el elemento de la posición especificada por el índice en la lista.
	 * Los elementos posteriores al índice se desplazan hacia la izquierda.
	 *
	 * @param index El índice del elemento que se va a borrar (comenzando desde 0).
	 * @return El elemento que ha sido borrado de la lista.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	public E remove(int index);

	/**
	 * Sustituye el elemento en la posición especificada por el índice en la lista
	 * con el elemento especificado y devuelve el elemento que estaba previamente en esa posición.
	 *
	 * @param index El índice del elemento que se va a sustituir (comenzando desde 0).
	 * @param e     El nuevo elemento que se va a almacenar en la lista.
	 * @return El elemento que estaba previamente en la posición especificada por el índice.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	public Object set(int index, E e);

	/**
	 * Devuelve el número de elementos que contiene la lista.
	 *
	 * @return El número de elementos en la lista.
	 */
	public int size();

	
	
}
