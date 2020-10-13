package iterators;

import java.util.Iterator;

public class FavoritesListDemo {
    public static void main(String[] args) {
        FavoritesList<String> favoritesList = new FavoritesList<>();
        favoritesList.access("Python");
        favoritesList.access("Rust");
        favoritesList.access("Go");
        favoritesList.access("JavaScript");
        favoritesList.access("Rust");
        favoritesList.access("R");
        favoritesList.access("D");
        favoritesList.access("C");
        favoritesList.access("C++");
        favoritesList.access("Java");
        favoritesList.access("Pascal");
        favoritesList.access("Nim");
        favoritesList.access("Dragon");
        favoritesList.access("Python");
        favoritesList.access("Rust");
        favoritesList.access("Go");
        favoritesList.access("JavaScript");
        favoritesList.access("Rust");
        favoritesList.access("Java");
        favoritesList.access("Go");
        favoritesList.access("Rust");
        favoritesList.access("JavaScript");
        System.out.println("List size: " + favoritesList.size());
        favoritesList.getFavorites(2).forEach(name -> System.out.print(name + " "));
        System.out.println();
        favoritesList.getFavorites(3).forEach(name -> System.out.print(name + " "));
        System.out.println();
        favoritesList.getFavorites(4).forEach(name -> System.out.print(name + " "));
        System.out.println();
        System.out.println("Top 10 most accessed elements");
        for (int i = 1; i < 11; i++) {
            // System.out.print("i: " + i + " ");
            favoritesList.getFavorites(i).forEach(name -> System.out.print(name + " "));
            System.out.println();
        }
        System.out.println("Remove the most accessed element from the list");
        Iterator<String> iterator = favoritesList.getFavorites(1).iterator();
        if (iterator.hasNext()) {
            favoritesList.remove(iterator.next());
            // The below code will not work as expected
            // iterator.next();
            // iterator.remove();
        }

        System.out.println("Top two most accessed elements now: ");
        favoritesList.getFavorites(2).forEach(name -> System.out.print(name + " "));
    }
}
