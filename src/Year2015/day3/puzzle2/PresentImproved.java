package Year2015.day3.puzzle2;

import Year2015.day3.Coordonnee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PresentImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day3/input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        ArrayList<Coordonnee> liste = new ArrayList<>();
        int xSanta = 0, ySanta = 0, xRobot = 0, yRobot = 0;
        liste.add(new Coordonnee(0, 0));
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)){
                case '^' -> {
                    xSanta++;
                    if (!liste.contains(new Coordonnee(xSanta, ySanta))) liste.add(new Coordonnee(xSanta, ySanta));
                }
                case '>' -> {
                    ySanta++;
                    if (!liste.contains(new Coordonnee(xSanta, ySanta))) liste.add(new Coordonnee(xSanta, ySanta));
                }
                case '<' -> {
                    ySanta--;
                    if (!liste.contains(new Coordonnee(xSanta, ySanta))) liste.add(new Coordonnee(xSanta, ySanta));
                }
                case 'v' -> {
                    xSanta--;
                    if (!liste.contains(new Coordonnee(xSanta, ySanta))) liste.add(new Coordonnee(xSanta, ySanta));
                }
            }
            i++;
            switch (line.charAt(i)){
                case '^' -> {
                    xRobot++;
                    if (!liste.contains(new Coordonnee(xRobot, yRobot))) liste.add(new Coordonnee(xRobot, yRobot));
                }
                case '>' -> {
                    yRobot++;
                    if (!liste.contains(new Coordonnee(xRobot, yRobot))) liste.add(new Coordonnee(xRobot, yRobot));
                }
                case '<' -> {
                    yRobot--;
                    if (!liste.contains(new Coordonnee(xRobot, yRobot))) liste.add(new Coordonnee(xRobot, yRobot));
                }
                case 'v' -> {
                    xRobot--;
                    if (!liste.contains(new Coordonnee(xRobot, yRobot))) liste.add(new Coordonnee(xRobot, yRobot));
                }
            }
        }
        System.out.println(liste.size());
    }

}
