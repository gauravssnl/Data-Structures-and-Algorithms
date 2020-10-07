package recursion;

public class BadFibonacci {
    /** Returns the nth Fibonacci number (inefficiently). */
    // let cn denote the number of calls performed in the execution of
    // fibonacciBad(n).
    // cn > 2n/2 , thus badFibonacci(n) makes no. of calls that is exponential in n.
    public static long badFibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return badFibonacci(n - 2) + badFibonacci(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++)
            System.out.println(badFibonacci(i));
    }
}