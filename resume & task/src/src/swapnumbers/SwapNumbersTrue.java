package swapnumbers;

import java.util.Arrays;

public class SwapNumbersTrue {
    public static void main(String[] args) {
        int a = 1234327;
        int b = 7223134;

        int[] arrayA = digitArray(a);
        int[] arrayB = digitArray(b);

        System.out.println("Result = " + Arrays.equals(arrayA, arrayB));
    }

    private static int[] digitArray(int number) {
        int[] res = new int [10];
        while(number>0){
            res[number % 10]++;
            number = number/10;
        }
        return res;
    }
}
