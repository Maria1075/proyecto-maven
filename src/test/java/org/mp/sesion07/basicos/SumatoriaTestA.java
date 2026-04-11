package org.mp.sesion07.basicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SumatoriaTestA {

    @Test
    public void testSuma() {
        assertEquals(Sumatoria.sumaGaus(3), Sumatoria.sumaRec(3));
        assertEquals(Sumatoria.sumaGaus(100), Sumatoria.sumaRec(100));
        assertEquals(Sumatoria.sumaGaus(100), Sumatoria.sumaIter(100));
        assertEquals(Sumatoria.sumaRec(1000), Sumatoria.sumaIter(1000));
        assertEquals(Sumatoria.sumaGaus(1), Sumatoria.sumaRec(1));
    }
}
