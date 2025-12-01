package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day05_2_2024 {
    public int incorrectMidSum(String filePath) throws FileNotFoundException {
        int MidSum = 0;
        Map<String, Set<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        boolean processingList = false;

        // Read and parse the input file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("|")) {
                String[] parts = line.split("\\|");
                String left = parts[0];
                String right = parts[1];
                map.putIfAbsent(left, new HashSet<>());
                map.get(left).add(right);
            } else {
                processingList = true;
                if (processingList) {
                    String[] arr = line.split(",");
                    List<String> seq = new ArrayList<>();
                    for (String part : arr) {
                        seq.add(part.trim());
                    }
                    list.add(seq);
                }
            }
        }
        scanner.close();

        System.out.println(map);
        System.out.println(list);

        List<List<String>> correctOrderList = new ArrayList<>();

        for (var inner : list) {
            while (true) {
                boolean corrected = false;

                for (int i = 0; i < inner.size() - 1; i++) {
                    String current = inner.get(i);
                    String next = inner.get(i + 1);

                    if (!map.containsKey(current) || !map.get(current).contains(next)) {
                        swap(inner, i, i + 1);
                        corrected = true;
                        break; // Restart
                    }
                }

                if (!corrected) {
                    correctOrderList.add(new ArrayList<>(inner)); // Add
                    break;
                }
            }
        }

        System.out.println("Correct Order List:");
        System.out.println(correctOrderList);

        for (var orderList : correctOrderList) {
            int mid = orderList.size() / 2;
            String middle = orderList.get(mid);
            int num = Integer.parseInt(middle);
            MidSum += num;
        }

        return MidSum;
    }

    public void swap(List<String> list, int ind1, int ind2) {
        String temp = list.get(ind1);
        list.set(ind1, list.get(ind2));
        list.set(ind2, temp);
    }
}
