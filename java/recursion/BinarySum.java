package recursion;

public class BinarySum {
    /** Returns the sum of subarray data[low] through data[high] inclusive. */
    // initially invoked as binarySum(data, 0, n−1).
    // Time complexity : O(n)
    public static int binarySum(int[] data, int low, int high) {
        if (low > high) // zero element in subarray
            return 0;
        else if (low == high) // one element in subarray
            return data[low];
        else {
            int mid = (low + high) / 2;
            // depth of the recursion is 1+log2 n.
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(binarySum(data, 0, data.length - 1));
    }
}
