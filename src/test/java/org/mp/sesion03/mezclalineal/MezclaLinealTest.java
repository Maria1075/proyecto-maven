package org.mp.sesion03.mezclalineal;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MezclaLinealTest {

    @Test
    public void testMezclaLinealInt() {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

   

    @Test
    public void testMezclaLinealGenericos() {
        String[] arr1 = {"antonio", "c", "e", "g", "i"};
        String[] arr2 = {"b", "d", "f", "h", "j"};
        String[] expected = {"antonio", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealGenericos(arr1, arr2));
    }
}
