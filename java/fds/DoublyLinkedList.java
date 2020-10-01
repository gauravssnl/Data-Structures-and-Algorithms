package fds;

public class DoublyLinkedList<E> {
    // -------- nested Node class ---------
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the next node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        @Override
        public String toString() {
            return "Node [element=" + element + "]";
        }

    } // ------------- end of nested Node class

    // instance variables of the Doubly linked list
    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of elemnets in the list

    /** Constructs an empty Doubly linked list. */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // create header sentinel
        trailer = new Node<>(null, header, null); // trailer is precceded by header
        header.setNext(trailer); // header is followed by trailer
    }

    /** Returns the number of the element in the doubly linked list. */
    public int size() {
        return size;
    }

    /** Tests whether the doubly linked list is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns (but does not remove) the first element of the doubly lined list. */
    public E first() {
        if (isEmpty())
            return null;
        return header.getNext().getElement(); // first element is beyond header
    }

    /** Returns (but does not remove) the last element of the doubly lined list. */
    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement(); // last elemnt is before trailer
    }

    // public update methods

    /** Adds elemeent e to the front of the list. */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // place just after the header
    }

    /** Adds elemeent e to the front of the list. */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }

    /** Removes and returns the fisrt element of the list. */
    public E removeFirst() {
        if (isEmpty())
            return null; // nothing to remove
        return remove(header.getNext()); // first elemnent is beyond the header
    }

    /** Removes and returns the fisrt element of the list. */
    public E removeLast() {
        if (isEmpty())
            return null; // nothing to remove
        return remove(trailer.getPrev()); // last elemnent is before the trailer
    }

    // private update methods

    /** Adds element e to the linked list between the given nodes. */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /** Removes the given node from the linked list and returns its element. */
    public E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    @Override
    public String toString() {
        String result = "DoublyLinkedList [size=" + size + ", Elements=";
        if (!isEmpty()) {
            Node<E> currentNode = header.getNext();
            while (currentNode != trailer.getPrev()) {
                result += currentNode + " -> <- ";
                currentNode = currentNode.getNext();
            }

            // add last node (trailer.getPrev() details
            result += currentNode;

        }
        result += "]";
        return result;
    }

}
