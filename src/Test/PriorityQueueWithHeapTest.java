package Test;
import Model.PriorityQueueWithHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriorityQueueWithHeapTest {

    @Test
    void testInsertAndGet() {
        PriorityQueueWithHeap<Integer, String> priorityQueue = new PriorityQueueWithHeap<>();
        priorityQueue.Insert(2, "valor2");
        priorityQueue.Insert(3, "valor3");
        priorityQueue.Insert(1, "valor1");
        priorityQueue.Insert(4, "valor4");

        Assertions.assertEquals("valor4", priorityQueue.get());
    }

    @Test
    void testRemove() {
        PriorityQueueWithHeap<Integer, String> priorityQueue = new PriorityQueueWithHeap<>();
        priorityQueue.Insert(2, "valor2");
        priorityQueue.Insert(3, "valor3");
        priorityQueue.Insert(1, "valor1");
        priorityQueue.Insert(4, "valor4");

        Assertions.assertEquals("valor4", priorityQueue.remove());
        Assertions.assertEquals("valor3", priorityQueue.remove());
        Assertions.assertEquals("valor2", priorityQueue.remove());
        Assertions.assertEquals("valor1", priorityQueue.remove());

        Assertions.assertNull(priorityQueue.remove());
    }

    @Test
    void testIsEmpty() {
        PriorityQueueWithHeap<Integer, String> priorityQueue = new PriorityQueueWithHeap<>();

        Assertions.assertTrue(priorityQueue.isEmpty());

        priorityQueue.Insert(2, "valor2");
        Assertions.assertFalse(priorityQueue.isEmpty());

        priorityQueue.remove();
        Assertions.assertTrue(priorityQueue.isEmpty());
    }

    @Test
    void testCount() {
        PriorityQueueWithHeap<Integer, String> priorityQueue = new PriorityQueueWithHeap<>();

        Assertions.assertEquals(0, priorityQueue.count());

        priorityQueue.Insert(2, "valor2");
        priorityQueue.Insert(3, "valor3");

        Assertions.assertEquals(0, priorityQueue.count());

        priorityQueue.remove();

        Assertions.assertEquals(0, priorityQueue.count());
    }
}
