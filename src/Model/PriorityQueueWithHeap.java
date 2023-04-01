package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueueWithHeap<P extends Comparable<P>, V> implements IHeap<P, V>  {
    private List<HeapEntry<P, V>> heap;

    public PriorityQueueWithHeap() {
        this.heap = new ArrayList<>();
    }
    @Override
    public void Insert(P priority, V value) {
        HeapEntry<P, V> entry = new HeapEntry<>(priority, value);
        heap.add(entry);

        // Realizamos un up-heap para asegurarnos de que el nuevo elemento esté en su lugar correcto
        int current = heap.size() - 1;
        while (current > 0 && heap.get(current).priority.compareTo(heap.get(parent(current)).priority) > 0) {
            Collections.swap(heap, current, parent(current));
            current = parent(current);
        }
    }

    @Override
    public V get() {
        return heap.get(0).value;
    }

    @Override
    public V remove() {
        if (heap.isEmpty()) {
            System.out.println("La priority queue está vacía.");
            return null;
        }

        V root = heap.get(0).value;

        if (heap.size() == 1) {
            heap.remove(0);
            return root;
        }

        heap.set(0, heap.remove(heap.size() - 1));

        // Realizamos un down-heap para asegurarnos de que el nuevo elemento esté en su lugar correcto
        int current = 0;
        while (hasLeftChild(current)) {
            int maxChild = leftChild(current);
            if (hasRightChild(current) && heap.get(rightChild(current)).priority.compareTo(heap.get(maxChild).priority) > 0) {
                maxChild = rightChild(current);
            }

            if (heap.get(current).priority.compareTo(heap.get(maxChild).priority) < 0) {
                Collections.swap(heap, current, maxChild);
                current = maxChild;
            } else {
                break;
            }
        }

        return root;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private boolean hasLeftChild(int i) {
        return leftChild(i) < heap.size();
    }

    private boolean hasRightChild(int i) {
        return rightChild(i) < heap.size();
    }
}
