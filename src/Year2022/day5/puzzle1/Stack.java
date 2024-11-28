package Year2022.day5.puzzle1;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack {

    private ArrayList<String> content;

    public Stack(String[] input) {
        content = new ArrayList<>(Arrays.asList(input));
    }

    public Stack(ArrayList<String> input) {
        content = input;
    }

    public Stack remove(int quantity) {
        ArrayList<String> temp = new ArrayList<>();
        int size = this.content.size();
        for (int i = 0; i < quantity; i++) {
            temp.addFirst(this.content.remove(size - quantity));
        }
        return new Stack(temp);
    }

    public void add(Stack input) {
        this.content.addAll(input.content);
    }

    public String getLastValue() {
        return this.content.getLast();
    }

}
