package Year2015.day5.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InternElvesImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day5/input.txt");
        Scanner scanner = new Scanner(file);
        int total = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (doublePair(line) && nearlyTwoInARow(line)) total++;
        }
        System.out.println(total);
    }

    public static boolean doublePair(String string) {
        boolean flag = false;
        for (int i = 0; i < string.length()-1; i++){
            flag = flag || string.substring(0, i).contains(string.substring(i, i+2)) || string.substring(i+2).contains(string.substring(i, i+2));
        }
        return flag;
    }

    public static boolean nearlyTwoInARow(String string) {
        boolean flag = false;
        for (int i = 0; i < string.length()-2; i++) {
            flag = flag || (string.charAt(i) == string.charAt(i+2));
        }
        return flag;
    }

}
