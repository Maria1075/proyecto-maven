package org.mp.sesion04.list.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayListIteratorTest {
	
	private ArrayList<Integer> arrayList;
    private Iterator<Integer> iterator;
	
	@Test
	public void testHasNext() {
		arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		iterator = arrayList.iterator();
		assertTrue(iterator.hasNext());
		iterator.next();
		assertTrue(iterator.hasNext());
		iterator.next();
		assertTrue(iterator.hasNext());
		iterator.next();
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testNext() {
		arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		iterator = arrayList.iterator();
		assertEquals(1, iterator.next().intValue());
		assertEquals(2, iterator.next().intValue());
		assertEquals(3, iterator.next().intValue());
	}

	@Test
	public void testRemove() {
		arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		iterator = arrayList.iterator();
		iterator.next();
		iterator.remove();
		assertEquals(2, arrayList.size());
		assertEquals(2, iterator.next().intValue());
	}
	
	@Test
	public void testNextLanzaNoSuchElementException() {
		arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		iterator = arrayList.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		try {
			iterator.next();
			fail("Debería haber lanzado una excepción");
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(), "No hay más elementos en la lista");
		}
	}

	@Test
	public void testRemoveSinNext() {
		arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		iterator = arrayList.iterator();
		try {
			iterator.remove();
			fail("Debería haber lanzado una excepción");
		} catch (IllegalStateException e) {
			assertEquals(e.getMessage(), "No se puede usar remove() sin hacer next()");
		}
	}
}
