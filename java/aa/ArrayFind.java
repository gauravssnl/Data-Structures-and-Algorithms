package aa;

public class ArrayFind {
    public static int arrayFind(int[] data, int val) {
        int n = data.length;
        int j = 0;
        while (j < n) {
            if (data[j] == val)
                return j;
            j++;
        }
        return -1; // elelemnt is not found in the list
    }
}