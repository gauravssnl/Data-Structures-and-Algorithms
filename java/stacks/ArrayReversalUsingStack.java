package stacks;

import java.util.Arrays;

public class ArrayReversalUsingStack {
    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i = 0; i < a.length; i++)
            buffer.push(a[i]);
        // now we will reverse the data using stack
        for (int i = 0; i < a.length; i++)
            a[i] = buffer.pop();
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 4, 10, 12, 14 };
        System.out.println(Arrays.toString(arr1));
        reverse(arr1);
        System.out.println(Arrays.toString(arr1));

        String[] arr2 = { "Rust", "Python", "Go" };
        System.out.println(Arrays.toString(arr2));
        reverse(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
