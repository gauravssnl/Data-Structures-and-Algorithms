package queues;

/** Implementation of the queue ADT using a fixed-length array */
public class ArrayQueue<E> implements Queue<E> {
    public final static int CAPACITY = 100;
    // instance variables
    private E[] data; // generic array used for storage
    private int f = 0; // index of the front element
    private int sz = 0; // current number of elements in the queue

    // constructores
    // constructs queue with default capacity
    public ArrayQueue() {
        this(CAPACITY);
    }

    // constructs queue with given capacity
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    // methods
    /** Returns the number of elements in the queue. */
    @Override
    public int size() {
        return sz;
    }

    /** Tests whether the queue is empty. */
    @Override
    public boolean isEmpty() {
        return sz == 0;
    }

    /** Inserts an element at the rear of the queue. */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length; // use modular arithmetic to insert the data
        data[avail] = e;
        sz++;
    }

    /**
     * Returns, but does not remove, the first element of the queue (null if empty).
     */
    @Override
    public E first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    /** Removes and returns the first element of the queue (null if empty). */
    @Override
    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = data[f];
        data[f] = null; // dereference to help garbage collection
        // use f = (f + 1) % N formula to set the new front index value;
        // where N = data.length
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}
