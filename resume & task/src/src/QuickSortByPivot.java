import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSortByPivot {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src" + File.separator + "input.txt"));
        int arrayDimention = sc.nextInt();
        int kSetDimention = sc.nextInt();
        int[] arrayA = new int[arrayDimention];
        for (int i = 0; i < arrayDimention; i++) {
            arrayA[i] = sc.nextInt();
        }
        int[] sortedArrayA;
        sortedArrayA = Arrays.copyOf(arrayA, arrayDimention);
        quickSort(sortedArrayA, 0, sortedArrayA.length - 1);
        System.out.printf("%d\n%d\n%s\n%s\n", arrayDimention, kSetDimention, Arrays.toString(arrayA), Arrays.toString(sortedArrayA));
    }

    private static void quickSort(int[] array, int beginPos, int endPos) {
        if (beginPos < endPos) {
            int border = pivoting(array, beginPos, endPos);
            quickSort(array, beginPos, border - 1);
            quickSort(array, border + 1, endPos);
        }
    }

    private static int pivoting(int[] array, int beginPos, int endPos) {
        int i = beginPos - 1;
        int pivot = array[endPos];
        for (int j = beginPos; j < endPos; j++) {
            if (array[j] <= pivot) {
                i++;
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }
        int swap = array[i + 1];
        array[i + 1] = array[endPos];
        array[endPos] = swap;
        return i + 1;
    }
}
