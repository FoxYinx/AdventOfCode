package Year2023.day4.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScratchcardsImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day4/input.txt");
        Scanner scanner = new Scanner(file);
        String[] winningNb;
        String[] myNb;
        int total = 0;
        ArrayList<Card> cards = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line = line.split(":")[1];
            winningNb = line.split("\\|")[0].strip().split(" +");
            myNb = line.split("\\|")[1].strip().split(" +");
            cards.add(new Card(winningNb, myNb));
        }
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).contains()) {
                int nb = cards.get(i).containsHowMany();
                for (int j = 0; j < nb; j++) {
                    cards.get(i+1+j).setNbOfThis(cards.get(i+1+j).getNbOfThis() + cards.get(i).getNbOfThis());
                }
            }
        }
        for (Card card : cards) {
            total += card.getNbOfThis();
        }
        System.out.println("You won : " + total + " cards!");
    }

}
