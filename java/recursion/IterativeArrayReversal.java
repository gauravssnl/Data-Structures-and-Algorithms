package recursion;

import java.util.Arrays;

public class IterativeArrayReversal {
    /** Reverses the contents of the given array. */
    public static void reverseArrayIterative(int[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) { // swap data[low] and data[high]
            int temp = data[low];
            data[low++] = data[high]; // post-incerement of low
            data[high--] = temp; // post-decrement of high
        }
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 10, 20, 34, 45, 36, 23 };
        System.out.println(Arrays.toString(data));
        reverseArrayIterative(data);
        System.out.println(Arrays.toString(data));
    }
}
