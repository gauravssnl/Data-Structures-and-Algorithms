package queues;

/** Realization of a FIFO queue as an adaptation of a SinglyLinkedList. */

import fds.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    public LinkedQueue() { // new queue relies on empty list
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public void enqueue(E e) {
        list.addFirst(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

}
