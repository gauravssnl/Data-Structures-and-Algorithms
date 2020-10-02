package fds;

/** Generic Circularly liinked list class. */
public class CircularlyLinkedList<E> {
    // Nested Node class
    private static class Node<E> {
        private E element;
        Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        @Override
        public String toString() {
            return "Node [element=" + element + "]";
        }

    }

    // instance variables of the CircularlyLinkedList
    private Node<E> tail = null; // we store tail ( but not head);
    private int size = 0; // number of nodes in the list

    public CircularlyLinkedList() { // constructs an empty list initially

    }

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // Returns the first (but don't remove) the first element
        if (isEmpty())
            return null;
        return tail.getNext().getElement(); // the head is after the tail
    }

    public E last() { // Returns the last (but don't remove) the last element
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // update methods
    public void rotate() { // rotate the first element to the back of the list
        if (tail != null) { // if empty do nothing
            tail = tail.getNext(); // the old head becomes the new tail
        }
    }

    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null); // set the new node as tail as the list is currently empty
            tail.setNext(tail); // link to itself circularly ( setting the head here)
        } else { // list has a tail
            Node<E> newset = new Node<>(e, tail.getNext());
            tail.setNext(newset);
        }
        size++;
    }

    public void addLast(E e) { // adds element E to the end of the list
        addFirst(e); // insert new element at the front of the list
        tail = tail.getNext(); // set the new tail which is at the front of the list
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) // nothing to remove
            return null;
        Node<E> head = tail.getNext();
        if (head == tail) // must be the only one nod left
            tail = null;
        else
            tail.setNext(head.getNext()); // set the head to next node of current head & remove current head
        size--;
        return head.getElement();
    }

    @Override
    public String toString() {
        String result = "CircularlyLinkedList [size=" + size + ", Elements=";

        if (!isEmpty()) { // there is at least one element in the list
            Node<E> nextNode = tail.getNext();
            while (nextNode != tail) {
                result += nextNode + " -> ";
                nextNode = nextNode.getNext();
            }
            // add tail details
            result += tail + " -> ";
        } else { // list is empty
            result += tail;
        }

        result += "]";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CircularlyLinkedList other = (CircularlyLinkedList) obj;
        if (size != other.size)
            return false;
        Node walkA = tail;
        Node walkB = other.tail;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement()))
                return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
            // Handle special case for circularly linked list
            // otherwise this will keep on running recursively
            if (walkA.equals(tail) && walkB.equals(other.tail)) // we have again reached at the tail of the current
                                                                // list, need to break the loop
                return true;
        }
        return true;
    }

}
