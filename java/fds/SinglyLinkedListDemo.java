package fds;

public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList<String> sl = new SinglyLinkedList<>();
        sl.addFirst("Ram");
        sl.addLast("Shyam");
        System.out.println(sl);
        System.out.println(sl.first());
        System.out.println(sl.last());
        sl.addFirst("Ravi");
        System.out.println(sl);
        System.out.println(sl.first());
        System.out.println(sl.removeFirst());
        System.out.println(sl);
        sl.addFirst("Rust");
        System.out.println(sl);
        sl.addLast("Python");
        System.out.println(sl);
        System.out.println(sl.removeFirst());
        System.out.println(sl.removeFirst());
        System.out.println(sl.removeFirst());
        System.out.println(sl.removeFirst());
        System.out.println(sl);
        System.out.println(sl.first());
        System.out.println(sl.last());
        sl.addFirst("Ravi");
        System.out.println(sl);
        sl.addLast("Python");
        System.out.println(sl);

        SinglyLinkedList<String> ol = new SinglyLinkedList<>();
        ol.addLast("Ravi");
        ol.addLast("Python");
        System.out.println(ol);
        System.out.println(sl.equals(ol));
        sl.addFirst("Test1");
        ol.addFirst("Test2");
        System.out.println(sl.equals(ol));
    }
}
