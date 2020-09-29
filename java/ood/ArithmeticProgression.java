package ood;

public class ArithmeticProgression extends Progression {
    // store step size
    protected long increment;

    /** Construct arithmetic progression 0, 1, 2, ... */
    public ArithmeticProgression() {
        this(0, 1);                                                     // start at 0 with increment of 1
    } 

    /** Construct arithmetic progression 0, stepsize, 2 * stepsize, ... */
    public ArithmeticProgression(long stepsize) {
        this(0, stepsize);                                              // start at 0
    } 

    /** Construct arithmetic progression with aribtrary start and increment */
    public ArithmeticProgression(long start, long stepsize) {
        super(start);
        increment = stepsize;
    }

    @Override
    protected void advance() {
        current += increment;
    }
}
