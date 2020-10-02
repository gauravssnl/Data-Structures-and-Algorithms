package fds;

import java.util.Arrays;

public class ArrayDeepCopy {
    public static int[][] deepClone(int[][] original) {
        int[][] backup = new int[original.length][]; // create top-level of arrays;
        for (int k = 0; k < original.length; k++) {
            backup[k] = original[k].clone(); // copy row k
        }
        return backup;
    }

    public static void main(String[] args) {
        int arr1[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, {} };
        System.out.println(Arrays.toString(arr1[2]));
        int arr2[][] = new int[arr1.length][];
        System.out.println(Arrays.toString(arr2));
        arr2 = arr1.clone(); // shallow copy
        System.out.println(Arrays.toString(arr2[1]));
        System.out.println(Arrays.toString(arr2[2]));
        System.out.println(Arrays.toString(arr1[1]));
        // changing the value also afffects arr2 as arr2 is a shallow copy
        // to avoid this we need to use deep copy ( deep clone )
        arr1[1][0] = 100;
        System.out.println(Arrays.toString(arr1[1]));
        System.out.println(Arrays.toString(arr2[1]));
        // using deep clone here so that chnaging arr1 does not affect arr2
        arr2 = deepClone(arr1);
        System.out.println(Arrays.toString(arr2[1]));
        System.out.println(Arrays.toString(arr2[2]));
        arr1[1][0] = 200; // this does not affect arr2 as it is a deepl clone/copy of arr1
        System.out.println(Arrays.toString(arr1[1]));
        System.out.println(Arrays.toString(arr2[1]));
    }
}
