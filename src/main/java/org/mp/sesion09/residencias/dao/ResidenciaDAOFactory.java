/**
 * Clase de fábrica que proporciona una implementación concreta de la interfaz
 * DataAccessObject dependiendo del tipo de formato solicitado (XML, JSON o SER).
 * 
 * Esta clase implementa el patrón de diseño Factory.
 * 
 * @author Maria Camila Soto Zapata
 * @since 2025
 */

package org.mp.sesion09.residencias.dao;

public class ResidenciaDAOFactory {

    /**
     * Crea una instancia de DataAccessObject según el tipo de archivo proporcionado.
     *
     * @param archivoDatos Ruta del archivo donde se almacenarán los datos.
     * @param string Tipo de formato del archivo (xml, json o ser).
     * @return Instancia concreta de DataAccessObject correspondiente al tipo de archivo.
     * @throws IllegalArgumentException Si el tipo de archivo no es válido.
     */
    public static DataAccessObject createResidenciaDAOFactory(String archivoDatos, String string) {
        if (string.equalsIgnoreCase("xml"))
            return new ResidenciaXML(archivoDatos);
        else if (string.equalsIgnoreCase("ser"))
            return new ResidenciaSER(archivoDatos);
        else if (string.equalsIgnoreCase("json"))
            return new ResidenciaJSON(archivoDatos);
        else
            throw new IllegalArgumentException("Tipo de archivo (" + string + ") incorrecto. Solo soporta XML, JSON o SER.");
    }
}
