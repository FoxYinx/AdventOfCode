package Year2015.day2.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PaperImproved {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/Year2015/day2/input.txt");
        Scanner scanner = new Scanner(file);
        int total = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int l = Integer.parseInt(line.split("x")[0]);
            int h = Integer.parseInt(line.split("x")[1]);
            int w = Integer.parseInt(line.split("x")[2]);
            int biggest;
            if (l < h) {
                biggest = Math.max(h, w);
            }
            else {
                biggest = Math.max(l, w);
            }
            total += l * h * w;
            int[] array = {l, h, w};
            boolean flag = true;
            for (int i = 0; i < 3; i++) {
                if (array[i] == biggest && flag) {
                    flag = false;
                } else {
                    total += 2 * array[i];
                }
            }
        }
        System.out.println(total);
    }

}
