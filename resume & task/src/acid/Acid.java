package acid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Acid {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src" + File.separator + "acid" + File.separator + "input.txt"));
        int amountBottles = sc.nextInt();
        int[] acidLitres = new int[amountBottles];
        int i = 0;
        while (sc.hasNext()) {
            acidLitres[i] = sc.nextInt();
            i++;
        }
        System.out.printf("Count of bottles %d, bottles filled %s\n", amountBottles, Arrays.toString(acidLitres));
        boolean canFill = true;
        for (i = 0; i < amountBottles - 1; i++) {
            if (acidLitres[i] > acidLitres[i + 1] || acidLitres[i] > acidLitres[amountBottles - 1]) {
                canFill = false;
                break;
            }
        }
        int fillIteration = -1;
        if (canFill) {
            fillIteration = acidLitres[amountBottles - 1] - acidLitres[0];
        }
        FileWriter output = new FileWriter("src/output.txt", false);
        output.write(Integer.toString(fillIteration));
        output.flush();
        output.close();
        sc.close();
        System.out.println("Min amount of iterations: " + fillIteration);
    }
}
