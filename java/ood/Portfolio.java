package ood;

/** A sample class storing data in a generic Array. */
public class Portfolio<T> {
    T[] data;

    public Portfolio(int capacity) {
        /*
         * If the class uses <T> as a parameterized type, it can declare an array of
         * type T[ ], but it cannot directly instantiate such an array. Instead, a
         * common approach is to instantiate an array of type Object[ ], and then make a
         * narrowing cast to type T[ ],
         */
        // uncomment the below line to see the error
        // data = new T[capacity]; // illegal; compile error
        data = (T[]) new Object[capacity]; // legal; but compiler warning
    }

    public T get(int index) {
        return data[index];
    }

    public void set(int index, T element) {
        data[index] = element;
    }

}
