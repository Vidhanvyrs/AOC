package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day03_2_2024 {

    public int NorthPoleDoMultiplier(String filePath) throws FileNotFoundException{
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int mulSum = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            boolean enable = true;
            for(int i=0; i<line.length()-7; i++){
                if(i+4<=line.length() && line.substring(i,i+4).equals("do()")){
                    enable=true;
                    i+=3;
                    continue;
                }
                if(i+7<=line.length() && line.substring(i,i+7).equals("don't()")){
                    enable=false;
                    i+=6;
                    continue;
                }
                if(enable && line.charAt(i)=='m'){
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


//    -----------------------another regex method-----------------------

    public int RegexMultiplier(String filePath) throws FileNotFoundException {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

        // Regex patterns
        String mulRegex = "mul\\((\\d+),(\\d+)\\)";
        String doRegex = "do\\(\\)";
        String dontRegex = "don't\\(\\)";

        Pattern mulPattern = Pattern.compile(mulRegex);
        Pattern doPattern = Pattern.compile(doRegex);
        Pattern dontPattern = Pattern.compile(dontRegex);

        boolean isEnabled = true; // Mul is enabled by default
        int mulSum = 0;

        // Scan through each line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int currentIndex = 0;

            while (currentIndex < line.length()) {
                String remaining = line.substring(currentIndex);

                // Check for do() and don't()
                Matcher doMatcher = doPattern.matcher(remaining);
                Matcher dontMatcher = dontPattern.matcher(remaining);
                Matcher mulMatcher = mulPattern.matcher(remaining);

                // Update isEnabled if a do() or don't() is encountered
                if (doMatcher.lookingAt()) {
                    isEnabled = true;
                    currentIndex += 4; // Move past "do()"
                } else if (dontMatcher.lookingAt()) {
                    isEnabled = false;
                    currentIndex += 7; // Move past "don't()"
                }
                // Process mul() instructions if enabled
                else if (mulMatcher.lookingAt() && isEnabled) {
                    // Extract numbers from mul()
                    String mulString = mulMatcher.group();
                    Matcher numberMatcher = Pattern.compile("\\d+").matcher(mulString);

                    int mulResult = 1;
                    while (numberMatcher.find()) {
                        mulResult *= Integer.parseInt(numberMatcher.group());
                    }

                    // Add to sum
                    mulSum += mulResult;

                    // Move past the current mul() match
                    currentIndex += mulMatcher.group().length();
                } else {
                    // Move to the next character if no match
                    currentIndex++;
                }
            }
        }

        scanner.close();
        return mulSum;
    }
}