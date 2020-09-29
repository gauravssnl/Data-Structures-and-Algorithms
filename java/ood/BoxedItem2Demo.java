package ood;

public class BoxedItem2Demo {
    public static void main(String[] args) {
        Insurable insurable = new BoxedItem2("Laptops", 10000000, 70, false);
        System.out.println(insurable.description());
        System.out.println(insurable.listPrice());
        System.out.println(((Sellable) insurable).listPrice());
        System.out.println(insurable.weight());
        System.out.println(((Transpotable) insurable).weight());
    }
}
