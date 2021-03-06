package ood;

public abstract class AbstractProgression {
    protected long current;

    public AbstractProgression() {
        this(0);
    }

    public AbstractProgression(long start) {
        current = start;
    }

    public long nextValue() {
        long answer = current;
        advance(); // an example of the template method pattern
        return answer;
    }

    public void printProgression(int n) {
        System.out.print(nextValue());
        for (int j = 1; j < n; j++)
            System.out.print(" " + nextValue());    // print leading space before others
        System.out.println();
    }

    protected abstract void advance(); // abstract method

}
