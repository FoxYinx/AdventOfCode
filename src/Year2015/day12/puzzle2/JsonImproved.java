package Year2015.day12.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day12/test.txt");
        Scanner scanner = new Scanner(file);
        StringBuilder line = new StringBuilder(scanner.nextLine());
        ArrayList<String> sections = new ArrayList<>();
        for (int i = 0; i < line.length()-1; i++) {
            if (line.charAt(i) == '{' || line.charAt(i) == '[' || !(line.charAt(i+1) == '{' || line.charAt(i+1) == '[')) {
                int j;
                int breakingPoint = 1;
                for (j = i+1; j < line.length(); j++) {
                    if (line.charAt(j) == '{' || line.charAt(j) == '[') breakingPoint++;
                    if (line.charAt(j) == '}' || line.charAt(j) == ']') breakingPoint--;
                    if (breakingPoint == 0) break;
                }
                sections.add(line.substring(i, j+1));
                line.replace(i, j+2, "");
                i = 0;
            }
            if (!line.toString().contains("{") || !line.toString().contains("}")) break;
        }
        sections.add(line.toString());
        for (String s : sections) {
            System.out.println(s);
        }
    }

}
