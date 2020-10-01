package fds;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList<String> dl = new DoublyLinkedList<>();
        System.out.println(dl);
        System.out.println(dl.first());
        System.out.println(dl.last());
        dl.addFirst("Rust");
        System.out.println(dl);
        System.out.println(dl.first());
        System.out.println(dl.last());
        dl.addFirst("Go");
        System.out.println(dl);
        System.out.println(dl.first());
        System.out.println(dl.last());
        dl.addLast("Java");
        System.out.println(dl);
        System.out.println(dl.first());
        System.out.println(dl.last());
        System.out.println("Remove examples");
        System.out.println(dl.removeFirst());
        System.out.println(dl);
        System.out.println(dl.first());
        System.out.println(dl.last());
        System.out.println(dl.removeLast());
        System.out.println(dl);
        System.out.println(dl.first());
        System.out.println(dl.last());
        System.out.println(dl.removeLast());
        System.out.println(dl);
        System.out.println(dl.first());
        System.out.println(dl.last());
        System.out.println(dl.isEmpty());
    }
}
