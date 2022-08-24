package distance;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Distance_ver02 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("src" + File.separator
                + "distance" + File.separator + "input.txt")));

        String[] amounts = sc.readLine().split(" ");
        int arrayDimention = Integer.parseInt(amounts[0]);
        int kSetDimention = Integer.parseInt(amounts[1]);

        int[] array = new int[arrayDimention];

        int c;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((c = sc.read()) != -1) {
            if (c >= 48 && c <= 57) {
                sb.append((char) c);
            } else if (sb.length() > 0) {
                array[i] = Integer.parseInt(sb.toString());
                sb.setLength(0);
                i++;
            }
        }

        System.out.printf("%d %d\n%s\n", arrayDimention, kSetDimention, Arrays.toString(array));
        findDistance(array, kSetDimention);
        sc.close();
    }

    private static void findDistance(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            int[] temp = new int[array.length - 1];
            swap(array, i);
            for (int j = 1; j < array.length; j++) {
                temp[j - 1] = Math.abs(array[0] - array[j]);
            }
            Arrays.sort(temp);
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += temp[j];
            }
            System.out.print(sum + " ");
            swap(array, i);
        }
    }

    private static void swap(int[] array, int i) {
        int swap = array[0];
        array[0] = array[i];
        array[i] = swap;
    }
}
