/**
 * Clase que representa una Residencia con sus residentes, habitaciones y reservas.
 * Permite gestionar ingresos, salidas, cambios de habitación y listados varios.
 * 
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.residencias;

import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Residencia implements Serializable {

    private String nombre;
    private List<Residente> residentes = new ArrayList<Residente>();
    private List<Habitacion> habitaciones = new ArrayList<Habitacion>();
    private List<Reserva> reservas = new ArrayList<Reserva>();

    /**
     * Constructor de residencia con solo nombre.
     * 
     * @param nombre Nombre de la residencia.
     */
    public Residencia(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con habitaciones iniciales.
     * 
     * @param nombre       Nombre de la residencia.
     * @param habitaciones Array de habitaciones a agregar.
     */
    public Residencia(String nombre, Habitacion[] habitaciones) {
        this.nombre = nombre;
        for (int i = 0; i < habitaciones.length; i++) {
            if (habitaciones[i] != null)
                this.habitaciones.add(habitaciones[i]);
        }
    }

    /**
     * Registra un ingreso de un residente a una habitación.
     * 
     * @param residente    Residente que se desea ingresar.
     * @param habitacion   Habitación que se asigna.
     * @param fechaInicio  Fecha de inicio de la reserva.
     * @param fechaFin     Fecha de fin de la reserva.
     */
    public void ingreso(Residente residente, Habitacion habitacion, Date fechaInicio, Date fechaFin) {
        if (isHabitacionOcupada(habitacion, fechaInicio) || residentes.contains(residente)
                || fechaFin.before(fechaInicio))
            return;
        insertarResidente(residente);
        insertarHabitacion(habitacion);
        reservas.add(new Reserva(residente, habitacion, fechaInicio, fechaFin));
    }

    /**
     * Registra la salida de un residente en una fecha determinada.
     * 
     * @param residente Residente que se va.
     * @param fecha     Fecha de salida.
     */
    public void salida(Residente residente, Date fecha) {
        residentes.remove(residente);
        Iterator<Reserva> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getResidente().equals(residente)) {
                reserva.setFechaFin(fecha);
            }
        }
    }

    /**
     * Verifica si una habitación está ocupada en una fecha dada.
     * 
     * @param habitacion Habitación a verificar.
     * @param fecha      Fecha específica.
     * @return true si está ocupada, false si está libre.
     */
    public boolean isHabitacionOcupada(Habitacion habitacion, Date fecha) {
        Iterator<Reserva> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getHabitacion().equals(habitacion)
                    && (fecha.equals(reserva.getFechaInicio()) || fecha.equals(reserva.getFechaFin())
                            || (fecha.after(reserva.getFechaInicio()) && fecha.before(reserva.getFechaFin())))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca una habitación por su número.
     * 
     * @param numero Número de habitación.
     * @return Habitación encontrada o null si no existe.
     */
    public Habitacion buscarHabitacion(String numero) {
        Iterator<Habitacion> iterator = habitaciones.iterator();
        while (iterator.hasNext()) {
            Habitacion habitacion = iterator.next();
            if (habitacion.getNumero() == numero)
                return habitacion;
        }
        return null;
    }

    /**
     * Inserta un residente si no existe ya.
     * 
     * @param residente Residente a insertar.
     * @return true si se insertó, false si ya existía.
     */
    public boolean insertarResidente(Residente residente) {
        if (residentes.contains(residente))
            return false;
        return residentes.add(residente);
    }

    /**
     * Inserta una habitación si no existe ya.
     * 
     * @param habitacion Habitación a insertar.
     */
    public void insertarHabitacion(Habitacion habitacion) {
        if (habitaciones.contains(habitacion))
            return;
        Iterator<Habitacion> iterator = habitaciones.iterator();
        while (iterator.hasNext()) {
            String numero = iterator.next().getNumero();
            if (numero == habitacion.getNumero())
                return;
        }
        habitaciones.add(habitacion);
    }

    /**
     * Cambia un residente de habitación.
     * 
     * @param residente       Residente a cambiar.
     * @param nuevaHabitacion Nueva habitación asignada.
     * @param fechaInicio     Fecha de inicio de la nueva reserva.
     * @param fechaFin        Fecha de fin de la nueva reserva.
     */
    public void cambiarHabitacion(Residente residente, Habitacion nuevaHabitacion, Date fechaInicio, Date fechaFin) {
        reservas.add(new Reserva(residente, nuevaHabitacion, fechaInicio, fechaFin));
    }

    /**
     * Genera un listado de residentes con sus habitaciones en una fecha dada.
     * 
     * @param fecha Fecha consultada.
     * @return String con el listado.
     */
    public String listadoResidentesHabitaciones(Date fecha) {
        Reserva[] reservas = getReservas();
        StringBuffer salida = new StringBuffer("");
        for (int i = 0; i < reservas.length; i++) {
            Date fechaInicio = reservas[i].getFechaInicio(), fechaFin = reservas[i].getFechaFin();
            if ((fecha.after(fechaInicio) && fecha.before(fechaFin)) || fecha.equals(fechaInicio)
                    || fecha.equals(fechaFin)) {
                if (salida.isEmpty() || reservas[i].getResidente().getNombre()
                        .compareToIgnoreCase(reservas[i - 1].getResidente().getNombre()) > 0) {
                    salida.append("Habitacion " + reservas[i].getHabitacion().getNumero() + ": "
                            + reservas[i].getResidente().getNombre() + "\n");
                    continue;
                }
                if (reservas[i].getResidente().getNombre()
                        .compareToIgnoreCase(reservas[i - 1].getResidente().getNombre()) < 0) {
                    salida.insert(0, "Habitacion " + reservas[i].getHabitacion().getNumero() + ": "
                            + reservas[i].getResidente().getNombre() + "\n");
                    continue;
                }
            }
        }
        return salida.toString();
    }

    /**
     * Lista habitaciones libres en una fecha dada.
     * 
     * @param fecha Fecha consultada.
     * @return String con las habitaciones libres.
     */
    public String listadoHabitacionesLibres(Date fecha) {
        Reserva[] reservas = getReservas();
        StringBuffer salida = new StringBuffer("");
        for (int i = 0; i < reservas.length; i++) {
            Date fechaInicio = reservas[i].getFechaInicio(), fechaFin = reservas[i].getFechaFin();
            if (!((fecha.after(fechaInicio) && fecha.before(fechaFin)) || fecha.equals(fechaInicio)
                    || fecha.equals(fechaFin))) {
                salida.append("Habitacion " + reservas[i].getHabitacion().getNumero());
            }
        }
        return salida.toString();
    }

    /**
     * Calcula la edad media de residentes por sexo en una fecha dada.
     * 
     * @param fecha Fecha consultada.
     * @return String con el informe de edad media por sexo.
     */
    public String listadoEdadMediaPorSexo(Date fecha) {
        Reserva[] reservas = getReservas();
        String formato = "Listado de edad media por sexo:\n" + "Edad hombres   Edad mujeres\n";
        StringBuffer salida = new StringBuffer(formato);
        double sumaEdadesHombres = 0.0;
        double sumaEdadesMujeres = 0.0;
        double mediaEdadHombres = 0.0;
        double mediaEdadMujeres = 0.0;
        int numeroHombres = 0;
        int numeroMujeres = 0;
        for (Reserva reserva : reservas) {
            Residente residente = reserva.getResidente();
            int edad = residente.getEdad(fecha);
            if (residente.getSexo() == 'V') {
                sumaEdadesHombres += edad;
                numeroHombres++;
            } else {
                sumaEdadesMujeres += edad;
                numeroMujeres++;
            }
        }
        if (numeroHombres != 0)
            mediaEdadHombres = sumaEdadesHombres / numeroHombres;
        if (numeroMujeres != 0)
            mediaEdadMujeres = sumaEdadesMujeres / numeroMujeres;
        salida.append(mediaEdadHombres + "\t\t\t");
        salida.append(mediaEdadMujeres + " ");
        return salida.toString();
    }

    /**
     * @return Array de habitaciones.
     */
    public Habitacion[] getHabitaciones() {
        Habitacion[] arrayHabitaciones = new Habitacion[habitaciones.size()];
        Iterator<Habitacion> iterator = habitaciones.iterator();
        for (int i = 0; i < arrayHabitaciones.length; i++) {
            arrayHabitaciones[i] = iterator.next();
        }
        return arrayHabitaciones;
    }

    /**
     * @return Nombre de la residencia.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return Array de reservas.
     */
    public Reserva[] getReservas() {
        Reserva[] arrayReservas = new Reserva[reservas.size()];
        Iterator<Reserva> iterator = reservas.iterator();
        for (int i = 0; i < arrayReservas.length; i++) {
            arrayReservas[i] = iterator.next();
        }
        return arrayReservas;
    }

    /**
     * @return Número total de habitaciones.
     */
    public int getNHabitaciones() {
        return habitaciones.size();
    }

    /**
     * @return Número total de residentes.
     */
    public int getNResidentes() {
        return residentes.size();
    }

    /**
     * @return Número total de reservas.
     */
    public int getNReservas() {
        return reservas.size();
    }

    /**
     * Elimina una habitación de la residencia.
     * 
     * @param habitacion Habitación a eliminar.
     */
    public void eliminarHabitacion(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }
}
