package ood;

// The issue with this approach is that we need expicit casting wherever we use the individual parts
/** Representing a generic pair of objects using a classic style. */
public class ObjectPair {
    Object first;
    Object second;

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

}
