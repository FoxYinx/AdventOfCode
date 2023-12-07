package Year2023.day7;

import java.util.Comparator;
import java.util.HashMap;

public class CardComparatorImproved implements Comparator<Card> {

    private static final HashMap<Character, Integer> power = new HashMap<>();
    static {
        power.put('2', 2);
        power.put('3', 3);
        power.put('4', 4);
        power.put('5', 5);
        power.put('6', 6);
        power.put('7', 7);
        power.put('8', 8);
        power.put('9', 9);
        power.put('T', 10);
        power.put('J', 1);
        power.put('Q', 12);
        power.put('K', 13);
        power.put('A', 14);
    }

    @Override
    public int compare(Card c1, Card c2) {
        if (c2.getStatusValue() - c1.getStatusValue() > 0) {
            return -1;
        } else if (c2.getStatusValue() - c1.getStatusValue() < 0) {
            return 1;
        } else {
            for (int i = 0; i < c1.getValue().length(); i++) {
                if (power.get(c2.getValue().charAt(i)) - power.get(c1.getValue().charAt(i)) > 0) return -1;
                if (power.get(c2.getValue().charAt(i)) - power.get(c1.getValue().charAt(i)) < 0) return 1;
            }
            return 0;
        }
    }

}
