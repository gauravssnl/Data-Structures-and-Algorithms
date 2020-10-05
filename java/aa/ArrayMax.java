package aa;

// Time complexity : O(n)
public class ArrayMax {
    public static double arrayMax(double[] data) {
        int n = data.length;
        double currentMax = data[0];
        // loop runs n-1 times
        for (int i = 1; i < n; i++)
            if (data[i] > currentMax)
                currentMax = data[i];
        return currentMax;
    }

    public static void main(String[] args) {
        double[] data = { 1.0, 3.4, 4.5, 5.6, 6.7, 3.2 };
        System.out.println(arrayMax(data));
    }
}
