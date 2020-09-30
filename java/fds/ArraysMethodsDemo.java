package fds;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysMethodsDemo {
    public static void main(String[] args) {
        int[] numArr1 = { 1, 2, 3, 4, 5 };
        int[] numArr2 = { 1, 2, 3, 4, 5 };

        System.out.println(numArr1.equals(numArr2)); // returns false
        System.out.println(numArr1 == numArr2); // returns false
        // The preferred way to compare equlaity of arrays.
        System.out.println(Arrays.equals(numArr1, numArr2)); // returns true

        int[] numArr3 = { 1, 2, 3, 4, 5 };
        int[] numArr4 = { 1, 2, 3, 5, 4 };
        System.out.println(Arrays.equals(numArr3, numArr4)); // returns false

        int[] numArr5 = Arrays.copyOf(numArr4, 5);
        System.out.println(Arrays.toString(numArr5));

        int[] numArr6 = Arrays.copyOfRange(numArr5, 1, 5);
        System.out.println(Arrays.toString(numArr6));

        int[] numArr7 = { 2, 10, 22, 4, 16, 18, 7, 5, 3, 1, 20 };
        System.out.println(Arrays.toString(numArr7));
        Arrays.sort(numArr7);
        System.out.println(Arrays.toString(numArr7));

        Integer[] numArr8 = { 2, 10, 22, 4, 16, 18, 7, 5, 3, 1, 20 };
        System.out.println(Arrays.toString(numArr8));
        // Sorting in the reverse order
        Arrays.sort(numArr8, Collections.reverseOrder());
        System.out.println(Arrays.toString(numArr8));

        Integer[] numArr9 = { 2, 10, 22, 4, 16, 18, 7, 5, 3, 1, 20 };
        System.out.println(Arrays.toString(numArr9));
        // Sorting in the reverse order
        Arrays.sort(numArr9, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else if (o1 < o2)
                    return 1;
                return 0;
            }

        });
        ;
        System.out.println(Arrays.toString(numArr9));

        // Binary search
        int[] numArr10 = {1, 2, 5, 8, 12, 10, 1, 5, 7, 3, 15};
        System.out.println(Arrays.binarySearch(numArr10, 8));

    }
}