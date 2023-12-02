package day1.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrebuchetImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day1/values.txt");
        Scanner scanner = new Scanner(file);
        String line;
        int result = 0;
        ArrayList<Integer> liste;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            liste = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))){
                    liste.add(Integer.parseInt(String.valueOf(line.charAt(i))));
                }
                if (isValue(line.substring(i)) != -1) {
                    liste.add(isValue(line.substring(i)));
                }
            }
            result += liste.getFirst() * 10 + liste.getLast();
        }
        System.out.println(result);
    }

    public static int isValue(String line) {
        if (line.length() >= 5) {
            String five = line.substring(0, 5);
            switch (five) {
                case "three" -> {
                    return 3;
                }
                case "seven" -> {
                    return 7;
                }
                case "eight" -> {
                    return 8;
                }
            }
        }
        if (line.length() >= 4) {
            String four = line.substring(0, 4);
            switch (four) {
                case "four" -> {
                    return 4;
                }
                case "five" -> {
                    return 5;
                }
                case "nine" -> {
                    return 9;
                }
            }
        }
        if (line.length() >= 3) {
            String three = line.substring(0, 3);
            switch (three) {
                case "one" -> {
                    return 1;
                }
                case "two" -> {
                    return 2;
                }
                case "six" -> {
                    return 6;
                }
            }
        }
        return -1;
    }

}
