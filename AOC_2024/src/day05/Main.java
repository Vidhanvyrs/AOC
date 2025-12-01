package day05;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Day05_2024 day05 = new Day05_2024();
        Day05_2_2024 day05_2 = new Day05_2_2024();
        int MidSum = day05.CorrectOrder("src/resources/input5.txt");
        int incorrectSum = day05_2.incorrectMidSum("src/resources/input5.txt");
        System.out.println(MidSum);
        System.out.println(incorrectSum-MidSum);
    }
}
