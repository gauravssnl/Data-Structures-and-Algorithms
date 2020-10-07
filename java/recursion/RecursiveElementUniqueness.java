package recursion;

public class RecursiveElementUniqueness {
    /**
     * Returns true if there are no duplicate values from data[low] through
     * data[high].
     */
    // Time complexity : 1 + 2 + 4 + 8 + .. + n = 2^n i.e O(2 ^ n)
    // we call function unique by passing value as array.length - 1
    public static boolean unique(int[] data, int low, int high) {
        if (low >= high)
            return true; // at most one item
        else if (!unique(data, low, high - 1)) // duplicate in first n - 1
            return false;
        else if (!unique(data, low + 1, high)) // duplicate in last n - 1
            return false;
        else
            return data[low] != data[high]; // do first & last differ ?
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(unique(data, 0, data.length - 1));
        int[] data1 = { 1, 2, 4, 6, 7, 8, 8, 9, 10, 11 };
        System.out.println(unique(data1, 0, data.length - 1));
    }
}
