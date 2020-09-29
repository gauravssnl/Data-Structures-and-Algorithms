package ood;

public class InterfaceDemo {
    public static void main(String[] args) {
        Sellable sellable = new Photograph("Photo1", 23, true);
        System.out.println(sellable.listPrice());
        System.out.println(sellable.lowestPrice());
        System.out.println(sellable.description());
        InterfaceDemo.takeSellableObject(sellable);

        Transpotable transpotable = new BoxedItem("Shoes", 50_000, 50, false);
        System.out.println(transpotable.weight());
        System.out.println(transpotable.isHazardous());

        sellable = new BoxedItem("Shoes", 50_000, 50, false);
        System.out.println(sellable.listPrice());
        System.out.println(sellable.lowestPrice());
        System.out.println(sellable.description());

        BoxedItem boxedItem = new BoxedItem("Shoes", 50_000, 50, false);
        boxedItem.setBox(20, 50, 30);
        System.out.println(boxedItem.weight());
        System.out.println(boxedItem.insuredValue());

        sellable = boxedItem;
        System.out.println(sellable.listPrice());
        System.out.println(sellable.lowestPrice());
        System.out.println(sellable.description());

        transpotable = boxedItem;
        System.out.println(boxedItem.weight());
        System.out.println(boxedItem.insuredValue());

        takeTransportableObject(transpotable);
        callBoxedItemClassMethodFromInterfaceRef(transpotable);
    }

    public static void takeSellableObject(Sellable sellable) {
        System.out.println(sellable instanceof Photograph);
        System.out.println(sellable instanceof BoxedItem);
    }

    public static void takeTransportableObject(Transpotable transpotable) {
        System.out.println(transpotable instanceof Photograph);
        System.out.println(transpotable instanceof Sellable);
        System.out.println(transpotable instanceof BoxedItem);
    }

    public static void callBoxedItemClassMethodFromInterfaceRef(Transpotable transpotable) {
        BoxedItem boxedItem = (BoxedItem) transpotable; // explicit cast interface reference to Class reference
        boxedItem.setBox(20, 30, 40);
        System.out.println(boxedItem.weight());
    }
}
