package org.mp.sesion08.estadistica;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mp.sesion08.conjuntodatos.ConjuntoDatos;

public class EstadisticaTest {
	String archivoTexto;
	String directorioEntrada;
	ConjuntoDatos cd; 
	Estadistica estadistica;

	@BeforeEach
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");
        directorioEntrada = directorioEntrada 
        		+ File.separator + "src"
        		+ File.separator + "main"
        		+ File.separator + "java"
                + File.separator + "org" 
        		+ File.separator + "mp"
                + File.separator + "sesion08" 
                + File.separator + "estadistica" 
        		+ File.separator;

		String temperaturas = directorioEntrada + "temperaturas.txt";
		File file = new File(temperaturas);
		cd = new ConjuntoDatos(file, ";", new Locale("English",
				"US"));
	    estadistica = new Estadistica(cd);
	}

	@Test
	public void testNormal() throws Exception {
		assertEquals(estadistica.max("TM"),18.2,0.01);
		assertEquals(estadistica.min("Tm"),4.7,0.00);
		assertEquals(estadistica.suma("PT"),22.5,0.01);
		assertEquals(estadistica.media("VV"),12.09,0.01);
		assertEquals(estadistica.max("VR"),51.86,0.01);
		assertEquals(estadistica.media("VR"), Double.NaN, 0.0000000001);
	}
}
