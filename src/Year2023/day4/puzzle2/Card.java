package Year2023.day4.puzzle2;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private int nbOfThis;
    private String[] winningNb;
    private String[] myNb;
    private ArrayList<String> myNbList;

    public Card(String[] winningNb, String[] myNb) {
        this.nbOfThis = 1;
        this.winningNb = winningNb;
        this.myNb = myNb;
        this.myNbList = new ArrayList<>(List.of(myNb));
    }
    public boolean contains() {
        for (String nb : winningNb) {
            if (myNbList.contains(nb)) return true;
        }
        return false;
    }

    public int containsHowMany() {
        int total = 0;
        for (String nb : winningNb) {
            if (myNbList.contains(nb)) total++;
        }
        return total;
    }

    public int getNbOfThis() {
        return nbOfThis;
    }

    public void setNbOfThis(int nbOfThis) {
        this.nbOfThis = nbOfThis;
    }
}
