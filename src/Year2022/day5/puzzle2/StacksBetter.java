package Year2022.day5.puzzle2;

import java.util.ArrayList;

public class StacksBetter {

    private final ArrayList<StackBetter> stacks;

    public StacksBetter() {
        stacks = new ArrayList<>();
    }

    public void addStack(StackBetter stack) {
        this.stacks.add(stack);
    }

    public void move(int quantity, int from, int to) {
        this.stacks.get(to - 1).add(this.stacks.get(from - 1).remove(quantity));
    }

    public String getAnswer() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackBetter stack : stacks) {
            stringBuilder.append(stack.getLastValue());
        }
        return stringBuilder.toString();
    }

}
