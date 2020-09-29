package ood;

public class BoxedItem implements Sellable, Transpotable {
    private String description; // description of this item
    private int price; // list price in cents
    private int weight; // weight in grams
    private boolean hazardous; // true if object is hazardous
    private int height = 0; // box height in centimeters
    private int width = 0; // box width in centimeters
    private int depth = 0; // box depth in centimeters

    /** Construct BoxedItem object */
    public BoxedItem(String description, int price, int weight, boolean hazardous) {
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.hazardous = hazardous;
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

    @Override
    public boolean isHazardous() {
        return hazardous;
    }

    @Override
    public int weight() {
        return weight;
    }

    public int insuredValue() {
        return price * 2;
    }

    public void setBox(int height, int weight, int depth) {
        this.height = height;
        this.weight = weight;
        this.depth = depth;
    }

}
