package org.mp.sesion05.colas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeQueueTest {

    @Test
    public void testEnqueueAndDequeue() {
        Queue<Double> queue = new NodeQueue<>();
        queue.enqueue(1.1);
        queue.enqueue(2.2);
        queue.enqueue(3.3);

        assertEquals(1.1, queue.dequeue(), 0.0001);
        assertEquals(2.2, queue.dequeue(), 0.0001);
        assertEquals(3.3, queue.dequeue(), 0.0001);
    }

    @Test
    public void testGetSize() {
        Queue<Character> queue = new NodeQueue<>();
        assertEquals(0, queue.getSize());

        queue.enqueue('A');
        queue.enqueue('B');
        assertEquals(2, queue.getSize());

        queue.dequeue();
        assertEquals(1, queue.getSize());
    }
}
