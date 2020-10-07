package recursion;

import java.io.File;

public class DiskUsage {
    /**
     * Calculates the total disk usage (in bytes) of the portion of the file system
     * rooted at the given path, while printing a summary akin to the standard 'du'
     * Unix tool.
     */
    public static long diskUsage(File root) {
        long total = root.length(); // statrt with direct disk usage
        if (root.isDirectory()) { // if this is a directory, find the cumlative disk usage
            for (String childName : root.list()) { // then for each child
                File child = new File(root, childName); // compose full path to child
                total += diskUsage(child);
            }
        }
        System.out.println(total + "\t" + root); // decsriptive output
        return total; // return the grand total
    }

    public static void main(String[] args) {
        String rootDir = "C:\\Go";
        File rootFile = new File(rootDir);
        diskUsage(rootFile);
    }
}
