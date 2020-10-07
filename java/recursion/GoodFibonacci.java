package recursion;

public class GoodFibonacci {
    /** Returns array containing the pair of Fibonacci numbers, F(n) and F(n−1). */
    // Time complexity : O(n)
    public static long[] goodFibonacci(int n) {
        if (n <= 1) {
            long[] answer = { n, 0 };
            return answer;
        } else {
            long[] temp = goodFibonacci(n - 1); // returns {Fn−1, Fn−2}
            long[] answer = { temp[0] + temp[1], temp[0] }; // returns {Fn, Fn−1}
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(goodFibonacci(0)[0]);
        System.out.println(goodFibonacci(1)[0]);
        System.out.println(goodFibonacci(2)[0]);
        System.out.println(goodFibonacci(3)[0]);
        System.out.println(goodFibonacci(10)[0]);
    }
}
