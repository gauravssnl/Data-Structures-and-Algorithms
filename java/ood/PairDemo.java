package ood;

public class PairDemo {
    public static void main(String[] args) {
        Pair<String, Double> pair1 = new Pair<>("T-Shirt", 38.00);
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getFirst().getClass());
        System.out.println(pair1.getSecond());
        System.out.println(pair1.getSecond().getClass());

        Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(1, 2);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getFirst().getClass());
        System.out.println(pair2.getSecond());
        System.out.println(pair2.getSecond().getClass());
        System.out.println(pair2.getFirst().getClass() == pair2.getSecond().getClass());

        Pair<Integer, Double> pair3 = new Pair<>(5, 6.3);       // rely on type inference
        System.out.println(pair3.getFirst());
        System.out.println(pair3.getFirst().getClass());
        System.out.println(pair3.getSecond());
        System.out.println(pair3.getSecond().getClass());
        System.out.println(pair2.getFirst().getClass() == pair2.getSecond().getClass());
        System.out.println(pair3.getFirst().getClass().equals(pair2.getSecond().getClass()));
    }
}
