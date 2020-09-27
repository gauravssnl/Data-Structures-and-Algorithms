package primer;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] primes = { 2, 3, 5, 7 };
        for (int p : primes) {
            System.out.println(p);
        }
        double[] measurements = new double[100];                        // each will be initialized to 0.0
        System.out.println(Arrays.toString(measurements));
        Integer[] scores = new Integer[10];                             // each will be initialized to null
        System.out.println(Arrays.toString(scores));
    }
}
