package distance;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Distance {
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
        int[] sorted = countSort(array);
        Map<Integer, Integer> result = new HashMap<>();
        calcDistance(sorted, result, kSetDimention);
        printA(result, array);
        sc.close();
    }

    private static int[] countSort(int[] array) {

        int[] temp = new int[findMax(array) + 1];
        for (int x : array) {
            temp[x]++;
        }
        int[] result = new int[array.length];
        int pos = 0;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] != 0) {
                for (int j = 0; j < temp[i]; j++) {
                    result[pos] = i;
                    pos++;
                }
            }
        }

        return result;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    private static void printA(Map<Integer, Integer> result, int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(result.get(array[i]) + " ");
        }
        System.out.println();
    }

    private static void calcDistance(int[] array, Map<Integer, Integer> result, int kSetDimention) {
        for (int i = 0; i < array.length; i++) {
            if (!result.containsKey(array[i])) {
                int leftPos = 0;
                int rightPos = 0;
                int lastSum = 0;
                for (int j = 0; j < kSetDimention; j++) {
                    if (i == 0) {
                        lastSum += Math.abs(array[i] - array[i + j + 1]);
                    } else if (i == array.length - 1) {
                        lastSum += Math.abs(array[i] - array[i - j - 1]);
                    } else {
                        if (j == 0) {
                            leftPos = i - 1;
                            rightPos = i + 1;
                            if ((Math.abs(array[i] - array[leftPos])) >= (Math.abs(array[i] - array[rightPos]))) {
                                lastSum = Math.abs(array[i] - array[rightPos]);
                                rightPos++;
                            } else {
                                lastSum = Math.abs(array[i] - array[leftPos]);
                                leftPos--;
                            }
                        } else {
                            if ((rightPos > array.length - 1) && leftPos >= 0) {
                                lastSum += Math.abs(array[i] - array[leftPos]);
                                leftPos--;
                            } else if (leftPos < 0 && (rightPos <= array.length - 1)) {
                                lastSum += Math.abs(array[i] - array[rightPos]);
                                rightPos++;
                            } else {
                                if ((lastSum + Math.abs(array[i] - array[leftPos])) >= (lastSum + Math.abs(array[i] - array[rightPos]))) {
                                    lastSum += Math.abs(array[i] - array[rightPos]);
                                    rightPos++;
                                } else {
                                    lastSum += Math.abs(array[i] - array[leftPos]);
                                    leftPos--;
                                }
                            }
                        }
                    }
                }
                result.put(array[i], lastSum);
            }
        }
    }
}