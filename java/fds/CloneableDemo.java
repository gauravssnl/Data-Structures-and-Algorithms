package fds;

import java.util.Arrays;

public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person[] guestList1 = new Person[5];
        Person person = new Person("P1", 25);
        guestList1[0] = person;
        person = new Person("P2", 26);
        guestList1[1] = person;
        person = new Person("P3", 27);
        guestList1[2] = person;
        person = new Person("P4", 28);
        guestList1[3] = person;
        person = new Person("P5", 29);
        guestList1[4] = person;
        System.out.println(Arrays.toString(guestList1));
        
        Person[] guestList2 = new Person[guestList1.length];
        // make a deep copy 
        for (int i =0; i < guestList1.length; i++) {
            guestList2[i] = (Person) guestList1[i].clone();
        }
        System.out.println(Arrays.toString(guestList2));
        person = new Person("P6", 30);
        guestList1[4] = person; // only affects guestList1 as guestList2 is a deep copy
        System.out.println(Arrays.toString(guestList1));
        System.out.println(Arrays.toString(guestList2));
    }
}
