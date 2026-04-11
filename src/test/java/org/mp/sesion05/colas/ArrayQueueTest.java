package org.mp.sesion05.colas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeue() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
    }

    @Test
    public void testGetSize() {
        Queue<String> queue = new ArrayQueue<>();
        assertEquals(0, queue.getSize());

        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.getSize());

        queue.dequeue();
        assertEquals(1, queue.getSize());
    }
}
