package recursion;

public class NonRecursiveBinarySearch {
    /** Returns true if the target value is found in the data array. */
    public static boolean binarySearch(int data[], int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) { // at least one element
            int mid = (low + high) / 2;
            if (target == data[mid]) // found a match
                return true;
            else if (target < data[mid])
                high = mid - 1; // only consider values left of mid
            else
                low = mid + 1; // only consider values right of mid
        }
        return false; // loop ended without success
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 3, 10, 14, 15, 17, 20, 23 };
        int target = 15;
        System.out.println(binarySearch(data, target));
        target = 25;
        System.out.println(binarySearch(data, target));
    }
}
