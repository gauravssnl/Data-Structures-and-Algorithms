package recursion;

public class RecursiveLinearSum {
    /** Returns the sum of the first n integers of the given array. */
    public static int linearSum(int[] data, int n) {
        if (n == 0)
            return 0;
        else
            return linearSum(data, n - 1) + data[n - 1]; // n-1 is the actual index for nth element
    }
    
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(linearSum(data, 1));
        System.out.println(linearSum(data, 2));
        System.out.println(linearSum(data, data.length / 2));
        System.out.println(linearSum(data, data.length));
    }
}