package ood;

/** Inteface foe objects that can be transported. */
public interface Transpotable {
    /** Returns the weight in grams. */
    public int weight();

    /** Returns whether object is hazardous. */
    public boolean isHazardous();
}
