package fds;

import java.util.Arrays;

public class MultiDimensionalArraysEqualityTest {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {1, 3, 5, 7};
        System.out.println(arr1 == arr2);
        System.out.println(arr1.equals(arr2));
        // the way to test arrays haveing same values in the same order
        System.out.println(Arrays.equals(arr1, arr2));

        int arr3[][] = {{1, 2, 3}, {4, 5, 6}};
        int arr4[][] = {{1, 2, 3}, {4, 5, 6}};
        // Arrays.equals  won't work in case of multi-dimensional arrays
        System.out.println(Arrays.equals(arr3, arr4));
          // Arrays.deepEquals will work in case of multi-dimensional arrays
        System.out.println(Arrays.deepEquals(arr3, arr4));
    }
}
