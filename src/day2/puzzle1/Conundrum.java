package day2.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Conundrum {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day2/input.txt");
        Scanner scanner = new Scanner(file);
        String line;
        int nbLine = 0;
        int result = 0;
        while (scanner.hasNext()) {
            nbLine++;
            boolean blueFlag = true;
            boolean redFlag = true;
            boolean greenFlag = true;
            line = scanner.nextLine().split(":")[1];
            for(String part:line.split(";")) {
                part = part.strip();
                for (String subpart:part.split(",")) {
                    subpart = subpart.strip();
                    if (subpart.contains("red") && Integer.parseInt(subpart.split(" ")[0]) > 12) redFlag = false;
                    if (subpart.contains("blue") && Integer.parseInt(subpart.split(" ")[0]) > 14) blueFlag = false;
                    if (subpart.contains("green") && Integer.parseInt(subpart.split(" ")[0]) > 13) greenFlag = false;
                }
            }
            if (redFlag && blueFlag && greenFlag) result += nbLine;
        }
        System.out.println(result);
    }

}
