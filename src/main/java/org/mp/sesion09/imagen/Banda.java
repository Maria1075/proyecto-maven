/**
 * Clase genérica que representa una banda de datos numéricos bidimensionales.
 * Utilizada principalmente en procesamiento de imágenes (por ejemplo, una banda espectral).
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.imagen;

public class Banda<T extends Number> {

	private String nombreBanda; // Nombre identificador de la banda
	private T[][] datos;        // Matriz de datos de la banda

	/**
	 * Constructor que inicializa la banda con nombre y matriz de datos.
	 *
	 * @param nombre Nombre de la banda
	 * @param datos  Matriz de datos numéricos
	 */
	public Banda(String nombre, T[][] datos) {
		this.nombreBanda = nombre;
		this.datos = datos;
	}

	/**
	 * Constructor que inicializa la banda con nombre y dimensiones vacías.
	 *
	 * @param nombre Nombre de la banda
	 * @param x      Número de filas
	 * @param y      Número de columnas
	 */
	public Banda(String nombre, int x, int y) {
		this.nombreBanda = nombre;
		this.datos = (T[][]) new Number[x][y];
	}

	/**
	 * @return Nombre de la banda
	 */
	public String getNombreBanda() {
		return nombreBanda;
	}

	/**
	 * Asigna un nuevo nombre a la banda.
	 *
	 * @param nombreBanda Nuevo nombre
	 */
	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}

	/**
	 * @return Matriz de datos de la banda
	 */
	public T[][] getDatos() {
		return datos;
	}

	/**
	 * Asigna una nueva matriz de datos a la banda.
	 *
	 * @param datos Matriz de datos a establecer
	 */
	public void setDatos(T[][] datos) {
		this.datos = datos;
	}

	/**
	 * Obtiene el valor en la posición (x, y) de la matriz de datos.
	 *
	 * @param x Fila
	 * @param y Columna
	 * @return Valor almacenado en la posición indicada
	 */
	public T getDatoXY(int x, int y) {
		return datos[x][y];
	}

	/**
	 * Asigna un valor en la posición (x, y) de la matriz de datos.
	 *
	 * @param dato Valor a establecer
	 * @param x    Fila
	 * @param y    Columna
	 */
	public void setDatoXY(T dato, int x, int y) {
		datos[x][y] = dato;
	}

	/**
	 * Representación textual de la banda (actualmente sin implementar).
	 *
	 * @return null
	 */
	@Override
	public String toString() {
		return null;
	}
}
