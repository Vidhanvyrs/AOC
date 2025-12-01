package day04;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Day04_2024 day04 = new Day04_2024();
        Day04_2_2024 day04_2 = new Day04_2_2024();
        int counter = day04.CountXMAS("src/resources/example4.txt");
        int masX = day04_2.findMAS_X("src/resources/input4.txt");
        System.out.println(masX);
    }
}
