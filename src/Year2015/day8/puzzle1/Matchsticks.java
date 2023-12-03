package Year2015.day8.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matchsticks {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day8/input.txt");
        Scanner scanner = new Scanner(file);
        int nbStringCode = 0;
        int nbStringMemory = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            nbStringCode += line.length();
            line = line.substring(1, line.length()-1);
            while (!line.isEmpty()) {
                if (line.startsWith("\\x")) {
                    line = line.substring(4);
                } else if (line.startsWith("\\")) {
                    line = line.substring(2);
                } else {
                    line = line.substring(1);
                }
                nbStringMemory++;
            }
        }
        System.out.println("nbStringCode : " + nbStringCode);
        System.out.println("nbStringMemory : " + nbStringMemory);
        System.out.println("Result = " + (nbStringCode-nbStringMemory));
    }

}
