package firstsum;

import java.util.HashSet;
import java.util.Set;

public class FindSumInSet {
    public static void main(String[] args) {
        int[] set = {3, 5, 2, 6, 2, 7, 1, 3, 9, 6, 8, 1};
        int x = 10;
        findSumInSet(set, x);
    }

    private static void findSumInSet(int[] set, int x) {
        Set<Integer> lastSet = new HashSet<>();
        for (int a : set) {
            if (lastSet.contains(x - a)) {
                System.out.printf("A + B: %d + %d = %d\n", x - a, a, x);
                return;
            }
            lastSet.add(a);
        }
    }
}
