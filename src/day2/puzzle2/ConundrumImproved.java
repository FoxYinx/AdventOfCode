package day2.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConundrumImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day2/input.txt");
        Scanner scanner = new Scanner(file);
        String line;
        int result = 0;
        while (scanner.hasNext()) {
            int blueFlag = 0;
            int redFlag = 0;
            int greenFlag = 0;
            line = scanner.nextLine().split(":")[1];
            for(String part:line.split(";")) {
                part = part.strip();
                for (String subpart:part.split(",")) {
                    subpart = subpart.strip();
                    if (subpart.contains("red") && Integer.parseInt(subpart.split(" ")[0]) > redFlag) redFlag = Integer.parseInt(subpart.split(" ")[0]);
                    if (subpart.contains("blue") && Integer.parseInt(subpart.split(" ")[0]) > blueFlag) blueFlag = Integer.parseInt(subpart.split(" ")[0]);
                    if (subpart.contains("green") && Integer.parseInt(subpart.split(" ")[0]) > greenFlag) greenFlag = Integer.parseInt(subpart.split(" ")[0]);
                }
            }
            result += blueFlag * redFlag * greenFlag;
        }
        System.out.println(result);
    }

}
