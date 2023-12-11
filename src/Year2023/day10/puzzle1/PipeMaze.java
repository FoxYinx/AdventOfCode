package Year2023.day10.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PipeMaze {

    private static final int size = 140;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2023/day10/input.txt");
        Scanner scanner = new Scanner(file);
        char[][] maze = new char[size][size];
        int[][] distances = new int[size][size];
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < size; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        int[] currentPos = findStartPos(maze);
        distances[currentPos[0]][currentPos[1]] = -999;
        ArrayList<int[]> possibleStarts = new ArrayList<>();
        int dis = 0;
        if (currentPos[0] > 0 && (maze[currentPos[0]-1][currentPos[1]] == 'F' || maze[currentPos[0]-1][currentPos[1]] == '7' || maze[currentPos[0]-1][currentPos[1]] == '|')) {
            possibleStarts.add(new int[]{currentPos[0]-1, currentPos[1]});
        }
        if (currentPos[0] < size-1 && (maze[currentPos[0]+1][currentPos[1]] == 'J' || maze[currentPos[0]+1][currentPos[1]] == 'L' || maze[currentPos[0]+1][currentPos[1]] == '|')) {
            possibleStarts.add(new int[]{currentPos[0]+1, currentPos[1]});
        }
        if (currentPos[1] > 0 && (maze[currentPos[0]][currentPos[1]-1] == '-' || maze[currentPos[0]][currentPos[1]-1] == 'F' || maze[currentPos[0]][currentPos[1]-1] == 'L')) {
            possibleStarts.add(new int[]{currentPos[0], currentPos[1]-1});
        }
        if (currentPos[1] < size-1 && (maze[currentPos[0]][currentPos[1]+1] == '-' || maze[currentPos[0]][currentPos[1]+1] == 'J' || maze[currentPos[0]][currentPos[1]+1] == '7')){
            possibleStarts.add(new int[]{currentPos[0], currentPos[1]+1});
        }
        int[] c1Pos = possibleStarts.getFirst();
        int[] c2Pos = possibleStarts.getLast();
        dis++;
        distances[c1Pos[0]][c1Pos[1]] = dis;
        distances[c2Pos[0]][c2Pos[1]] = dis;
        do {
            if (maze[c1Pos[0]][c1Pos[1]] == 'F') {
                if (distances[c1Pos[0] + 1][c1Pos[1]] == 0) {
                    c1Pos[0]++;
                } else {
                    c1Pos[1]++;
                }
            } else if (maze[c1Pos[0]][c1Pos[1]] == '7') {
                if (distances[c1Pos[0] + 1][c1Pos[1]] == 0) {
                    c1Pos[0]++;
                } else {
                    c1Pos[1]--;
                }
            } else if (maze[c1Pos[0]][c1Pos[1]] == 'J') {
                if (distances[c1Pos[0] - 1][c1Pos[1]] == 0) {
                    c1Pos[0]--;
                } else {
                    c1Pos[1]--;
                }
            } else if (maze[c1Pos[0]][c1Pos[1]] == 'L') {
                if (distances[c1Pos[0] - 1][c1Pos[1]] == 0) {
                    c1Pos[0]--;
                } else {
                    c1Pos[1]++;
                }
            } else if (maze[c1Pos[0]][c1Pos[1]] == '-') {
                if (distances[c1Pos[0]][c1Pos[1] + 1] == 0) {
                    c1Pos[1]++;
                } else {
                    c1Pos[1]--;
                }
            } else if (maze[c1Pos[0]][c1Pos[1]] == '|') {
                if (distances[c1Pos[0] + 1][c1Pos[1]] == 0) {
                    c1Pos[0]++;
                } else {
                    c1Pos[0]--;
                }
            }
            if (maze[c2Pos[0]][c2Pos[1]] == 'F') {
                if (distances[c2Pos[0] + 1][c2Pos[1]] == 0) {
                    c2Pos[0]++;
                } else {
                    c2Pos[1]++;
                }
            } else if (maze[c2Pos[0]][c2Pos[1]] == '7') {
                if (distances[c2Pos[0] + 1][c2Pos[1]] == 0) {
                    c2Pos[0]++;
                } else {
                    c2Pos[1]--;
                }
            } else if (maze[c2Pos[0]][c2Pos[1]] == 'J') {
                if (distances[c2Pos[0] - 1][c2Pos[1]] == 0) {
                    c2Pos[0]--;
                } else {
                    c2Pos[1]--;
                }
            } else if (maze[c2Pos[0]][c2Pos[1]] == 'L') {
                if (distances[c2Pos[0] - 1][c2Pos[1]] == 0) {
                    c2Pos[0]--;
                } else {
                    c2Pos[1]++;
                }
            } else if (maze[c2Pos[0]][c2Pos[1]] == '-') {
                if (distances[c2Pos[0]][c2Pos[1] + 1] == 0) {
                    c2Pos[1]++;
                } else {
                    c2Pos[1]--;
                }
            } else if (maze[c2Pos[0]][c2Pos[1]] == '|') {
                if (distances[c2Pos[0] + 1][c2Pos[1]] == 0) {
                    c2Pos[0]++;
                } else {
                    c2Pos[0]--;
                }
            }
            dis++;
            distances[c1Pos[0]][c1Pos[1]] = dis;
            distances[c2Pos[0]][c2Pos[1]] = dis;
        } while (!(c1Pos[0] == c2Pos[0] && c1Pos[1] == c2Pos[1]));
        System.out.println("Finished!");
        System.out.println("The farthest point from the start is " + dis + " steps away.");
    }

    private static int[] findStartPos(char[][] maze) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (maze[i][j] == 'S') return new int[]{i, j};
            }
        }
        return new int[0];
    }

}
