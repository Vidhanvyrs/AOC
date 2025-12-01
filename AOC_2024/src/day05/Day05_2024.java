package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day05_2024 {
    public int CorrectOrder(String filePath) throws FileNotFoundException {
        int MidSum = 0;
        Map <String, Set<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        boolean processingList = false;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("|")) {
                String[] parts = line.split("\\|");
                String left = parts[0];
                String right = parts[1];
            if(!map.containsKey(left)){
                map.put(left,new HashSet<>());
                map.get(left).add(right);
            }
            if(map.containsKey(left)){
                map.get(left).add(right);
            }
            }else{
                processingList = true;
                if(processingList){
                    String[] arr = line.split(",");
                    List<String> seq = new ArrayList<>();
                    for(String part : arr){
                        seq.add(part.trim());
                    }
                    list.add(seq);
                }
            }
        }
//        System.out.println(map);
//        System.out.println(list);

        List<List<String>> correctOrderList = new ArrayList<>();
        for (var inner : list) {
            boolean correctOrder = true;
            for (int i = 0; i < inner.size() - 1; i++) {
                String current = inner.get(i);
                String next = inner.get(i + 1);
                // Check if the map contains the current key
                if (!map.containsKey(current) || !map.get(current).contains(next)) {
                    correctOrder = false;
                    break;
                }
            }
            if (correctOrder) {
                correctOrderList.add(inner);
            }
        }

//        System.out.println("Correct Order List:");
//        System.out.println(correctOrderList);

        for(var orderlist : correctOrderList){
            int left = 0;
            int right = orderlist.size()-1;
            int mid = left + (right-left)/2;
            String middle = orderlist.get(mid);
            int num = Integer.parseInt(middle);
            MidSum += num;
        }

        return MidSum;
    }
}
