package fds;

import java.util.Arrays;

/** Insertion sort of an array of characters into non-decreasing order. */
public class InsertionSort {
    public static void insertionSort(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) { // begin with second character
            char curr = data[k]; // time to insert curr = data[k]
            int j = k; // find correct index j for curr
            while (j > 0 && data[j - 1] > curr) { // thus data[j-1] must go after curr
                data[j] = data[j - 1]; // slide data[j -1] rightward
                j--; // and consider previous j for curr
            }
            data[j] = curr; // this is the proper place for curr
        }
    }

    public static void main(String[] args) {
        char[] characters = { 'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F' };
        System.out.println(Arrays.toString(characters));
        insertionSort(characters);
        System.out.println(Arrays.toString(characters));
    }
}
