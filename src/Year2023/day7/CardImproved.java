package Year2023.day7;

import java.util.ArrayList;

public class CardImproved {

    private final String value;
    private final int bid;
    private String status;
    private int statusValue;
    private boolean fiveKind;
    private boolean fourKind;
    private boolean fullHouse;
    private boolean threeKind;
    private boolean twoPair;
    private boolean onePair;
    private boolean highcard;

    public CardImproved(String value, int bid) {
        this.value = value;
        this.bid = bid;
        this.evaluate();
        this.evaluateJoker();
    }

    private void evaluateJoker() {
        int nbJokers = 0;
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i)=='J') nbJokers++;
        }
        switch (nbJokers){
            case 1 -> {
                if (this.fourKind) this.fiveKind = true;
                if (this.threeKind) this.fourKind = true;
                if (this.twoPair) this.fullHouse = true;
                if (this.onePair) this.threeKind = true;
                if (this.highcard) this.onePair = true;
            }
            case 2 -> {
                if (this.fullHouse) this.fiveKind = true;
                if (this.threeKind) this.fiveKind = true;
                if (this.twoPair) this.fourKind = true;
                if (this.onePair) this.threeKind = true;
            }
            case 3 -> {
                if (this.fullHouse) this.fiveKind = true;
                if (this.threeKind) this.fourKind = true;
            }
            case 4 -> {
                if (this.fourKind) this.fiveKind = true;
            }
            default -> {}
        }
        this.updateStatus();
    }

    private void updateStatus() {
        if (this.fiveKind) {
            this.status = "FiveKind";
            this.statusValue = 6;
        } else if (this.fourKind) {
            this.status = "FourKind";
            this.statusValue = 5;
        } else if (this.fullHouse) {
            this.status = "FullHouse";
            this.statusValue = 4;
        } else if (this.threeKind) {
            this.status = "ThreeKind";
            this.statusValue = 3;
        } else if (this.twoPair) {
            this.status = "TwoPair";
            this.statusValue = 2;
        } else if (this.onePair) {
            this.status = "OnePair";
            this.statusValue = 1;
        } else if (this.highcard) {
            this.status = "HighCard";
            this.statusValue = 0;
        } else {
            this.status = "None";
            this.statusValue = -999;
        }
    }

    private void evaluate() {
        this.isHighCard();
        this.hasOnePair();
        this.hasTwoPair();
        this.isThreeKind();
        this.isFullHouse();
        this.isFourKind();
        this.isFiveKind();
        this.updateStatus();
    }

    private void isHighCard() {
        boolean flag = true;
        ArrayList<Character> cache = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            if (cache.contains(value.charAt(i))) {
                flag = false;
                break;
            }
            cache.add(value.charAt(i));
        }
        this.highcard = flag;
    }

    private void hasOnePair() {
        this.onePair = !this.highcard;
    }

    private void hasTwoPair() {
        ArrayList<Character> cache = new ArrayList<>();
        ArrayList<Character> cache2 = new ArrayList<>();
        ArrayList<Character> cache3 = new ArrayList<>();
        ArrayList<Character> cache4 = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            if (cache.contains(value.charAt(i))) {
                cache.add(value.charAt(i));
            } else if (cache.isEmpty()) {
                cache.add(value.charAt(i));
            } else if (cache2.contains(value.charAt(i))) {
                cache2.add(value.charAt(i));
            } else if (cache2.isEmpty()) {
                cache2.add(value.charAt(i));
            } else if (cache3.contains(value.charAt(i))){
                cache3.add(value.charAt(i));
            } else if (cache3.isEmpty()) {
                cache3.add(value.charAt(i));
            } else {
                cache4.add(value.charAt(i));
            }
        }
        this.twoPair = (cache.size() == 2 && cache2.size() == 2 && cache3.size() == 1) ||
                (cache.size() == 1 && cache2.size() == 2 && cache3.size() == 2) ||
                (cache.size() == 2 && cache2.size() == 1 && cache3.size() == 2);
    }

    private void isThreeKind() {
        ArrayList<Character> cache = new ArrayList<>();
        ArrayList<Character> cache2 = new ArrayList<>();
        ArrayList<Character> cache3 = new ArrayList<>();
        ArrayList<Character> cache4 = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            if (cache.contains(value.charAt(i))) {
                cache.add(value.charAt(i));
            } else if (cache.isEmpty()) {
                cache.add(value.charAt(i));
            } else if (cache2.contains(value.charAt(i))) {
                cache2.add(value.charAt(i));
            } else if (cache2.isEmpty()) {
                cache2.add(value.charAt(i));
            } else if (cache3.contains(value.charAt(i))){
                cache3.add(value.charAt(i));
            } else if (cache3.isEmpty()) {
                cache3.add(value.charAt(i));
            } else {
                cache4.add(value.charAt(i));
            }
        }
        this.threeKind = (cache.size() == 3 && cache2.size() == 1 && cache3.size() == 1) ||
                (cache.size() == 1 && cache2.size() == 3 && cache3.size() == 1) ||
                (cache.size() == 1 && cache2.size() == 1 && cache3.size() == 3);
    }

    private void isFullHouse() {
        ArrayList<Character> cache = new ArrayList<>();
        ArrayList<Character> cache2 = new ArrayList<>();
        ArrayList<Character> cache3 = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            if (cache.contains(value.charAt(i))) {
                cache.add(value.charAt(i));
            } else if (cache.isEmpty()) {
                cache.add(value.charAt(i));
            } else if (cache2.contains(value.charAt(i))) {
                cache2.add(value.charAt(i));
            } else if (cache2.isEmpty()) {
                cache2.add(value.charAt(i));
            } else {
                cache3.add(value.charAt(i));
            }
        }
        this.fullHouse = (cache.size() == 3 && cache2.size() == 2 && cache3.isEmpty()) ||
                (cache.size() == 2 && cache2.size() == 3 && cache3.isEmpty());
    }

    private void isFourKind() {
        ArrayList<Character> cache = new ArrayList<>();
        ArrayList<Character> cache2 = new ArrayList<>();
        ArrayList<Character> cache3 = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            if (cache.contains(value.charAt(i))) {
                cache.add(value.charAt(i));
            } else if (cache.isEmpty()) {
                cache.add(value.charAt(i));
            } else if (cache2.contains(value.charAt(i))) {
                cache2.add(value.charAt(i));
            } else if (cache2.isEmpty()) {
                cache2.add(value.charAt(i));
            } else {
                cache3.add(value.charAt(i));
            }
        }
        this.fourKind = (cache.size() == 4 && cache2.size() == 1 && cache3.isEmpty()) ||
                (cache.size() == 1 && cache2.size() == 4 && cache3.isEmpty());
    }

    private void isFiveKind() {
        ArrayList<Character> cache = new ArrayList<>();
        ArrayList<Character> cache2 = new ArrayList<>();
        ArrayList<Character> cache3 = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            if (cache.contains(value.charAt(i))) {
                cache.add(value.charAt(i));
            } else if (cache.isEmpty()) {
                cache.add(value.charAt(i));
            } else if (cache2.contains(value.charAt(i))) {
                cache2.add(value.charAt(i));
            } else if (cache2.isEmpty()) {
                cache2.add(value.charAt(i));
            } else {
                cache3.add(value.charAt(i));
            }
        }
        this.fiveKind = cache.size() == 5 && cache2.isEmpty() && cache3.isEmpty();
    }

    @Override
    public String toString() {
        return "Card value is " + value + " its bid value is " + bid + " and its status is " + status;
    }

    public int getStatusValue() {
        return statusValue;
    }

    public String getValue() {
        return value;
    }

    public int getBid() {
        return bid;
    }
}
