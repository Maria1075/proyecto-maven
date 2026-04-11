package org.mp.sesion08.conjuntodatos;

import static org.junit.jupiter.api.Assertions.*;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConjuntoDatosTest {

	String archivoTexto;
	String directorioEntrada;
	ConjuntoDatos cd;

	@BeforeEach
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");
		directorioEntrada = directorioEntrada + File.separator + "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "org" + File.separator + "mp" + File.separator + "sesion08" + File.separator
				+ "conjuntodatos" + File.separator;

		String ficheroPrueba = directorioEntrada + "archivoPrueba.txt";
		FileWriter fw = new FileWriter(ficheroPrueba);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.println("A;B;C");
		pw.println("1.1;1.2;1.3");
		pw.println("2.1;2.2;2.3");
		pw.println("3.1;3.2;3.3");
		pw.close();

		archivoTexto = directorioEntrada + "archivoPrueba.txt";
		File file = new File(archivoTexto);
		cd = new ConjuntoDatos(file, ";", Locale.forLanguageTag("en-US"));
	}

	@Test
	public void testBasico() throws Exception {
		assertTrue(cd.getArchivoTexto().getAbsolutePath().equals(archivoTexto));
		assertTrue(cd.getNumeroColumnas() == 3);
		assertTrue(cd.getNumeroLineas() == 3);
		assertTrue(cd.getSeparador().equals(";"));
		assertTrue(cd.getLocale().getCountry().equals("US"));

		ArrayList<String> cabecera = (ArrayList<String>) cd.getCabecera();
		assertTrue(cabecera.size() == 3);
		assertTrue(cabecera.get(0).equals("A"));
		assertTrue(cabecera.get(1).equals("B"));
		assertTrue(cabecera.get(2).equals("C"));

		String[][] datos = cd.getDatosString();
		assertEquals("1.1", datos[0][0]);
		assertEquals("3.3", datos[2][2]);
	}

	@Test
	public void testGetColumnaIndice() {
		try {
			String[] columna0 = cd.getColumna(0);
			assertEquals("1.1", columna0[0]);
			assertEquals("2.1", columna0[1]);
			assertEquals("3.1", columna0[2]);

			String[] columna1 = cd.getColumna(1);
			assertEquals("1.2", columna1[0]);
			assertEquals("2.2", columna1[1]);
			assertEquals("3.2", columna1[2]);

			String[] columna2 = cd.getColumna(2);
			assertEquals("1.3", columna2[0]);
			assertEquals("2.3", columna2[1]);
			assertEquals("3.3", columna2[2]);

			String[] columna3 = cd.getColumna(3);
			fail("Falla");
		} catch (Exception e) {
		}
	}

	@Test
	public void testGetColumnaString() {

		try {
			String[] columna0 = cd.getColumna("A");
			assertEquals("1.1", columna0[0]);
			assertEquals("2.1", columna0[1]);
			assertEquals("3.1", columna0[2]);

			String[] columna1 = cd.getColumna("B");
			assertEquals("1.2", columna1[0]);
			assertEquals("2.2", columna1[1]);
			assertEquals("3.2", columna1[2]);

			String[] columna2 = cd.getColumna("C");
			assertEquals("1.3", columna2[0]);
			assertEquals("2.3", columna2[1]);
			assertEquals("3.3", columna2[2]);
			
			String[] columna3 = cd.getColumna("D");
			fail("Falla");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void testExportar() throws Exception {
		archivoTexto = directorioEntrada + "archivoPruebaAB.txt";
		String[] cabeceraAB = { "A", "B" };
		cd.exportar(cabeceraAB, archivoTexto, ";");
		ConjuntoDatos cdAB = new ConjuntoDatos(new File(archivoTexto), ";", new Locale("English", "US"));
		assertTrue(cdAB.getArchivoTexto().getAbsolutePath().equals(archivoTexto));
		ArrayList<String> cabecera =  cdAB.getCabecera();

		assertTrue(cabecera.size() == 2);
		assertTrue(cabecera.get(0).equals("A"));
		assertTrue(cabecera.get(1).equals("B"));
		String[][] datos = cdAB.getDatosString();
		assertEquals("1.1", datos[0][0]);
		assertEquals("2.2", datos[1][1]);
	}
}
