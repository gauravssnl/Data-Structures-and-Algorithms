package recursion;

import java.util.Arrays;

public class RecursiveArrayReversal {
    /** Reverses the contents of subarray data[low] through data[high] inclusive. */
    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) { // if at least 2 elements in subarray
            int temp = data[low]; // swap data[low] and data[high]
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1); // recur on the rest
        }
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 19 };
        System.out.println(Arrays.toString(data));
        // first time we call this algorithm we do so as reverseArray(data, 0, n−1)
        reverseArray(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
