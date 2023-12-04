package Year2023.day4.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScratchcardsImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day4/input.txt");
        Scanner scanner = new Scanner(file);
        String[] winningNb;
        String[] myNb;
        int total = 0;
        int power;
        while (scanner.hasNext()) {
            power = -1;
            String line = scanner.nextLine();
            line = line.split(":")[1];
            winningNb = line.split("\\|")[0].strip().split(" +");
            myNb = line.split("\\|")[1].strip().split(" +");
            ArrayList<String> myNbList = new ArrayList<>(List.of(myNb));
            for (String nb : winningNb) {
                if (myNbList.contains(nb)) power++;
            }
            if (power != -1) total += (int) Math.pow(2, power);
        }
        System.out.println("You won : " + total + " credits!");
    }

}
