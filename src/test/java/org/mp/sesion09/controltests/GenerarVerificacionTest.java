package org.mp.sesion09.controltests;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GenerarVerificacionTest {

    @Test
    void verificarUrlPrueba() {
        String rutaBase = System.getProperty("user.dir");
        List<InfoArchivo> listaArchivos = new ArrayList<>();
        boolean fallo = false;

        String urlStringLinuxMac = "https://drive.google.com/uc?export=view&id=1o2caXsq9WxoN0csU07KVCoc7poF2VuYp";
        String urlStringWindows = "https://drive.google.com/uc?export=view&id=180ZrUKn4W4RMZIVUqwn45AHdp1RE5WDn";
        String urlString;
        //https://drive.google.com/file/d/1o2caXsq9WxoN0csU07KVCoc7poF2VuYp/view?usp=drive_link
        //https://drive.google.com/file/d/180ZrUKn4W4RMZIVUqwn45AHdp1RE5WDn/view?usp=drive_link
        try {
            // Obtener la lista de archivos que terminan en Test.java en el proyecto
            List<File> archivosTest = new ArrayList<>();
            recopilarArchivosTest(new File(rutaBase), archivosTest);

            // Determinar el sistema operativo y cargar la URL correspondiente
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("windows")) {
                urlString = urlStringWindows;
            } else {
                urlString = urlStringLinuxMac;
            }
            
            
            URL url = new URL(urlString);
            try (BufferedReader lector = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String linea;
                lector.readLine(); // Omitir la línea de encabezado

                while ((linea = lector.readLine()) != null) {
                    String[] partes = linea.split(";");
                    String nombreArchivo = partes[0];
                    long tamanoArchivo = Long.parseLong(partes[1]);
                    String md5 = partes[2];

                    // Ajuste adicional solicitado por el usuario
                    nombreArchivo = nombreArchivo.substring(9);

                    // Buscar el archivo en la lista de archivos de test
                    File archivo = buscarArchivo(archivosTest, nombreArchivo);
                    if (archivo != null) {
                        String md5Calculado = calcularMD5(archivo);
                        listaArchivos.add(new InfoArchivo(nombreArchivo, archivo.length(), md5Calculado));

                        if (tamanoArchivo != archivo.length()) {
                            System.err.println("Archivo " + archivo.getAbsolutePath() + ": FALLO - Tamaño incorrecto");
                            fallo = true;
                        } else if (!md5.equals(md5Calculado)) {
                            System.err.println("Archivo " + archivo.getAbsolutePath() + ": FALLO - Hash MD5 incorrecto");
                            fallo = true;
                        } else {
                            System.out.println("Archivo " + archivo.getAbsolutePath() + ": OK");
                        }
                    } else {
                        System.err.println("Archivo " + rutaBase + File.separator + nombreArchivo + ": NO ENCONTRADO");
                        fallo = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            fallo = true;
        }

        assertNotNull(listaArchivos, "No se encontraron archivos en la URL proporcionada.");

        if (fallo) {
            System.err.println("Se produjeron fallos durante la verificación de la URL.");
        }
    }

    private void recopilarArchivosTest(File dir, List<File> archivosTest) {
        if (dir.isDirectory()) {
            for (File archivo : dir.listFiles()) {
                if (archivo.isDirectory()) {
                    recopilarArchivosTest(archivo, archivosTest);
                } else if (archivo.getName().endsWith("Test.java")) {
                    archivosTest.add(archivo);
                }
            }
        }
    }

    private File buscarArchivo(List<File> archivosTest, String nombreArchivo) {
        for (File archivo : archivosTest) {
            if (archivo.getPath().endsWith(nombreArchivo.replace("/", File.separator))) {
                return archivo;
            }
        }
        return null;
    }

    private static String calcularMD5(File archivo) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytesArchivo = Files.readAllBytes(archivo.toPath());
            byte[] digest = md.digest(bytesArchivo);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class InfoArchivo {
        private final String nombre;
        private final long tamano;
        private final String md5;

        public InfoArchivo(String nombre, long tamano, String md5) {
            this.nombre = nombre;
            this.tamano = tamano;
            this.md5 = md5;
        }

        public String getNombre() {
            return nombre;
        }

        public long getTamano() {
            return tamano;
        }

        public String getMd5() {
            return md5;
        }
    }
}