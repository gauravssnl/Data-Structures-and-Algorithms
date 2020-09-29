package ood;

public class GenericsAndArraysDemo {
    public static void main(String[] args) {
        Pair<String, Double>[] holdings;
        /*
         * an array can be declared with a parameterized type, but it must be
         * instantiated with an unparameterized type and then cast back to the
         * parameterized type.
         */
        // uncomment the below line to see the error
        // holdings = new Pair<String, Double>[25]; // illegal; compiler error
        holdings = new Pair[25]; // correct; but warning about unchecked cast;

        Portfolio<String> portfolio1 = new Portfolio<>(20);
        portfolio1.set(0, "Rust");
        System.out.println(portfolio1.get(0));
        System.out.println(portfolio1.get(19));

        Portfolio<Integer> portfolio2 = new Portfolio<>(20);
        portfolio2.set(0, 1);
        System.out.println(portfolio2.get(0));
        System.out.println(portfolio2.get(19));
    }
}
