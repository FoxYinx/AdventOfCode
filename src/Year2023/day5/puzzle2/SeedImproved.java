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
        File file = new File("src/Year2023/day5/test.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        long[] seeds = Arrays.stream(line.split(":")[1].strip().split(" ")).mapToLong(Long::parseLong).toArray();
        LinkedList<Long> realSeeds = new LinkedList<>();
        for (int i = 0; i < seeds.length; i += 2) {
            for (int j = 0; j < seeds[i+1]; j++) {
                realSeeds.add(seeds[i] + j);
            }
        }
        ArrayList<Long> outputValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+) (\\d+) (\\d+)");
        /**
         * Parcours du fichier
         */
        for (int z = 0; z < realSeeds.size(); z++){
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
                    if (realSeeds.get(z) >= src && realSeeds.get(z) <= (src+range)) {
                        realSeeds.set(z, dest + (realSeeds.get(z)-src));
                        hasChanged = true;
                    }
                }
            }
            outputValues.add(realSeeds.get(z));
        }
        outputValues.sort(Long::compareTo);
        System.out.println("Lowest location : " + outputValues.getFirst());
    }

}
