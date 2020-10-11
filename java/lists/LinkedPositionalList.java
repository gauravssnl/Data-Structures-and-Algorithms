package lists;

public class LinkedPositionalList<E> implements PositionalList<E> {
    // ----------------- nested Node class --------------------
    private static class Node<E> implements Position<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the next node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) // convention for defunct node
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }
    // ------------------ end of nested Node class ----------

    // instance variable of the LinkedPositionalList
    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of elements in the list

    /** Constructs a new empty list. */
    public LinkedPositionalList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer sentinel; header is the previous node
        header.setNext(trailer); // header is followed by trailer
    }

    // privatye utilities
    /** Validates the position and returns it as a node. */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getNext() == null) // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    /** Returns the given node as a Position (or null, if it is a sentinel). */
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null; // dpo not expose user to sentinels
        return node;
    }

    /** Adds element e to the linked list between the given nodes. */
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<E>(e, pred, succ); // create and link a new node
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return position(newest);
    }

    // public accessor methods
    /**
     * Inserts element e immediately after Position p, and returns its new Position.
     */
    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /**
     * Inserts element e immediately before Position p, and returns its new Position
     */
    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    /**
     * Inserts element e at the front of the linked list and returns its new
     * Position.
     */
    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    /**
     * Inserts element e at the back of the linked list and returns its new
     * Position.
     */
    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Returns the Position immediately after Position p (or null, if p is last).
     */
    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    /**
     * Returns the Position immediately before Position p (or null, if p is first).
     */
    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    /** Returns the first Position in the linked list (or null, if empty). */
    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    /** Tests whether the linked list is empty. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the last Position in the linked list (or null, if empty). */
    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    /** Removes the element stored at Position p and returns it (invalidating p). */
    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null); // help garbage collection
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }

    /**
     * Replaces the element stored at Position p and returns the replaced element
     */
    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    /** Returns the number of elements in the linked list. */
    @Override
    public int size() {
        return size;
    }

}
