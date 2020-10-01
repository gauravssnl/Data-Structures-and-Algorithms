package fds;

public class CircularlyLinkedListDemo {
    public static void main(String[] args) {
        CircularlyLinkedList<String> cl = new CircularlyLinkedList<>();
        System.out.println(cl);
        cl.addFirst("Rust");
        System.out.println(cl.last());
        System.out.println(cl.first());
        System.out.println(cl);
        cl.addLast("Python");
        System.out.println(cl);
        System.out.println(cl.size());
        cl.addLast("Go");
        System.out.println(cl);
        System.out.println(cl.size());
        cl.rotate();
        System.out.println(cl.last());
        System.out.println(cl.first());
        System.out.println(cl);
        System.out.println(cl.removeFirst());
        System.out.println(cl.last());
        System.out.println(cl.first());
        System.out.println(cl);
    }
}
