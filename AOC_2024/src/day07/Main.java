package day07;

import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        Day07_2024 day07_2024 = new Day07_2024();
        Day07_2_2024 day07_2_2024 = new Day07_2_2024();
        long sum = day07_2024.EvaluationOfEquation("src/resources/input7.txt");
        BigInteger sum2 = day07_2_2024.Concatenation("src/resources/input7.txt");
        System.out.println(sum2);
    }
}
