//import day01.Day01_2024;
//import day01.Day01_2_2024;
//import day02.Day02_2024;
//import day02.Day02_2_2024;
//import day03.Day03_2024;
//import day03.Day03_2_2024;

//import day04.Day04_2024;;
import day06.Day06_2024;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//      Day01_2024 day01 = new Day01_2024();
//      Day01_2_2024 day01_2 = new Day01_2_2024();
//      Day02_2024 day02 = new Day02_2024();
//        Day02_2_2024 day02_2 = new Day02_2_2024();
//        Day03_2024 day03_2024 = new Day03_2024();
//        Day03_2_2024 day03_2_2024 = new Day03_2_2024();
//        Day05_2024 day05 = new Day05_2024();
//        Day05_2_2024 day05_2 = new Day05_2_2024();
//        int sum = day03_2024.NorthPoleMultiplier("src/resources/input3.txt");
//        int sum2 =day03_2_2024.NorthPoleDoMultiplier("src/resources/input3.txt");
//        int MidSum = day05.CorrectOrder("src/resources/input5.txt");
//        int incorrectSum = day05_2.incorrectMidSum("src/resources/input5.txt");
        Day06_2024 day06_2024 = new Day06_2024();
        int visitedPlaces = day06_2024.Visitation("src/resources/input6.txt");
        System.out.println(visitedPlaces+1);
    }
}