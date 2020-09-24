package primer;

public class CounterDemo {
    public static void main(String[] args) {
        Counter c = new Counter();
        c.increment();
        c.increment(3);
        System.out.println(c.getCount());
        int temp = c.getCount();
        c.reset();
        System.out.println(c.getCount());

        Counter d = new Counter();
        d.increment();
        Counter e = d;
        temp = e.getCount();
        System.out.println(temp);
        e.increment(2);
        System.out.println(e.getCount());
        System.out.println(d.getCount());
    }
}
