package Year2015.day6.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lights {

    public static void main(String[] args) throws FileNotFoundException {
        boolean[][] grid = new boolean[1000][1000];
        File file = new File("src/Year2015/day6/input.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.startsWith("tu")) {
                int xstart = Integer.parseInt(line.split(" ")[2].split(",")[0]);
                int ystart = Integer.parseInt(line.split(" ")[2].split(",")[1]);
                int xend = Integer.parseInt(line.split(" ")[4].split(",")[0]);
                int yend = Integer.parseInt(line.split(" ")[4].split(",")[1]);
                turn(line.split(" ")[1], xstart, ystart, xend, yend, grid);
            } else {
                int xstart = Integer.parseInt(line.split(" ")[1].split(",")[0]);
                int ystart = Integer.parseInt(line.split(" ")[1].split(",")[1]);
                int xend = Integer.parseInt(line.split(" ")[3].split(",")[0]);
                int yend = Integer.parseInt(line.split(" ")[3].split(",")[1]);
                toggle(xstart, ystart, xend, yend, grid);
            }
        }
        int total = 0;
        for (boolean[] booleans : grid) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) total++;
            }
        }
        System.out.println(total);
    }

    public static void turn(String state, int xstart, int ystart, int xend, int yend, boolean[][] grid) {
        for (int i = xstart; i <= xend; i++) {
            for (int j = ystart; j <= yend; j++) {
                if (state.equals("off")) grid[i][j] = false;
                if (state.equals("on")) grid[i][j] = true;
            }
        }
    }

    public static void toggle(int xstart, int ystart, int xend, int yend, boolean[][] grid) {
        for (int i = xstart; i <= xend; i++) {
            for (int j = ystart; j <= yend; j++) {
                grid[i][j] = !grid[i][j];
            }
        }
    }

}
