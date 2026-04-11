package org.mp.sesion05.pilas;
/**
 * {@code ArrayStack<E>} es una implementación de la interfaz {@link Stack} que utiliza
 * un array dinámico para almacenar los elementos de la pila. Permite las operaciones
 * push (añadir en la cima), pop (remover de la cima), peek (ver la cima) y getSize
 * (obtener el tamaño) con un posible redimensionamiento del array para acomodar
 * un número creciente de elementos.
 *
 * @param <E> El tipo de los elementos que contendrá esta pila.
 */
public class ArrayStack<E> implements Stack<E>{
	
	private static final int CAPACITY = 16;
	private Object[] array;
	private int size;
	/**
	 * Constructor: Inicializa una nueva pila vacía con la capacidad inicial predeterminada (16 elementos).
	 * El tamaño de la pila se establece en 0.
	 */
	public ArrayStack() { //[1, 2, 3]
		this.array = new Object[CAPACITY];
		this.size = 0;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el número de elementos que contiene la pila.
	 *
	 * @return El número de elementos en la pila.
	 */
	public int getSize() {
		return this.size;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el elemento que se encuentra en la cima de la pila sin eliminarlo.
	 * Si la pila está vacía, devuelve {@code null}.
	 *
	 * @return El elemento en la cima de la pila, o {@code null} si la pila está vacía.
	 */
	public E peek() {
		if(size == 0) return null;
		return (E) array[size-1];
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Añade un elemento a la cima de la pila (operación push).
	 * Primero, verifica y expande la capacidad del array si es necesario.
	 * Luego, añade el elemento en la siguiente posición disponible en la cima
	 * (al final del bloque utilizado del array) e incrementa el tamaño de la pila.
	 *
	 * @param o El elemento que se va a añadir a la cima de la pila.
	 */
	public void push(E o) {
		expandCapacity();
		array[size] = o;
		size++;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina y devuelve el elemento que se encuentra en la cima de la pila (operación pop).
	 * Si la pila está vacía, devuelve {@code null}.
	 * De lo contrario, obtiene el elemento de la cima, decrementa el tamaño de la pila
	 * y devuelve el elemento extraído.
	 *
	 * @return El elemento que estaba en la cima de la pila, o {@code null} si la pila está vacía.
	 */
	public E pop() {
		if(isEmpty()) return null;
		E aux = (E) array[size-1];
		size--;
		return aux;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve {@code true} si la pila no contiene ningún elemento.
	 *
	 * @return {@code true} si el tamaño de la pila es 0, {@code false} en caso contrario.
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	/**
	 * Expande la capacidad del array interno si es necesario.
	 * Si el array está lleno (el tamaño es igual a la capacidad), crea un nuevo array
	 * con una capacidad mayor (doble del tamaño actual más 1), copia los elementos
	 * del array antiguo al nuevo y actualiza la referencia del array interno.
	 */
	private void expandCapacity() {
		if(size == array.length) {
			Object[] aux = new Object[2*size + 1];
			System.arraycopy(array, 0, aux, 0, size);
			array = aux;
		}
	}

}