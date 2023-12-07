package Year2023.day5.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seed {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day5/input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        long[] seeds = Arrays.stream(line.split(":")[1].strip().split(" ")).mapToLong(Long::parseLong).toArray();
        ArrayList<Long> outputValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+) (\\d+) (\\d+)");
        /**
         * Parcours du fichier
         */
        for (int z = 0; z < seeds.length; z++){
            boolean hasChanged = false;
            scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                Matcher m = pattern.matcher(line);
                if (line.isEmpty()) {
                    hasChanged = false;
                    continue;
                }
                while (m.find() && !hasChanged) {
                    long dest = Long.parseLong(m.group(1));
                    long src = Long.parseLong(m.group(2));
                    long range = Long.parseLong(m.group(3));
                    // Vérification de la range
                    if (seeds[z] >= src && seeds[z] <= (src+range)) {
                        seeds[z] = dest + (seeds[z]-src);
                        hasChanged = true;
                    }
                }
            }
            outputValues.add(seeds[z]);
        }
        outputValues.sort(Long::compareTo);
        System.out.println("Lowest location : " + outputValues.getFirst());
    }

}
