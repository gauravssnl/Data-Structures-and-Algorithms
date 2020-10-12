package iterators;

import java.util.Iterator;

public class IterableArrayListDemo {
    public static void main(String[] args) {
        IterableArrayList<String> names = new IterableArrayList<>();
        names.add(0, "Python");
        names.add(1, "Go");
        names.add(2, "Rust");
        names.add(3, "Nim");
        names.add(4, "Java");
        System.out.println(names);
        for (String name : names) {
            System.out.println(name);
        }
        Iterator<String> iterator = names.iterator();
        System.out.println("Print interator values");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // uncomment the below line to see the error
        // System.out.println(iterator.next());
        iterator = names.iterator();
        System.out.println("Print interator values");
        while (iterator.hasNext()) {
            if (iterator.next().equals("Java")) {
                System.out.println("Removing Java");
                iterator.remove();
            }
        }
        System.out.println("Names now:");
        System.out.println(names);
    }
}
