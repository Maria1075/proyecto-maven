/**
 * Clase que representa una acción en el mercado financiero, con nombre y volumen negociado.
 * Implementa la interfaz Comparable para permitir su ordenación alfabética por nombre.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.comparator;

public class Accion implements Comparable<Accion> {

	private String nombre;   // Nombre de la acción (por ejemplo: "AAPL", "MSFT")
	private long volumen;    // Volumen negociado

	/**
	 * Constructor para crear una acción con nombre y volumen.
	 *
	 * @param nombre Nombre de la acción
	 * @param volumen Volumen de negociación
	 */
	public Accion(String nombre, long volumen) {
		super();
		this.nombre = nombre;
		this.volumen = volumen;
	}

	/** @return Nombre de la acción */
	public String getNombre() {
		return nombre;
	}

	/** @param nombre Nuevo nombre de la acción */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** @return Volumen negociado */
	public long getVolumen() {
		return volumen;
	}

	/** @param volumen Nuevo volumen negociado */
	public void setVolumen(long volumen) {
		this.volumen = volumen;
	}

	/**
	 * Compara dos objetos Accion por su nombre.
	 *
	 * @param accion La acción con la que se va a comparar
	 * @return Valor negativo si es menor, 0 si es igual, positivo si es mayor
	 */
	@Override
	public int compareTo(Accion accion) {
	    return this.nombre.compareTo(accion.nombre);
	}

	/**
	 * Verifica si dos acciones son iguales según nombre y volumen.
	 *
	 * @param obj Objeto a comparar
	 * @return true si son iguales, false si no
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Accion other = (Accion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return volumen == other.volumen;
	}

	/**
	 * Representación textual del objeto Accion.
	 *
	 * @return String con el nombre y volumen de la acción
	 */
	@Override
	public String toString() {
		return "Accion [nombre=" + nombre + ", volumen=" + volumen + "]";
	}
}
