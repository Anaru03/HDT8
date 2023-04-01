package Model;

public class HeapEntry<P extends Comparable<P>, V> {
    public P priority;
    public V value;

    public HeapEntry(P priority, V value) {
        this.priority = priority;
        this.value = value;
    }
}
