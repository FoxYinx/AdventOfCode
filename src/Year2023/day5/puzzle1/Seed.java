package Year2023.day5.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seed {

    public static ArrayList<HashMap<Long, Long>> Almanac = new ArrayList<>();
    public static HashMap<Long, Long> seedToSoil = new HashMap<>();
    public static HashMap<Long, Long> soilToFertilizer = new HashMap<>();
    public static HashMap<Long, Long> fertilizerToWater = new HashMap<>();
    public static HashMap<Long, Long> waterToLight = new HashMap<>();
    public static HashMap<Long, Long> lightToTemperature = new HashMap<>();
    public static HashMap<Long, Long> temperatureToHumidity = new HashMap<>();
    public static HashMap<Long, Long> humidityToLocation = new HashMap<>();

    static {
        Almanac.add(seedToSoil);
        Almanac.add(soilToFertilizer);
        Almanac.add(fertilizerToWater);
        Almanac.add(waterToLight);
        Almanac.add(lightToTemperature);
        Almanac.add(temperatureToHumidity);
        Almanac.add(humidityToLocation);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day5/input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        long[] seeds = Arrays.stream(line.split(":")[1].strip().split(" ")).mapToLong(Long::parseLong).toArray();
        Pattern pattern = Pattern.compile("(\\d+) (\\d+) (\\d+)");
        int mapSelector = -1;
        /**
         * Parcours du fichier pour créer la liste de map
         */
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            Matcher m = pattern.matcher(line);
            if (line.isEmpty()) {
                mapSelector++;
                continue;
            }
            while (m.find()) {
                long dest = Long.parseLong(m.group(1));
                long src = Long.parseLong(m.group(2));
                long range = Long.parseLong(m.group(3));
                for (int i = 0; i < range; i++) {
                    Almanac.get(mapSelector).put(src+i, dest+i);
                }
            }
        }
        ArrayList<Long> outputValues = new ArrayList<>();
        for (long seed : seeds) {
            for (HashMap<Long, Long> map : Almanac) {
                if (map.containsKey(seed)) {
                    seed = map.get(seed);
                }
            }
            outputValues.add(seed);
        }
        outputValues.sort(Long::compareTo);
        System.out.println("Lowest location : " + outputValues.getFirst());
    }

}
