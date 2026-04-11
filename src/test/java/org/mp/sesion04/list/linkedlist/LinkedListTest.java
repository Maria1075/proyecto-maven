/**
 *
 */
package org.mp.sesion04.list.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

	private LinkedList<String> lista1 = new LinkedList<String>();
	private Integer[] enteros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 }; // autoboxing
	private LinkedList<Integer> lista2 = new LinkedList<Integer>(enteros);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}
	 @Test
	    public void testEqualsConMismaInstancia() {
	        LinkedList<Integer> list = new LinkedList<>();
	        assertTrue(list.equals(list));
	    }

	    @Test
	    public void testEqualsConNull() {
	        LinkedList<Integer> list = new LinkedList<>();
	        assertFalse(list.equals(null));
	    }

	    @Test
	    public void testEqualsConDiferentesClases() {
	        LinkedList<Integer> list = new LinkedList<>();
	        assertFalse(list.equals("test"));
	    }

	    @Test
	    public void testEqualsConDiferentesListas() {
	        LinkedList<Integer> list1 = new LinkedList<>();
	        list1.add(1);
	        list1.add(2);

	        LinkedList<Integer> list2 = new LinkedList<>();
	        list2.add(1);
	        list2.add(2);
	        list2.add(3);

	        assertFalse(list1.equals(list2));
	    }

	    @Test
	    public void testEqualsConListasIguales() {
	        LinkedList<Integer> list1 = new LinkedList<>();
	        list1.add(1);
	        list1.add(4);
	        list1.add(2);

	        LinkedList<Integer> list2 = new LinkedList<>();
	        list2.add(1);
	        list2.add(4);
	        list2.add(2);

	        assertTrue(list1.equals(list2));
	    }
	
	@Test
	public void testGetFirst() {
		assertEquals(null, lista1.getFirst());
		assertEquals(Integer.valueOf(1), lista2.getFirst());
		String resultado1 = "[]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for {@link org.mp.sesion04.LinkedList#getLast()}.
	 */
	@Test
	public void testGetLast() {
		assertEquals(null, lista1.getLast());
		assertEquals(Integer.valueOf(16), lista2.getLast());
		String resultado1 = "[]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion04.LinkedList#addFirst(java.lang.Object)}.
	 */
	@Test
	public void testAddFirst() {
		lista1.addFirst("Ana");
		assertEquals("Ana", lista1.getFirst());
		lista2.addFirst(999);
		assertEquals(Integer.valueOf(999), lista2.getFirst());
		String resultado1 = "[Ana]";
		String resultado2 = "[999, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion04.LinkedList#addLast(java.lang.Object)}.
	 */
	@Test
	public void testAddLast() {
		lista1.addLast("Zapata");
		assertEquals("Zapata", lista1.getFirst());
		lista2.addLast(999);
		assertEquals(Integer.valueOf(999), lista2.getLast());
		String resultado1 = "[Zapata]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 999]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion04.LinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		lista1.add(-7, "Juan");
		assertEquals("Juan", lista1.getFirst());
		lista1.add(0, "Ana");
		assertEquals("Ana", lista1.getFirst());
		lista1.add(1, "Belen");
		assertEquals("Ana", lista1.getFirst());
		lista1.add(20, "Zapata");
		assertEquals("Zapata", lista1.getLast());

		lista2.add(-7, 3);
		assertEquals(Integer.valueOf(3), lista2.getFirst());
		lista2.add(0, 1);
		assertEquals(Integer.valueOf(1), lista2.getFirst());
		lista2.add(1, 5);
		assertEquals(Integer.valueOf(1), lista2.getFirst());
		lista2.add(20, 7);
		assertEquals(Integer.valueOf(7), lista2.getLast());

		String resultado1 = "[Ana, Belen, Juan, Zapata]";
		String resultado2 = "[1, 5, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 7]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion04.LinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		assertEquals(null, lista1.removeFirst());
		assertEquals(Integer.valueOf(1), lista2.removeFirst());
		String resultado1 = "[]";
		String resultado2 = "[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion04.LinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLast() {
		assertEquals(null, lista1.removeLast()); // lista vacia
		lista1.addFirst("Ana");
		assertEquals("Ana", lista1.removeLast()); // lista con un elemento
		lista1.addFirst("Juan"); // cualquier otro caso
		lista1.addFirst("Ana");
		assertEquals("Juan", lista1.removeLast());

		assertEquals(Integer.valueOf(1), lista2.removeFirst());
		// assertEquals(Integer.valueOf(1), lista2.removeFirst());

		String resultado1 = "[Ana]";
		String resultado2 = "[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for {@link org.mp.sesion04.LinkedList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		assertEquals(null, lista1.remove(0));
		assertEquals(Integer.valueOf(1), lista2.remove(0));
		assertEquals(Integer.valueOf(16), lista2.remove(14));
		assertEquals(Integer.valueOf(7), lista2.remove(5));
		String resultado1 = "[]";
		String resultado2 = "[2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion04.LinkedList#toString()}.
	 */
	@Test
	public void testToString() {
		// más que probado en los otros pero bueno...
		String resultado1 = "[]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion04.LinkedList#clear()}.
	 */
	@Test
	public void testClear() {
		lista1.clear();
		lista2.clear();
		String resultado1 = "[]";
		String resultado2 = "[]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for
	 * {@link org.mp.sesion04.LinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		assertFalse(lista1.contains("Ana"));
		assertTrue(lista2.contains(7));
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion04.LinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		assertEquals(-1, lista1.indexOf("Jacinto"));
		assertEquals(-1, lista2.indexOf(329));
		assertEquals(0, lista2.indexOf(1));
		assertEquals(15, lista2.indexOf(16));
		assertEquals(4, lista2.indexOf(5));

	}

	@Test
	public void testLastIndexOf() {
		assertEquals(-1, lista1.lastIndexOf("Ana"));
		lista1.add("Ana");
		lista1.add("Ana");
		assertEquals(1, lista1.lastIndexOf("Ana"));

		assertEquals(-1, lista2.lastIndexOf(329));
		lista2.add(16);
		lista2.add(16);
		assertEquals(17, lista2.lastIndexOf(16));

	}

	/**
	 * Test method for
	 * {@link org.mp.sesion04.LinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		assertEquals(null, lista1.set(0, "Juan"));
		lista1.add("Ana");
		assertEquals("Ana", lista1.set(0, "Juan"));

		assertEquals(Integer.valueOf(1), lista2.set(0,999));
		assertEquals(Integer.valueOf(16), lista2.set(15,999));
		assertEquals(Integer.valueOf(8), lista2.set(7,999));

		String resultado1 = "[Juan]";
		String resultado2 = "[999, 2, 3, 4, 5, 6, 7, 999, 9, 10, 11, 12, 13, 14, 15, 999]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}
}
