package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @param <P>
 * @param <V>
 */
public class PriorityQueueWithHeap<P extends Comparable<P>, V> implements IHeap<P, V>  {
    private List<HeapEntry<P, V>> heap;

    public PriorityQueueWithHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Agrega un nuevo elemento al heap con una determinada prioridad y valor asociado
     * @param priority organizan en función de su prioridad
     * @param value valor asociado al elemento que se va a insertar en el heap
     */
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

    /**
     * @return regresa el valor del elemento que está en la raíz del heap
     */
    @Override
    public V get() {
        return heap.get(0).value;
    }

    /**
     * @return se devuelve el valor del elemento de mayor prioridad que se eliminó del heap
     */
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

    /**
     * @return retorna cero
     */
    @Override
    public int count() {
        return 0;
    }

    /**
     * @return retorna un valor boolean (indica si el heap está vacio o no)
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * @param i indice de un nodo en la estructura de datos
     * @return devuelve el índice del nodo padre correspondiente a ese nodo como numero entero
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * @param i calcula el indice del hijo izquierdo
     * @return regresa el indice del hijo izquierdo
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * @param i calcula el indice del hijo derecho
     * @return regresa el indice del hijo derecho
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * @param i verifica si tinee hijo izquierdo el nodo
     * @return regresa true si el nodo tiene hijo izquierdo y false en caso contrario.
     */
    private boolean hasLeftChild(int i) {
        return leftChild(i) < heap.size();
    }

    /**
     * @param i verifica si tinee hijo derecho el nodo
     * @return regresa true si el nodo tiene hijo derecho y false en caso contrario.
     */
    private boolean hasRightChild(int i) {
        return rightChild(i) < heap.size();
    }
}
