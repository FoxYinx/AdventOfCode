package Year2022.day5.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CraneBetter {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2022/day5/input.txt");
        Scanner scanner = new Scanner(file);

        StackBetter stack1 = new StackBetter(new String[]{"Q", "S", "W", "C", "Z", "V", "F", "T"});
        StackBetter stack2 = new StackBetter(new String[]{"Q", "R", "B"});
        StackBetter stack3 = new StackBetter(new String[]{"B", "Z", "T", "Q", "P", "M", "S"});
        StackBetter stack4 = new StackBetter(new String[]{"D", "V", "F", "R", "Q", "H"});
        StackBetter stack5 = new StackBetter(new String[]{"J", "G", "L", "D", "B", "S", "T", "P"});
        StackBetter stack6 = new StackBetter(new String[]{"W", "R", "T", "Z"});
        StackBetter stack7 = new StackBetter(new String[]{"H", "Q", "M", "N", "S", "F", "R", "J"});
        StackBetter stack8 = new StackBetter(new String[]{"R", "N", "F", "H", "W"});
        StackBetter stack9 = new StackBetter(new String[]{"J", "Z", "T", "Q", "P", "R", "B"});

        StacksBetter stacks = new StacksBetter();
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
