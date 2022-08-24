package seatavailable;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class SeatAvailable {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("src" + File.separator +
                "seatavailable" + File.separator + "input.txt"));
        int rowAmount = Integer.parseInt(sc.nextLine());
        StringBuilder[] rows = new StringBuilder[rowAmount];

        for (int i = 0; i < rowAmount; i++) {
            rows[i] = new StringBuilder(sc.nextLine());
        }

        int groupAmount = Integer.parseInt(sc.nextLine());
        String[] groupDemand;

        int startSeat = 0;
        int endSeat = 0;

        String freeSeats = "";

        int peopleInGroup = 0;
        String rowsName = "ABC_DEF";
        boolean findSeats = false;

        int lastRow = 0;

        for (int i = 0; i < groupAmount; i++) {

            groupDemand = sc.nextLine().split(" ");
            peopleInGroup = Integer.parseInt(groupDemand[0]);

            if (groupDemand[1].equals("left")) {
                if (groupDemand[2].equals("window")) {
                    startSeat = 0;
                    endSeat = peopleInGroup;
                } else {
                    startSeat = 2 - peopleInGroup + 1;
                    endSeat = 3;
                }
            } else {
                if (groupDemand[2].equals("window")) {
                    startSeat = 6 - peopleInGroup + 1;
                    endSeat = 7;
                } else {
                    startSeat = 4;
                    endSeat = 4 + peopleInGroup;
                }
            }

            freeSeats += String.join("", Collections.nCopies(peopleInGroup, "."));

            for (int j = 0; j < rowAmount; j++) {
                if (rows[j].substring(startSeat, endSeat).equals(freeSeats)) {
                    String strX = "";
                    strX += String.join("", Collections.nCopies(peopleInGroup, "X"));
                    rows[j].replace(startSeat, endSeat, strX);
                    lastRow = j;
                    System.out.print("Passengers can take seats:");
                    for (int k = startSeat; k < endSeat; k++) {
                        System.out.print(" " + (j + 1) + rowsName.charAt(k));
                    }
                    System.out.println();

                    findSeats = true;
                    break;
                }
            }
            if (!findSeats) {
                System.out.println("Cannot fulfill passengers requirements");
            } else {
                for (int j = 0; j < rowAmount; j++) {
                    System.out.println(rows[j].toString());
                }
                String strH = "";
                strH += String.join("", Collections.nCopies(peopleInGroup, "#"));
                rows[lastRow].replace(startSeat, endSeat, strH);
            }
            freeSeats = "";
            findSeats = false;
        }

    }
}
