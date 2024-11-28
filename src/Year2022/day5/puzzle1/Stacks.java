package Year2022.day5.puzzle1;

import java.util.ArrayList;

public class Stacks {

    private final ArrayList<Stack> stacks;

    public Stacks() {
        stacks = new ArrayList<>();
    }

    public void addStack(Stack stack) {
        this.stacks.add(stack);
    }

    public void move(int quantity, int from, int to) {
        this.stacks.get(to - 1).add(this.stacks.get(from - 1).remove(quantity));
    }

    public String getAnswer() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Stack stack : stacks) {
            stringBuilder.append(stack.getLastValue());
        }
        return stringBuilder.toString();
    }

}
