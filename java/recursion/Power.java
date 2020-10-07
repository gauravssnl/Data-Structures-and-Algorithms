package recursion;

public class Power {
    /**
     * Computes the value of x raised to the nth power, for nonnegative integer n.
     * Time Complexity : O(n) .
     */
    public static double power(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * power(x, n - 1);
    }

    /**
     * Computes the value of x raised to the nth power, for nonnegative integer n.
     * Use the technique of n /2 to make the alogirith faster.
     */
    public static double power_by_halving(double x, int n) {
        if (n == 0)
            return 1;
        else {
            // rely on truncated division of n
            double partial = power_by_halving(x, n / 2); // result is fine for even values of n
            double result = partial * partial;
            if (n % 2 == 1) // n is odd
                result *= x; // we need to multiply x^(n/2) * x ^(n /2) by x again to get x^n when n is odd
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2, 12));
        System.out.println(power_by_halving(2, 12));
        System.out.println(power_by_halving(2, 13));
    }
}
