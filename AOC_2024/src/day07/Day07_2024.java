package day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day07_2024 {
    public long EvaluationOfEquation(String filePath) throws FileNotFoundException{
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        long sum = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            String str = arr[0];
            arr[0] = str.substring(0,str.length()-1);
//            System.out.println(Arrays.toString(arr));
            Long[] nums = new Long[arr.length];
            for(int i=0; i<nums.length; i++){
                nums[i] = Long.parseLong(arr[i]);
            }
            if(recursion(0,nums,nums[0],0)){
                System.out.println(Arrays.toString(nums));
                sum+=nums[0];
            }
        }
        return sum;
    }
    public boolean recursion(int ind, Long[] nums, long target, long currResult){
        if(ind == nums.length){
            return currResult==target;
        }
        boolean add = recursion(ind+1, nums, target, currResult + nums[ind]);
        boolean multiply = recursion(ind+1, nums, target, currResult * nums[ind]);
        return add || multiply;
    }
}
