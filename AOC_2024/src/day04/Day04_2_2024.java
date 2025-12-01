package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day04_2_2024 {
    public int findMAS_X(String filePath) throws FileNotFoundException{
        int masX = 0;
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
        }
        Set<String> set = new HashSet<>();
        set.add("MMSS");
        set.add("MSSM");
        set.add("SSMM");
        set.add("SMMS");
        int size = list.get(0).size();
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<size; j++){
                if(list.get(i).get(j)=='A'){
                    masX += goDiagonal(i,j,list,set);
                }
            }
        }

        return masX;
    }
    public int goDiagonal(int start, int end, List<List<Character>> list, Set<String>set){
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        if(start-1>=0 && end-1>=0) {
          sb.append(list.get(start-1).get(end-1));
        }
        if(start-1>=0 && end+1<list.get(start).size()) {
            sb.append(list.get(start-1).get(end+1));
        }
        if(start+1<list.size() && end+1<list.get(start).size()) {
            sb.append(list.get(start+1).get(end+1));
        }
        if(start+1<list.size() && end-1>=0){
            sb.append(list.get(start+1).get(end-1));
        }
        String str = sb.toString();
        if(set.contains(str))counter++;
        return counter;
    }

}
