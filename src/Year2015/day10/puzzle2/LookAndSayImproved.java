package Year2015.day10.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LookAndSayImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day10/input.txt");
        Scanner scanner = new Scanner(file);
        String input = scanner.nextLine();
        System.out.println("Step 0 : " + input);
        StringBuilder output;
        long start = System.currentTimeMillis();
        for (int j = 0; j < 50; j++) {
            output = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                switch (input.length() - i) {
                    case 2:
                        if (input.charAt(i) == input.charAt(i + 1)) {
                            output.append("2").append(input.charAt(i));
                            i++;
                        } else {
                            output.append("1").append(input.charAt(i));
                        }
                        break;
                    case 1:
                        output.append("1").append(input.charAt(i));
                        break;
                    default:
                        if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i+2) == input.charAt(i+1)) {
                            output.append("3").append(input.charAt(i));
                            i+=2;
                        } else if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i + 2) != input.charAt(i + 1)) {
                            output.append("2").append(input.charAt(i));
                            i++;
                        } else {
                            output.append("1").append(input.charAt(i));
                        }
                        break;
                }
            }
            input = String.valueOf(output);
            System.out.println("Step " + (j+1) + " : " + output);
        }
        long end = System.currentTimeMillis();
        System.out.println("Length of step 50 is " + input.length());
        System.out.println("Execution time (ms) : " + (end-start));
    }

}
