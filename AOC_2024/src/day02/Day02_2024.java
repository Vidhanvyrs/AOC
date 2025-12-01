package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day02_2024 {
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
                continue; // Ignore lines with less than 2 numbers
            }

            int[] levels = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                levels[i] = Integer.parseInt(arr[i]);
            }
            boolean isAscending = levels[0] < levels[1];
            boolean isValid = true;

            for (int i = 0; i < levels.length - 1; i++) {
                int curr = levels[i];
                int next = levels[i + 1];
                int diff = Math.abs(curr - next);

                if (diff < 1 || diff > 3) {
                    isValid = false;
                    break;
                }

                if (isAscending && curr >= next) {
                    isValid = false;
                    break;
                }

                if (!isAscending && curr <= next) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                isSafe++;
            }
        }
        return isSafe;
    }
}
