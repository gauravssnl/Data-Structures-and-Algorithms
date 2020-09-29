package ood;

public class ProgressionDemo {
    public static void main(String[] args) {
        Progression pr = new Progression();
        System.out.println(pr.current);
        System.out.println(pr.nextValue());
        System.out.println(pr.current);
        pr.printProgression(10);

        pr = new ArithmeticProgression();
        System.out.println(pr.current);
        System.out.println(pr.nextValue());
        System.out.println(pr.current);
        pr.printProgression(10);

        pr = new ArithmeticProgression(10);
        System.out.println(pr.current);
        System.out.println(pr.nextValue());
        System.out.println(pr.current);
        pr.printProgression(10);

        pr = new ArithmeticProgression(30);
        pr.printProgression(10);

        pr = new ArithmeticProgression(1, 2);
        pr.printProgression(10);

        pr = new ArithmeticProgression(0, 2);
        pr.printProgression(10);

        pr = new GeometricProgression();
        pr.printProgression(10);

        pr = new GeometricProgression(4);
        pr.printProgression(10);

        pr = new GeometricProgression(3, 2);
        pr.printProgression(10);

        pr = new FibonacciProgression();
        pr.printProgression(10);

        pr = new FibonacciProgression(2, 5);
        pr.printProgression(10);
    }
}
