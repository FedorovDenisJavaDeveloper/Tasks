package multiply;

import java.util.Arrays;

public class MaxMultiplyOf3InArray {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, -4, 10, -5, 2, 9, 0, -7};
        int min1 = array[0];
        int min2 = array[0];
        int max1 = array[0];
        int max2 = array[0];
        int max3 = array[0];
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            if (x < max1) {
                if (x > min1 && x < min2) {
                    min2 = x;
                } else if (x < min1) {
                    min2 = min1;
                    min1 = x;
                }
            } else {
                if (x < max2) {
                    max1 = x;
                } else if (max2 < x && x < max3) {
                    max1 = max2;
                    max2 = x;
                } else if (max3 < x) {
                    max1 = max2;
                    max2 = max3;
                    max3 = x;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.printf(
                "Min1 = %d\nMin2 = %d\nMax1 = %d\nMax2 = %d\nMax3 = %d\n",
                min1, min2, max1, max2, max3
        );
        if (min1 * min2 >= max1 * max2) {
            System.out.printf("Лучшее произведение из чисел: %d, %d, %d", min1, min2, max3);
        } else {
            System.out.printf("Лучшее произведение из чисел: %d, %d, %d", max1, max2, max3);
        }
    }
}
