package Year2022.day1.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Calories {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day1/input.txt");
        Scanner scanner = new Scanner(file);
        int[] maxCalories = new int[3];
        int currentCalories = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (Objects.equals(line, "")) {
                if (currentCalories > maxCalories[0]) {
                    maxCalories[2] = maxCalories[1];
                    maxCalories[1] = maxCalories[0];
                    maxCalories[0] = currentCalories;
                } else if (currentCalories > maxCalories[1]) {
                    maxCalories[2] = maxCalories[1];
                    maxCalories[1] = currentCalories;
                } else if (currentCalories > maxCalories[2]) {
                    maxCalories[2] = currentCalories;
                }
                currentCalories = 0;
                continue;
            }
            currentCalories += Integer.parseInt(line);
        }
        int max = maxCalories[0] + maxCalories[1] + maxCalories[2];
        System.out.println("Les trois lutins avec le plus de calories en ont en tout "+ max + ".");
    }
}
