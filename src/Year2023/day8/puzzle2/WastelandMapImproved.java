package Year2023.day8.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WastelandMapImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day8/input.txt");
        Scanner scanner = new Scanner(file);
        String directions = scanner.nextLine();
        ArrayList<String> starts = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String entreeKey = line.split("=")[0].strip();
            if (entreeKey.endsWith("A")) starts.add(entreeKey);
        }
        ArrayList<Integer> distances = new ArrayList<>();
        for (String key : starts) {
            int totalMoves = 0;
            String currentDirection = key;
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
                    if (currentDirection.endsWith("Z")) break;
                }
            } while (!currentDirection.endsWith("Z"));
            distances.add(totalMoves);
        }
        System.out.println("It took " + lcm(distances) + " moves to get out!");
    }

    public static long lcm(ArrayList<Integer> numbers) {
        long value = 1;
        for (Integer nb : numbers) {
            value = (value * nb)/gcd(value, nb);
        }
        return value;
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
