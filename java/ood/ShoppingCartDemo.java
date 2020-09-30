package ood;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        Photograph p = new Photograph("Photo1", 23_000, true);
        ShoppingCart<Photograph> pCart = new ShoppingCart<>(p);
        System.out.println(pCart.getDescription());
        System.out.println(pCart.getListPrice());
        System.out.println(pCart.getLowestPrice());
        System.out.println(pCart.getItemSummary());
    }
}
