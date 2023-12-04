package Year2023.day3.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GearRatiosImproved {

    public static int Height = 140;
    public static int Width = 140;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day3/input.txt");
        Scanner scanner = new Scanner(file);
        char[][] engine = new char[Height][Width];
        int lineNb = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < Width; i++) {
                engine[lineNb][i] = line.charAt(i);
            }
            lineNb++;
        }
        Pattern pattern = Pattern.compile("(\\d+)");
        lineNb = 0;
        scanner = new Scanner(file);
        int total = 0;
        HashMap<String,ArrayList<Integer>> gears = new HashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Matcher m = pattern.matcher(line);
            while (m.find()) {
                if (hasGear(engine, m.start(), m.end()-1, lineNb)) {
                    String gearPos = getGearPos(engine, m.start(), m.end()-1, lineNb);
                    if (gears.containsKey(gearPos)) {
                        gears.get(gearPos).add(Integer.parseInt(m.group()));
                    } else {
                        gears.put(gearPos, new ArrayList<>(List.of(Integer.parseInt(m.group()))));
                    }
                }
            }
            lineNb++;
        }
        for (String lists: gears.keySet()) {
            if (gears.get(lists).size() == 2) {
                total += gears.get(lists).get(0) * gears.get(lists).get(1);
            }
        }
        System.out.println("The engine output is " + total);
    }

    public static String getGearPos(char[][] engine, int startPos, int endPos, int nbLine) {
        if (nbLine != 0) {
            if (startPos != 0) {
                if (engine[nbLine - 1][startPos - 1] == '*') {
                    return (nbLine - 1) + "," + (startPos - 1);
                }
            }
            for (int i = startPos; i <= endPos; i++) {
                if (engine[nbLine - 1][i] == '*') {
                    return (nbLine - 1) + "," + (i);
                }
            }
            if (endPos != Width-1) {
                if (engine[nbLine - 1][endPos + 1] == '*') {
                    return (nbLine - 1) + "," + (endPos + 1);
                }
            }
        }
        if (startPos != 0) {
            if (engine[nbLine][startPos - 1] == '*') {
                return (nbLine) + "," + (startPos - 1);
            }
        }
        if (endPos != Width-1) {
            if (engine[nbLine][endPos + 1] == '*') {
                return (nbLine) + "," + (endPos + 1);
            }
        }
        if (nbLine != Height-1) {
            if (startPos != 0) {
                if (engine[nbLine + 1][startPos - 1] == '*') {
                    return (nbLine + 1) + "," + (startPos - 1);
                }
            }
            for (int i = startPos; i <= endPos; i++) {
                if (engine[nbLine + 1][i] == '*') {
                    return (nbLine + 1) + "," + (i);
                }
            }
            if (endPos != Width-1) {
                if (engine[nbLine + 1][endPos + 1] == '*') {
                    return (nbLine + 1) + "," + (endPos + 1);
                }
            }
        }
        return (-999) + "," + (-999);
    }

    public static boolean hasGear(char[][] engine, int startPos, int endPos, int nbLine) {
        boolean flag = false;
        if (nbLine != 0) {
            if (startPos != 0) flag = engine[nbLine - 1][startPos - 1] == '*';
            for (int i = startPos; i <= endPos; i++) {
                flag = flag || (engine[nbLine - 1][i] == '*');
            }
            if (endPos != Width-1) flag = flag || (engine[nbLine - 1][endPos + 1] == '*');
        }
        if (startPos != 0) flag = flag || (engine[nbLine][startPos - 1] == '*');
        if (endPos != Width-1) flag = flag || (engine[nbLine][endPos + 1] == '*');
        if (nbLine != Height-1) {
            if (startPos != 0) flag = flag || engine[nbLine + 1][startPos - 1] == '*';
            for (int i = startPos; i <= endPos; i++) {
                flag = flag || (engine[nbLine + 1][i] == '*');
            }
            if (endPos != Width-1) flag = flag || (engine[nbLine + 1][endPos + 1] == '*');
        }
        return flag;
    }

}
