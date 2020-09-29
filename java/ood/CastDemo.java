package ood;

public class CastDemo {
    public static void main(String[] args) {
        Number n;
        Integer i;
        n = Integer.valueOf(3);
        i = (Integer) n; // this is legal
        n = Double.valueOf(1);
        // uncomment the below line to see the error
        // i = (Integer) n; // this is illegal

        // Handling casting
        n = Integer.valueOf(5);
        if (n instanceof Integer)
            i = (Integer) n;

        n = Double.valueOf(12);
        if (n instanceof Integer)
            i = (Integer) n;
    }
}
