package Test;

import Model.HeapEntry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapEntryTest {

    @Test
    public void testHeapEntryConstructor() {
        // Arrange
        Integer priority = 5;
        String value = "Test";

        // Act
        HeapEntry<Integer, String> heapEntry = new HeapEntry<>(priority, value);

        // Assert
        assertEquals(priority, heapEntry.priority);
        assertEquals(value, heapEntry.value);
    }
}

