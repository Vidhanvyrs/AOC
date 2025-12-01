package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day06_2024 {
    public int Visitation(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        List<List<Character>> list = new ArrayList<>();
        List<List<Character>> visited = new ArrayList<>();

        while (scanner.hasNextLine()) {
            List<Character> inner = new ArrayList<>();
            List<Character> vis = new ArrayList<>();
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                inner.add(line.charAt(i));
                vis.add('V');
            }
            list.add(inner);
            visited.add(vis);
        }
        scanner.close();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == '^') {
                    StartTravellingUP(list, visited, i, j);
                    break;
                }
            }
        }

        int countX = 0;
        for (var row : visited) {
            for (char c : row) {
                if (c == 'X') countX++;
            }
        }

        return countX;
    }

    public void StartTravellingUP(List<List<Character>> list, List<List<Character>> visited, int i, int j) {
        if (isBoundary(list, i, j)) {
            return;
        }

        if (list.get(i - 1).get(j) == '#') {
            StartTravellingRight(list, visited, i, j); // Turn right
        } else {
            visited.get(i).set(j, 'X');
            StartTravellingUP(list, visited, i - 1, j);
        }
    }

    public void StartTravellingRight(List<List<Character>> list, List<List<Character>> visited, int i, int j) {
        if (isBoundary(list, i, j)) {
            return;
        }

        if (list.get(i).get(j + 1) == '#') {
            StartTravellingDown(list, visited, i, j); // Turn down
        } else {
            visited.get(i).set(j, 'X');
            StartTravellingRight(list, visited, i, j + 1);
        }
    }

    public void StartTravellingDown(List<List<Character>> list, List<List<Character>> visited, int i, int j) {
        if (isBoundary(list, i, j)) {
            return;
        }

        if (list.get(i + 1).get(j) == '#') {
            StartTravellingLeft(list, visited, i, j); // Turn left
        } else {
            visited.get(i).set(j, 'X');
            StartTravellingDown(list, visited, i + 1, j);
        }
    }

    public void StartTravellingLeft(List<List<Character>> list, List<List<Character>> visited, int i, int j) {
        if (isBoundary(list, i, j)) {
            return;
        }

        if (list.get(i).get(j - 1) == '#') {
            StartTravellingUP(list, visited, i, j); // Turn up
        } else {
            visited.get(i).set(j, 'X');
            StartTravellingLeft(list, visited, i, j - 1);
        }
    }

    public boolean isBoundary(List<List<Character>> list, int row, int col) {
        return row == 0 || row == list.size() - 1 || col == 0 || col == list.get(row).size() - 1;
    }
}
