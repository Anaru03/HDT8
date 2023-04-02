package Model;

/**
 *
 * @param <P> tipo generico que se utiliza para especificar el tipo de la prioridad del elemento en el heap
 * @param <V> tipo generico que se utiliza para especificar el tipo del valor asociado al elemento
 */

public class HeapEntry<P extends Comparable<P>, V> {
    public P priority;
    public V value;

    /**
     * @param priority especifica la prioridad del elemento
     * @param value especifica el valor asociado al elemento
     */
    public HeapEntry(P priority, V value) {
        this.priority = priority;
        this.value = value;
    }
}
