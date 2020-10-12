package iterators;

import java.util.Iterator;

import lists.Position;

public class IterableLinkedPositionalListDemo {
    public static void main(String[] args) {
        IterableLinkedPositionalList<String> names = new IterableLinkedPositionalList<>();
        names.addFirst("Rust");
        names.addLast("Java");
        names.addAfter(names.first(), "Go");
        names.addBefore(names.last(), "Spring");
        System.out.println(names);

        for (String name : names) {
            System.out.println(name);
        }

        for (Position<String> p : names.positions()) {
            System.out.println(p.getElement());
        }

        Iterator<String> sIterator = names.iterator();
        while (sIterator.hasNext()) {
            if (sIterator.next().equals("Java")) {
                System.out.println("Removing Java");
                sIterator.remove();
            }
        }

        System.out.println("Names data now:");
        names.forEach(name -> System.out.println(name));

        Iterator<Position<String>> pIterator = names.positions().iterator(); // positions() returns Iterable
        while (pIterator.hasNext()) {
            if (pIterator.next().getElement().equals("Spring")) {
                System.out.println("Removing Spring");
                pIterator.remove();
            }
        }

        System.out.println("Names data now:");
        names.forEach(name -> System.out.println(name));

    }
}
