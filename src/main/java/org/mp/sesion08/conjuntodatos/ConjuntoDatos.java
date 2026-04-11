/**
 * Clase que permite leer, procesar y exportar datos desde un archivo de texto con formato tabular.
 * Soporta separación por delimitadores personalizados, cabecera de columnas, acceso a columnas por índice o nombre,
 * y exportación de subconjuntos de datos.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion08.conjuntodatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConjuntoDatos {

	private File archivoTexto;
	private String separator;
	private Locale locale;
	private ArrayList<String> cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private String[][] datosString;

	/**
	 * Constructor principal.
	 *
	 * @param archivoTexto Archivo de texto a procesar
	 * @param separator Separador de columnas (por ejemplo, ",", ";", "\t")
	 * @param locale Configuración regional para interpretación (no usado directamente aquí)
	 */
	public ConjuntoDatos(File archivoTexto, String separator, Locale locale) {
		this.archivoTexto = archivoTexto;
		this.separator = separator;
		this.locale = locale;
		leerArchivo();
	}

	/**
	 * Lee la primera línea del archivo y extrae los nombres de columnas.
	 */
	private ArrayList<String> cabecera(File archivoTexto) {
		ArrayList<String> header = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
			String line = br.readLine();
			String[] columns = line.split(separator);
			for (String column : columns) {
				header.add(column);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return header;
	}

	/**
	 * Cuenta el número de líneas (excluyendo la cabecera) en el archivo.
	 */
	private int numLineas(File archivoTexto) {
		int numLines = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
			while (br.readLine() != null) {
				numLines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numLines - 1; // Excluye la cabecera
	}

	/**
	 * Cuenta cuántas columnas hay según la primera línea del archivo.
	 */
	private int numColumnas(File archivoTexto) {
		int numColumns = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
			String line = br.readLine();
			String[] columns = line.split(separator);
			numColumns = columns.length;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numColumns;
	}

	/**
	 * Lee los datos del archivo en una matriz bidimensional de Strings.
	 */
	private String[][] leerDatos(File archivoTexto, int filas, int columnas) {
		String[][] datos = new String[filas][columnas];
		try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
			br.readLine(); // Saltar cabecera
			for (int i = 0; i < filas; i++) {
				String line = br.readLine();
				String[] columns = line.split(separator);
				for (int j = 0; j < columnas; j++) {
					datos[i][j] = columns[j];
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Lee el archivo y llena los atributos principales.
	 */
	private void leerArchivo() {
		cabecera = cabecera(archivoTexto);
		numeroLineas = numLineas(archivoTexto);
		numeroColumnas = numColumnas(archivoTexto);
		datosString = leerDatos(archivoTexto, numeroLineas, numeroColumnas);
	}

	/** @return Cabecera con nombres de columnas */
	public ArrayList<String> getCabecera() {
		return cabecera;
	}

	/** @return Objeto Locale configurado */
	public Locale getLocale() {
		return locale;
	}

	/** @return Número de líneas de datos (sin contar la cabecera) */
	public int getNumeroLineas() {
		return numeroLineas;
	}

	/** @return Número de columnas */
	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	/** @return Matriz de Strings que contiene los datos */
	public String[][] getDatosString() {
		return datosString;
	}

	/** @return Archivo de texto original */
	public File getArchivoTexto() {
		return archivoTexto;
	}

	/**
	 * Obtiene una columna completa por índice.
	 *
	 * @param columna Índice de columna (0-based)
	 * @return Arreglo con los datos de la columna
	 */
	public String[] getColumna(int columna) {
		if (columna < 0 || columna >= numeroColumnas) {
			throw new IllegalArgumentException("Índice de columna inválido");
		}
		String[] columnaArray = new String[numeroLineas];
		for (int i = 0; i < numeroLineas; i++) {
			columnaArray[i] = datosString[i][columna];
		}
		return columnaArray;
	}

	/**
	 * Obtiene una columna completa por nombre.
	 *
	 * @param columna Nombre de la columna
	 * @return Arreglo con los datos de la columna
	 */
	public String[] getColumna(String columna) {
		int indiceColumna = cabecera.indexOf(columna);
		if (indiceColumna == -1) {
			throw new IllegalArgumentException("Nombre de columna no encontrado");
		}
		return getColumna(indiceColumna);
	}

	/**
	 * Exporta a un nuevo archivo de texto solo las columnas seleccionadas.
	 *
	 * @param cabeceraExportar Array con los nombres de las columnas a exportar
	 * @param archivoTexto Ruta del archivo de salida
	 * @param separator Separador a usar en el archivo exportado
	 */
	public void exportar(String[] cabeceraExportar, String archivoTexto, String separator) {
		try (FileWriter fw = new FileWriter(archivoTexto)) {
			// Escribir cabecera
			fw.write(String.join(separator, cabeceraExportar));
			fw.write("\n");

			// Buscar índices de columnas a exportar
			int[] indices = new int[cabeceraExportar.length];
			for (int i = 0; i < cabeceraExportar.length; i++) {
				int index = cabecera.indexOf(cabeceraExportar[i]);
				if (index == -1) {
					throw new IllegalArgumentException("Columna no encontrada: " + cabeceraExportar[i]);
				}
				indices[i] = index;
			}

			// Escribir filas seleccionadas
			for (String[] row : datosString) {
				List<String> valores = new ArrayList<>();
				for (int index : indices) {
					valores.add(row[index]);
				}
				fw.write(String.join(separator, valores));
				fw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** @return Separador actual usado en el archivo */
	public Object getSeparador() {
		return separator;
	}
}
