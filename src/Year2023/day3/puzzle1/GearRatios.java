package Year2023.day3.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GearRatios {

    public static int Height = 140;
    public static int Width = 140;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day3/input.txt");
        Scanner scanner = new Scanner(file);
        char[][] engine = new char[Height][Width];
        int lineNb = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < 140; i++) {
                engine[lineNb][i] = line.charAt(i);
            }
            lineNb++;
        }
        Pattern pattern = Pattern.compile("(\\d+)");
        lineNb = 0;
        scanner = new Scanner(file);
        int total = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Matcher m = pattern.matcher(line);
            while (m.find()) {
                if (isValid(engine, m.start(), m.end()-1, lineNb)) {
                    total+= Integer.parseInt(m.group());
                    System.out.println("Is valid : " + m.group());
                } else {
                    System.out.println("Is NOT valid : " + m.group());
                }
            }
            lineNb++;
        }
        System.out.println("The engine output is " + total);
    }

    public static boolean isValid(char[][] engine, int startPos, int endPos, int nbLine) {
        boolean flag = false;
        if (nbLine != 0) {
            if (startPos != 0) flag = engine[nbLine - 1][startPos - 1] != '.';
            for (int i = startPos; i <= endPos; i++) {
                flag = flag || (engine[nbLine - 1][i] != '.');
            }
            if (endPos != Width-1) flag = flag || (engine[nbLine - 1][endPos + 1] != '.');
        }
        if (startPos != 0) flag = flag || (engine[nbLine][startPos - 1] != '.');
        if (endPos != Width-1) flag = flag || (engine[nbLine][endPos + 1] != '.');
        if (nbLine != Height-1) {
            if (startPos != 0) flag = flag || engine[nbLine + 1][startPos - 1] != '.';
            for (int i = startPos; i <= endPos; i++) {
                flag = flag || (engine[nbLine + 1][i] != '.');
            }
            if (endPos != Width-1) flag = flag || (engine[nbLine + 1][endPos + 1] != '.');
        }
        return flag;
    }

}
