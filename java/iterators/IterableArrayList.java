package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import lists.ArrayList;

/**
 * An implementation of a simple Iterable ArrayList class with bounded capacity.
 */
public class IterableArrayList<E> extends ArrayList<E> implements Iterable<E> {
    // ------- nested ArrayIterator class
    /**
     * A (nonstatic) inner class. Note well that each instance contains an implicit
     * reference to the containing list, allowing it to access the list's members.
     */
    private class ArrayIterator implements Iterator<E> {
        private int j = 0; // index of the current element to report
        private boolean removale = false; // can remove be called at this time?

        /**
         * Tests whether the iterator has a next object.
         * 
         * @return true if there are further objects, false otherwise
         */
        @Override
        public boolean hasNext() {
            return j < size();
        }

        /**
         * Returns the next object in the iterator.
         * 
         * @return next object
         * @throws NoSuchElementException if there are no further elements
         */
        @Override
        public E next() throws NoSuchElementException {
            if (j == size())
                throw new NoSuchElementException("No next element");
            removale = true;
            // outer class parent method is called as get() is not defined for the inner
            // class
            return get(j++);
        }

        @Override
        public void remove() throws IllegalStateException {
            if (!removale)
                throw new IllegalStateException("nothing to remove.");
            // call outer class method
            IterableArrayList.this.remove(j - 1); // that was the last one returned when we called next()
            j--; // decrease the index as next element has shifted one cell to the left
            removale = false; // don't allow remove again until next is called
        }

    }

    // -------------------- end of the nested ArrayIterator class
    /** Returns an iterator of the elements stored in the list. */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator(); // create a new instance of the inner class
    }

}
