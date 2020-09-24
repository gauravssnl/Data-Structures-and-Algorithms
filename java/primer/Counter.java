package primer;

public class Counter {
    private int count;
    public Counter() {};                                    // default constructor ( count is 0 )
    public Counter(int initial) { count = initial; }        // an alternate constructor
    public int getCount() { return count; }
    public void increment() { count++; }
    public void increment(int delta) { count += delta; }
    public void decremnet() { count-- ; }
    public void reset() { count = 0 ;}
}
