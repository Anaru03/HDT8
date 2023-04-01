import Model.PriorityQueueWithHeap;

public class ProcesController {
    public static void main(String[] args) {
        PriorityQueueWithHeap<Integer,String> pq = new PriorityQueueWithHeap<>();
        pq.Insert(10, "A");
        pq.Insert(5, "B");
        pq.Insert(20, "C");
        pq.Insert(3, "D");
        pq.Insert(15, "E");
        System.out.println(pq.get());
    }
    public static void fillQueue(){

    }
}
