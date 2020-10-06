package recursion;

import java.util.Arrays;

public class BinarySearch {
    /*
     * Returns true if the target value is found in the indicated portion of the
     * data array. This search only considers the array portion from data[low] to
     * data[high] inclusive.
     */
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
            return false; // interval empty; no match
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true; // found a match
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1); // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high); // recur right of the middle
        }
    }

    /*
     * Returns index if the target value is found in the indicated portion of the
     * data array ; else return -1. This search only considers the array portion
     * from data[low] to data[high] inclusive.
     */
    public static int binarySearchIndex(int[] data, int target, int low, int high) {
        if (low > high)
            return -1; // interval empty; no match
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return mid; // found a match
            else if (target < data[mid])
                return binarySearchIndex(data, target, low, mid - 1); // recur left of the middle
            else
                return binarySearchIndex(data, target, mid + 1, high); // recur right of the middle
        }
    }

    public static void main(String[] args) {
        int[] data = { 10, 15, 1, 2, 3, 5, 7, 8, 9, 11, 23, 10 };
        // we need sorted input for binary search
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        int target = 23, low = 0, high = data.length - 1;
        System.out.println("Target " + target + " is in data array : " + binarySearch(data, target, low, high));
        System.out.println("Target " + target + " index in data array : " + binarySearchIndex(data, target, low, high));

        target = 20;
        System.out.println("Target " + target + " is in data array : " + binarySearch(data, target, low, high));
        System.out.println("Target " + target + " index in data array : " + binarySearchIndex(data, target, low, high));

        target = 10;
        System.out.println("Target " + target + " is in data array : " + binarySearch(data, target, low, high));
        // we get the rightmost index here for the duplicate element 10
        System.out.println("Target " + target + " index in data array : " + binarySearchIndex(data, target, low, high));

    }
}
