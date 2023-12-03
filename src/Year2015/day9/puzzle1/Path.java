package Year2015.day9.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Path {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day9/test.txt");
        Scanner scanner = new Scanner(file);
        HashMap<ArrayList<String>, Integer> paths = new HashMap<>();
        HashMap<ArrayList<String>, Integer> roads = new HashMap<>();
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(line.split(" ")[0]);
            tmp.add(line.split(" ")[2]);
            paths.put(tmp, Integer.parseInt(line.split(" ")[4]));
        }
        for (ArrayList<String> city : paths.keySet()) {
            roads.put(city, paths.get(city));
            roads.put(new String[]{city[1], city[0]}, paths.get(city));
            if (!cities.contains(city[0])) cities.add(city[0]);
            if (!cities.contains(city[1])) cities.add(city[1]);
        }
        /**
         * OUTPUT
         */
        System.out.println("**********************************************");
        List<List<String>> permutations  = getAllPermutations(cities);
        // Print the combinations
        for (List<String> permutation : permutations) {
            int length = 0;
            for (int i = 0; i < permutation.size()-1; i++) {
                length += roads.get(new String[]{permutation.get(i), permutation.get(i+1)});
            }
            distances.add(length);
        }
        distances.sort(Integer::compareTo);
        System.out.println("Smallest distance : " + distances.getFirst());
    }

    public static List<List<String>> getAllPermutations(ArrayList<String> input) {
        List<List<String>> result = new ArrayList<>();
        generatePermutations(input, 0, result);
        return result;
    }

    private static void generatePermutations(ArrayList<String> input, int index, List<List<String>> result) {
        if (index == input.size() - 1) {
            result.add(new ArrayList<>(input));
            return;
        }

        for (int i = index; i < input.size(); i++) {
            swap(input, index, i);
            generatePermutations(input, index + 1, result);
            swap(input, index, i);
        }
    }

    private static void swap(ArrayList<String> input, int i, int j) {
        String temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }

}
