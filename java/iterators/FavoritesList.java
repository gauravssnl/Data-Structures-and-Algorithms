package iterators;

import java.util.Iterator;

import lists.Position;

/** Maintains a list of elements ordered according to access frequency. */
public class FavoritesList<E> {
    // ------------------ nested Item class ------------------
    protected static class Item<E> {
        private E value;
        private int count = 0;

        /** Constructs new item with initial count of zero. */
        public Item(E val) {
            value = val;
        }

        public int getCount() {
            return count;
        }

        public E getValue() {
            return value;
        }

        public void increment() {
            count++;
        }
    }
    // ------------------ end of nested Item class ------------------

    PositionalList<Item<E>> list = new LinkedPositionalList<>(); // list of items

    public FavoritesList() { // construct initially empty favorites list

    }

    // non-public utilities
    /**
     * Provides shorthand notation to retrieve user's element stored at Position p.
     */
    protected E value(Position<Item<E>> p) {
        return p.getElement().getValue();
    }

    /**
     * Provides shorthand notation to retrieve count of item stored at Position p.
     */
    protected int count(Position<Item<E>> p) {
        return p.getElement().getCount();
    }

    /**
     * Returns Position of Item having element equal to e (or null if not found).
     */
    protected Position<Item<E>> findPosition(E e) {
        // In Java 10, the var keyword allows local variable type inference
        // If you are using older version of Java, modify this code
        // var walk = list.first();
        Position<Item<E>> walk = list.first();
        while (walk != null && !e.equals(value(walk)))
            walk = list.after(walk);
        return walk;
    }

    /** Moves item at Position p earlier in the list based on access count. */
    protected void moveUp(Position<Item<E>> p) {
        int cnt = count(p);
        Position<Item<E>> walk = p;
        while (walk != list.first() && count(list.before(walk)) < cnt) // found smaller access count ahead of Item
            walk = list.before(walk); // set walk to the left position
        if (walk != p) // we need to remove and re-insert the item at its right position
            list.addBefore(walk, list.remove(p)); // remove and re-inser the item

    }

    // public methods
    /** Returns the number of items in the favorite list. */
    public int size() {
        return list.size();
    }

    /** Returns true if the favorites list is empty. */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /** Accesses element e (possibly new), increasing its access count. */
    public void access(E e) {
        Position<Item<E>> p = findPosition(e); // try to locate existing element
        if (p == null) // new element
            p = list.addLast(new Item<E>(e)); // if new , place at end
        p.getElement().increment(); // always increment count
        moveUp(p);
    }

    /** Removes element equal to e from the list of favorites (if found). */
    public void remove(E e) {
        Position<Item<E>> p = findPosition(e);
        if (p != null) // element's position is found
            list.remove(p);
    }

    /**
     * Returns an iterable collection of the k most frequently accessed elements.
     */
    public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if (k < 0 || k > size())
            throw new IllegalArgumentException("Invalid k");
        PositionalList<E> result = new LinkedPositionalList<>();
        Iterator<Item<E>> iterator = list.iterator();
        for (int j = 0; j < k; j++)
            result.addLast(iterator.next().getValue());
        return result;
    }
}
