package org.mp.sesion04.list;
/**
 * La clase abstracta {@code AbstractList<E>} proporciona una implementación base
 * para la interfaz {@link List}. Contiene la lógica común para todas las listas,
 * como el seguimiento del tamaño y las implementaciones predeterminadas para algunos métodos.
 * Las subclases concretas de {@code AbstractList} deben implementar los métodos restantes
 * específicos de su estructura de datos subyacente.
 *
 * @param <E> El tipo de los elementos que contendrá esta lista.
 */
public abstract class AbstractList<E> implements List<E> {
	/**
	 * El número actual de elementos en la lista.
	 */
	protected int size = 0; // Tamano de la lista

	/** Crea una lista por defecto */
	protected AbstractList() {
	}

	/**
	 * Crea una lista e inicializa sus elementos a partir de los elementos de un array dado.
	 *
	 * @param objects El array de objetos cuyos elementos se añadirán a la nueva lista.
	 */
	protected AbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
					add(objects[i]);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Esta implementación añade el elemento especificado al final de la lista,
	 * utilizando la implementación de {@link #add(int, E)} con el índice igual al tamaño actual.
	 */
	public void add(E e) {
		add(size, e);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Esta implementación devuelve {@code true} si el tamaño de la lista es cero.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Esta implementación devuelve el valor del campo {@code size}, que representa
	 * el número de elementos en la lista.
	 */
	public int size() {
		return size;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Esta implementación borra la primera ocurrencia del elemento especificado de la lista.
	 * Primero busca el índice del elemento utilizando {@link #indexOf(Object)}.
	 * Si el elemento se encuentra (índice es mayor o igual a 0), llama a {@link #remove(int)}
	 * para eliminar el elemento en esa posición y devuelve {@code true}.
	 * Si el elemento no se encuentra, devuelve {@code false}.
	 */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}
	
	
}
