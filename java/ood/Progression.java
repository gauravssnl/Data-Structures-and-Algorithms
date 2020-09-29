package ood;

/**
 * Generates a simple progression. By default: 0, 1, 2, ...
 */
public class Progression {

    // instance variable
    protected long current;

    /** Construct a Progression starting at zero. */
    public Progression() {
        this(0);
    }

    /** Construct a progression with given start value. */
    public Progression(long start) {
        current = start;
    }

    /** Return the next value of the progression. */
    public long nextValue() {
        long answer = current;
        advance(); // this protected call is responsible for advancing the current value
        return answer;
    }

    /** Advances the current value to the next value of the progression. */
    protected void advance() {
        current++;
    }

    /** Prints the next n values of the Progression separated by spaces. */
    public void printProgression(int n) {
        System.out.print(nextValue()); // print first value without space
        for (int j = 1; j < n; j++) {
            System.out.print(" " + nextValue());
        }
        System.out.println(); // end the line
    }
}
