package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day04_2024 {
    public int CountXMAS(String filePath) throws FileNotFoundException{
        int xmas = 0;
        List<List<Character>> list = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            List<Character> inner = new ArrayList<>();
            String line = scanner.nextLine();
            for(int i=0; i<line.length(); i++){
                inner.add(line.charAt(i));
            }
            list.add(inner);
            System.out.println(inner);
        }
        int size = list.get(0).size();
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<size; j++){
                if(list.get(i).get(j)=='X'){
                    xmas += findXMAS(i,j,list);
                }
            }
        }

        return xmas;
    }
    public int findXMAS(int start,int end, List<List<Character>> list){
        int count = 0;
        StringBuilder sb;
        //leftward
        if (end - 3 >= 0) {
            sb = new StringBuilder();
            for (int i = end; i >= end - 3; i--) {
                sb.append(list.get(start).get(i));
            }
            if (sb.toString().equals("XMAS")) count++;
        }
        //rightward
        if (end + 3 < list.get(start).size()) {
            sb = new StringBuilder();
            for (int i = end; i <= end + 3; i++) {
                sb.append(list.get(start).get(i));
            }
            if (sb.toString().equals("XMAS")) count++;
        }
        //downward
        if (start + 3 < list.size()) {
            sb = new StringBuilder();
            for (int i = start; i <= start + 3; i++) {
                sb.append(list.get(i).get(end));
            }
            if (sb.toString().equals("XMAS")) count++;
        }
        //upward
        if (start - 3 >= 0) {
            sb = new StringBuilder();
            for (int i = start; i >= start - 3; i--) {
                sb.append(list.get(i).get(end));
            }
            if (sb.toString().equals("XMAS")) count++;
        }
        //diagonals directions all
        // Top-left diagonal (start-3, end-3)
        if (start - 3 >= 0 && end - 3 >= 0) {
            sb = new StringBuilder();
            for (int i = 0; i <= 3; i++) {
                sb.append(list.get(start - i).get(end - i));
            }
            if (sb.toString().equals("XMAS")) count++;
        }

        // Top-right diagonal (start-3, end+3)
        if (start - 3 >= 0 && end + 3 < list.get(start).size()) {
            sb = new StringBuilder();
            for (int i = 0; i <= 3; i++) {
                sb.append(list.get(start - i).get(end + i));
            }
            if (sb.toString().equals("XMAS")) count++;
        }

        // Bottom-left diagonal (start+3, end-3)
        if (start + 3 < list.size() && end - 3 >= 0) {
            sb = new StringBuilder();
            for (int i = 0; i <= 3; i++) {
                sb.append(list.get(start + i).get(end - i));
            }
            if (sb.toString().equals("XMAS")) count++;
        }

        // Bottom-right diagonal (start+3, end+3)
        if (start + 3 < list.size() && end + 3 < list.get(start).size()) {
            sb = new StringBuilder();
            for (int i = 0; i <= 3; i++) {
                sb.append(list.get(start + i).get(end + i));
            }
            if (sb.toString().equals("XMAS")) count++;
        }

        return count;
    }
}
