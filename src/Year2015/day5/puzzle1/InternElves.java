package Year2015.day5.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InternElves {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day5/input.txt");
        Scanner scanner = new Scanner(file);
        int total = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (threevowels(line) && twoInARow(line) && !doesNotContain(line)) total++;
        }
        System.out.println(total);
    }

    public static boolean threevowels(String string) {
        int nb = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u') nb++;
        }
        return nb >= 3;
    }

    public static boolean twoInARow(String string) {
        boolean flag = false;
        for (int i = 0; i < string.length()-1; i++) {
            flag = flag || (string.charAt(i) == string.charAt(i+1));
        }
        return flag;
    }

    public static boolean doesNotContain(String string) {
        return string.contains("ab") || string.contains("cd") || string.contains("pq") || string.contains("xy");
    }

}
