package Year2015.day2.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Paper {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/Year2015/day2/input.txt");
        Scanner scanner = new Scanner(file);
        int total = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int l = Integer.parseInt(line.split("x")[0]);
            int h = Integer.parseInt(line.split("x")[1]);
            int w = Integer.parseInt(line.split("x")[2]);
            int firstArea = l*h;
            int secondArea = l*w;
            int thirdArea = h*w;
            int smallest;
            if (firstArea < secondArea) {
                smallest = Math.min(firstArea, thirdArea);
            }
            else {
                smallest = Math.min(secondArea, thirdArea);
            }
            total += 2 * (firstArea + secondArea + thirdArea) + smallest;
        }
        System.out.println(total);
    }

}
