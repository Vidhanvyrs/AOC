package day02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Day02_2024 day02 = new Day02_2024();
        Day02_2_2024 day02_2 = new Day02_2_2024();
        int isSafe = day02.findSafeLevel("src/resources/input2.txt");
        int isSafe2 = day02_2.findSafeLevel("src/resources/input2.txt");
        System.out.println(isSafe);
        System.out.println(isSafe2);
    }
}
