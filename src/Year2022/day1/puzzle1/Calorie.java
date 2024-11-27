package Year2022.day1.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Calorie {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day1/input.txt");
        Scanner scanner = new Scanner(file);
        int maxCalories = 0;
        int currentCalories = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (Objects.equals(line, "")) {
                if (currentCalories > maxCalories) {
                    maxCalories = currentCalories;
                }
                currentCalories = 0;
                continue;
            }
            currentCalories += Integer.parseInt(line);
        }
        System.out.println("Le lutin avec le plus de calories en a "+ maxCalories + ".");
    }
}
