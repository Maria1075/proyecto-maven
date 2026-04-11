/**
 * Clase genérica que representa una estructura de datos para realizar búsquedas.
 * Genera un arreglo de elementos aleatorios (entre 0 y 99), lo ordena y selecciona un elemento objetivo.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.busqueda;

import java.util.Arrays;
import java.util.Random;

public class Busqueda<T extends Comparable<T>> {

	private int numElementos;  // Número total de elementos
	private T[] datos;         // Arreglo de datos generado
	private T numBuscado;      // Elemento seleccionado al azar para buscar

	/**
	 * Constructor que genera un arreglo ordenado de elementos aleatorios y selecciona uno para buscar.
	 *
	 * @param numElementos Cantidad de elementos a generar
	 */
	public Busqueda(int numElementos) {
		this.numElementos = numElementos;
		datos = (T[]) new Comparable[numElementos];
		generarDatosAleatorios();
	}

	/**
	 * Genera datos aleatorios entre 0 y 99, los ordena y selecciona un elemento aleatorio como objetivo.
	 */
	private void generarDatosAleatorios() {
		Random random = new Random();
		for (int i = 0; i < numElementos; i++) {
			datos[i] = (T) Integer.valueOf(random.nextInt(100));
		}
		Arrays.sort(datos);
		numBuscado = datos[random.nextInt(numElementos)];
	}

	/**
	 * @return Número de elementos en el arreglo
	 */
	public int getNumElementos() {
		return numElementos;
	}

	/**
	 * @return Arreglo de datos generado
	 */
	public T[] getDatos() {
		return datos;
	}

	/**
	 * Reemplaza el arreglo actual por uno proporcionado.
	 *
	 * @param datosModelo Nuevo arreglo de datos
	 */
	public void setDatos(T[] datosModelo) {
		this.datos = datosModelo;
	}

	/**
	 * @return Elemento seleccionado como objetivo de búsqueda
	 */
	public T getNumBuscado() {
		return numBuscado;
	}

	/**
	 * Establece el valor a buscar en el arreglo.
	 *
	 * @param buscar Elemento objetivo de búsqueda
	 */
	public void setNumBuscado(T buscar) {
		numBuscado = buscar;
	}

	/**
	 * Representación en texto del estado actual de la búsqueda.
	 */
	@Override
	public String toString() {
		return "Problema búsqueda con " + numElementos + " elementos\n"
			 + "Elemento buscado: " + numBuscado + "\n"
			 + Arrays.toString(datos);
	}
}
