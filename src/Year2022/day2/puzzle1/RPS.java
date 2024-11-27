package Year2022.day2.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RPS {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day2/input.txt");
        Scanner scanner = new Scanner(file);
        int score = 0;
        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            switch (line.charAt(0)) {
                case 'A' -> score += 8;
                case 'B' -> score++;
                case 'C' -> score += 6;
            }
        }
        System.out.println("My total score is " + score);
    }
}
