package aa;

import java.util.Arrays;

public class ElementUniqueness {
    // Time complexity : (n-1) + (n-2) + ... + 2 + 1 = O(n ^ 2)
    public static boolean unique1(int[] data) {
        int n = data.length;
        // 1st iteration of outer loop causes n-1 iteration of the inner loop
        // 2nd iteration of outer loop causes n-2 iteration of the loop and so on.
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (data[i] == data[j])
                    return false;
        return true;
    }

    // Time complexity : (n-1) + (n-2) + ... + 2 + 1 = O(n ^ 2)
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n); // make copy of original list
        Arrays.sort(temp); // and sort the copy - Time complexity : O(n logn)
        for (int i = 0; i < n - 1; i++) // Time complexity : O(n)
            if (data[i] == data[i + 1]) // check neighboring enteries as the list is sorted
                return false;
        return true;
    }

}