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
}
