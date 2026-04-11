/**
 * Clase que representa un residente con datos personales como nombre, DNI,
 * sexo y fecha de nacimiento. Permite calcular la edad en una fecha dada.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.residencias;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Residente implements Serializable {

    private String dni;
    private String nombre;
    private char sexo;
    private Date fechaNacimiento;

    /**
     * Constructor para inicializar un residente con todos sus atributos.
     *
     * @param nombre           Nombre del residente.
     * @param dni              DNI del residente.
     * @param sexo             Sexo del residente ('V' para varón, 'M' para mujer).
     * @param fechaNacimiento  Fecha de nacimiento del residente.
     */
    public Residente(String nombre, String dni, char sexo, Date fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula la edad del residente en una fecha específica.
     *
     * @param fecha Fecha en la que se desea calcular la edad.
     * @return Edad del residente.
     */
    public int getEdad(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(fechaNacimiento);
        int yearNacimiento = calendar.get(Calendar.YEAR);
        int monthNacimiento = calendar.get(Calendar.MONTH);
        int dayNacimiento = calendar.get(Calendar.DAY_OF_MONTH);

        if (month < monthNacimiento || (month == monthNacimiento && day < dayNacimiento)) {
            year--;
        }

        return year - yearNacimiento;
    }

    /** @return DNI del residente. */
    public String getDni() {
        return dni;
    }

    /** @param dni Nuevo DNI del residente. */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /** @return Nombre del residente. */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre Nuevo nombre del residente. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return Sexo del residente ('V' o 'M'). */
    public char getSexo() {
        return sexo;
    }

    /** @param sexo Nuevo sexo del residente ('V' o 'M'). */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /** @return Fecha de nacimiento del residente. */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /** @param fechaNacimiento Nueva fecha de nacimiento. */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
