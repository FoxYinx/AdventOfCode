package Year2015.day12.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Json {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day12/input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(line);
        int total = 0;
        while (matcher.find()) {
            total += Integer.parseInt(matcher.group());
        }
        pattern = Pattern.compile("(-\\d+)");
        matcher = pattern.matcher(line);
        while (matcher.find()) {
            total += Integer.parseInt(matcher.group()) * 2;
        }
        System.out.println("The total value is " + total);
    }

}
