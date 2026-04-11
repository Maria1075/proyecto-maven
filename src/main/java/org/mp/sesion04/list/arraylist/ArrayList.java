package org.mp.sesion04.list.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.mp.sesion04.list.AbstractList;
/**
 * {@code ArrayList<E>} es una implementación de la interfaz {@link org.mp.sesion04.list.List}
 * que utiliza un array dinámico para almacenar los elementos. Permite el acceso rápido
 * a los elementos por su índice y puede redimensionar su capacidad según sea necesario.
 * Hereda de la clase abstracta {@link AbstractList}, proporcionando implementaciones
 * específicas para las operaciones de lista basadas en un array.
 *
 * @param <E> El tipo de los elementos que contendrá esta lista.
 */
public class ArrayList<E> extends AbstractList<E> {

	private static final int CAPACIDAD_INICIAL = 16;

	private E[] data = (E[]) new Object[CAPACIDAD_INICIAL];

	/**
	 * Crea una lista vacía con la capacidad inicial predeterminada (16 elementos).
	 */
	public ArrayList() {
	}
	/**
	 * Crea una lista e inicializa sus elementos a partir de los elementos de un array dado.
	 * La capacidad inicial de la lista será al menos el tamaño del array proporcionado.
	 *
	 * @param objects El array de objetos cuyos elementos se añadirán a la nueva lista.
	 */
	public ArrayList(E[] objects) {

		for (int i = 0; i < objects.length; i++)
			add(objects[i]); // Advertencia: no usar super(objects)!

	}

	/**
	 * Compara esta lista con otro objeto para determinar si son iguales.
	 * Dos listas ArrayList son iguales si tienen el mismo tamaño y contienen los mismos
	 * elementos en el mismo orden.
	 *
	 * @param obj El objeto con el que se va a comparar esta lista.
	 * @return {@code true} si el objeto especificado es igual a esta lista, {@code false} en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		ArrayList<E> otro = (ArrayList<E>) obj;
		if(this.size() != otro.size()) return false;
		for (int i = 0; i < size; i++) {
			if(!this.data[i].equals(otro.data[i])) return false;
		}
		return true;
		//[ A, B, C ]  <--> [ A, B ] => false
		//[ A, B, C ]  <--> [ A, B, C ] => true
	}
	/**
	 * Añade un nuevo elemento en la posición especificada por el índice.
	 * Si el índice es igual al tamaño actual de la lista, el elemento se añade al final.
	 * Los elementos posteriores al índice se desplazan hacia la derecha.
	 * Asegura que haya suficiente capacidad en el array antes de la inserción.
	 *
	 * @param index El índice en el que se va a insertar el elemento (comenzando desde 0).
	 * @param e     El elemento que se va a añadir a la lista.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index > size()}).
	 */
	@Override /** Anade un nuevo elemento en la posición especifica por index */
	public void add(int index, E e) {
		ensureCapacity();
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);

		// Mueve los elementos a la derecha de la posicion especificada por index
		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];

		// Inserta un nuevo elemento en data[index]
		data[index] = e;

		// Incrementa el tamano en 1
		size++;
	}
	/**
	 * Asegura que el array interno tenga suficiente capacidad para añadir un nuevo elemento.
	 * Si el array está lleno (el tamaño es igual a la capacidad), crea un nuevo array
	 * con una capacidad mayor (doble del tamaño actual más 1), copia los elementos
	 * del array antiguo al nuevo y actualiza la referencia del array interno.
	 * Crea un nuevo array de tamano doble +1 */

	private void ensureCapacity() {
		// POR HACER
		// Verifica cuando el array está lleno. De ser así,
		// crea un nuevo array con el doble tamaño más 1 y copia
		// el array en el nuevo utilizando el método System.
		// arraycopy y pone el nuevo array como el array a utilizar
		if(size == data.length) {
			E[] aux = (E[]) new Object[size * 2 + 1];
//			for (int i = 0; i < size; i++) {
//				aux[i] = data[i];
//			}
			System.arraycopy(data, 0, aux, 0, size);
			data = aux;
		}
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina todos los elementos de la lista. El array interno se reemplaza por uno
	 * nuevo con la capacidad inicial predeterminada, y el tamaño se restablece a 0.
	 */
	@Override /** Elimina todos los elementos de la lista */
	public void clear() {
		// POR HACER
		// Crea un nuevo array de tamaño CAPACIDAD_INICIAL y resetea la variable size a
		// 0
		data = (E[]) new Object[CAPACIDAD_INICIAL];
		size = 0;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Comprueba si la lista contiene el elemento especificado. Utiliza el método
	 * {@link #indexOf(Object)} para buscar el elemento y devuelve {@code true} si
	 * el índice devuelto no es -1.
	 */
	@Override /** Devuelve true si la lista contiene el elemento */
	public boolean contains(E e) {
		// POR HACER
		// Comprueba si e está en el array comparando cada elemento del array con e
		// usando para
		// ello equals
		return indexOf(e) != -1;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el elemento en la posición especificada por el índice.
	 * Lanza una excepción si el índice está fuera del rango válido.
	 */
	@Override /** Devuelve el elemento en la posicion index especificada */
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}
	/**
	 * Verifica si el índice proporcionado está dentro del rango válido de la lista.
	 *
	 * @param index El índice que se va a verificar.
	 * @throws IndexOutOfBoundsException Si el índice es menor que 0 o mayor o igual que el tamaño de la lista.
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size) // Comprueba si index está en el rango
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size); // Si no, el método lanza esa
																							// Excepción
	}
	/**
	 * Devuelve la capacidad actual del array interno. Este método se proporciona
	 * principalmente para pruebas y no forma parte de la interfaz {@link List}.
	 *
	 * @return La longitud del array interno.
	 */
	private int getLength() {
		return data.length;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el índice de la primera ocurrencia del elemento especificado en la lista.
	 * Devuelve -1 si el elemento no está presente. Utiliza el método {@code equals}
	 * para comparar los elementos.
	 */
	@Override 
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if(data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el índice de la última ocurrencia del elemento especificado en la lista.
	 * Devuelve -1 si el elemento no está presente. Utiliza el método {@code equals}
	 * para comparar los elementos, buscando desde el final de la lista hacia el principio.
	 */
	@Override 
	public int lastIndexOf(E e) {
		for (int i = size-1; i >= 0; i--) {
			if(data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina el elemento en la posición especificada por el índice.
	 * Los elementos posteriores al índice se desplazan hacia la izquierda.
	 * Devuelve el elemento que ha sido eliminado de la lista.
	 *
	 * @param index El índice del elemento que se va a borrar (comenzando desde 0).
	 * @return El elemento que fue borrado de la lista.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	@Override 

	public E remove(int index) {
		checkIndex(index);
		E aux = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i+1];
		}
		size--;
		return aux;

	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Sustituye el elemento en la posición especificada por el índice con el elemento
	 * especificado y devuelve el elemento que estaba previamente en esa posición.
	 *
	 * @param index El índice del elemento que se va a sustituir (comenzando desde 0).
	 * @param e     El nuevo elemento que se va a almacenar en la lista.
	 * @return El elemento que estaba previamente en la posición especificada por el índice.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	@Override 
	public E set(int index, E e) {
		checkIndex(index);
		E antiguo = data[index];
		data[index] = e;
		return antiguo;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve una representación en cadena de la lista, que consiste en una secuencia
	 * de los elementos de la lista en el orden en que se encuentran, encerrados entre
	 * corchetes ("[]"). Los elementos adyacentes están separados por una coma y un espacio.
	 */
	@Override
	public String toString() {
		//[A, B, C, D]
		//[]
		StringBuilder resultado = new StringBuilder("[");

		for (int i = 0; i < size; i++) {
			resultado.append(data[i]);
			if (i < size - 1)
				resultado.append(", ");
		}

		return resultado.toString() + "]";

	}

	/**
	 * Reduce la capacidad del array interno al tamaño actual de la lista.
	 * Esto puede liberar memoria no utilizada si la lista ha reducido su tamaño.
	 * Si el tamaño actual es igual a la capacidad, no se realiza ninguna acción.
	 *
	 * @throws RuntimeException Si el tamaño de la lista ya coincide con la capacidad del array.
	 */
	public void trimToSize() {

		// POR HACER
		// si el tamaño del array es distinto de la capacidad
		// Crea un nuevo array del tamaño del que se tiene
		// Copia el array en el nuevo array utilizando System.arraycopy
		// Si tamaño == capacidad, no es necesario hacer nada
		if(size < data.length) {
			E[] aux = (E[]) new Object[size];
			System.arraycopy(data, 0, aux, 0, size);
		}else {
			throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
		}
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve un iterador sobre los elementos de esta lista en la secuencia apropiada.
	 * El iterador proporcionado por esta clase es fail-fast.
	 */
	@Override /** Sobre-escribe el metodo iterator() definido en Iterable */
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}
	/**
	 * Clase interna que implementa la interfaz {@link Iterator} para la clase {@code ArrayList}.
	 * Proporciona la funcionalidad para recorrer los elementos de la lista.
	 */
	private class ArrayListIterator implements Iterator<E> {
		private int current = 0; // indice current
		private boolean removePermitido = false; // solo se permite si se hace next
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			return current < size;
		}
		/**
		 * {@inheritDoc}
		 *
		 * @throws NoSuchElementException Si no hay más elementos para devolver.
		 */
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No hay más elementos en la lista");
			}
			E aux = data[current];
			current++;
			removePermitido = true;
			return aux;
		}
		/**
		 * {@inheritDoc}
		 *
		 * @throws IllegalStateException Si este método se llama antes de {@link #next()} o si {@link #remove()} ya ha sido llamado después de la última llamada a {@code next()}.
		 */
		@Override
		public void remove() {
			if(removePermitido) {
				current--;
				ArrayList.this.remove(current);
				removePermitido = false;
			}else {
				throw new IllegalStateException("No se puede usar remove() sin hacer next()");
			}
		}
	}

}