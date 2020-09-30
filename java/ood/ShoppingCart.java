package ood;

// A sample of bounded generic type 
public class ShoppingCart<T extends Sellable> {
    T item;

    public ShoppingCart(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public String getItemSummary() {
        return "Description: " + item.description() + ", List Price: " + item.listPrice() + ", Lowerst Price: "
                + item.lowestPrice();
    }

    public int getListPrice() {
        return item.listPrice();
    }

    public int getLowestPrice() {
        return item.lowestPrice();
    }

    public String getDescription() {
        return item.description();
    }
}
