package day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Day07_2_2024 {
    public BigInteger Concatenation(String filePath) throws FileNotFoundException{
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        BigInteger sum = BigInteger.ZERO;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            String str = arr[0];
            arr[0] = str.substring(0, str.length() - 1);

            BigInteger[] nums = new BigInteger[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = new BigInteger(arr[i]);
            }

            if (recursion(0, nums, nums[0], BigInteger.ZERO)) {
                System.out.println(Arrays.toString(nums));
                sum = sum.add(nums[0]);
            }
        }
        return sum;
    }

    public boolean recursion(int ind, BigInteger[] nums, BigInteger target, BigInteger currResult) {
        if (ind == nums.length) {
            return currResult.equals(target);
        }

        boolean add = recursion(ind + 1, nums, target, currResult.add(nums[ind]));
        boolean concatenate = recursion(ind + 1, nums, target, concatenate(currResult, nums[ind]));
        boolean multiply = recursion(ind + 1, nums, target, currResult.multiply(nums[ind]));

        return add || multiply || concatenate;
    }
    public BigInteger concatenate(BigInteger curr, BigInteger num) {
        StringBuilder sb = new StringBuilder();
        sb.append(curr);
        sb.append(num);
        String str = sb.toString();
        System.out.println(str);
        return new BigInteger(str);
    }
}