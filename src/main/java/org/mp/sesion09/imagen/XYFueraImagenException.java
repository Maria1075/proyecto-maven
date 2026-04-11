/**
 * Excepción que se lanza cuando se intenta acceder a coordenadas (x, y)
 * que están fuera de los límites de una imagen.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.imagen;

public class XYFueraImagenException extends Exception {

    /**
     * Constructor por defecto que lanza la excepción sin mensaje adicional.
     */
    public XYFueraImagenException() {
        super();
    }
}
