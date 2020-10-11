package lists;

import java.util.Arrays;

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

}
