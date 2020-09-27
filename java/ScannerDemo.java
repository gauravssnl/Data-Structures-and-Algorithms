import java.util.Scanner;
import java.util.stream.Stream;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter a double value");
        double d = inputScanner.nextDouble();
        System.out.println(d);
        // Read input continuously and echo it on the console
        Stream<String> tokenStringStream = inputScanner.tokens();
        tokenStringStream.forEach(s -> System.out.println(s));
        // need to close the scanner
        inputScanner.close();
    }
}
