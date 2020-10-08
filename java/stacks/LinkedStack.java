package stacks;

import fds.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    public LinkedStack() { // new stack relies on the initially empty list
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void push(E e) {
        list.addFirst(e); // we are using the front of singly linked list as top of stack
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return "LinkedStack [list=" + list + "]";
    }

}
