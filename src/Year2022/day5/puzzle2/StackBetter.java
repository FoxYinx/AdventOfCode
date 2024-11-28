package Year2022.day5.puzzle2;

import java.util.ArrayList;
import java.util.Arrays;

public class StackBetter {

    private final ArrayList<String> content;

    public StackBetter(String[] input) {
        content = new ArrayList<>(Arrays.asList(input));
    }

    public StackBetter(ArrayList<String> input) {
        content = input;
    }

    public StackBetter remove(int quantity) {
        ArrayList<String> temp = new ArrayList<>();
        int size = this.content.size();
        for (int i = 0; i < quantity; i++) {
            temp.addLast(this.content.remove(size - quantity));
        }
        return new StackBetter(temp);
    }

    public void add(StackBetter input) {
        this.content.addAll(input.content);
    }

    public String getLastValue() {
        return this.content.getLast();
    }

}
