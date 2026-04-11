package org.mp.sesion09.imagen;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Iterator;

public class ImagenTest {

    private Banda<Double> bandad;
    private Banda<Integer> bandai;

    @BeforeEach
    public void setUp() throws Exception {
        Integer[][] a = new Integer[10][10];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = 100;
            }
        }
        bandai = new Banda<>("BandaIntegers", a);

        Double[][] b = new Double[10][10];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = 100.1;
            }
        }
        bandad = new Banda<>("BandaDoubles", b);
    }

    @Test
    public void testOperaciones() throws XYFueraImagenException  {
        Imagen imagen = new Imagen(10, 10, "BSQ", "Doubles");
        assertTrue(imagen.getFormatoImagen().equals("BSQ"));
        assertTrue(imagen.getTipoImagen().equals("Doubles"));
        assertTrue(imagen.getNumeroBandas() == 0);

        imagen.anadirBanda(bandad);
        imagen.anadirBanda(bandad);

        assertTrue(imagen.getNumeroBandas() == 2);

        imagen.eliminarBanda(0);

        assertTrue(imagen.getNumeroBandas() == 1);

        imagen.anadirBanda(bandad);
        imagen.anadirBanda(bandad);

        assertTrue(imagen.getNumeroBandas() == 3);

        Number[] num = imagen.getDatosPixel(3, 3);
        for (int i = 0; i < num.length; i++) {
            assertTrue(num[i].doubleValue() == 100.1);
        }
    }

    @Test
    public void testExtraerImagen()  {
        Imagen imagen = new Imagen(10, 10, "BSQ", "Integers");
        assertTrue(imagen.getFormatoImagen().equals("BSQ"));
        assertTrue(imagen.getTipoImagen().equals("Integers"));
        assertTrue(imagen.getNumeroBandas() == 0);

        imagen.anadirBanda(bandai);
        imagen.anadirBanda(bandai);

        Imagen img;
        try {
            img = imagen.extraerImagen(0, 0, 5, 5);

            assertTrue(img.getFormatoImagen().equals("BSQ"));
            assertTrue(img.getNumeroBandas() == 2);

            ArrayList<Banda<?>> bandas = img.getBandas();
            for (Iterator<?> iterator = bandas.iterator(); iterator.hasNext();) {
                Banda<?> banda = (Banda<?>) iterator.next();

                Number[][] num = banda.getDatos();

                for (int i = 0; i < num.length; i++) {
                    for (int j = 0; j < num[0].length; j++) {
                        assertTrue(num[i][j].intValue() == 100);
                    }
                }
            }
        } catch (XYFueraImagenException e) {
            e.printStackTrace();
        }

        try {
            img = imagen.extraerImagen(0, 0, 11, 11);
            fail("Debe saltar la excepción");
        } catch (XYFueraImagenException e) {
            assertTrue(true);
        }
    }
}
