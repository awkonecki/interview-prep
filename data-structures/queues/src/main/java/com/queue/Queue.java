import java.util.LinkedList;
import arrays.src.main.java.com.array.Array;

public class Queue <T> {
    // Keep track of couple of attributes.
    LinkedList<T> linked_list_queue_ = new LinkedList<>();

    public Queue() {}

    public boolean enqueue(T data) {
        return enqueueBack(data);
    }

    boolean enqueueFront(T data) {
        // linked_list_queue_.add(data, 0);
        return true;
    } 
    
    public boolean enqueueBack(T data) {
        // Coupling our design to the linked list implementation for the time being
        // for the desired behavior.

        // Linked list default add, adds new elements to the end of the list by default.
        return linked_list_queue_.add(data);    
    }

    public T peek() {
        // default is peek at head.
        return peekAtHead();
    }

    public T peekAtHead() {
        if (!linked_list_queue_.isEmpty()) {
            // want to return the first element in the queue / linked list.
            return linked_list_queue_.peekFirst();
        }
        else {
            throw new java.lang.IllegalStateException(
                "Queue is empty."
            );
        }
    }

    public T peekAtBack() {
        if (!linked_list_queue_.isEmpty()) {
            // want to return the first element in the queue / linked list.
            return linked_list_queue_.peekLast();
        }
        else {
            throw new java.lang.IllegalStateException(
                "Queue is empty."
            );
        }
    }

    public T peekAtIndex(int index) {
        // TODO Get might not be the best for this, due to modification.
        if (!linked_list_queue_.isEmpty() || (index >= 0 && index < linked_list_queue_.size())) {
            // want to return the first element in the queue / linked list.
            return linked_list_queue_.get(index);
        }
        else {
            throw new java.lang.IllegalStateException(
                "Queue is empty."
            );
        }
    }

    public T dequeue() {
        if (!linked_list_queue_.isEmpty()) {
            // Do work FIFO
            return linked_list_queue_.remove();
        }
        else {
            return null;
        }
    }

    public int size() {
        return linked_list_queue_.size();
    }

    public static void main(String [] args) {
        Queue<Integer> queue = new Queue<>();
        // Queue<int> int_queue = new Queue<>();

        Array<Integer> myArray;

        queue.enqueue(10);
        assert (queue.peek() == 10);
        System.out.println("First Value " + queue.peek());
        assert (queue.size() == 1);
        // this is bad
        assert (queue.dequeue().intValue() == 10);
        assert (queue.size() == 0);
        queue.enqueue(1);
        queue.enqueue(2);
        assert (queue.size() == 2);
        assert (queue.peekAtIndex(1).intValue() == 2);
        assert (queue.peekAtBack().intValue() == 2);
        assert (queue.peekAtHead().intValue() == 1);
        // Below is bad
        assert (queue.dequeue().intValue() == 1);
        assert (queue.peekAtIndex(0).intValue() == 2);
        assert (queue.peekAtBack().intValue() == 2);
        assert (queue.peekAtHead().intValue() == 2);
    }
}