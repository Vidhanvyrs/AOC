package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02_2_2024 {

    public int findSafeLevel(String filePath) throws FileNotFoundException {
        int isSafe = 0;
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine().trim();
            if (currentLine.isEmpty()) {
                continue;
            }

            String[] arr = currentLine.split("\\s+");
            if (arr.length < 2) {
                continue;
            }

            int[] levels = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                levels[i] = Integer.parseInt(arr[i]);
            }

            if (isSafeReport(levels)) {
                isSafe++;
            } else if (canBeMadeSafe(levels)) {
                isSafe++;
            }
        }

        return isSafe;
    }

    // Check if the report is safe without modifications
    private boolean isSafeReport(int[] levels) {
        if (levels.length < 2) {
            return false;
        }

        boolean isAscending = levels[0] < levels[1];
        for (int i = 0; i < levels.length - 1; i++) {
            int curr = levels[i];
            int next = levels[i + 1];
            int diff = Math.abs(curr - next);

            if (diff < 1 || diff > 3) {
                return false;
            }

            if (isAscending && curr >= next) {
                return false;
            }

            if (!isAscending && curr <= next) {
                return false;
            }
        }
        return true;
    }

    //gonna remove one by one inorder to get to know whether it could be made safe or not
    private boolean canBeMadeSafe(int[] levels) {
        for (int i = 0; i < levels.length; i++) {
            if (isSafeReport(removeLevel(levels, i))) {
                return true;
            }
        }
        return false;
    }

    // Remove the level at the specified index and gonna insert it into the modified array
    private int[] removeLevel(int[] levels, int index) {
        int[] modified = new int[levels.length - 1];
        for (int i = 0, j = 0; i < levels.length; i++) {
            if (i != index) {
                modified[j++] = levels[i];
            }
        }
        return modified;
    }
}
