import edu.princeton.cs.algs4.Queue;
import org.junit.Test;
public class TestMergeSort {

    @Test
    public void MergeSort() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(34);
        queue.enqueue(23);
        queue.enqueue(12);
        queue = QuickSort.quickSort(queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
