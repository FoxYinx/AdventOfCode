package Year2023.day9.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MirageMaintenance {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day9/input.txt");
        Scanner scanner = new Scanner(file);
        long total = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            total += futureValue(Arrays.stream(line.split(" +")).mapToInt(Integer::parseInt).toArray());
        }
        System.out.println("The sum of the future values is " + total);
    }

    private static long futureValue(int[] split) {
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
        for (int[] value : values){
            sum += value[value.length-1];
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
