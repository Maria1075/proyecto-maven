/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */package org.mp.sesion03.matriz;
/**
 * {@code MatrizEntera}: Matriz de números enteros.
 * Hereda de {@link MatrizGenerica} especializado para {@code Integer}.
 */
public class MatrizEntera extends MatrizGenerica<Integer>{
	/**
	 * Constructor: Crea una matriz de {@code Integer} con las dimensiones dadas.
	 * @param filas Número de filas.
	 * @param columnas Número de columnas.
	 */
	public MatrizEntera(int filas, int columnas) {
		super(filas, columnas);
	}
	/**
	 * Crea una nueva instancia de {@code MatrizEntera} con las dimensiones especificadas.
	 * @param filas Número de filas.
	 * @param columnas Número de columnas.
	 * @return Nueva {@code MatrizEntera}.
	 */
	@Override
	public MatrizGenerica<Integer> crearMatriz(int filas, int columnas) {
		return new MatrizEntera(filas, columnas);
	}
	/**
	 * Suma dos elementos {@code Integer}.
	 * @param a Primer operando.
	 * @param b Segundo operando.
	 * @return Suma de {@code a} y {@code b}.
	 */
	@Override
	public Integer sumarElementos(Integer a, Integer b) {
		return a + b;
	}
	/**
	 * Multiplica dos elementos {@code Integer}.
	 * @param a Primer operando.
	 * @param b Segundo operando.
	 * @return Producto de {@code a} y {@code b}.
	 */
	@Override
	public Integer multiplicarElementos(Integer a, Integer b) {
		return a * b;
	}
	/**
	 * Devuelve el elemento cero para {@code Integer} (0).
	 * @return 0.
	 */
	@Override
	public Integer ceroElemento() {
		return 0;
	}

}
