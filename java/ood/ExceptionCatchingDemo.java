package ood;

public class ExceptionCatchingDemo {
    public static void main(String[] args) {
        final int DEFAULT = 5;
        int n = DEFAULT;
        try {
            n = Integer.parseInt(args[0]);
            if (n <= 0) {
                System.out.println("n must be positive. Using default.");
                n = DEFAULT;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No arguments specified for n. Using default.");
        } catch (NumberFormatException ex) {
            System.out.println("Inavlid integer argument. using default.");
        }
        System.out.println("The value of n is " + n);
    }
}
