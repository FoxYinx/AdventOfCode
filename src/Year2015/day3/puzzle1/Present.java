package Year2015.day3.puzzle1;

import Year2015.day3.Coordonnee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Present {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day3/input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        ArrayList<Coordonnee> liste = new ArrayList<>();
        int x = 0, y = 0;
        liste.add(new Coordonnee(x, y));
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)){
                case '^' -> {
                    x++;
                    if (!liste.contains(new Coordonnee(x, y))) liste.add(new Coordonnee(x, y));
                }
                case '>' -> {
                    y++;
                    if (!liste.contains(new Coordonnee(x, y))) liste.add(new Coordonnee(x, y));
                }
                case '<' -> {
                    y--;
                    if (!liste.contains(new Coordonnee(x, y))) liste.add(new Coordonnee(x, y));
                }
                case 'v' -> {
                    x--;
                    if (!liste.contains(new Coordonnee(x, y))) liste.add(new Coordonnee(x, y));
                }
            }
        }
        System.out.println(liste.size());
    }

}
