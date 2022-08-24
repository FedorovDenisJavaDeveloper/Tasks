package minesweeper;

import java.util.Arrays;

public class MinesweeperFillArray {
    public final static int N = 11;
    public final static int M = 10;

    public static void main(String[] args) {
        char[][] array = new char[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(array[i], '.');
        }
        int[][] mines = {
                {3, 0}, {10, 0}, {2, 1}, {5, 1},
                {6, 2}, {4, 3}, {6, 3}, {1, 4},
                {9, 4}, {7, 5}, {2, 6}, {10, 6},
                {9, 7}, {10, 8}, {1, 9}, {6, 9}
        };
        for (int i = 0; i < mines.length; i++) {
            array[mines[i][0]][mines[i][1]] = '*';
            putDigitsAroundMine(array, mines[i][0], mines[i][1]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void putDigitsAroundMine(char[][] array, int i, int j) {
        for (int k = i - 1; k <= i + 1; k++) {
            if (k >= 0 && k < N) {
                for (int l = j - 1; l <= j + 1; l++) {
                    if (l >= 0 && l < M) {
                        if (array[k][l] != '*') {
                            if (array[k][l] == '.') {
                                array[k][l] = '1';
                            } else {
                                array[k][l] += 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
