package aa;

public class Disjointness {
    // Time Complexity : O(n ^ 3)
    public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
        for (int a : groupA)
            for (int b : groupB)
                for (int c : groupC)
                    if (a == b && b == c)
                        return false;
        return true;
    }

    // Time Complexity : O(n ^ 2)
    public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
        for (int a : groupA)
            for (int b : groupB)
                if (a == b)
                    for (int c : groupC)    // only check C when we find match from A and B
                        if (a == b && b == c)
                            return false;
        return true;
    }
}
