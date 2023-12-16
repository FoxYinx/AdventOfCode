package Year2023.day11.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CosmicExpansionImproved {

    private static final int nbOfCharacters = 140;
    private static final int size = nbOfCharacters + 1;
    private static final int expansionPower = 1000000-1;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/Year2023/day11/input.txt");
        Scanner scanner = new Scanner(file);
        // Initialization of the map
        String[][] map = new String[size][size];
        for (int i = 0; i < size; i++) {
            map[0][i] = "0";
        }
        for (int i = 0; i < size; i++) {
            map[i][0] = "0";
        }
        int lineNb = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] lineChar = line.toCharArray();
            lineNb++;
            for (int i = 0; i < nbOfCharacters; i++) {
                map[lineNb][i+1] = String.valueOf(lineChar[i]);
            }
        }
        // Initialization of the expansion
        boolean flag;
        for (int i = 0; i < nbOfCharacters; i++) {
            flag = true;
            for (int j = 0; j < nbOfCharacters; j++) {
                if (!map[j+1][i+1].equals(".")) {
                    flag = false;
                    break;
                }
            }
            if (flag) map[0][i+1] = String.valueOf(expansionPower);
        }
        for (int i = 0; i < nbOfCharacters; i++) {
            flag = true;
            for (int j = 0; j < nbOfCharacters; j++) {
                if (!map[i+1][j+1].equals(".")) {
                    flag = false;
                    break;
                }
            }
            if (flag) map[i+1][0] = String.valueOf(expansionPower);
        }
        // Getting the galaxies
        ArrayList<int[]> galaxies = getGalaxies(map);
        // Finding the sum of distances between each pair of galaxies
        long total = 0;
        //System.out.println("Distance 1 to 7 : " + distance(map, galaxies.getFirst()[0], galaxies.getFirst()[1], galaxies.get(6)[0], galaxies.get(6)[1]));
        //System.out.println("Distance 3 to 6 : " + distance(map, galaxies.get(2)[0], galaxies.get(2)[1], galaxies.get(5)[0], galaxies.get(5)[1]));
        //System.out.println("Distance 8 to 9 : " + distance(map, galaxies.get(7)[0], galaxies.get(7)[1], galaxies.get(8)[0], galaxies.get(8)[1]));
        //System.out.println("Distance 5 to 9 : " + distance(map, galaxies.get(4)[0], galaxies.get(4)[1], galaxies.get(8)[0], galaxies.get(8)[1]));
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i; j < galaxies.size(); j++) {
                if (i != j) {
                    //System.out.println("From galaxy n°" + i + " to galaxy n°" + j);
                    total += distance(map, galaxies.get(i)[0], galaxies.get(i)[1], galaxies.get(j)[0], galaxies.get(j)[1]);
                }
            }
        }
        System.out.println("The total distance is " + total);
    }

    public static ArrayList<int[]> getGalaxies(String[][] map) {
        ArrayList<int[]> galaxies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j].equals("#")) galaxies.add(new int[]{i, j});
            }
        }
        return galaxies;
    }

    public static long distance(String[][] map, int xPosOrg, int yPosOrg, int xPosDest, int yPosDest) {
        long dist = Math.abs(xPosDest - xPosOrg) + Math.abs(yPosDest - yPosOrg);
        for (int i = Math.min(xPosOrg, xPosDest)+1; i < Math.max(xPosOrg, xPosDest); i++) {
            if (!map[i][0].equals("0")) dist += Long.parseLong(map[i][0]);
        }
        for (int i = Math.min(yPosOrg, yPosDest)+1; i < Math.max(yPosOrg, yPosDest); i++) {
            if (!map[0][i].equals("0")) dist += Long.parseLong(map[0][i]);
        }
        return dist;
    }

}
