package org.mp.sesion05.pilas;

/**
 * Interfaz para una estructura de datos tipo pila (stack).
 * Esta estructura de datos sigue el principio LIFO (Last In, First Out).
 * Define las operaciones básicas que se pueden realizar en una pila.
 *
 * @param <E> el tipo de elementos que la pila puede contener.
 */
public interface Stack<E> {

    /**
     * Obtiene el número de elementos en la pila.
     *
     * @return el tamaño de la pila.
     */
    int getSize();

    /**
     * Mira el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return el elemento en la parte superior de la pila.
     * @throws NoSuchElementException si la pila está vacía.
     */
    E peek();

    /**
     * Añade un elemento a la parte superior de la pila.
     *
     * @param o el elemento a añadir.
     */
    void push(E o);

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return el elemento eliminado de la parte superior de la pila.
     * @throws NoSuchElementException si la pila está vacía.
     */
    E pop();

    /**
     * Comprueba si la pila está vacía.
     *
     * @return verdadero si la pila no contiene elementos, falso en caso contrario.
     */
    boolean isEmpty();

}