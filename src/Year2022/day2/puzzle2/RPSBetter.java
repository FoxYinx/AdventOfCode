package Year2022.day2.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RPSBetter {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day2/input.txt");
        Scanner scanner = new Scanner(file);
        int score = 0;
        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            switch (line.charAt(0)) {
                case 'A' -> {
                    switch (line.charAt(2)) {
                        case 'X' -> score += 3 + 0;
                        case 'Y' -> score += 1 + 3;
                        case 'Z' -> score += 2 + 6;
                    }
                }
                case 'B' -> {
                    switch (line.charAt(2)) {
                        case 'X' -> score += 1 + 0;
                        case 'Y' -> score += 2 + 3;
                        case 'Z' -> score += 3 + 6;
                    }
                }
                case 'C' -> {
                    switch (line.charAt(2)) {
                        case 'X' -> score += 2 + 0;
                        case 'Y' -> score += 3 + 3;
                        case 'Z' -> score += 1 + 6;
                    }
                }
            }
        }
        System.out.println("My total score is " + score);
    }
}
