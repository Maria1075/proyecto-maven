/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion03.matriz;
/**
 * {@code MatrizGenerica<T>}: Clase abstracta genérica para representar matrices de números.
 * Proporciona funcionalidades básicas para matrices y define métodos abstractos para operaciones específicas del tipo numérico.
 *
 * @param <T> El tipo de número que contendrá la matriz, debe extender {@link Number}.
 */
public abstract class MatrizGenerica<T extends Number> {
	
	protected T[][] matriz;
	protected int filas;
	protected int columnas;
	/**
	 * Constructor: Inicializa una matriz genérica con el número de filas y columnas especificado.
	 * @param filas Número de filas de la matriz.
	 * @param columnas Número de columnas de la matriz.
	 */
	public MatrizGenerica(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = (T[][]) new Number[filas][columnas];
	}
	/**
	 * Devuelve una representación en cadena de la matriz.
	 * @return Una cadena formateada que muestra los elementos de la matriz separados por tabulaciones y filas por saltos de línea.
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				s += matriz[i][j];
				if(j < matriz[0].length - 1) {
					s += "\t";
				}
			}
			s += "\n";
		}
		return s;
	}
	/**
	 * Establece el valor de un elemento en la matriz en la fila y columna especificadas.
	 * @param fila El índice de la fila (comenzando desde 0).
	 * @param columna El índice de la columna (comenzando desde 0).
	 * @param valor El valor de tipo T a establecer en la matriz.
	 */
	public void setValor(int fila, int columna, T valor) {
		this.matriz[fila][columna] = valor;
	}
	/**
	 * Obtiene la matriz interna.
	 * @return Una matriz bidimensional de tipo T que representa la matriz.
	 */
	public T[][] getMatriz(){
		return this.matriz;
	}
	/**
	 * Suma esta matriz genérica con otra matriz genérica del mismo tipo.
	 * @param otraMatriz La matriz genérica a sumar. Debe tener las mismas dimensiones.
	 * @return Una nueva matriz genérica del mismo tipo que representa la suma de las dos matrices.
	 * @throws IllegalArgumentException Si las matrices no tienen las mismas dimensiones.
	 */
	public MatrizGenerica<T> sumar(MatrizGenerica<T> otraMatriz){
		if(this.filas != otraMatriz.filas || this.columnas != otraMatriz.columnas) {
			throw new IllegalArgumentException("Matrices incompatibles");
		}
		MatrizGenerica<T> resultado = crearMatriz(filas, columnas);
		T[][] otra = otraMatriz.getMatriz();
		T[][] r = resultado.getMatriz();
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[0].length; j++) {
				r[i][j] = sumarElementos(this.matriz[i][j], otra[i][j]);
			}
		}
		return resultado;
	}
	/**
	 * Multiplica esta matriz genérica con otra matriz genérica del mismo tipo.
	 * @param otraMatriz La matriz genérica por la cual multiplicar. El número de columnas de esta matriz debe ser igual al número de filas de la otra matriz.
	 * @return Una nueva matriz genérica del mismo tipo que representa el producto de las dos matrices.
	 * @throws IllegalArgumentException Si el número de columnas de la primera matriz no es igual al número de filas de la segunda matriz.
	 * @throws IllegalArgumentException Si algún valor en las matrices es nulo durante la multiplicación.
	 */
	public MatrizGenerica<T> multiplicar(MatrizGenerica<T> otraMatriz){
		if(this.columnas != otraMatriz.filas) {
			throw new IllegalArgumentException("Matrices incompatibles");
		}
		MatrizGenerica<T> resultado = crearMatriz(this.filas, otraMatriz.columnas);
		T[][] otra = otraMatriz.getMatriz();
		T[][] r = resultado.getMatriz();
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < otraMatriz.columnas; j++) {
				T suma = ceroElemento();
				for (int k = 0; k < this.columnas; k++) {
					if(this.matriz[i][k] == null || otra[k][j] == null) {
						throw new IllegalArgumentException("Valores nulos");
					}
					suma = sumarElementos(suma, multiplicarElementos(this.matriz[i][k], otra[k][j]));
				}
				r[i][j] = suma;
			}
		}
		return resultado;
	}
	/**
	 * Calcula la transpuesta de esta matriz genérica.
	 * @return Una nueva matriz genérica del mismo tipo que es la transpuesta de esta matriz.
	 */
	public MatrizGenerica<T> transponer(){
		MatrizGenerica<T> resultado = crearMatriz(columnas, filas);
		T[][] r = resultado.getMatriz();
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				r[j][i] = this.matriz[i][j];
			}
		}
		return resultado;
	}
	/**
	 * Método abstracto para crear una nueva matriz genérica del tipo específico.
	 * Debe ser implementado por las subclases concretas para devolver una instancia de su propio tipo.
	 * @param filas El número de filas de la nueva matriz.
	 * @param columnas El número de columnas de la nueva matriz.
	 * @return Una nueva instancia de {@code MatrizGenerica<T>} o su subtipo.
	 */
	public abstract MatrizGenerica<T> crearMatriz(int filas, int columnas);
	/**
	 * Método abstracto para sumar dos elementos del tipo T.
	 * Debe ser implementado por las subclases concretas para definir la operación de suma para su tipo numérico.
	 * @param a El primer operando.
	 * @param b El segundo operando.
	 * @return La suma de {@code a} y {@code b}.
	 */
	public abstract T sumarElementos(T a, T b);
	/**
	 * Método abstracto para multiplicar dos elementos del tipo T.
	 * Debe ser implementado por las subclases concretas para definir la operación de multiplicación para su tipo numérico.
	 * @param a El primer operando.
	 * @param b El segundo operando.
	 * @return El producto de {@code a} y {@code b}.
	 */
	public abstract T multiplicarElementos(T a, T b);
	/**
	 * Método abstracto para obtener el elemento cero del tipo T.
	 * Debe ser implementado por las subclases concretas para definir el elemento neutro de la suma para su tipo numérico.
	 * @return El elemento cero del tipo T.
	 */
	public abstract T ceroElemento();
	
}
