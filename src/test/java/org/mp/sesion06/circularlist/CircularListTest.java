package org.mp.sesion06.circularlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class CircularListTest {

    @Test
    void testAddRemoveElement() {
        CircularList<Integer> list = new CircularList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        assertEquals(3, list.getSize());
        assertTrue(list.removeElement(2));
        assertEquals(2, list.getSize());
        assertEquals(1, list.getElement(0));
        assertEquals(3, list.getElement(1));
    }

    @Test
    void testGetElement() {
        CircularList<String> list = new CircularList<>();
        list.addElement("apple");
        list.addElement("banana");
        list.addElement("cherry");

        assertEquals("apple", list.getElement(0));
        assertEquals("banana", list.getElement(1));
        assertEquals("cherry", list.getElement(2));
        assertEquals("apple", list.getElement(3));
        assertEquals("banana", list.getElement(4));
    }

    @Test
    void testGetIndex() {
        CircularList<Double> list = new CircularList<>();
        list.addElement(3.14);
        list.addElement(2.718);
        list.addElement(1.618);

        assertEquals(0, list.getIndex(3.14));
        assertEquals(1, list.getIndex(2.718));
        assertEquals(2, list.getIndex(1.618));
        assertEquals(0, list.getIndex(3.14));
    }

    @Test
    void testIterator() {
        CircularList<Character> list = new CircularList<>();
        list.addElement('a');
        list.addElement('b');
        list.addElement('c');

        Iterator<Character> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals('a', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals('b', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals('c', iterator.next());
        
        assertFalse(iterator.hasNext());
        assertEquals('a', iterator.next());
        assertFalse(iterator.hasNext());
        assertEquals('b', iterator.next());
        assertFalse(iterator.hasNext());
        assertEquals('c', iterator.next());
        assertFalse(iterator.hasNext());
    }
}