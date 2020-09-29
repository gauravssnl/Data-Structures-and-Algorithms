package ood;

public class GeometricProgression extends Progression {
    // store the base / factor
    protected long base;

    /** Connstruct progression 1, 2, 4, 8, ... */
    public GeometricProgression() {
        this(1, 2);                                         // start at 1 with base of 2
    }

    /** Construct progression 1, b, b^2, b^3, b^4, ... for base of b*/
    public GeometricProgression(long base) {
        this(1, base);
    }

    /** Construct geometric progression with arbitrary start and base */
    public GeometricProgression(long start, long base) {
        super(start);
        this.base = base;
    }

    @Override
    protected void advance() {
        current *= base;                                // multiply current by the geometric base
    }

}
