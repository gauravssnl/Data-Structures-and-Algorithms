package primer;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        String title = "Data Structure & Algorithms in Rust. Pure";
        char d = title.charAt(0);
        System.out.println(d);
        // Print ACSII value of characters
        title.chars().forEach(i -> System.out.println(i + " " + (char) i));
        int[] charactersAsciiValueArray = title.chars().toArray();
        System.out.println(Arrays.toString(charactersAsciiValueArray));
        System.out.println(title.substring(5, 11));
        System.out.println(title.toLowerCase());
        System.out.println(title.toUpperCase());
        char c = 69;
        System.out.println(c);
        Character c1 = Character.valueOf(c);
        System.out.println(c1);
        System.out.println(Character.toChars(65));
        String[] splittedTitleData = title.split(" ");
        System.out.println(Arrays.toString(splittedTitleData));
        // get the ASCII value at a give index of a string
        System.out.println(title.codePointAt(2));
        System.out.println(title.contains("Rust"));
        System.out.println(title.contains("Java"));
        System.out.println(title.indexOf("re"));
        System.out.println(title.indexOf("Da"));
        System.out.println(title.indexOf("D"));
        // get the rightmost index
        System.out.println(title.lastIndexOf("re"));
        // get sum of ASCII value of each characters of the string
        String s1 = "ABC";
        System.out.println(s1.chars().sum());
        // space also matters
        String s2 = "ABC ";
        System.out.println(s2.chars().sum());

        // Let us see the right way to compare equality of Strings
        String title1 = new String("Data Structure & Algorithms in Rust. Pure");
        System.out.println(title == title1); // returns false
        System.out.println(title.equals(title1)); // return true
        String title3 = "Data Structure & Algorithms in Rust. Pure";
        System.out.println(title == title3); // return true
        // strip is used to remove only white space
        String title4 = "   Rust is cool. Python is cool. Java is cool. A lot of things are cool. Everyone is cool.  ";
        System.out.print(title4.strip());
        System.out.println("*Done*");

        title4 = "   Rust is cool. Python is cool. Java is cool. A lot of things are cool. Everyone is cool.  ";
        System.out.print(title4.stripLeading());
        System.out.println("*Done*");

        title4 = "   Rust is cool. Python is cool. Java is cool. A lot of things are cool. Everyone is cool.\t  ";
        System.out.print(title4.stripTrailing());
        System.out.println("*Done*");

        // trim is used to remove space from both leading and trailing end
        title4 = "   \tRust is cool. Python is cool. Java is cool. A lot of things are cool. Everyone is cool.\t\n  ";
        System.out.print(title4.trim());
        System.out.println("*Done*");
    }
}
