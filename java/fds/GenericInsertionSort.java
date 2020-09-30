package fds;

import java.util.Arrays;

public class GenericInsertionSort {
    public static <T extends Comparable> void insertionSort(T[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            T curr = data[k];
            int j = k;
            // curr != null is added only for handling unitialized array
            // ( handle null values as compareTo throws error in case of null values),
            // you can ignore if you are sure that we are dealing with arrays where all
            // values are initalized
            while (curr != null && j > 0 && data[j - 1].compareTo(curr) > 0) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = curr;
        }
    }

    public static void main(String[] args) {
        ComparableGameEntry[] gameEntries = new ComparableGameEntry[10];
        ComparableGameEntry gameEntry = new ComparableGameEntry("Rahul", 78);
        gameEntries[0] = gameEntry;
        gameEntry = new ComparableGameEntry("Raj", 73);
        gameEntries[1] = gameEntry;
        gameEntry = new ComparableGameEntry("Ravi", 79);
        gameEntries[2] = gameEntry;
        gameEntry = new ComparableGameEntry("Rohit", 75);
        gameEntries[3] = gameEntry;
        gameEntry = new ComparableGameEntry("Rashmi", 73);
        gameEntries[4] = gameEntry;
        gameEntry = new ComparableGameEntry("Raj", 72);
        gameEntries[5] = gameEntry;
        System.out.println(Arrays.toString(gameEntries));
        insertionSort(gameEntries);
        System.out.println(Arrays.toString(gameEntries));

        Integer[] integers = { 2, 5, 1, 3, 6, 4, 9, 7, 8 };
        System.out.println(Arrays.toString(integers));
        insertionSort(integers);
        System.out.println(Arrays.toString(integers));

    }
}
