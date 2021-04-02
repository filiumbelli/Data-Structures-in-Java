import java.util.EmptyStackException;
import java.util.LinkedList;

public class Queue<T> {

    private LinkedList<T> queue = new LinkedList<T>();


    public Queue(T element) {
        this.queue.add(element);
    }

    public Queue() {
    }


    public void enqueue(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        queue.add(element);
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        queue.removeLast();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.size() > 0;
    }

    public boolean contains(T element) {
        return queue.contains(element);
    }

}
