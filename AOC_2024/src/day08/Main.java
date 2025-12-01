package day08;



import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Day08_2024 day08_2024 = new Day08_2024();
//        int count = day08_2024.PosCounter("src/resources/example8.txt");
        int count = day08_2024.PosCounter("src/resources/input8.txt");
        System.out.println(count);
    }
}
