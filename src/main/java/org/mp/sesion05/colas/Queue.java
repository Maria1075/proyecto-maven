/**
 * Interfaz Queue que define las operaciones básicas de una cola.
 * Esta estructura de datos sigue el principio FIFO (First In, First Out).
 * @param <E> el tipo de elementos que esta cola puede contener.
 */
package org.mp.sesion05.colas;
/**
 * La interfaz {@code Queue<E>} define las operaciones fundamentales que debe implementar
 * cualquier estructura de datos que se comporte como una cola. Una cola es una colección
 * de elementos que sigue el principio FIFO (First In, First Out), lo que significa que el
 * primer elemento que se añade a la cola es el primero que se elimina de ella.
 *
 * @param <E> El tipo de los elementos que esta cola puede contener.
 */
public interface Queue<E> {

	/**
	 * Añade un elemento al final de la cola (operación enqueue).
	 * El nuevo elemento se inserta al final de la secuencia de elementos en la cola.
	 *
	 * @param e El elemento que se va a añadir a la cola.
	 */
    void enqueue(E e);

    /**
	 * Elimina y devuelve el elemento que se encuentra al frente de la cola (operación dequeue).
	 * Este es el elemento que se añadió primero a la cola.
	 * Si la cola está vacía, la implementación debe especificar si se lanza una excepción
	 * (como {@link java.util.NoSuchElementException}) o si se devuelve {@code null}.
	 *
	 * @return El primer elemento de la cola, o {@code null} si la cola está vacía y la
	 * implementación lo permite.
	 */
    E dequeue();

    /**
	 * Devuelve el número de elementos que contiene la cola en ese momento.
	 *
	 * @return El tamaño de la cola como un entero no negativo.
	 */
    int getSize();

	void remove(int index);

	E get(int index);

}
