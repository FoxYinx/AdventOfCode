package Year2023.day5.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeedImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day5/" + "input" + "Reversed.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\d+) (\\d+)");
        Matcher m = pattern.matcher(line);
        ArrayList<Long[]> ranges = new ArrayList<>();
        while (m.find()) {
            ranges.add(new Long[]{Long.parseLong(m.group(1)), Long.parseLong(m.group(2))});
        }
        boolean hasFound = false;
        long output = 0;
        long testValue;
        long testValueNb = 0;
        pattern = Pattern.compile("(\\d+) (\\d+) (\\d+)");
        /**
         * Parcours du fichier
         */
        while (!hasFound){
            testValue = testValueNb;
            if (testValue % 1000000 == 0) System.out.println("Valeur testée : " + testValue);
            boolean hasChanged = false;
            scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                m = pattern.matcher(line);
                if (line.isEmpty()) {
                    hasChanged = false;
                    continue;
                }
                while (m.find() && !hasChanged) {
                    long dest = Long.parseLong(m.group(1));
                    long src = Long.parseLong(m.group(2));
                    long range = Long.parseLong(m.group(3));
                    // Vérification de la range
                    if (testValue >= dest && testValue <= (dest+range)) {
                        testValue = src + (testValue - dest);
                        hasChanged = true;
                    }
                }
            }
            for (Long[] longs : ranges) {
                if (longs[0] <= testValue && (longs[0] + longs[1] - 1) >= testValue) {
                    hasFound = true;
                    output = testValueNb;
                    break;
                }
            }
            if (!hasFound) testValueNb++;
        }
        System.out.println("Lowest location : " + output);
    }

}
