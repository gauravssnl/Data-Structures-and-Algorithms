package stacks;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000; // default array capacity
    private E[] data; // generic array used for storage
    private int t = -1; // index of the top element in the stack

    // construct stack with default capacity
    public ArrayStack() {
        this(CAPACITY);
    }

    // construct stack with given capacity
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

     @Override
    public int size() {
        return t + 1; // intial value of t is -1 and size is 0
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) throws IllegalArgumentException {
        if (size() == data.length)
            throw new IllegalArgumentException("Stack is full");
        data[++t] = e; // increment t before saving new item
    }

    @Override
    public E top() {
        if (isEmpty())
            return null;
        return data[t]; // top element is at index t
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;
        E answer = top();
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer;
    }

    @Override
    public String toString() {
        // need to slice the original data with the data contained in it
        return "ArrayStack [data=" + Arrays.toString(Arrays.copyOf(data, size())) + ", top Index=" + t + "]";
    }

}
