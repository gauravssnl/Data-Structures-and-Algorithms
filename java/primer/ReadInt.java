package primer;

import java.util.Scanner;
// This program will loop until it reads int values
public class ReadInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        while(!input.hasNextInt()) {
            input.nextLine();
            System.out.println("Invalid integer. please enter an integer: ");
        }
        int i = input.nextInt();
        System.out.println("Your input was : " + i);
        input.close();
    }
}
