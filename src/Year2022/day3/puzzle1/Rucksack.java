package Year2022.day3.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rucksack {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day3/input.txt");
        Scanner scanner = new Scanner(file);
        String line;
        char charToFind = '1';
        int totalPriority = 0;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                char firstChar = chars[i];
                boolean flag = false;
                for (int j = chars.length / 2; j < chars.length; j++) {
                    if (firstChar == chars[j]) {
                        flag = true;
                        charToFind = chars[j];
                        break;
                    }
                }
                if (flag) break;
            }
            int number = charToFind - 96;
            if (number < 0) number += 58;
            totalPriority += number;
        }
        System.out.println(totalPriority);
    }

}
