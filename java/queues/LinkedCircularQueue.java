package queues;

import fds.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {
    private CircularlyLinkedList<E> cList = new CircularlyLinkedList<>(); // an empty list

    public LinkedCircularQueue() { // new queue relies on empty list

    }

    @Override
    public void rotate() {
        cList.rotate();
    }

    @Override
    public E dequeue() {
        return cList.removeFirst();
    }

    @Override
    public void enqueue(E e) {
        cList.addFirst(e);
    }

    @Override
    public E first() {
        return cList.first();
    }

    @Override
    public boolean isEmpty() {
        return cList.isEmpty();
    }

    @Override
    public int size() {
        return cList.size();
    }

}
