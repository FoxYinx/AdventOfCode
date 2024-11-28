package Year2022.day4.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cleanup {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day4/input.txt");
        Scanner scanner = new Scanner(file);
        int f1, f2, s1, s2;
        String line;
        String[] twoParts;
        int howManyPairs = 0;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            twoParts = line.split(",");
            f1 = Integer.parseInt(twoParts[0].split("-")[0]);
            f2 = Integer.parseInt(twoParts[0].split("-")[1]);
            s1 = Integer.parseInt(twoParts[1].split("-")[0]);
            s2 = Integer.parseInt(twoParts[1].split("-")[1]);
            if ((s1 >= f1 && s2 <= f2) || (f1 >= s1 && f2 <= s2)) howManyPairs++;
        }
        System.out.println(howManyPairs);
    }

}
