/**
 * Clase que representa una reserva en una residencia.
 * Incluye información sobre el residente, la habitación, y las fechas de inicio y fin.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.residencias;

import java.util.Date;
import java.io.Serializable;

public class Reserva implements Serializable {

	private int numeroReserva;
	private Residente residente;
	private Habitacion habitacion;
	private Date fechaInicio;
	private Date fechaFin;
	private static int ultimoN = 0;

	/**
	 * Constructor de la clase Reserva. Asigna un número de reserva incremental.
	 *
	 * @param residente    Residente que hace la reserva.
	 * @param habitacion   Habitación reservada.
	 * @param fechaInicio  Fecha de inicio de la reserva.
	 * @param fechaFin     Fecha de fin de la reserva.
	 */
	public Reserva(Residente residente, Habitacion habitacion, Date fechaInicio, Date fechaFin) {
		this.numeroReserva = ++ultimoN;
		this.residente = residente;
		this.habitacion = habitacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	/**
	 * @return Número de la reserva.
	 */
	public int getNumeroReserva() {
		return numeroReserva;
	}

	/**
	 * Establece manualmente el número de la reserva.
	 *
	 * @param numeroReserva Número de reserva a asignar.
	 */
	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	/**
	 * @return Residente asociado a la reserva.
	 */
	public Residente getResidente() {
		return residente;
	}

	/**
	 * Asigna un nuevo residente a la reserva.
	 *
	 * @param residente Residente que se quiere asociar.
	 */
	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	/**
	 * @return Habitación reservada.
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * Establece una nueva habitación para la reserva.
	 *
	 * @param habitacion Nueva habitación a asociar.
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * @return Fecha de inicio de la reserva.
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece la fecha de inicio de la reserva.
	 *
	 * @param fechaInicio Fecha de inicio.
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return Fecha de fin de la reserva.
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece la fecha de fin de la reserva.
	 *
	 * @param fechaFin Fecha de finalización.
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return Último número de reserva asignado.
	 */
	public static int getUltimoNumero() {
		return ultimoN;
	}
}
