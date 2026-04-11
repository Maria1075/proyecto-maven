/**
 * Interfaz DataAccessObject que define las operaciones básicas de escritura
 * y lectura para persistencia de datos en archivos o cualquier otro medio.
 *
 * @author Maria Camila Soto Zapata
 * @since 2025
 */

package org.mp.sesion09.residencias.dao;

import java.io.IOException;

public interface DataAccessObject {

    /**
     * Escribe un objeto en un medio de almacenamiento (por ejemplo, archivo).
     *
     * @param obj Objeto a escribir.
     * @throws IOException Si ocurre un error durante la escritura.
     */
    public void escribir(Object obj) throws IOException;

    /**
     * Lee un objeto desde un medio de almacenamiento.
     *
     * @return El objeto leído.
     * @throws IOException Si ocurre un error durante la lectura.
     */
    public Object leer() throws IOException;
}
