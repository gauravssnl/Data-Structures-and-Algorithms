package aa;

public class PrefixAverages {
    // Time complexity : O(n ^ 2)
    public static double[] prefixAverage1(double[] data) {
        int n = data.length;
        double[] a = new double[n]; // filled with zeros by default
        // executed n time for j = 0, 1, ... n-1
        for (int j = 0; j < n; j++) {
            double sum = 0;
            // executed j + 1 times
            // i.e inner loop is executed 1 + 2 + 3 + ... + n- times => Time complexity :
            // O(n ^ 2)
            for (int k = 0; k <= 0; k++)
                sum += data[k];
            a[j] = sum / (j + 1);
        }
        return a;
    }

    // Time complexity : O(n)
    public static double[] prefixAverage2(double[] data) {
        int n = data.length;
        double[] a = new double[n]; // filled with zeros by default
        double sum = 0;
        // executed n time for j = 0, 1, ... n-1
        for (int j = 0; j < n; j++) {
            sum += data[j];
            a[j] = sum / (j + 1);
        }
        return a;
    }
}
