package lists;

import java.util.Arrays;

/**
 * An implementation of a simple ArrayList class with unbounded capacity.
 */
public class DynamicArrayList<E> implements List<E> {
    // instance variables
    public static final int CAPACITY = 16; // default array capacity
    private E[] data; // generic array for staorage
    private int size = 0;

    // constructors
    // construct list with default capacity
    public DynamicArrayList() {
        this(CAPACITY);
    }

    // constructs list with given capacity
    public DynamicArrayList(int capacity) {
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    // public methods
    /**
     * Inserts element e to be at index i, shifting all subsequent elements later.
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size);
        if (size == data.length) // not enough capacity
            resize(2 * data.length); // so double the current capacity
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
        // code added by Gaurav to shrink array to reduce memory usage
        // reduce array size by half when the no. of elements are less than 1/4 of
        // capacity
        if (size < data.length / 4)
            resize(data.length / 2);
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

    /** Resizes internal array to have given capacity >= size. */
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
        for (int k = 0; k < data.length; k++)
            temp[k] = data[k];
        data = temp;
    }

}
