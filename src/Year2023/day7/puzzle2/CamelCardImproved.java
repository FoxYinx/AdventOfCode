package Year2023.day7.puzzle2;

import Year2023.day7.CardComparatorImproved;
import Year2023.day7.CardImproved;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CamelCardImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day7/input.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<CardImproved> cards = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            cards.add(new CardImproved(line.split(" +")[0], Integer.parseInt(line.split(" +")[1].strip())));
        }
        System.out.println("Old order : ");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("N°" + i + " " + cards.get(i));
        }
        cards.sort(new CardComparatorImproved());
        System.out.println("New order : ");
        int total = 0;
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("N°" + i + " " + cards.get(i));
            total += (i+1) * cards.get(i).getBid();
        }
        System.out.println("The total winnings are : " + total);
    }

}
