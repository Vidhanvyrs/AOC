package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//class Pair {
//    int x;
//    int y;
//
//    public Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public String toString() {
//        return "(" + x + ", " + y + ")";
//    }
//}
//

public class Day08_2024 {
    public int PosCounter(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int counter = 0;
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        int m = list.size(), n = list.get(0).length();
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = list.get(i).toCharArray();
        }

        Map<Character, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != '.') {
                    map.putIfAbsent(arr[i][j], new ArrayList<>());
                    map.get(arr[i][j]).add(new Pair(i, j));
                }
            }
        }
        Set<Pair> antinodes = new HashSet<>();
        for (var entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
            List<Pair> inner = entry.getValue();
//            System.out.println(inner);
            for (int i = 0; i < inner.size(); i++) {
                Pair pair1 = inner.get(i);
                int x1 = pair1.x();
                int y1 = pair1.y();
                for (int j = i + 1; j < inner.size(); j++) {
                    Pair pair2 = inner.get(j);
                    int x2 = pair2.x();
                    int y2 = pair2.y();

                    int ind1 = 2 * x1 - x2;
                    int ind2 = 2 * y1 - y2;
                    Pair anti1 = new Pair(ind1, ind2);

                    int idx1 = 2 * x2 - x1;
                    int idx2 = 2 * y2 - y1;
                    Pair anti2 = new Pair(idx1, idx2);

                    if (ind1 >= 0 && ind1 < m && ind2 >= 0 && ind2 < n) antinodes.add(anti1);
                    if (idx1 >= 0 && idx1 < m && idx2 >= 0 && idx2 < n) antinodes.add(anti2);
                }
//                System.out.println(">>" + antinodes.size());
            }
        }

        return antinodes.size();
    }

    record Pair(int x, int y){
        @Override
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }
}
