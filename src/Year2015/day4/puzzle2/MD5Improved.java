package Year2015.day4.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5Improved {

    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        File file = new File("src/Year2015/day4/input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        MessageDigest md = MessageDigest.getInstance("MD5");
        boolean flag = true;
        String hash;
        int nb = 0;
        while (flag) {
            nb++;
            String input = line + nb;
            md.update(input.getBytes(StandardCharsets.UTF_8));
            byte[] result = md.digest();
            hash = bytesToHex(result);
            if (hash.startsWith("000000")) flag = false;
        }
        System.out.println(nb);
    }

    // Convert bytes to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

}

