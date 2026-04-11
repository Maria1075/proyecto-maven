/**
 * Clase que implementa la interfaz DataAccessObject para manejar
 * operaciones de lectura y escritura de objetos de tipo Residencia
 * utilizando el formato XML mediante la librería XStream.
 * 
 * Permite la persistencia de objetos en archivos XML.
 *
 * @author Maria Camila Soto Zapata
 * @since 2025
 */

package org.mp.sesion09.residencias.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.*;
import org.mp.sesion09.residencias.Residencia;

public class ResidenciaXML implements DataAccessObject {
    
    private String archivoDatos;

    /**
     * Constructor que define la ruta del archivo XML de datos.
     *
     * @param archivoDatos Ruta del archivo donde se almacenarán o leerán los datos.
     */
    public ResidenciaXML(String archivoDatos) {
        this.archivoDatos = archivoDatos;
    }

    /**
     * Serializa un objeto a formato XML y lo escribe en el archivo especificado.
     *
     * @param object Objeto a serializar.
     */
    @Override
    public void escribir(Object object) {
        try (FileOutputStream fos = new FileOutputStream(archivoDatos)) {
            XStream xstream = new XStream(new DomDriver());
            xstream.toXML(object, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializa un objeto desde el archivo XML especificado.
     *
     * @return Objeto deserializado (instancia de Residencia) o null si hay error.
     */
    @Override
    public Object leer() {
        try (FileInputStream fis = new FileInputStream(archivoDatos)) {
            XStream xstream = new XStream(new DomDriver());
            xstream.addPermission(AnyTypePermission.ANY);
            return (Residencia) xstream.fromXML(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
