package org.mp.sesion05.colas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListQueueTest {

    @Test
    public void testEnqueueAndDequeue() {
        Queue<String> queue = new LinkedListQueue<>();
        queue.enqueue("Uno");
        queue.enqueue("Dos");
        queue.enqueue("Tres");

        assertEquals("Uno", queue.dequeue());
        assertEquals("Dos", queue.dequeue());
        assertEquals("Tres", queue.dequeue());
    }

    @Test
    public void testGetSize() {
        Queue<Integer> queue = new LinkedListQueue<>();
        assertEquals(0, queue.getSize());

        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.getSize());

        queue.dequeue();
        assertEquals(1, queue.getSize());
    }
}
