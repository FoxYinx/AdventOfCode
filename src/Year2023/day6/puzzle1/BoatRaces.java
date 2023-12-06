package Year2023.day6.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BoatRaces {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day6/input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        int[] times = Arrays.stream(line.split(":")[1].strip().split(" +")).mapToInt(Integer::parseInt).toArray();
        line = scanner.nextLine();
        int[] distances = Arrays.stream(line.split(":")[1].strip().split(" +")).mapToInt(Integer::parseInt).toArray();
        int total = 1;
        for (int i = 0; i < times.length; i++) {
            int possibilities = 0;
            for (int j = 0; j < times[i]; j++) {
                int remains = times[i] - j;
                if (remains * j > distances[i]) {
                    possibilities++;
                }
            }
            total *= possibilities;
        }
        System.out.println("The mystery value is " + total);
    }

}
