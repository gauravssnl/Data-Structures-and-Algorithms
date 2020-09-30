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
    }
}
