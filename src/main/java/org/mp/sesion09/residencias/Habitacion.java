/**
 * Clase que representa una habitación en una residencia.
 * Implementa Serializable para permitir la persistencia del objeto.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.residencias;

import java.io.Serializable;

public class Habitacion implements Serializable {

    private String numero;

    /**
     * Constructor que inicializa la habitación con su número.
     *
     * @param numero Número identificador de la habitación.
     */
    public Habitacion(String numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el número de la habitación.
     *
     * @return número de la habitación.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece un nuevo número para la habitación.
     *
     * @param numero Nuevo número de habitación.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
