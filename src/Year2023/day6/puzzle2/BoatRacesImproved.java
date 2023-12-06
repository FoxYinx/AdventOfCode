package Year2023.day6.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoatRacesImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day6/inputImproved.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        long time = Long.parseLong(line.split(":")[1]);
        line = scanner.nextLine();
        long distance = Long.parseLong(line.split(":")[1]);
        int possibilities = 0;
        for (int j = 0; j < time; j++) {
            long remains = time - j;
            if (remains * j > distance) {
                possibilities++;
            }
        }
        System.out.println("The mystery value is " + possibilities);
    }

}
