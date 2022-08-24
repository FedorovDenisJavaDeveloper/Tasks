package queen;

import java.util.HashMap;

public class Queen {
    final static int N = 8;

    public static void main(String[] args) {
        int[][] queenPosArray = {
                {1, 3},
                {1, 6},
                {2, 1},
                {2, 5},
                {3, 2},
                {3, 4},
                {4, 0},
                {4, 7},
                {5, 1},
                {5, 5},
                {6, 3}
        };

        HashMap<Integer, Integer> rowPosCount = new HashMap<>();
        HashMap<Integer, Integer> columnPosCount = new HashMap<>();
        HashMap<Integer, Integer> diagPosCount = new HashMap<>();
        HashMap<Integer, Integer> diagReversePosCount = new HashMap<>();

        for (int i = 0; i < queenPosArray.length; i++) {
            addPosToMap(columnPosCount, queenPosArray[i][1]);
            addPosToMap(rowPosCount, queenPosArray[i][0]);
            addPosToDiagonal(diagPosCount, diagReversePosCount, queenPosArray[i]);
        }
        System.out.println("Sum of Queens is " + (countSum(rowPosCount) + countSum(columnPosCount)
                + countSum(diagPosCount) + countSum(diagReversePosCount)));
    }

    private static void addPosToDiagonal(HashMap<Integer, Integer> diagonal, HashMap<Integer, Integer> diagonalReverse, int[] position) {
        int result = position[0] - position[1];
        addPosToMap(diagonal, result);
        result = N - 1 - (position[0] + position[1]);
        addPosToMap(diagonalReverse, result);
    }

    private static int countSum(HashMap<Integer, Integer> posCount) {
        int sum = 0;
        for (int pos : posCount.keySet()) {
            sum += posCount.get(pos) - 1;
        }
        return sum;
    }

    private static void addPosToMap(HashMap<Integer, Integer> posCount, int pos) {
        if (!posCount.containsKey(pos)) {
            posCount.put(pos, 1);
        } else {
            posCount.put(pos, posCount.get(pos) + 1);
        }
    }
}
