package org.mp.sesion04.list.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class LinkedListIteratorTest {
    private LinkedList<Integer> list;

	@Test
	public void testIteratorConListaVacia() {
		list = new LinkedList<>();
		Iterator<Integer> iterator = list.iterator();
		assertFalse(iterator.hasNext());
		try {
			iterator.next();
			fail(" Se esperaba NoSuchElementException");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

    @Test
    public void testIterator() {
    	list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorRemove() {
    	list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        assertEquals(1, iterator.next());
        iterator.remove();
        assertEquals(2, iterator.next());
        iterator.remove();
        assertEquals(3, iterator.next());
        iterator.remove();

        assertEquals(0, list.size());
        assertFalse(list.iterator().hasNext());
    }

    @Test
    public void testIteratorRemoveSinNext() {
    	list = new LinkedList<>();
        list.add(1);
        Iterator<Integer> iterator = list.iterator();
        try {
            iterator.remove();
            fail("Se esperaba IllegalStateException");
        } catch (IllegalStateException e) {
           System.out.println(e.getMessage());
        }
    }
}