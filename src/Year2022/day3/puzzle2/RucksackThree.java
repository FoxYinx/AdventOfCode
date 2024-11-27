package Year2022.day3.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RucksackThree {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day3/input.txt");
        Scanner scanner = new Scanner(file);
        String firstLine;
        String secondLine;
        String thirdLine;
        char charToFind = '1';
        int totalPriority = 0;
        while (scanner.hasNextLine()) {
            firstLine = scanner.nextLine();
            secondLine = scanner.nextLine();
            thirdLine = scanner.nextLine();
            char[] firstChars = firstLine.toCharArray();
            char[] secondChars = secondLine.toCharArray();
            char[] thirdChars = thirdLine.toCharArray();
            for (char aChar : firstChars) {
                boolean flag = false;
                for (char secondChar : secondChars) {
                    for (char thirdChar : thirdChars) {
                        if (aChar == secondChar && secondChar == thirdChar) {
                            flag = true;
                            charToFind = aChar;
                            break;
                        }
                    }
                    if (flag) break;
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
