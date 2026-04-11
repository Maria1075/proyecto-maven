/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion03.matriz;
/**
 * {@code MatrizDouble}: Matriz de números de punto flotante doble.
 * Hereda de {@link MatrizGenerica} especializado para {@code Double}.
 */
public class MatrizDouble extends MatrizGenerica<Double>{
	/**
	 * Constructor: Crea una matriz de {@code Double} con las dimensiones dadas.
	 * @param filas Número de filas.
	 * @param columnas Número de columnas.
	 */
	public MatrizDouble(int filas, int columnas) {
		super(filas, columnas);
	}
	/**
	 * Crea una nueva instancia de {@code MatrizDouble} con las dimensiones especificadas.
	 * @param filas Número de filas.
	 * @param columnas Número de columnas.
	 * @return Nueva {@code MatrizDouble}.
	 */
	@Override
	public MatrizGenerica<Double> crearMatriz(int filas, int columnas) {
		return new MatrizDouble(filas, columnas);
	}
	/**
	 * Suma dos elementos {@code Double}.
	 * @param a Primer operando.
	 * @param b Segundo operando.
	 * @return Suma de {@code a} y {@code b}.
	 */
	@Override
	public Double sumarElementos(Double a, Double b) {
		return a + b;
	}
	/**
	 * Multiplica dos elementos {@code Double}.
	 * @param a Primer operando.
	 * @param b Segundo operando.
	 * @return Producto de {@code a} y {@code b}.
	 */
	@Override
	public Double multiplicarElementos(Double a, Double b) {
		return a * b;
	}
	/**
	 * Devuelve el elemento cero para {@code Double} (0.0).
	 * @return 0.0.
	 */
	@Override
	public Double ceroElemento() {
		return 0.0;
	}

}
