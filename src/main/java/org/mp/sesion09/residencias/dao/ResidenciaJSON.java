/**
 * Clase que implementa la interfaz DataAccessObject para manejar
 * operaciones de lectura y escritura de objetos de tipo Residencia
 * en formato JSON utilizando la librería Gson.
 * 
 * Esta implementación permite serializar y deserializar objetos de tipo
 * Residencia a/desde archivos JSON.
 * 
 * @author Maria Camila Soto Zapata
 * @since 2025
 */

package org.mp.sesion09.residencias.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import org.mp.sesion09.residencias.Residencia;

public class ResidenciaJSON implements DataAccessObject {

    private String archivoDatos;

    /**
     * Constructor que inicializa el archivo donde se leerán/escribirán los datos.
     *
     * @param archivoDatos Ruta del archivo JSON.
     */
    public ResidenciaJSON(String archivoDatos) {
        this.archivoDatos = archivoDatos;
    }

    /**
     * Escribe un objeto en formato JSON en el archivo especificado.
     *
     * @param object Objeto a serializar (se espera que sea instancia de Residencia).
     */
    @Override
    public void escribir(Object object) {
        try (FileWriter writer = new FileWriter(archivoDatos)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee y deserializa un objeto de tipo Residencia desde el archivo JSON.
     *
     * @return Objeto deserializado o null si ocurre un error.
     */
    @Override
    public Object leer() {
        try (FileReader reader = new FileReader(archivoDatos)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<Residencia>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
