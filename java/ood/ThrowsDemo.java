package ood;

public class ThrowsDemo {
    public static void enusrePositive(int n) {
        if (n < 0)
            throw new IllegalArgumentException("That is not positive!");
    }

    // it is not mandatory to throw Exception.
    public static void functionThrowingException(int n) throws IllegalAccessException {
        enusrePositive(n);
    }

    public static void main(String[] args) {
        final int i = -20;
        // need to handle Exception if a function throws any
        try {
            functionThrowingException(i);
        } catch (IllegalArgumentException | ArithmeticException ex) { // catch multiple exceptions in one catch block

        } catch (Exception e) {

        }

    }
}
