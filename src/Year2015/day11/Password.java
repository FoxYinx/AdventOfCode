package Year2015.day11;

import java.util.ArrayList;
import java.util.Arrays;

public class Password {

    private static final ArrayList<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public static Character increaseOneChar(Character character) {
        int pos = letters.indexOf(character);
        return letters.get((pos + 1) % 26);
    }

    public static String increaseString(String string) {
        char[] output = string.toCharArray();
        for (int i = output.length-1; i >= 0; i--) {
            output[i] = increaseOneChar(output[i]);
            if (output[i] != 'a') break;
        }
        return arrayToString(output);
    }

    public void increasePassword() {
        password = increaseString(password);
    }

    public String getPassword() {
        return password;
    }

    public static String arrayToString(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public boolean firstRequirement() {
        boolean flag = false;
        char[] letters = this.password.toCharArray();
        for (int i = 0; i < letters.length-2; i++) {
            if (Password.letters.indexOf(letters[i])+1 == Password.letters.indexOf(letters[i+1]) && Password.letters.indexOf(letters[i])+2 == Password.letters.indexOf(letters[i+2])) flag = true;
        }
        return flag;
    }

    public boolean secondRequirement() {
        boolean flag = true;
        char[] letters = this.password.toCharArray();
        for (char c : letters) {
            if (c == 'i' || c == 'l' || c == 'o') {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean thirdRequirement() {
        ArrayList<Character> doubleChar = new ArrayList<>();
        char[] letters = this.password.toCharArray();
        for (int i = 0; i < letters.length-1; i++) {
            if (letters[i] == letters[i+1] && !doubleChar.contains(letters[i])) {
                doubleChar.add(letters[i]);
            }
        }
        return doubleChar.size() >= 2;
    }

    public boolean meetAllRequirements() {
        return firstRequirement() && secondRequirement() && thirdRequirement();
    }
}
