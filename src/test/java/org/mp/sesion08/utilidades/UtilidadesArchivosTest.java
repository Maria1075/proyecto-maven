package org.mp.sesion08.utilidades;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UtilidadesArchivosTest {

    private static Path tempDirPath;

    @BeforeAll
    static void setUp() throws IOException {
        tempDirPath = Files.createTempDirectory("PruebasArchivosTemp");
    }

    @Test
    @Order(1)
    void testCrearArchivo_ArchivoCreado() throws IOException {
        String ruta = tempDirPath.resolve("archivo_nuevo.txt").toString();
        UtilidadesArchivos.crearArchivo(ruta);

        // Assert that the file exists
        assertTrue(Files.exists(Paths.get(ruta)));
    }

    @Test
    @Order(2)
    void testVerificarExistenciaArchivo_ArchivoNoExistente() {
        String ruta = tempDirPath.resolve("archivo_no_existente.txt").toString();

        assertFalse(UtilidadesArchivos.verificarExistenciaArchivo(ruta));
    }

    @Test
    @Order(3)
    void testEliminarArchivo_ArchivoEliminado() throws IOException {
        String ruta = tempDirPath.resolve("archivo_a_eliminar.txt").toString();
        Files.createFile(Paths.get(ruta));

        assertTrue(UtilidadesArchivos.eliminarArchivo(ruta));
        assertFalse(Files.exists(Paths.get(ruta)));
    }

    @Test
    @Order(4)
    void testEliminarArchivo_ArchivoNoExistente() {
        String ruta = tempDirPath.resolve("archivo_no_existente.txt").toString();

        assertFalse(UtilidadesArchivos.eliminarArchivo(ruta));
        // Assert that the message indicates missing file (optional)
    }

    @Test
    @Order(5)
    void testObtenerNombreArchivo() {
        String rutaCompleta = tempDirPath.resolve("archivo_con_nombre.txt").toString();

        String nombreArchivo = UtilidadesArchivos.obtenerNombreArchivo(rutaCompleta);
        assertEquals("archivo_con_nombre.txt", nombreArchivo);
    }

    @Test
    @Order(6)
    void testObtenerRutaPadre() {
        String rutaCompleta = tempDirPath.resolve("subdirectorio/archivo.txt").toString();

        String rutaPadre = UtilidadesArchivos.obtenerRutaPadre(rutaCompleta);
        assertEquals(tempDirPath.resolve("subdirectorio").toString(), rutaPadre);
    }

    @Test
    @Order(7)
    void testCopiarArchivo_ArchivoCopiado() throws IOException {
        String rutaOrigen = tempDirPath.resolve("archivo_origen.txt").toString();
        String rutaDestino = tempDirPath.resolve("archivo_destino.txt").toString();
        Files.createFile(Paths.get(rutaOrigen));
        if (Files.exists(Paths.get(rutaDestino))) {
            Files.delete(Paths.get(rutaDestino));
        }

        UtilidadesArchivos.copiarArchivo(rutaOrigen, rutaDestino);
        assertTrue(Files.exists(Paths.get(rutaDestino)));
        assertEquals(Files.size(Paths.get(rutaOrigen)), Files.size(Paths.get(rutaDestino)));
    }

    @Test
    @Order(10)
    void testCopiarDirectorio_DirectorioVacio() throws IOException {
        String rutaOrigen = tempDirPath.resolve("directorio_vacio").toString();
        Files.createDirectory(Paths.get(rutaOrigen));

        String rutaDestino = tempDirPath.resolve("directorio_destino").toString();

        UtilidadesArchivos.copiarDirectorioRecursivamente(rutaOrigen, rutaDestino);

        assertTrue(Files.exists(Paths.get(rutaDestino)));
        assertTrue(Files.isDirectory(Paths.get(rutaDestino)));
        assertEquals(0, Files.list(Paths.get(rutaDestino)).count());
    }

    @Test
    @Order(11)
    void testCopiarDirectorio_DirectorioConArchivos() throws IOException {
        String rutaOrigen = tempDirPath.resolve("directorio_con_archivos").toString();
        Files.createDirectory(Paths.get(rutaOrigen));
        Files.createFile(Paths.get(rutaOrigen, "archivo1.txt"));
        Files.createFile(Paths.get(rutaOrigen, "archivo2.txt"));

        String rutaDestino = tempDirPath.resolve("directorio_destino").toString();

        UtilidadesArchivos.copiarDirectorioRecursivamente(rutaOrigen, rutaDestino);

        assertTrue(Files.exists(Paths.get(rutaDestino)));
        assertTrue(Files.isDirectory(Paths.get(rutaDestino)));
        assertEquals(2, Files.list(Paths.get(rutaDestino)).count());
    }

    @Test
    @Order(22)
    void testObtenerTamanioArchivo() throws IOException {
        String ruta = tempDirPath.resolve("archivo_tamanio.txt").toString();
        Files.createFile(Paths.get(ruta));

        long tamanioArchivo = UtilidadesArchivos.obtenerTamanioArchivo(ruta);
        assertEquals(0, tamanioArchivo);
    }

    @Test
    @Order(23)
    void testVerificarSiEsDirectorio_EsDirectorio() throws IOException {
        String rutaDirectorio = tempDirPath.resolve("directorio_prueba").toString();
        Files.createDirectory(Paths.get(rutaDirectorio));

        assertTrue(UtilidadesArchivos.verificarSiEsDirectorio(rutaDirectorio));
    }

    @Test
    @Order(24)
    void testVerificarSiEsDirectorio_NoEsDirectorio() throws IOException {
        String rutaArchivo = tempDirPath.resolve("archivo_prueba.txt").toString();
        Files.createFile(Paths.get(rutaArchivo));

        assertFalse(UtilidadesArchivos.verificarSiEsDirectorio(rutaArchivo));
    }

    @Test
    @Order(25)
    void testObtenerRutaActual() {
        Path rutaActual = UtilidadesArchivos.obtenerRutaActual();
        assertNotNull(rutaActual);
    }

    @Test
    @Order(26)
    void testObtenerRutaRaiz() {
        Path rutaRaiz = UtilidadesArchivos.obtenerRutaRaiz();
        assertNotNull(rutaRaiz);

        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        if (sistemaOperativo.contains("win")) {
            // Windows
            assertEquals("C:\\", rutaRaiz.toString());
        } else {
            // Otros sistemas operativos (Linux, macOS, etc.)
            assertEquals("/", rutaRaiz.toString());
        }
    }

    @Test
    @Order(27)
    void testObtenerRutaRelativa() {
    	String directorioEntrada01 = System.getProperty("user.dir");
    	String directorioEntrada02 = "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "org" + File.separator + "mp" + File.separator + "sesion08" + File.separator
				+ "conjuntodatos" ;
    	String directorioEntrada03 = directorioEntrada01 + File.separator + directorioEntrada02;
    	System.out.println(directorioEntrada01);
    	System.out.println(directorioEntrada02);
    	System.out.println(directorioEntrada03);
   	
        Path rutaBase = Paths.get(directorioEntrada01);
        Path rutaEspecifica = Paths.get(directorioEntrada03);

        Path rutaRelativa = UtilidadesArchivos.obtenerRutaRelativa(rutaBase, rutaEspecifica);
        assertEquals(directorioEntrada02, rutaRelativa.toString());
    }

    @Test
    @Order(28)
    void testObtenerStringRuta() {
    	String directorioEntrada01 = System.getProperty("user.dir");
    	String directorioEntrada02 = "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "org" + File.separator + "mp" + File.separator + "sesion08" + File.separator
				+ "conjuntodatos" ;
    	String directorioEntrada03 = directorioEntrada01 + File.separator + directorioEntrada02;

        Path ruta = Paths.get(directorioEntrada03);
        String rutaString = UtilidadesArchivos.obtenerStringRuta(ruta);
        assertEquals(directorioEntrada03, rutaString);
    }

    @Test
    @Order(29)
    void testCompararRutas() {
    	String directorioEntrada01 = System.getProperty("user.dir");
    	String directorioEntrada02 = "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "org" + File.separator + "mp" + File.separator + "sesion08" + File.separator
				+ "conjuntodatos" ;
    	String directorioEntrada03 = directorioEntrada01 + File.separator + directorioEntrada02;


        Path ruta1 = Paths.get(directorioEntrada01);
        Path ruta2 = Paths.get(directorioEntrada01);
        Path ruta3 = Paths.get(directorioEntrada03);

        assertFalse(UtilidadesArchivos.compararRutas(ruta1, ruta3));
        assertTrue(UtilidadesArchivos.compararRutas(ruta1, ruta2));
    }

    @Test
    @Order(31)
    void testCopiarArchivosConFiltro_SinFiltro() throws IOException {
        String rutaOrigen = tempDirPath.resolve("directorio_origen01").toString();
        String rutaDestino = tempDirPath.resolve("directorio_destino01").toString();
        Files.createDirectory(Paths.get(rutaOrigen));
        Files.createFile(Paths.get(rutaOrigen, "archivo1.txt"));
        Files.createFile(Paths.get(rutaOrigen, "archivo2.txt"));
        Files.createFile(Paths.get(rutaOrigen, "archivo3.xml"));

        UtilidadesArchivos.copiarArchivosConFiltro(rutaOrigen, rutaDestino, ".*");

        assertTrue(Files.exists(Paths.get(rutaDestino, "archivo1.txt")));
        assertTrue(Files.exists(Paths.get(rutaDestino, "archivo2.txt")));
        assertTrue(Files.exists(Paths.get(rutaDestino, "archivo3.xml")));
    }

    @Test
    @Order(32)
    void testCopiarArchivosConFiltro_ConFiltro() throws IOException {
        String rutaOrigen = tempDirPath.resolve("directorio_origen02").toString();
        String rutaDestino = tempDirPath.resolve("directorio_destino02").toString();
        Files.createDirectory(Paths.get(rutaOrigen));
        Files.createFile(Paths.get(rutaOrigen, "archivo1.txt"));
        Files.createFile(Paths.get(rutaOrigen, "archivo2.txt"));
        Files.createFile(Paths.get(rutaOrigen, "archivo3.xml"));

        UtilidadesArchivos.copiarArchivosConFiltro(rutaOrigen, rutaDestino, ".*\\.txt");

        assertTrue(Files.exists(Paths.get(rutaDestino, "archivo1.txt")));
        assertTrue(Files.exists(Paths.get(rutaDestino, "archivo2.txt")));
        assertFalse(Files.exists(Paths.get(rutaDestino, "archivo3.xml")));
    }

  

    @Test
    @Order(33)
    void testListarArchivosEnDirectorio_DirectorioConArchivos() throws IOException {
        String rutaDirectorio = tempDirPath.resolve("directorio_con_archivos03").toString();
        Files.createDirectory(Paths.get(rutaDirectorio));
        Files.createFile(Paths.get(rutaDirectorio, "archivo1.txt"));
        Files.createFile(Paths.get(rutaDirectorio, "archivo2.txt"));

        List<File> archivos = UtilidadesArchivos.listarArchivosEnDirectorio(rutaDirectorio);
        assertEquals(2, archivos.size());
    }
    
    @Test
    void testRecorrerDirectorioRecursivamente() throws IOException {
        String rutaDirectorio = tempDirPath.resolve("directorio_recursivo").toString();
        Files.createDirectory(Paths.get(rutaDirectorio));
        Files.createFile(Paths.get(rutaDirectorio, "archivo1.txt"));

        Path subdirectorio1 = Files.createDirectory(Paths.get(rutaDirectorio, "subdirectorio1"));
        Files.createFile(subdirectorio1.resolve("archivo2.txt"));

        Path subdirectorio2 = Files.createDirectory(Paths.get(subdirectorio1.toString(), "subdirectorio2"));
        Files.createFile(subdirectorio2.resolve("archivo3.txt"));

        List<Path> pathsVisitados = new ArrayList<>();
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                pathsVisitados.add(file);
                return FileVisitResult.CONTINUE;
            }
        };

        UtilidadesArchivos.recorrerDirectorioRecursivamente(rutaDirectorio, visitor);

        assertEquals(6, pathsVisitados.size());
        assertTrue(pathsVisitados.contains(Paths.get(rutaDirectorio)));
        assertTrue(pathsVisitados.contains(Paths.get(rutaDirectorio, "archivo1.txt")));
        assertTrue(pathsVisitados.contains(subdirectorio1));
        assertTrue(pathsVisitados.contains(subdirectorio1.resolve("archivo2.txt")));
        assertTrue(pathsVisitados.contains(subdirectorio2.resolve("archivo3.txt")));
    }
}
