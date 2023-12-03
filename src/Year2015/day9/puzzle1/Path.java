package Year2015.day9.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Path {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day9/input.txt");
        Scanner scanner = new Scanner(file);
        HashMap<String[], Integer> roads = new HashMap<>();
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            roads.put(new String[]{line.split(" ")[0], line.split(" ")[2]}, Integer.parseInt(line.split(" ")[4]));
        }
        for (String[] city : roads.keySet()) {
            if (!cities.contains(city[0])) cities.add(city[0]);
            if (!cities.contains(city[1])) cities.add(city[1]);
        }
        /**
         * OUTPUT
         */
        for (String[] array:roads.keySet()) {
            System.out.println(Arrays.toString(array) + " : " + roads.get(array));
        }
        System.out.println("Nb de villes : " + cities.size());
    }

}
