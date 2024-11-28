package Year2022.day5.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Crane {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day5/input.txt");
        Scanner scanner = new Scanner(file);

        Stack stack1 = new Stack(new String[]{"Q", "S", "W", "C", "Z", "V", "F", "T"});
        Stack stack2 = new Stack(new String[]{"Q", "R", "B"});
        Stack stack3 = new Stack(new String[]{"B", "Z", "T", "Q", "P", "M", "S"});
        Stack stack4 = new Stack(new String[]{"D", "V", "F", "R", "Q", "H"});
        Stack stack5 = new Stack(new String[]{"J", "G", "L", "D", "B", "S", "T", "P"});
        Stack stack6 = new Stack(new String[]{"W", "R", "T", "Z"});
        Stack stack7 = new Stack(new String[]{"H", "Q", "M", "N", "S", "F", "R", "J"});
        Stack stack8 = new Stack(new String[]{"R", "N", "F", "H", "W"});
        Stack stack9 = new Stack(new String[]{"J", "Z", "T", "Q", "P", "R", "B"});

        Stacks stacks = new Stacks();
        stacks.addStack(stack1);
        stacks.addStack(stack2);
        stacks.addStack(stack3);
        stacks.addStack(stack4);
        stacks.addStack(stack5);
        stacks.addStack(stack6);
        stacks.addStack(stack7);
        stacks.addStack(stack8);
        stacks.addStack(stack9);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            stacks.move(Integer.parseInt(parts[1]), Integer.parseInt(parts[3]), Integer.parseInt(parts[5]));
        }

        System.out.println(stacks.getAnswer());
    }

}
