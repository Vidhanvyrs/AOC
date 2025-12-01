package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//mul(4*, mul(6,9!, ?(12,34), or mul ( 2 , 4 ) do nothing.
public class Day03_2024 {
    //here is what i require m | u | l | ( | anynumber | , | anynumber | )
    public int NorthPoleMultiplier(String filePath) throws FileNotFoundException{
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int mulSum = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            for(int i=0; i<line.length(); i++){
                if(line.charAt(i)=='m'){
                    if(i+3<line.length() && line.charAt(i+1)=='u' && line.charAt(i+2)=='l' && line.charAt(i+3)=='(' ){
                        i+=4;
                        int[] vals = getNumber(i,line);
                        i = vals[1];
                        int num = vals[0];
                        if(i<line.length() && line.charAt(i)==','){
                            i+=1;
                            int[] vals2 = getNumber(i,line);
                            i=vals2[1];
                            int num2 = vals2[0];
                            if(i<line.length() && line.charAt(i)==')'){
                                if(num!=-1 && num2!=-1)mulSum += num * num2;
                            }
                        }

                    }
                }
            }
        }

        return mulSum;
    }
    public int[] getNumber(int i, String line){
        int x = 0;
        while(x<1000 && isDigit(line.charAt(i))){
            x=10*x+(line.charAt(i)-'0');
            i++;
        }
        if(1 <= x && x <= 999){
            return new int[]{x,i};
        }
        return new int[]{-1,i};
    }

    public boolean isDigit(char ch){
        return Character.isDigit(ch);
    }

//    ---------------------------------another regex method--------------

}
