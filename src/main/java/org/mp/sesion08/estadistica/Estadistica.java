/**
 * Clase que permite calcular medidas estadísticas básicas a partir de un conjunto de datos.
 * 
 * Autor: Maria Camila Soto Zapata  
 * Año: 2025
 */

package org.mp.sesion08.estadistica;

import org.mp.sesion08.conjuntodatos.ConjuntoDatos;

public class Estadistica {

	private ConjuntoDatos cd;

	/**
	 * Constructor de la clase Estadistica.
	 * 
	 * @param cd Conjunto de datos sobre el cual se harán los cálculos estadísticos.
	 */
	public Estadistica(ConjuntoDatos cd) {
		this.cd = cd;
	}

	/**
	 * Convierte un arreglo de Strings en un arreglo de doubles.
	 *
	 * @param datosString Arreglo de datos numéricos en formato texto
	 * @return Arreglo equivalente en formato double
	 */
	private double[] convertirADouble(String[] datosString) {
		double[] datosDouble = new double[datosString.length];

		for (int i = 0; i < datosDouble.length; i++)
			datosDouble[i] = Double.parseDouble(datosString[i]);

		return datosDouble;
	}

	/**
	 * Calcula la media (promedio) de los valores de una columna numérica.
	 *
	 * @param columna Nombre de la columna
	 * @return Valor de la media
	 */
	public double media(String columna) {
		String[] datosString = cd.getColumna(columna);
		double[] datosDouble = convertirADouble(datosString);
		double suma = 0;

		for (int i = 0; i < datosDouble.length; i++)
			suma += datosDouble[i];

		double media = suma / datosDouble.length;

		return media;
	}

	/**
	 * Calcula el valor máximo en una columna numérica.
	 *
	 * @param columna Nombre de la columna
	 * @return Valor máximo encontrado
	 */
	public double max(String columna) {
		String[] datosString = cd.getColumna(columna);
		double[] datosDouble = convertirADouble(datosString);
		double max = Double.MIN_NORMAL;

		for (int i = 0; i < datosDouble.length; i++) {
			if (Double.isNaN(datosDouble[i]))
				continue;
			else if (max < datosDouble[i])
				max = datosDouble[i];
		}
		return max;
	}

	/**
	 * Calcula el valor mínimo en una columna numérica.
	 *
	 * @param columna Nombre de la columna
	 * @return Valor mínimo encontrado
	 */
	public double min(String columna) {
		String[] datosString = cd.getColumna(columna);
		double[] datosDouble = convertirADouble(datosString);
		double min = datosDouble[0];

		for (int i = 0; i < datosDouble.length; i++) {
			if (datosDouble[i] < min)
				min = datosDouble[i];
		}

		return min;
	}

	/**
	 * Calcula la suma total de una columna numérica.
	 *
	 * @param columna Nombre de la columna
	 * @return Suma de los valores
	 */
	public double suma(String columna) {
		String[] datosString = cd.getColumna(columna);
		double[] datosDouble = convertirADouble(datosString);
		double suma = 0;

		for (int i = 0; i < datosDouble.length; i++)
			suma += datosDouble[i];

		return suma;
	}

	/**
	 * Calcula la mediana de una columna numérica.
	 * (Actualmente no implementado)
	 *
	 * @param columna Nombre de la columna
	 * @return Valor de la mediana (0.0 por defecto)
	 */
	public double mediana(String columna) {
		String[] datosString = cd.getColumna(columna);
		double[] datosDouble = convertirADouble(datosString);
		return 0.0;
	}

	/**
	 * Calcula la varianza de una columna numérica.
	 * (Actualmente no implementado)
	 *
	 * @param columna Nombre de la columna
	 * @return Valor de la varianza (0.0 por defecto)
	 */
	public double varianza(String columna) {
		String[] datosString = cd.getColumna(columna);
		double[] datosDouble = convertirADouble(datosString);
		return 0.0;
	}

	/**
	 * Calcula la desviación estándar de una columna numérica.
	 * (Actualmente no implementado)
	 *
	 * @param columna Nombre de la columna
	 * @return Valor de la desviación estándar (0.0 por defecto)
	 */
	public double desviacionEstandar(String columna) {
		String[] datosString = cd.getColumna(columna);
		double[] datosDouble = convertirADouble(datosString);
		return 0.0;
	}
}
