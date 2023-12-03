package Year2015.day8.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatchsticksImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day8/input.txt");
        Scanner scanner = new Scanner(file);
        int nbStringCode = 0;
        int nbStringCodeNew = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            nbStringCode += line.length();
            nbStringCodeNew += 2;
            while (!line.isEmpty()) {
                if (line.startsWith("\"")){
                    nbStringCodeNew++;
                } else if (line.startsWith("\\")) {
                    nbStringCodeNew++;
                }
                nbStringCodeNew++;
                line = line.substring(1);
            }
        }
        System.out.println("nbStringCodeNew : " + nbStringCodeNew);
        System.out.println("nbStringCode : " + nbStringCode);
        System.out.println("Result = " + (nbStringCodeNew-nbStringCode));
    }

}
