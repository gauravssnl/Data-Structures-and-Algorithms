package ood;

// A sample mixin class approximation by extending multiple interfaces.
public interface Insurable extends Sellable, Transpotable {
    /** Returns insured value in cents. */
    public int insuredValue();
}
