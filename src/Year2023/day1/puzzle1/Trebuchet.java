package Year2023.day1.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trebuchet {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day1/values.txt");
        Scanner scanner = new Scanner(file);
        String line;
        int result = 0;
        ArrayList<Integer> liste;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            liste = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) liste.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
            result += liste.getFirst() * 10 + liste.getLast();
        }
        System.out.println(result);
    }

}
