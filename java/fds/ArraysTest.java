package fds;

import java.util.Arrays;
import java.util.Random;

public class ArraysTest {
    public static void main(String[] args) {
        int[] data = new int[10];
        Random rand = new Random(); // a pseudo-random number generator
        // Note : if we use the same seed each time, we will get 
        // same set of pseduo-random numbers
        rand.setSeed(System.currentTimeMillis()); // use current time (milliseconds since epoch time) as seed
        // fill the data array with pseudo-numbers from 0 to 99, inclusive
        for (int i = 0; i < data.length; i++)
            data[i] = rand.nextInt(100); // the next pseudo-random number
        int[] original = Arrays.copyOf(data, data.length);
        System.out.println("Arrays equal before sort: " + Arrays.equals(data, original));
        Arrays.sort(data);
        System.out.println("Arrays equal after sort: " + Arrays.equals(data, original));
        System.out.println("original = " + Arrays.toString(original));
        System.out.println("data = " + Arrays.toString(data));
    }
}
