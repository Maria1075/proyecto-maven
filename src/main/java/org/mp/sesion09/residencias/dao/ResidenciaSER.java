/**
 * Clase que implementa la interfaz DataAccessObject para manejar
 * operaciones de lectura y escritura de objetos de tipo Residencia
 * utilizando serialización Java (formato .ser).
 *
 * Esta clase permite guardar y recuperar objetos en formato binario.
 * 
 * @author Maria Camila Soto Zapata
 * @since 2025
 */

package org.mp.sesion09.residencias.dao;

import java.io.*;
import org.mp.sesion09.residencias.Residencia;

public class ResidenciaSER implements DataAccessObject, Serializable {

    private String archivoDatos;

    /**
     * Constructor que recibe el nombre del archivo donde se almacenarán los datos.
     *
     * @param archivoDatos Ruta del archivo .ser donde se escribirá o leerá el objeto.
     */
    public ResidenciaSER(String archivoDatos) {
        this.archivoDatos = archivoDatos;
    }

    /**
     * Serializa y escribe un objeto en el archivo especificado.
     *
     * @param obj Objeto a serializar (se espera que sea instancia de Residencia).
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    @Override
    public void escribir(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDatos));
        try {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee y deserializa un objeto desde el archivo especificado.
     *
     * @return Objeto deserializado o null si ocurre un error.
     */
    @Override
    public Object leer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDatos))) {
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
