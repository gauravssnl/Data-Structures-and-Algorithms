package queues;

/** Implementation of the Dequeue ADT using a fixed-length array */
public class ArrayDequeue<E> implements Deque<E> {
    public final static int CAPACAITY = 1000;
    // instance variables
    private E[] data; // generic array used for staorage
    private int f = 0; // index of the front element
    private int sz = 0; // current number of elements

    // constructors
    // construct queue with default capacity
    public ArrayDequeue() {
        this(CAPACAITY);
    }

    // construct queue with default capacity
    public ArrayDequeue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void addLast(E e) {
        int lastIndex = (f + sz) % data.length;
        data[lastIndex] = e;
        sz++;

    }

    @Override
    public E first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    @Override
    public boolean isEmpty() {
        return sz == 0;
    }

    @Override
    public E last() {
        if (isEmpty())
            return null;
        int lastIndex = f + sz;
        return data[lastIndex];
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = data[f];
        f = (f + 1) % data.length; // set the new front index
        data[f] = null; // dereference for garbage collection
        sz--;
        return answer;
    }

    @Override
    public E removeLast() {
        if (isEmpty())
            return null;
        int lastIndex = (f + sz) % data.length;
        E answer = data[lastIndex];
        data[lastIndex] = null; // dereference for garbage collection
        sz--;
        return answer;
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public void addFirst(E e) {
        // TODO Auto-generated method stub
        data[f] = e;
        sz++;
        // calculate new front index
        f = (f + 1) % data.length; // need to update the logic
    }

}
