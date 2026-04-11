package org.mp.sesion05.pilas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testArrayStack() {
        Stack<Integer> arrayStack = new ArrayStack<>();

        assertTrue(arrayStack.isEmpty());
        assertEquals(0, arrayStack.getSize());

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        assertFalse(arrayStack.isEmpty());
        assertEquals(3, arrayStack.getSize());
        assertEquals(Integer.valueOf(3), arrayStack.peek());

        assertEquals(Integer.valueOf(3), arrayStack.pop());
        assertEquals(Integer.valueOf(2), arrayStack.pop());

        assertEquals(1, arrayStack.getSize());
        assertFalse(arrayStack.isEmpty());

        arrayStack.pop(); 

        assertTrue(arrayStack.isEmpty());
        assertEquals(0, arrayStack.getSize());
        assertNull(arrayStack.peek());
        assertNull(arrayStack.pop());
    }

    @Test
    public void testNodeStack() {
        Stack<String> nodeStack = new NodeStack<>();

        assertTrue(nodeStack.isEmpty());
        assertEquals(0, nodeStack.getSize());

        nodeStack.push("Uno");
        nodeStack.push("Dos");
        nodeStack.push("Tres");

        assertFalse(nodeStack.isEmpty());
        assertEquals(3, nodeStack.getSize());
        assertEquals("Tres", nodeStack.peek());

        assertEquals("Tres", nodeStack.pop());
        assertEquals("Dos", nodeStack.pop());

        assertEquals(1, nodeStack.getSize());
        assertFalse(nodeStack.isEmpty());

        nodeStack.pop(); // Pop the last element

        assertTrue(nodeStack.isEmpty());
        assertEquals(0, nodeStack.getSize());
        assertNull(nodeStack.peek());
        assertNull(nodeStack.pop());
    }

    @Test
    public void testLinkedListStack() {
        Stack<Double> linkedListStack = new LinkedListStack<>();

        assertTrue(linkedListStack.isEmpty());
        assertEquals(0, linkedListStack.getSize());

        linkedListStack.push(1.1);
        linkedListStack.push(2.2);
        linkedListStack.push(3.3);

        assertFalse(linkedListStack.isEmpty());
        assertEquals(3, linkedListStack.getSize());
        assertEquals(Double.valueOf(3.3), linkedListStack.peek());

        assertEquals(Double.valueOf(3.3), linkedListStack.pop());
        assertEquals(Double.valueOf(2.2), linkedListStack.pop());

        assertEquals(1, linkedListStack.getSize());
        assertFalse(linkedListStack.isEmpty());

        linkedListStack.pop(); 

        assertTrue(linkedListStack.isEmpty());
        assertEquals(0, linkedListStack.getSize());
        assertNull(linkedListStack.peek());
        assertNull(linkedListStack.pop());
    }
}
