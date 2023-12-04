package Year2015.day11.puzzle2;

import Year2015.day11.Password;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CorporatePolicyImproved {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2015/day11/puzzle2/input.txt");
        Scanner scanner = new Scanner(file);
        Password password = new Password(scanner.nextLine());
        System.out.println("Original password : " + password.getPassword());
        password.increasePassword();
        while (!password.meetAllRequirements()){
            password.increasePassword();
        }
        System.out.println("New password : " + password.getPassword());
    }

}
