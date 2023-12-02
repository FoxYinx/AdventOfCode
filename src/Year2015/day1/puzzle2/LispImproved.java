package Year2015.day1.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LispImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day1/input.txt");
        Scanner scanner = new Scanner(file);
        String input = scanner.nextLine();
        int floor = 0;
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') floor++;
            if (input.charAt(i) == ')') floor--;
            if (floor == -1) {
                result = i + 1;
                break;
            }
        }
        System.out.println(result);
    }

}
