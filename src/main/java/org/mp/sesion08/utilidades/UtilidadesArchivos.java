/**
 * Clase que proporciona utilidades para la gestión de archivos y directorios,
 * usando las API de java.io y java.nio.file.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion08.utilidades;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Pattern;

public class UtilidadesArchivos {

	// Métodos con java.io.File // a)

	/**
	 * Crea un archivo vacío en la ruta especificada.
	 */
	public static void crearArchivo(String ruta) throws IOException {
		File archivo = new File(ruta);
		archivo.createNewFile();
	}

	/**
	 * Verifica si un archivo existe en la ruta especificada.
	 */
	public static boolean verificarExistenciaArchivo(String ruta) {
		File archivo = new File(ruta);
		return archivo.exists();
	}

	/**
	 * Elimina un archivo si existe.
	 */
	public static boolean eliminarArchivo(String ruta) {
		File archivo = new File(ruta);
		if (!archivo.exists())
			return false;
		archivo.delete();
		return true;
	}

	/**
	 * Devuelve el nombre del archivo desde una ruta completa.
	 */
	public static String obtenerNombreArchivo(String rutaCompleta) {
		File archivo = new File(rutaCompleta);
		return archivo.getName();
	}

	/**
	 * Devuelve la ruta padre de un archivo.
	 */
	public static String obtenerRutaPadre(String rutaCompleta) {
		File archivo = new File(rutaCompleta);
		return archivo.getParent();
	}

	// Métodos con java.nio.file.Files // b)

	/**
	 * Copia un archivo de una ruta a otra.
	 */
	public static void copiarArchivo(String rutaOrigen, String rutaDestino) throws IOException {
		Path origen = Paths.get(rutaOrigen);
		Path destino = Paths.get(rutaDestino);
		Files.copy(origen, destino);
	}

	/**
	 * Mueve un archivo de una ruta a otra.
	 */
	public static void moverArchivo(String rutaOrigen, String rutaDestino) throws IOException {
		Path origen = Paths.get(rutaOrigen);
		Path destino = Paths.get(rutaDestino);
		Files.move(origen, destino);
	}

	/**
	 * Obtiene el tamaño de un archivo en bytes.
	 */
	public static long obtenerTamanioArchivo(String ruta) throws IOException {
		Path archivo = Paths.get(ruta);
		return Files.size(archivo);
	}

	/**
	 * Verifica si la ruta corresponde a un directorio.
	 */
	public static boolean verificarSiEsDirectorio(String rutaDirectorio) {
		Path archivo = Paths.get(rutaDirectorio);
		return Files.isDirectory(archivo);
	}

	// Métodos con java.nio.file.Path // c)

	/**
	 * Retorna la ruta absoluta actual del programa.
	 */
	public static Path obtenerRutaActual() {
		return Paths.get("").toAbsolutePath();
	}

	/**
	 * Retorna la ruta raíz del sistema operativo.
	 */
	public static Path obtenerRutaRaiz() {
		Path rutaRaiz = FileSystems.getDefault().getRootDirectories().iterator().next();
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			return Paths.get(rutaRaiz.toString().substring(0, 3));
		} else {
			return rutaRaiz;
		}
	}

	/**
	 * Retorna la ruta relativa entre dos rutas dadas.
	 */
	public static Path obtenerRutaRelativa(Path rutaBase, Path rutaEspecificada) {
		return rutaBase.relativize(rutaEspecificada);
	}

	// Métodos con java.nio.file.Paths // d)

	/**
	 * Convierte un Path en String.
	 */
	public static String obtenerStringRuta(Path ruta) {
		return ruta.toString();
	}

	/**
	 * Compara si dos rutas son iguales.
	 */
	public static boolean compararRutas(Path ruta, Path otraRuta) {
		return ruta.equals(otraRuta);
	}

	// Otros métodos // e)

	/**
	 * Copia un directorio completo, incluyendo su contenido, de forma recursiva.
	 */
	public static void copiarDirectorioRecursivamente(String rutaOrigen, String rutaDestino) throws IOException {
		Path origen = Paths.get(rutaOrigen);
		Path destino = Paths.get(rutaDestino);
		try {
			Files.walk(origen).forEach(ruta -> {
				Path destinoPath = destino.resolve(origen.relativize(ruta));
				try {
					if (Files.isDirectory(ruta)) {
						Files.createDirectories(destinoPath);
					} else {
						Files.copy(ruta, destinoPath);
					}
				} catch (IOException e) {
					System.err.println("Error al copiar " + ruta + " a " + destinoPath);
				}
			});
		} catch (IOException e) {
			System.err.println("Error al caminar por " + origen);
		}
	}

	/**
	 * Copia archivos desde un directorio que coincidan con un filtro (expresión regular).
	 */
	public static void copiarArchivosConFiltro(String rutaOrigen, String rutaDestino, String filtroNombre)
			throws IOException {
		Path origenPath = Paths.get(rutaOrigen);
		Path destinoPath = Paths.get(rutaDestino);
		if (!Files.exists(destinoPath)) {
			Files.createDirectories(destinoPath);
		}
		Pattern pattern = Pattern.compile(filtroNombre);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(origenPath)) {
			for (Path entry : stream) {
				if (pattern.matcher(entry.getFileName().toString()).matches()) {
					Files.copy(entry, destinoPath.resolve(entry.getFileName()), StandardCopyOption.REPLACE_EXISTING);
				}
			}
		}
	}

	/**
	 * Lista los archivos contenidos directamente en un directorio (sin incluir subdirectorios).
	 */
	public static List<File> listarArchivosEnDirectorio(String rutaDirectorio) throws IOException {
		File directorio = new File(rutaDirectorio);
		List<File> archivos = new ArrayList<>();
		if (!directorio.isDirectory())
			return null;

		File[] archivosEnDirectorio = directorio.listFiles();
		for (File archivo : archivosEnDirectorio) {
			if (archivo.isFile()) {
				archivos.add(archivo);
			}
		}
		return archivos;
	}

	/**
	 * Recorre recursivamente un directorio y aplica una acción (visitor) a cada archivo.
	 */
	public static void recorrerDirectorioRecursivamente(String rutaDirectorio, FileVisitor<Path> visitor)
			throws IOException {
		Path directorio = Paths.get(rutaDirectorio);
		Queue<Path> queue = new LinkedList<>();
		queue.offer(directorio);
		while (!queue.isEmpty()) {
			Path current = queue.poll();
			if (Files.isDirectory(current)) {
				Iterator<Path> iterator = Files.list(current).iterator();
				while (iterator.hasNext()) {
					Path path = iterator.next();
					queue.offer(path);
				}
			}
			visitor.visitFile(current, Files.readAttributes(current, BasicFileAttributes.class));
		}
	}
}
