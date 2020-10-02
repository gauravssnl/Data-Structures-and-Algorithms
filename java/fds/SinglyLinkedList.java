package fds;

/** A generic Singly linked list. */
public class SinglyLinkedList<E> {
    // nested Node class
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the susbsequent node in the list

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
            return "Node(" + element + ") -> " + next;
        }

    }

    // instance variables of SinglyLinkedList class
    private Node<E> head = null; // head of the list (or null if empty)
    private Node<E> tail = null; // tail of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() { // construct an empty list initially

    }

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first elelemnt
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) { // adds element e to the first of the list
        head = new Node<>(e, head);
        if (size == 0)
            tail = head; // special case: new node bcomes tail also
        size++;
    }

    public void addLast(E e) { // adds element e to the last of the list
        Node<E> newest = new Node<>(e, null); // new nod will eventually be the tail
        if (isEmpty())
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) // nothing to remove
            return null;
        E answer = head.getElement();
        head = head.getNext(); // set the head node to the next node of current head
        size--; // decrease the size
        if (size == 0)
            tail = null; // special case: as list is now empty
        return answer;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        //  SinglyLinkedList<E> is not user here as other list might be of different elements type
        SinglyLinkedList other = (SinglyLinkedList) obj; // explicit cast
        if (size != other.size)
            return false;
        Node walkA = head; // traverse the current list
        Node walkB = other.head; // traverse the other list
        while (walkA != null) { // we need to traverse until the tail is reached
            if (!walkA.getElement().equals(walkB.getElement()))
                return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;
    }

}
