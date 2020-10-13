package iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of a simple ArrayList class with bounded capacity.
 */
public class ArrayList<E> implements List<E> {
    // instance variables
    public static final int CAPACITY = 16; // default array capacity
    private E[] data; // generic array for staorage
    private int size = 0;

    // constructors
    // construct list with default capacity
    public ArrayList() {
        this(CAPACITY);
    }

    // constructs list with given capacity
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    // public methods
    /**
     * Inserts element e to be at index i, shifting all subsequent elements later.
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size);
        if (size == data.length)
            throw new IllegalStateException("Array is full");
        for (int k = size - 1; k >= i; k++) // start by shifting rightmost
            data[k + 1] = data[k];
        data[i] = e;
        size++;
    }

    /** Returns (but does not remove) the element at index i. */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /** Returns whether the array list is empty. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) // shift elements to fill empty position
            data[k] = data[k + 1];
        data[size - 1] = null; // help garabge collection
        size--;
        return temp;
    }

    /** Replaces the element at index i with e, and returns the replaced element. */
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /** Returns the number of elements in the array list. */
    @Override
    public int size() {
        return size;
    }

    // utility method
    /** Checks whether the given index is in the range [0, n−1]. */
    private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i > n)
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
    }

    @Override
    public String toString() {
        return "ArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
    }

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
            ArrayList.this.remove(j - 1); // that was the last one returned when we called next()
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
