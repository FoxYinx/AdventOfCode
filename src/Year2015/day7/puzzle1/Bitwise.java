package Year2015.day7.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Bitwise {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day7/input.txt");
        Scanner scanner = new Scanner(file);
        HashMap<String, Integer> wires  = new HashMap<>();
        int verif = 0;
        while (verif < 339) {
            verif = 0;
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] blocks = line.split(" ");
                int blocksNb = blocks.length;
                switch (blocksNb) {
                    case 3:
                        if (wires.containsKey(blocks[0])) {
                            wires.put(blocks[2], wires.get(blocks[0]));
                            verif++;
                        } else {
                            try {
                                wires.put(blocks[2], Integer.parseInt(blocks[0]));
                                verif++;
                            } catch (Exception ignored) {}
                        }
                        break;
                    case 4:
                        if (wires.containsKey(blocks[1])){
                            int not = ~wires.get(blocks[1]);
                            wires.put(blocks[3], not & 0xFFFF);
                            verif++;
                        }
                        break;
                    case 5:
                        switch (blocks[1]) {
                            case "AND":
                                if (wires.containsKey(blocks[0])) {
                                    if (wires.containsKey(blocks[2])) {
                                        wires.put(blocks[4], (wires.get(blocks[0]) & wires.get(blocks[2])) & 0xFFFF);
                                        verif++;
                                    } else {
                                        try {
                                            wires.put(blocks[4], (wires.get(blocks[0]) & Integer.parseInt(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } catch (Exception ignored) {}
                                    }
                                } else {
                                    try {
                                        if (wires.containsKey(blocks[2])) {
                                            wires.put(blocks[4], (Integer.parseInt(blocks[0]) & wires.get(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } else {
                                            try {
                                                wires.put(blocks[4], (Integer.parseInt(blocks[0]) & Integer.parseInt(blocks[2])) & 0xFFFF);
                                                verif++;
                                            } catch (Exception ignored) {}
                                        }
                                    } catch (Exception ignored) {}
                                }
                                break;
                            case "OR":
                                if (wires.containsKey(blocks[0])) {
                                    if (wires.containsKey(blocks[2])) {
                                        wires.put(blocks[4], (wires.get(blocks[0]) | wires.get(blocks[2])) & 0xFFFF);
                                        verif++;
                                    } else {
                                        try {
                                            wires.put(blocks[4], (wires.get(blocks[0]) | Integer.parseInt(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } catch (Exception ignored) {}
                                    }
                                } else {
                                    try {
                                        if (wires.containsKey(blocks[2])) {
                                            wires.put(blocks[4], (Integer.parseInt(blocks[0]) | wires.get(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } else {
                                            try {
                                                wires.put(blocks[4], (Integer.parseInt(blocks[0]) | Integer.parseInt(blocks[2])) & 0xFFFF);
                                                verif++;
                                            } catch (Exception ignored) {}
                                        }
                                    } catch (Exception ignored) {}
                                }
                                break;
                            case "LSHIFT":
                                if (wires.containsKey(blocks[0])) {
                                    if (wires.containsKey(blocks[2])) {
                                        wires.put(blocks[4], (wires.get(blocks[0]) << wires.get(blocks[2])) & 0xFFFF);
                                        verif++;
                                    } else {
                                        try {
                                            wires.put(blocks[4], (wires.get(blocks[0]) << Integer.parseInt(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } catch (Exception ignored) {}
                                    }
                                } else {
                                    try {
                                        if (wires.containsKey(blocks[2])) {
                                            wires.put(blocks[4], (Integer.parseInt(blocks[0]) << wires.get(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } else {
                                            try {
                                                wires.put(blocks[4], (Integer.parseInt(blocks[0]) << Integer.parseInt(blocks[2])) & 0xFFFF);
                                                verif++;
                                            } catch (Exception ignored) {}
                                        }
                                    } catch (Exception ignored) {}
                                }
                                break;
                            case "RSHIFT":
                                if (wires.containsKey(blocks[0])) {
                                    if (wires.containsKey(blocks[2])) {
                                        wires.put(blocks[4], (wires.get(blocks[0]) >>> wires.get(blocks[2])) & 0xFFFF);
                                        verif++;
                                    } else {
                                        try {
                                            wires.put(blocks[4], (wires.get(blocks[0]) >>> Integer.parseInt(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } catch (Exception ignored) {}
                                    }
                                } else {
                                    try {
                                        if (wires.containsKey(blocks[2])) {
                                            wires.put(blocks[4], (Integer.parseInt(blocks[0]) >>> wires.get(blocks[2])) & 0xFFFF);
                                            verif++;
                                        } else {
                                            try {
                                                wires.put(blocks[4], (Integer.parseInt(blocks[0]) >>> Integer.parseInt(blocks[2])) & 0xFFFF);
                                                verif++;
                                            } catch (Exception ignored) {}
                                        }
                                    } catch (Exception ignored) {}
                                }
                                break;
                        }
                }
            }
            scanner = new Scanner(file);
            System.out.println(verif);
        }
        for (String string:wires.keySet()){
            System.out.println(string + " -> " + wires.get(string));
        }
        System.out.println("Wire a = " + wires.get("a"));
    }

}
