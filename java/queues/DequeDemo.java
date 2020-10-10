package queues;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> dq1 = new LinkedDeque<>();
        System.out.println(dq1.size());
        dq1.addFirst("Rust");
        System.out.println(dq1);
        dq1.addLast("Python");
        System.out.println(dq1);
        dq1.addFirst("Go");
        dq1.addLast("Pascal");
        System.out.println(dq1);
        System.out.println(dq1.size());
        System.out.println(dq1.first());
        System.out.println(dq1.last());
        System.out.println(dq1.removeFirst());
        System.out.println(dq1);
        System.out.println(dq1.removeLast());
        System.out.println(dq1);
        System.out.println(dq1.first());
        System.out.println(dq1.last());
        System.out.println(dq1.removeFirst());
        System.out.println(dq1.first());
        System.out.println(dq1.last());
        System.out.println(dq1.removeLast());
        System.out.println(dq1);
        System.out.println(dq1.isEmpty());
    }
}
