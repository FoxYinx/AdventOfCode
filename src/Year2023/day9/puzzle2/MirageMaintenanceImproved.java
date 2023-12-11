package Year2023.day9.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MirageMaintenanceImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day9/input.txt");
        Scanner scanner = new Scanner(file);
        long total = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            total += pastValue(Arrays.stream(line.split(" +")).mapToInt(Integer::parseInt).toArray());
        }
        System.out.println("The sum of the past values is " + total);
    }

    private static long pastValue(int[] split) {
        ArrayList<int[]> values = new ArrayList<>();
        values.add(split);
        for (int i = 0; i < values.size() && !onlyZeroes(values.get(i)); i++) {
            int[] line = new int[values.get(i).length-1];
            for (int j = 0; j < values.get(i).length-1; j++) {
                line[j] = values.get(i)[j+1] - values.get(i)[j];
            }
            values.add(line);
        }
        long sum = 0;
        for (int i = values.size()-1; i >= 0; i--){
            sum = values.get(i)[0] - sum;
        }
        return sum;
    }

    private static boolean onlyZeroes(int[] ints) {
        boolean flag = true;
        for (int val : ints) {
            if (val != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
