package ood;

/** Class for photographs that can be sold. */
public class Photograph implements Sellable {
    private String description; // description of this photo
    private int price; // the price we are setting;
    private boolean color; // true if photo is in color

    /** Construct Photograph instance. */
    public Photograph(String description, int price, boolean color) {
        this.description = description;
        this.price = price;
        this.color = color;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price / 2;
    }

    public boolean isColor() {
        return color;
    }

}
