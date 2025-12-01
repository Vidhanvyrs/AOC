package day01;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Day01_2024 day01 = new Day01_2024();
        Day01_2_2024 day01_2 = new Day01_2_2024();
        int sum = day01.findSum("src/resources/input.txt"); //text file path
        int sum2 = day01_2.findSum("src/resources/input.txt");
        System.out.println(sum);
        System.out.println(sum2);
    }
}