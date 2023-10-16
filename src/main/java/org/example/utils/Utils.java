package org.example.utils;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Utils {
    public static ArrayList<Integer> initializeBoard(int n) {
        ArrayList<Integer> queenPlaces = new ArrayList<>(n);
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            queenPlaces.add(rand.nextInt(n));
        }
        return queenPlaces;
    }

    public static int calculateConflicts(ArrayList<Integer> queenPlaces) {
        int conflicts = 0;
        for (int i = 0; i < queenPlaces.size(); i++) {
            for (int j = i + 1; j < queenPlaces.size(); j++) {
                if (Objects.equals(queenPlaces.get(i), queenPlaces.get(j)) ||
                        Math.abs(queenPlaces.get(i) - queenPlaces.get(j)) == Math.abs(i - j)) {
                    conflicts++;
                }
            }
        }
        return conflicts;
    }

    public static void displaySolution(ArrayList<Integer> queenPlaces) {
        for (int i = 0; i < queenPlaces.size(); i++) {
            for (int j = 0; j < queenPlaces.size(); j++) {
                if (queenPlaces.get(i) == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
