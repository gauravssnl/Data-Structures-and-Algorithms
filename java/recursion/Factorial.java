package recursion;

public class Factorial {
    public static long factorial(long n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException("Input cannot be negative."); // argument must be non-negative
        else if (n == 0) // base case
            return 1;
        else
            return n * factorial(n - 1); // recursive case
    }

    public static void main(String[] args) {
        System.out.println(factorial(30));
    }
}
