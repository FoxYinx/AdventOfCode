package Year2015.day9.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Path {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day9/test.txt");
        Scanner scanner = new Scanner(file);
        HashMap<String[], Integer> distances = new HashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            distances.put(new String[]{line.split(" ")[0], line.split(" ")[2]}, Integer.parseInt(line.split(" ")[4]));
        }

        /**
         * OUTPUT
         */
        for (String[] array:distances.keySet()) {
            System.out.println(Arrays.toString(array) + " : " + distances.get(array));
        }
    }

}
