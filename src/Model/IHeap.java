package Model;
/**
 * @author moises.alonso
 * Codigo extraido de https://github.com/malonso-uvg/uvg2023ed10/blob/main/11_BinaryHeap/src/IHeap.java
 */
public interface IHeap<P,V> {
    void Insert(P priority, V value);

    V get();

    V remove();

    int count();

    boolean isEmpty();
}
