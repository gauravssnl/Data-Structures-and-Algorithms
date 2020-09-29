package ood;

public class FibonacciProgression extends Progression {
    protected long previous;

    /** Construct traditional Fibonacci progression starting 0, 1, 1, 2, 3, ... */
    public FibonacciProgression() {
        this(0, 1);
    }

    /**
     * Construct generalized Fibonacci progression, with the given first and second
     * values.
     */
    public FibonacciProgression(long first, long second) {
        super(first);
        // fictious value preceeding the first; as we calculate
        // next = previous + current
        previous = second - first;
    }

    /** Replaces (previous, current) with (current, current + previous). */
    @Override
    protected void advance() {
        long temp = previous;
        previous = current;
        // add the value of prevoius that was before
        // the assignment of previous = current
        current += temp;
    }
}