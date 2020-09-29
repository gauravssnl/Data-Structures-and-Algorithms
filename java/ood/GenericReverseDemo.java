package ood;

import java.util.Arrays;

public class GenericReverseDemo {
    /** A generic method to reverse an array. */
    // This generic method cannot be applied to primitive arrays, because autoboxing
    // does not apply to entire arrays.
    public static <T> void reverse(T[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) {
            T temp = data[low];
            // now we need to swap values between both the ends.
            data[low++] = data[high]; // post-increment of low
            data[high--] = temp; // post-decrement on high

        }

    }

    public static void main(String[] args) {
        Student[] students = new Student[10];
        for (int i = 0; i < 10; i++) {
            Student s = new Student(String.valueOf(i), "Student" + i, i + 10);
            students[i] = s;
        }
        System.out.println(Arrays.toString(students));
        reverse(students);
        System.out.println("Students list after reversing.");
        System.out.println(Arrays.toString(students));
    }
}
