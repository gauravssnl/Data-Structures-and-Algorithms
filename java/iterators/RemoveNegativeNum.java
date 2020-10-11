package iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveNegativeNum {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, -1, 4, -5, -10, 2, 34, -13 };
        ArrayList<Integer> numList = new ArrayList<>();
        for (int n : nums) {
            numList.add(n);
        }
        System.out.println(numList);
        Iterator<Integer> walk = numList.iterator();
        while (walk.hasNext()) {
            if (walk.next() < 0)
                walk.remove();
        }
        System.out.println(numList);
    }
}
