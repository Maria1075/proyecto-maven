/**
 * Clase DAO (Data Access Object) para manejar operaciones de entrada/salida
 * de objetos tipo Imagen, incluyendo lectura y escritura de archivos en formato BSQ.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion09.imagen;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImagenDAO {

    /**
     * Escribe la cabecera del archivo de imagen y luego los datos en formato BSQ si corresponde.
     *
     * @param nombreArchivo Ruta del archivo a escribir
     * @param imagen         Imagen a guardar
     * @throws IOException Si ocurre un error de escritura
     */
    public static void escribirArchivo(String nombreArchivo, Imagen imagen) throws IOException {
        File archivo = new File(nombreArchivo);
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        String nombre = archivo.getName();

        // Cabecera: archivo.dat TipoImagen FormatoImagen nBandas [nombresBandas] filas columnas
        nombre = nombre.substring(0, nombre.indexOf("."));
        pw.println(nombre + ".dat");
        pw.println(imagen.getTipoImagen());
        pw.println(imagen.getFormatoImagen());
        pw.println(imagen.getNumeroBandas());

        List<String> nombreBandas = new ArrayList<>();
        Iterator<Banda<?>> bandas = imagen.getBandas().iterator();
        while (bandas.hasNext())
            nombreBandas.add(bandas.next().getNombreBanda());

        StringBuffer nombresBandas = new StringBuffer("[");
        Iterator<String> nombres = nombreBandas.iterator();
        while (nombres.hasNext()) {
            nombresBandas.append(nombres.next());
            if (nombres.hasNext())
                nombresBandas.append(";");
        }
        nombresBandas.append("]");
        pw.println(nombresBandas);
        pw.println(imagen.getLineas());
        pw.println(imagen.getColumnas());
        pw.close();

        String nombreNuevo = archivo.getParent() + File.separator + nombre + ".dat";

        if (imagen.getFormatoImagen().equals("BSQ"))
            escribirBSQ(nombreNuevo, imagen);
    }

    /**
     * Escribe los datos de la imagen en formato BSQ (una banda tras otra).
     *
     * @param nombreArchivo Archivo binario de salida
     * @param imagen         Imagen con los datos
     */
    private static void escribirBSQ(String nombreArchivo, Imagen imagen) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(nombreArchivo)));
            Iterator<Banda<?>> iterator = imagen.getBandas().iterator();

            while (iterator.hasNext()) {
                Banda<?> actual = iterator.next();
                for (int i = 0; i < imagen.getLineas(); i++) {
                    for (int j = 0; j < imagen.getColumnas(); j++) {
                        if (imagen.getTipoImagen().equals("Integer"))
                            dos.writeInt((int) actual.getDatoXY(i, j));
                        else
                            dos.writeDouble((double) actual.getDatoXY(i, j));
                    }
                }
            }
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee una imagen desde su archivo de cabecera y datos BSQ.
     *
     * @param nombreArchivo Ruta al archivo de cabecera
     * @return Imagen reconstruida
     */
    public static Imagen leerArchivo(String nombreArchivo) {
        Imagen imagen = null;
        String[] nombresBandas = null;
        String tipoImagen = null;
        String archivoImagen = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(nombreArchivo)));
            archivoImagen = br.readLine();
            tipoImagen = br.readLine();
            String formatoImagen = br.readLine();
            int nBandas = Integer.parseInt(br.readLine());
            String nombreBandas = br.readLine();
            nombresBandas = nombreBandas.substring(1, nombreBandas.length() - 1).split(";");
            int lineas = Integer.parseInt(br.readLine());
            int columnas = Integer.parseInt(br.readLine());
            br.close();

            imagen = new Imagen(lineas, columnas, formatoImagen, tipoImagen);
        } catch (Exception e) {
            e.printStackTrace();
        }

        archivoImagen = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "java" + File.separator + "org" + File.separator + "mp" + File.separator + "sesion09"
                + File.separator + "imagen" + File.separator + archivoImagen;

        imagen = leerBSQ(archivoImagen, imagen, nombresBandas, tipoImagen);
        return imagen;
    }

    /**
     * Lee los datos BSQ de un archivo binario y los carga en una Imagen.
     *
     * @param nombreArchivo Ruta del archivo binario BSQ
     * @param imagen         Objeto Imagen a completar
     * @param nBandas        Arreglo con los nombres de las bandas
     * @param tipoImagen     Tipo de datos (Integer o Double)
     * @return Imagen con bandas cargadas
     */
    private static Imagen leerBSQ(String nombreArchivo, Imagen imagen, String[] nBandas, String tipoImagen) {
        Integer[][] datosI = null;
        Double[][] datosD = null;
        boolean isInteger = false;

        if (tipoImagen.equals("Integer")) {
            datosI = new Integer[imagen.getLineas()][imagen.getColumnas()];
            isInteger = true;
        } else if (tipoImagen.equals("Double")) {
            datosD = new Double[imagen.getLineas()][imagen.getColumnas()];
        }

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchivo));
            for (int i = 0; i < nBandas.length; i++) {
                String nomBanda = nBandas[i];
                for (int j = 0; j < imagen.getLineas(); j++) {
                    for (int k = 0; k < imagen.getColumnas(); k++) {
                        if (isInteger)
                            datosI[j][k] = dis.readInt();
                        else
                            datosD[j][k] = dis.readDouble();
                    }
                }
                Banda<Number> bandaNueva = isInteger
                        ? new Banda<>(nomBanda, datosI)
                        : new Banda<>(nomBanda, datosD);
                imagen.anadirBanda(bandaNueva);
            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imagen;
    }
}
