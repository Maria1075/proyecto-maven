package org.mp.sesion06.orderedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderedListTest {

    @Test
    void testAddElement() {
        OrderedList<Integer> list = new OrderedList<>();
        list.addElement(3);
        list.addElement(1);
        list.addElement(4);
        list.addElement(2);

        assertEquals(4, list.getSize());
        assertEquals(1, list.getElement(0));
        assertEquals(2, list.getElement(1));
        assertEquals(3, list.getElement(2));
        assertEquals(4, list.getElement(3));
    }

    @Test
    void testRemoveElement() {
        OrderedList<String> list = new OrderedList<>();
        list.addElement("apple");
        list.addElement("banana");
        list.addElement("cherry");

        assertTrue(list.removeElement("banana"));
        assertEquals(2, list.getSize());
        assertEquals("apple", list.getElement(0));
        assertEquals("cherry", list.getElement(1));
    }

    @Test
    void testGetIndex() {
        OrderedList<Double> list = new OrderedList<>();
        list.addElement(3.14);
        list.addElement(2.718);
        list.addElement(1.618);

        assertEquals(2, list.getIndex(3.14));
        assertEquals(0, list.getIndex(1.618));
        assertEquals(-1, list.getIndex(4.0)); // Elemento no encontrado
    }

    @Test
    void testIsEmpty() {
        OrderedList<Character> list = new OrderedList<>();
        assertTrue(list.isEmpty());

        list.addElement('a');
        list.addElement('b');
        assertFalse(list.isEmpty());
    }
}