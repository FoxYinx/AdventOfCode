package Year2023.day8.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WastelandMap {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day8/input.txt");
        Scanner scanner = new Scanner(file);
        String directions = scanner.nextLine();
        String currentDirection = "AAA";
        int totalMoves = 0;
        do {
            int i;
            for (i = 0; i < directions.length(); i++) {
                scanner = new Scanner(file);
                scanner.nextLine();
                scanner.nextLine();
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String entreeKey = line.split("=")[0].strip();
                    String leftValue = line.split("\\(")[1].split(",")[0];
                    String rightValue = line.split(", ")[1].split("\\)")[0];
                    if (currentDirection.equals(entreeKey)) {
                        if (directions.charAt(i) == 'L') currentDirection = leftValue;
                        if (directions.charAt(i) == 'R') currentDirection = rightValue;
                        totalMoves++;
                        break;
                    }
                }
                if (currentDirection.equals("ZZZ")) break;
            }
        } while (!currentDirection.equals("ZZZ"));
        System.out.println("It took " + totalMoves + " moves to get out!");
    }
}
