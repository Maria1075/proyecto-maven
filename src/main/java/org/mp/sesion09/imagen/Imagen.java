/**
 * Clase que representa una imagen compuesta por varias bandas (capas de datos).
 * Permite acceder, modificar, extraer y gestionar bandas e información por píxel.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.imagen;

import java.util.ArrayList;

public class Imagen {

	private String formatoImagen;
	private String tipoImagen;
	private int lineas;
	private int columnas;
	private ArrayList<Banda<?>> bandas = new ArrayList<Banda<?>>();

	/**
	 * Constructor de la clase Imagen.
	 *
	 * @param lineas         Número de filas (alto)
	 * @param columnas       Número de columnas (ancho)
	 * @param formatoImagen  Formato (por ejemplo: JPG, PNG)
	 * @param tipoImagen     Tipo (por ejemplo: RGB, IR)
	 */
	public Imagen(int lineas, int columnas, String formatoImagen, String tipoImagen) {
		this.lineas = lineas;
		this.columnas = columnas;
		this.formatoImagen = formatoImagen;
		this.tipoImagen = tipoImagen;
	}

	/**
	 * Retorna los valores de todas las bandas en un píxel (x, y).
	 *
	 * @param x Fila
	 * @param y Columna
	 * @return Array de números correspondientes a cada banda en (x, y)
	 */
	public Number[] getDatosPixel(int x, int y) {
		Number[] datosPixel = new Number[bandas.size()];
		for (int i = 0; i < bandas.size(); i++) {
			Banda<?> banda = bandas.get(i);
			datosPixel[i] = banda.getDatoXY(x, y);
		}
		return datosPixel;
	}

	/**
	 * Extrae una subimagen rectangular desde (x1, y1) hasta (x2, y2).
	 *
	 * @param x1 Coordenada inicial x
	 * @param y1 Coordenada inicial y
	 * @param x2 Coordenada final x
	 * @param y2 Coordenada final y
	 * @return Imagen nueva correspondiente a la subregión
	 * @throws XYFueraImagenException Si alguna coordenada está fuera de los límites de la imagen
	 */
	public Imagen extraerImagen(int x1, int y1, int x2, int y2) throws XYFueraImagenException {
		if (x1 > columnas || x2 > columnas || y1 > lineas || y2 > lineas || x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0)
			throw new XYFueraImagenException();

		Imagen subImagen = new Imagen(x2 - x1 + 1, y2 - y1 + 1, formatoImagen, tipoImagen);

		for (Banda<?> banda : bandas) {
			Number[][] datosBanda = banda.getDatos();
			Number[][] datosSubBanda = new Number[x2 - x1 + 1][y2 - y1 + 1];
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					datosSubBanda[i - x1][j - y1] = datosBanda[i][j];
				}
			}
			Banda<Number> subBanda = new Banda<>(banda.getNombreBanda(), datosSubBanda);
			subImagen.anadirBanda(subBanda);
		}

		return subImagen;
	}

	/**
	 * Añade una nueva banda a la imagen.
	 *
	 * @param banda Banda a añadir
	 */
	public void anadirBanda(Banda<?> banda) {
		bandas.add(banda);
	}

	/**
	 * Elimina una banda por índice.
	 *
	 * @param i Índice de la banda a eliminar
	 */
	public void eliminarBanda(int i) {
		bandas.remove(i);
	}

	/**
	 * Obtiene una banda por índice.
	 *
	 * @param i Índice
	 * @return Banda correspondiente
	 */
	public Banda<?> getBanda(int i) {
		return bandas.get(i);
	}

	/**
	 * Devuelve la lista de bandas de la imagen.
	 *
	 * @return Lista de bandas
	 */
	public ArrayList<Banda<?>> getBandas() {
		return bandas;
	}

	/**
	 * Reemplaza todas las bandas de la imagen.
	 *
	 * @param bandas Lista de nuevas bandas
	 */
	public void setBandas(ArrayList<Banda<?>> bandas) {
		this.bandas = bandas;
	}

	/**
	 * @return Número de bandas actuales
	 */
	public int getNumeroBandas() {
		return bandas.size();
	}

	/**
	 * @return Número de líneas (alto)
	 */
	public int getLineas() {
		return lineas;
	}

	/**
	 * @return Número de columnas (ancho)
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * @return Formato de imagen (por ejemplo, PNG)
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}

	/**
	 * Establece el formato de la imagen.
	 *
	 * @param formatoImagen Formato a asignar
	 */
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}

	/**
	 * @return Tipo de imagen (por ejemplo, RGB)
	 */
	public String getTipoImagen() {
		return tipoImagen;
	}

	/**
	 * Establece el tipo de imagen.
	 *
	 * @param tipoImagen Tipo a asignar
	 */
	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}
}
